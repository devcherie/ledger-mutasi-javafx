package com.controller;

import com.model.MutasiView;
import com.service.MutasiService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.Locale;

public class MutasiDataController {

    @FXML
    private TableView<MutasiView> tableMutasi;

    @FXML
    private TableColumn<MutasiView, String> colTanggal;

    @FXML
    private TableColumn<MutasiView, String> colAkunAsal;

    @FXML
    private TableColumn<MutasiView, String> colAkunTujuan;

    @FXML
    private TableColumn<MutasiView, String> colNominal;

    @FXML
    private TableColumn<MutasiView, String> colKeterangan;

    @FXML
    public void initialize() {

        NumberFormat rupiah =
                NumberFormat.getInstance(
                        new Locale("id", "ID")
                );

        colTanggal.setCellValueFactory(
                c -> new SimpleStringProperty(
                        c.getValue().getTanggal()
                )
        );

        colAkunAsal.setCellValueFactory(
                c -> new SimpleStringProperty(
                        c.getValue().getAkunAsal()
                )
        );

        colAkunTujuan.setCellValueFactory(
                c -> new SimpleStringProperty(
                        c.getValue().getAkunTujuan()
                )
        );

        colNominal.setCellValueFactory(
                c -> new SimpleStringProperty(
                        "Rp " +
                                rupiah.format(
                                        c.getValue().getNominal()
                                )
                )
        );

        colKeterangan.setCellValueFactory(
                c -> new SimpleStringProperty(
                        c.getValue().getKeterangan()
                )
        );

        MutasiService service =
                new MutasiService();

        ObservableList<MutasiView> data =
                FXCollections.observableArrayList(
                        service.getAllMutasi()
                );

        tableMutasi.setItems(data);
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
                    new Scene(loader.load());

            Stage stage =
                    (Stage) tableMutasi
                            .getScene()
                            .getWindow();

            stage.setScene(scene);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}