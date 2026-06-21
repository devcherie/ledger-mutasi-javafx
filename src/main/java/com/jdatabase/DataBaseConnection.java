package com.jdatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/db_ledger_mutasi";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "angel879_";

    public static Connection getConnection() {

        try {

            Connection conn =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            System.out.println(
                    "KONEKSI BERHASIL"
            );

            return conn;

        } catch (Exception e) {

            System.out.println(
                    "KONEKSI GAGAL"
            );

            e.printStackTrace();

            return null;
        }
    }
}