package com.example.mwasilewski;

import org.sqlite.core.DB;

import java.sql.*;

public class Main {
public static final String DB_NAME="testjava.db";
public static final String CONNECTION="jdbc:sqlite:"+ DB_NAME;

public static final String TAB_CONTACTS="contacts";

public static final String COL_NAME="name";
    public static final String COL_PHONE="phone";
    public static final String COL_EMAIL="email";


    public static void main(String[] args) {


        try (Connection conn = DriverManager.getConnection(CONNECTION);
             Statement statement = conn.createStatement()) {
            System.out.println(String.format("{1}", ));
//            conn.setAutoCommit(false);
//            statement.execute("create table if not exists TAB_CONTACTS(COL_NAME text, COL_PHONE integer, email text )");
//            statement.execute("insert into contacts (name, COL_PHONE, email) values('joe',66455,'joe@tim.gmail.com')");
//            statement.execute("insert into contacts (name, COL_PHONE, email) values('jane',48925,'jane@tim.gmail.com')");
//            statement.execute("insert into contacts (name, COL_PHONE, email) values('dog',66455,'dog@tim.gmail.com')");
//            conn.commit();
//            statement.execute("update contacts set phone=66645 where name='jane'");

//            statement.execute("select * from contacts");

//            ResultSet resultSet = statement.getResultSet();
            ResultSet resultSet =statement.executeQuery("select * from "+TAB_CONTACTS);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(COL_NAME));
            }


            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong." + e.getMessage());
        }
    }
}
