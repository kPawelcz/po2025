package org.example.samochodgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import Symulator.Samochód;

public class HelloController {

    private Samochód mojSamochod;
    public Button startButton;
    public Button endButton;
    public Button zwiekszBieg;
    public Button zmniejsz;
    public Button dodajGaz;
    public Button ujmijGaz;
    public Button naccisnijSprzeglo;
    public Button zwolnijSprzeglo;
    public Button dodajNowy;
    public Button usunNowy;
    public Button Button;
    public TextField txtNazwaSB;
    public TextField txtCenaSB;
    public TextField txtWagaSB;
    public TextField txtBiegSB;
    public TextField txtNazwaS;
    public TextField txtCenaS;
    public TextField txtWagaS;
    public TextField txtObrotyS;
    public TextField txtStanSprz;
    public TextField txtWagaSprz;
    public TextField txtCenaSprz;
    public TextField txtNazwaSprz;
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

        mojSamochod = new Samochód("Fiat 126p", "WA 12345", 120);
        // Przykładowe dodanie danych do ComboBoxa
        if (cmbSamochod != null) {
            cmbSamochod.getItems().addAll("Fiat 126p", "Polonez", "Syrena");
        }
    }

    public void onStart(ActionEvent actionEvent) {
        System.out.println("Próba włączenia silnika...");
        if (mojSamochod != null) {
            mojSamochod.wlacz();
        }
    }

    public void onEnd(ActionEvent actionEvent) {
    }

    public void zmniejszBieg(ActionEvent actionEvent) {
    }

    public void zwiekszBieg(ActionEvent actionEvent) {
    }

    public void ujmijGaz(ActionEvent actionEvent) {
    }

    public void dodajGaz(ActionEvent actionEvent) {
    }

    public void nacisnijSprzeglo(ActionEvent actionEvent) {
    }

    public void zwolnijSprzeglo(ActionEvent actionEvent) {
    }

    public void dodajNowy(ActionEvent actionEvent) {
    }

    public void usunNowy(ActionEvent actionEvent) {
    }

    public void Button(ActionEvent actionEvent) {

    }

    public void oncmbSamochod(ActionEvent actionEvent) {

    }


    // Tutaj możesz dodawać metody obsługi przycisków, np.:
    // @FXML
    // private void handleDodajNowy() { ... }
}