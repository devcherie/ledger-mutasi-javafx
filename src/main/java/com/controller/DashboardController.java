package com.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

public class DashboardController {


    @FXML
    private Button btnMutasi;

    @FXML
    private Label lblJumlahAkun;

    @FXML
    private Label lblJumlahMutasi;

    @FXML
    private Label lblTotalDebit;

    @FXML
    private Label lblTotalKredit;

    @FXML
    public void initialize() {

        // Data sementara (dummy)
        lblJumlahAkun.setText("10");
        lblJumlahMutasi.setText("25");
        lblTotalDebit.setText("Rp 500.000");
        lblTotalKredit.setText("Rp 500.000");
    }

    @FXML
    public void bukaMutasi() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/mutasi.fxml"
                            )
                    );

            Scene scene =
                    new Scene(
                            loader.load()
                    );

            Stage stage =
                    (Stage) lblJumlahAkun
                            .getScene()
                            .getWindow();

            stage.setScene(scene);
            stage.setTitle("Form Mutasi");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @FXML
    public void bukaLedger() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/ledger.fxml"
                            )
                    );

            Scene scene =
                    new Scene(
                            loader.load()
                    );

            Stage stage =
                    (Stage) lblJumlahAkun
                            .getScene()
                            .getWindow();

            stage.setScene(scene);
            stage.setTitle("Data Ledger");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @FXML
    public void bukaDataMutasi() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/mutasi-data.fxml"
                            )
                    );

            Scene scene =
                    new Scene(loader.load());

            Stage stage =
                    (Stage) lblJumlahAkun
                            .getScene()
                            .getWindow();

            stage.setScene(scene);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @FXML
    public void exportCsv() {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle("Export");

        alert.setHeaderText(
                "📤 Export Berhasil"
        );

        alert.setContentText(
                "Data berhasil diexport ke file CSV."
        );

        alert.showAndWait();
    }
    @FXML
    public void tentangAplikasi() {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle("Tentang");

        alert.setHeaderText(
                "Sistem Ledger & Mutasi"
        );

        alert.setContentText(
                "Dibuat menggunakan JavaFX untuk memenuhi tugas OOP."
        );

        alert.showAndWait();
    }

    @FXML
    public void logout() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/login.fxml"
                            )
                    );

            Scene scene =
                    new Scene(
                            loader.load()
                    );

            Stage stage =
                    (Stage) lblJumlahAkun
                            .getScene()
                            .getWindow();

            stage.setScene(scene);
            stage.setTitle("Login");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}