package com.controller;

import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MutasiController {

    @FXML
    private DatePicker dpTanggal;

    @FXML
    private ComboBox<String> cbAkunAsal;

    @FXML
    private ComboBox<String> cbAkunTujuan;

    @FXML
    private TextField txtNominal;

    @FXML
    private TextArea txtKeterangan;

    @FXML
    private Label lblNotif;

    @FXML
    public void initialize() {

        cbAkunAsal.getItems().addAll(
                "Kas",
                "Bank",
                "Piutang",
                "Pendapatan"
        );

        cbAkunTujuan.getItems().addAll(
                "Kas",
                "Bank",
                "Piutang",
                "Pendapatan"
        );
    }

    private void tampilkanNotifikasiError(String pesan) {

        lblNotif.setText("⚠ " + pesan);

        lblNotif.setStyle(
                "-fx-background-color:#F44336;" +
                        "-fx-text-fill:white;" +
                        "-fx-padding:12;" +
                        "-fx-font-weight:bold;" +
                        "-fx-background-radius:5;"
        );

        lblNotif.setVisible(true);

        PauseTransition pause =
                new PauseTransition(
                        Duration.seconds(3)
                );

        pause.setOnFinished(
                e -> lblNotif.setVisible(false)
        );

        pause.play();
    }

    private void tampilkanNotifikasiSukses(String pesan) {

        lblNotif.setText("✅ " + pesan);

        lblNotif.setStyle(
                "-fx-background-color:#4CAF50;" +
                        "-fx-text-fill:white;" +
                        "-fx-padding:12;" +
                        "-fx-font-weight:bold;" +
                        "-fx-background-radius:5;"
        );

        lblNotif.setVisible(true);

        PauseTransition pause =
                new PauseTransition(
                        Duration.seconds(3)
                );

        pause.setOnFinished(
                e -> lblNotif.setVisible(false)
        );

        pause.play();
    }

    @FXML
    public void simpanMutasi() {

        if (dpTanggal.getValue() == null
                || cbAkunAsal.getValue() == null
                || cbAkunTujuan.getValue() == null
                || txtNominal.getText().trim().isEmpty()
                || txtKeterangan.getText().trim().isEmpty()) {

            tampilkanNotifikasiError(
                    "Semua data mutasi wajib diisi."
            );

            return;
        }

        try {

            Double.parseDouble(
                    txtNominal.getText()
            );

        } catch (NumberFormatException e) {

            tampilkanNotifikasiError(
                    "Nominal harus berupa angka."
            );

            return;
        }

        String tanggal =
                dpTanggal.getValue().toString();

        String akunAsal =
                cbAkunAsal.getValue();

        String akunTujuan =
                cbAkunTujuan.getValue();

        String nominal =
                txtNominal.getText();

        String keterangan =
                txtKeterangan.getText();

        System.out.println("===== DATA MUTASI =====");
        System.out.println("Tanggal     : " + tanggal);
        System.out.println("Akun Asal   : " + akunAsal);
        System.out.println("Akun Tujuan : " + akunTujuan);
        System.out.println("Nominal     : " + nominal);
        System.out.println("Keterangan  : " + keterangan);

        tampilkanNotifikasiSukses(
                "Transaksi berhasil disimpan"
        );

        resetForm();
    }

    @FXML
    public void resetForm() {

        dpTanggal.setValue(null);

        cbAkunAsal.setValue(null);

        cbAkunTujuan.setValue(null);

        txtNominal.clear();

        txtKeterangan.clear();
    }

    @FXML
    public void kembaliDashboard() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/dashboard.fxml"
                            )
                    );

            Scene scene =
                    new Scene(
                            loader.load()
                    );

            Stage stage =
                    (Stage) txtNominal
                            .getScene()
                            .getWindow();

            stage.setScene(scene);

            stage.setTitle(
                    "Dashboard"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}