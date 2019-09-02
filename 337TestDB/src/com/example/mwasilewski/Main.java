package com.example.mwasilewski;

import org.sqlite.core.DB;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION = "jdbc:sqlite:" + DB_NAME;

    public static final String TAB_CONTACTS = "contacts";

    public static final String COL_NAME = "name";
    public static final String COL_PHONE = "phone";
    public static final String COL_EMAIL = "email";


    public static void main(String[] args) {


        try (Connection conn = DriverManager.getConnection(CONNECTION);
             Statement statement = conn.createStatement()) {
            statement.execute("drop table if exists " + TAB_CONTACTS);
            statement.execute("create table if not exists " + TAB_CONTACTS
                    + "("
                    + COL_NAME + " text, "
                    + COL_PHONE + " integer, "
                    + COL_EMAIL + " text)");

            statement.execute(insertContactSQL("Tim", 34535, "tim@tim.com"));
            statement.execute(insertContactSQL("Joe", 775, "a@tim.com"));
            statement.execute(insertContactSQL("Maciek", 2346, "b@tim.com"));
            statement.execute(insertContactSQL("Aneta", 36785, "c@tim.com"));

            System.out.println("Success");
            try (ResultSet resultSet = statement.executeQuery("select * from " + TAB_CONTACTS);) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(COL_NAME)+" "+resultSet.getString(COL_PHONE));
                }
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong." + e.getMessage());
        }
    }

    private static String insertContactSQL(String name, int number, String email) {
        return "INSERT into " + TAB_CONTACTS + " ("
                + COL_NAME + ", "
                + COL_PHONE + ", "
                + COL_EMAIL
                + ") VALUES ("
                + "'" + name + "', "
                + number + ", "
                + "'" + email + "'"
                + ")";
    }
}
