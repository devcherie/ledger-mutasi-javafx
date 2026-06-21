package com.service;

import com.jdatabase.DataBaseConnection;
import com.model.Ledger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LedgerService {

    public List<Ledger> getAllLedger() {

        List<Ledger> data =
                new ArrayList<>();

        try {

            System.out.println(
                    "SERVICE DIJALANKAN"
            );

            Connection conn =
                    DataBaseConnection.getConnection();

            String sql =
                    """
                    SELECT
                        l.tanggal,
                        a.nama_akun,
                        d.debit,
                        d.kredit,
                        l.keterangan
                    FROM detail_ledger d
                    JOIN ledger l
                        ON d.id_ledger = l.id_ledger
                    JOIN akun a
                        ON d.id_akun = a.id_akun
                    ORDER BY l.tanggal DESC
                    """;

            Statement st =
                    conn.createStatement();

            ResultSet rs =
                    st.executeQuery(sql);

            while (rs.next()) {

                data.add(
                        new Ledger(
                                rs.getString("tanggal"),
                                rs.getString("nama_akun"),
                                rs.getDouble("debit"),
                                rs.getDouble("kredit"),
                                rs.getString("keterangan")
                        )
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println("Jumlah Ledger = " + data.size());

        return data;
    }
}