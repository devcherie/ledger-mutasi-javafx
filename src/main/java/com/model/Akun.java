package com.model;

public class Akun {

    private int idAkun;
    private String kodeAkun;
    private String namaAkun;
    private String jenisAkun;
    private double saldoAwal;

    // Constructor kosong
    public Akun() {
    }

    // Constructor lengkap
    public Akun(int idAkun, String kodeAkun, String namaAkun,
                String jenisAkun, double saldoAwal) {
        this.idAkun = idAkun;
        this.kodeAkun = kodeAkun;
        this.namaAkun = namaAkun;
        this.jenisAkun = jenisAkun;
        this.saldoAwal = saldoAwal;
    }

    public int getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(int idAkun) {
        this.idAkun = idAkun;
    }

    public String getKodeAkun() {
        return kodeAkun;
    }

    public void setKodeAkun(String kodeAkun) {
        this.kodeAkun = kodeAkun;
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public void setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
    }

    public String getJenisAkun() {
        return jenisAkun;
    }

    public void setJenisAkun(String jenisAkun) {
        this.jenisAkun = jenisAkun;
    }

    public double getSaldoAwal() {
        return saldoAwal;
    }

    public void setSaldoAwal(double saldoAwal) {
        this.saldoAwal = saldoAwal;
    }

    @Override
    public String toString() {
        return namaAkun;
    }
}
