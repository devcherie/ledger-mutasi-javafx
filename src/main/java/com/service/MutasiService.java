package com.service;

import com.jdatabase.DataBaseConnection;
import com.model.Mutasi;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MutasiService {

    public boolean simpanMutasi(
            Mutasi mutasi) {

        String sql =
                "INSERT INTO mutasi " +
                        "(tanggal,akun_asal,akun_tujuan," +
                        "nominal,keterangan,id_user) " +
                        "VALUES (?,?,?,?,?,?)";

        try {

            Connection com =
                    DataBaseConnection.getConnection();

            PreparedStatement ps =
                    com.prepareStatement(sql);

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

            System.out.println("GAGAL INSERT DATA");
            e.printStackTrace();

            return false;
        }
    }
}