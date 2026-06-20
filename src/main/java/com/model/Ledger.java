package com.model;

public class Ledger {

    private String tanggal;
    private String akun;
    private Double debit;
    private Double kredit;
    private String keterangan;

    public Ledger(
            String tanggal,
            String akun,
            Double debit,
            Double kredit,
            String keterangan) {

        this.tanggal = tanggal;
        this.akun = akun;
        this.debit = debit;
        this.kredit = kredit;
        this.keterangan = keterangan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getAkun() {
        return akun;
    }

    public Double getDebit() {
        return debit;
    }

    public Double getKredit() {
        return kredit;
    }

    public String getKeterangan() {
        return keterangan;
    }
}