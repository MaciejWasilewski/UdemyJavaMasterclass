package com.example.mwasilewski;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:testjava.db");
             Statement statement = conn.createStatement()) {
//            conn.setAutoCommit(false);
//            statement.execute("create table if not exists contacts(name text, phone integer, email text )");
//            statement.execute("insert into contacts (name, phone, email) values('joe',66455,'joe@tim.gmail.com')");
//            statement.execute("insert into contacts (name, phone, email) values('jane',48925,'jane@tim.gmail.com')");
//            statement.execute("insert into contacts (name, phone, email) values('dog',66455,'dog@tim.gmail.com')");
//            conn.commit();
            statement.execute("update contacts set phone=66645 where name='jane'");
        } catch (SQLException e) {
            System.out.println("Something went wrong." + e.getMessage());
        }
    }
}
