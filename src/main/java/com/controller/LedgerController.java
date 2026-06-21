package com.controller;

import com.model.Ledger;
import com.service.LedgerService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.Locale;

public class LedgerController {

    @FXML
    private TableView<Ledger> tableLedger;

    @FXML
    private TableColumn<Ledger, String> colTanggal;

    @FXML
    private TableColumn<Ledger, String> colAkun;

    @FXML
    private TableColumn<Ledger, String> colDebit;

    @FXML
    private TableColumn<Ledger, String> colKredit;

    @FXML
    private TableColumn<Ledger, String> colKeterangan;

    @FXML
    private Label lblTotalDebit;

    @FXML
    private Label lblTotalKredit;

    @FXML
    private TextField txtCari;

    private void loadLedger() {

        LedgerService service =
                new LedgerService();

        ObservableList<Ledger> data =
                FXCollections.observableArrayList(
                        service.getAllLedger()
                );

        tableLedger.setItems(data);

        double totalDebit =
                data.stream()
                        .mapToDouble(Ledger::getDebit)
                        .sum();

        double totalKredit =
                data.stream()
                        .mapToDouble(Ledger::getKredit)
                        .sum();

        NumberFormat rupiah =
                NumberFormat.getInstance(
                        new Locale("id", "ID")
                );

        lblTotalDebit.setText(
                "💰 Total Debit : Rp "
                        + rupiah.format(totalDebit)
        );

        lblTotalKredit.setText(
                "💳 Total Kredit : Rp "
                        + rupiah.format(totalKredit)
        );

        tableLedger.refresh();

        System.out.println(
                "Jumlah Data : "
                        + data.size()
        );
    }

    @FXML
    public void initialize() {

        System.out.println(
                "LEDGER BERHASIL DILOAD"
        );

        NumberFormat rupiah =
                NumberFormat.getInstance(
                        new Locale("id", "ID")
                );

        colTanggal.setCellValueFactory(
                c -> new SimpleStringProperty(
                        c.getValue().getTanggal()
                )
        );

        colAkun.setCellValueFactory(
                c -> new SimpleStringProperty(
                        c.getValue().getAkun()
                )
        );

        colDebit.setCellValueFactory(
                c -> new SimpleStringProperty(
                        "Rp "
                                + rupiah.format(
                                c.getValue().getDebit()
                        )
                )
        );

        colKredit.setCellValueFactory(
                c -> new SimpleStringProperty(
                        "Rp "
                                + rupiah.format(
                                c.getValue().getKredit()
                        )
                )
        );

        colKeterangan.setCellValueFactory(
                c -> new SimpleStringProperty(
                        c.getValue().getKeterangan()
                )
        );

        tableLedger.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );

        loadLedger();
    }

    @FXML
    public void refreshData() {

        loadLedger();

        System.out.println(
                "Data berhasil diperbarui"
        );
    }

    @FXML
    public void exportCsv() {

        try {

            javafx.stage.FileChooser fileChooser =
                    new javafx.stage.FileChooser();

            fileChooser.setTitle(
                    "Simpan File CSV"
            );

            fileChooser.setInitialFileName(
                    "ledger.csv"
            );

            java.io.File file =
                    fileChooser.showSaveDialog(
                            tableLedger.getScene()
                                    .getWindow()
                    );

            if (file == null) {
                return;
            }

            java.io.PrintWriter writer =
                    new java.io.PrintWriter(file);

            writer.println(
                    "Tanggal,Akun,Debit,Kredit,Keterangan"
            );

            for (Ledger ledger :
                    tableLedger.getItems()) {

                writer.println(
                        ledger.getTanggal() + "," +
                                ledger.getAkun() + "," +
                                ledger.getDebit() + "," +
                                ledger.getKredit() + "," +
                                ledger.getKeterangan()
                );
            }

            writer.close();

            Alert alert =
                    new Alert(
                            Alert.AlertType.INFORMATION
                    );

            alert.setTitle("Export CSV");
            alert.setHeaderText("Berhasil");
            alert.setContentText(
                    "File CSV berhasil disimpan."
            );

            alert.showAndWait();

        } catch (Exception e) {

            e.printStackTrace();

            Alert alert =
                    new Alert(
                            Alert.AlertType.ERROR
                    );

            alert.setTitle("Export CSV");
            alert.setHeaderText("Gagal");
            alert.setContentText(
                    e.getMessage()
            );

            alert.showAndWait();
        }
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