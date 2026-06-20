package com.controller;

import com.model.Ledger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class LedgerController {

    @FXML
    private TableView<Ledger> tableLedger;

    @FXML
    private TableColumn<Ledger, String> colTanggal;

    @FXML
    private TableColumn<Ledger, String> colAkun;

    @FXML
    private TableColumn<Ledger, Double> colDebit;

    @FXML
    private TableColumn<Ledger, Double> colKredit;

    @FXML
    private TableColumn<Ledger, String> colKeterangan;

    @FXML
    private Label lblTotalDebit;

    @FXML
    private Label lblTotalKredit;

    @FXML
    private TextField txtCari;

    @FXML
    public void initialize() {

        System.out.println("LEDGER BERHASIL DILOAD");

        colTanggal.setCellValueFactory(
                new PropertyValueFactory<>("tanggal"));

        colAkun.setCellValueFactory(
                new PropertyValueFactory<>("akun"));

        colDebit.setCellValueFactory(
                new PropertyValueFactory<>("debit"));

        colKredit.setCellValueFactory(
                new PropertyValueFactory<>("kredit"));

        colKeterangan.setCellValueFactory(
                new PropertyValueFactory<>("keterangan"));

        ObservableList<Ledger> data =
                FXCollections.observableArrayList();

        data.add(
                new Ledger(
                        "2026-06-20",
                        "Kas",
                        50000.0,
                        0.0,
                        "Setoran"
                )
        );

        data.add(
                new Ledger(
                        "2026-06-20",
                        "Bank",
                        0.0,
                        50000.0,
                        "Transfer"
                )
        );

        tableLedger.setItems(data);

        lblTotalDebit.setText(
                "💰 Total Debit : Rp 50.000"
        );

        lblTotalKredit.setText(
                "💳 Total Kredit : Rp 50.000"
        );

        System.out.println(
                "Jumlah Data : " + data.size()
        );
    }

    @FXML
    public void refreshData() {

        Thread thread =
                new Thread(() -> {

                    try {

                        Thread.sleep(3000);

                        System.out.println(
                                "Data berhasil diperbarui"
                        );

                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                });

        thread.start();
    }

    @FXML
    public void exportCsv() {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(
                "Export"
        );

        alert.setHeaderText(
                "Export Berhasil"
        );

        alert.setContentText(
                "Data Ledger berhasil diexport."
        );

        alert.showAndWait();
    }
    @FXML
    public void cariData() {

        String keyword =
                txtCari.getText();

        System.out.println(
                "Mencari : " + keyword
        );
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
                    (Stage) tableLedger
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