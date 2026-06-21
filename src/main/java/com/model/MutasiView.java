package com.model;

public class MutasiView {

    private String tanggal;
    private String akunAsal;
    private String akunTujuan;
    private Double nominal;
    private String keterangan;

    public MutasiView(
            String tanggal,
            String akunAsal,
            String akunTujuan,
            Double nominal,
            String keterangan
    ) {
        this.tanggal = tanggal;
        this.akunAsal = akunAsal;
        this.akunTujuan = akunTujuan;
        this.nominal = nominal;
        this.keterangan = keterangan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getAkunAsal() {
        return akunAsal;
    }

    public String getAkunTujuan() {
        return akunTujuan;
    }

    public Double getNominal() {
        return nominal;
    }

    public String getKeterangan() {
        return keterangan;
    }
}