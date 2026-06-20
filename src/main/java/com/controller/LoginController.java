package com.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.scene.control.Label;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblNotif;

    private void tampilkanNotifikasiError(String pesan) {

        lblNotif.setText("❌ " + pesan);

        lblNotif.setStyle(
                "-fx-background-color:#F44336;" +
                        "-fx-text-fill:white;" +
                        "-fx-padding:12;" +
                        "-fx-font-size:14;" +
                        "-fx-font-weight:bold;" +
                        "-fx-background-radius:8;"
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
    public void login() {

        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if(username.equals("hemat")
                && password.equals("hemat123")) {

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
                        (Stage) txtUsername
                                .getScene()
                                .getWindow();

                stage.setScene(scene);

            } catch (Exception e) {

                e.printStackTrace();
            }

        } else {

            tampilkanNotifikasiError(
                    "Username atau Password Salah"
            );
        }
    }
}