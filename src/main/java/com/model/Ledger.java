package com.model;

public class Ledger {

    private String tanggal;
    private String akun;
    private Double debit;
    private Double kredit;
    private String keterangan;

    public Ledger() {
    }

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

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getAkun() {
        return akun;
    }

    public void setAkun(String akun) {
        this.akun = akun;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getKredit() {
        return kredit;
    }

    public void setKredit(Double kredit) {
        this.kredit = kredit;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}