package com.model;

public class DetailLedger {

    private int idDetail;
    private int idLedger;
    private int idAkun;
    private double debit;
    private double kredit;

    // Constructor kosong
    public DetailLedger() {
    }

    // Constructor lengkap
    public DetailLedger(int idDetail, int idLedger,
                        int idAkun, double debit, double kredit) {
        this.idDetail = idDetail;
        this.idLedger = idLedger;
        this.idAkun = idAkun;
        this.debit = debit;
        this.kredit = kredit;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getIdLedger() {
        return idLedger;
    }

    public void setIdLedger(int idLedger) {
        this.idLedger = idLedger;
    }

    public int getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(int idAkun) {
        this.idAkun = idAkun;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getKredit() {
        return kredit;
    }

    public void setKredit(double kredit) {
        this.kredit = kredit;
    }

    @Override
    public String toString() {
        return "DetailLedger{" +
                "idDetail=" + idDetail +
                ", idLedger=" + idLedger +
                ", idAkun=" + idAkun +
                ", debit=" + debit +
                ", kredit=" + kredit +
                '}';
    }

}
