package com.controller;

import java.sql.Connection;
import java.sql.Date;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.model.Mutasi;
import com.service.MutasiService;

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

            double nominal =
                    Double.parseDouble(
                            txtNominal.getText()
                    );

            int akunAsal;
            int akunTujuan;

            switch (cbAkunAsal.getValue()) {

                case "Kas" -> akunAsal = 1;
                case "Bank" -> akunAsal = 2;
                case "Piutang" -> akunAsal = 3;
                case "Pendapatan" -> akunAsal = 4;

                default -> {
                    tampilkanNotifikasiError(
                            "Akun asal tidak valid"
                    );
                    return;
                }
            }

            switch (cbAkunTujuan.getValue()) {

                case "Kas" -> akunTujuan = 1;
                case "Bank" -> akunTujuan = 2;
                case "Piutang" -> akunTujuan = 3;
                case "Pendapatan" -> akunTujuan = 4;

                default -> {
                    tampilkanNotifikasiError(
                            "Akun tujuan tidak valid"
                    );
                    return;
                }
            }

            Mutasi mutasi =
                    new Mutasi(
                            dpTanggal
                                    .getValue()
                                    .toString(),
                            akunAsal,
                            akunTujuan,
                            nominal,
                            txtKeterangan.getText(),
                            1
                    );

            MutasiService service =
                    new MutasiService();

            boolean berhasil =
                    service.simpanMutasi(
                            mutasi
                    );

            if (berhasil) {

                tampilkanNotifikasiSukses(
                        "Transaksi berhasil disimpan"
                );

                resetForm();

            } else {

                if (akunAsal == akunTujuan) {

                    tampilkanNotifikasiError(
                            "Akun asal dan tujuan tidak boleh sama"
                    );

                    return;
                }

                tampilkanNotifikasiError(
                        "Gagal menyimpan data"
                );
            }

        } catch (NumberFormatException e) {

            tampilkanNotifikasiError(
                    "Nominal harus berupa angka"
            );

        } catch (Exception e) {

            e.printStackTrace();

            tampilkanNotifikasiError(
                    "Terjadi kesalahan sistem"
            );
        }

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