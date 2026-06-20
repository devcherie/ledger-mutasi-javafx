package com.jdatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/db_ledger_mutasi";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "";

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}