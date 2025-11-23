package org.example.samochodgui;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class HelloController {

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtRejestracja;

    @FXML
    private TextField txtWagaSamochod;

    @FXML
    private TextField txtPredkosc;

    @FXML
    private ComboBox<String> cmbSamochod;

    @FXML
    private Pane mapPane;

    @FXML
    public void initialize() {
        // Ta metoda uruchamia się automatycznie po załadowaniu FXML
        System.out.println("Aplikacja uruchomiona!");

        // Przykładowe dodanie danych do ComboBoxa
        if (cmbSamochod != null) {
            cmbSamochod.getItems().addAll("Fiat 126p", "Polonez", "Syrena");
        }
    }

    // Tutaj możesz dodawać metody obsługi przycisków, np.:
    // @FXML
    // private void handleDodajNowy() { ... }
}