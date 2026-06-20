package com.model;

public class Mutasi {

    private String tanggal;
    private int akunAsal;
    private int akunTujuan;
    private double nominal;
    private String keterangan;
    private int idUser;

    public Mutasi(
            String tanggal,
            int akunAsal,
            int akunTujuan,
            double nominal,
            String keterangan,
            int idUser) {

        this.tanggal = tanggal;
        this.akunAsal = akunAsal;
        this.akunTujuan = akunTujuan;
        this.nominal = nominal;
        this.keterangan = keterangan;
        this.idUser = idUser;
    }

    public String getTanggal() {
        return tanggal;
    }

    public int getAkunAsal() {
        return akunAsal;
    }

    public int getAkunTujuan() {
        return akunTujuan;
    }

    public double getNominal() {
        return nominal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public int getIdUser() {
        return idUser;
    }
}