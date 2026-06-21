package com.service;

import com.jdatabase.DataBaseConnection;
import com.model.Mutasi;
import com.model.MutasiView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MutasiService {

    // ==========================
    // SIMPAN MUTASI
    // ==========================
    public boolean simpanMutasi(
            Mutasi mutasi) {

        String sql =
                "INSERT INTO mutasi " +
                        "(tanggal,akun_asal,akun_tujuan," +
                        "nominal,keterangan,id_user) " +
                        "VALUES (?,?,?,?,?,?)";

        try {

            Connection conn =
                    DataBaseConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(
                    1,
                    mutasi.getTanggal()
            );

            ps.setInt(
                    2,
                    mutasi.getAkunAsal()
            );

            ps.setInt(
                    3,
                    mutasi.getAkunTujuan()
            );

            ps.setDouble(
                    4,
                    mutasi.getNominal()
            );

            ps.setString(
                    5,
                    mutasi.getKeterangan()
            );

            ps.setInt(
                    6,
                    mutasi.getIdUser()
            );

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    // ==========================
    // TAMPILKAN DATA MUTASI
    // ==========================
    public List<MutasiView> getAllMutasi() {

        List<MutasiView> data =
                new ArrayList<>();

        try {

            Connection conn =
                    DataBaseConnection.getConnection();

            String sql =
                    """
                    SELECT
                        m.tanggal,
                        a1.nama_akun AS akun_asal,
                        a2.nama_akun AS akun_tujuan,
                        m.nominal,
                        m.keterangan
                    FROM mutasi m
                    JOIN akun a1
                        ON m.akun_asal = a1.id_akun
                    JOIN akun a2
                        ON m.akun_tujuan = a2.id_akun
                    ORDER BY m.id_mutasi DESC
                    """;

            Statement st =
                    conn.createStatement();

            ResultSet rs =
                    st.executeQuery(sql);

            while (rs.next()) {

                data.add(
                        new MutasiView(
                                rs.getString("tanggal"),
                                rs.getString("akun_asal"),
                                rs.getString("akun_tujuan"),
                                rs.getDouble("nominal"),
                                rs.getString("keterangan")
                        )
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return data;
    }
}