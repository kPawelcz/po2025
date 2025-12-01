package org.example.samochodgui;

import Symulator.Skrzynia_Biegów;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import Symulator.Samochód;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    private Samochód mojSamochod;
    private List<Samochód> listaSamochodow = new ArrayList<>();
    private Skrzynia_Biegów skrzynia;
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

        Samochód fiat = new Samochód("Fiat 126p", "WA 12345", 120 , 1500);
        Samochód polonez = new Samochód("Polonez Caro", "WB 98765", 150, 1300);
        Samochód syrena = new Samochód("Syrena 105", "WE 55555", 90, 1700);

        listaSamochodow.add(fiat);
        listaSamochodow.add(polonez);
        listaSamochodow.add(syrena);

        mojSamochod = fiat;
        aktualizujWyswietlaneDane();
        // Przykładowe dodanie danych do ComboBoxa
        if (cmbSamochod != null) {
            for (Samochód s : listaSamochodow) {
                // Używamy gettera (musisz go mieć w klasie Samochód) lub pola publicznego
                cmbSamochod.getItems().add(s.getModel());
            }
            // Ustawiamy domyślną wartość w ComboBoxie
            cmbSamochod.setValue(fiat.getModel());
        }
    }



    @FXML
    public void oncmbSamochod(ActionEvent actionEvent) {
        // 1. Pobieramy nazwę wybraną przez użytkownika
        String wybranyModel = cmbSamochod.getValue();
        System.out.println("Wybrano z listy: " + wybranyModel);

        // 2. Szukamy obiektu samochodu na liście, który pasuje do tej nazwy
        for (Samochód auto : listaSamochodow) {
            if (auto.getModel().equals(wybranyModel)) {
                // 3. Podmieniamy aktualny samochód na ten wybrany
                mojSamochod = auto;

                // 4. Aktualizujemy pola tekstowe na ekranie
                aktualizujWyswietlaneDane();
                break; // Znaleźliśmy, kończymy pętlę
            }
        }
    }

    private void aktualizujWyswietlaneDane() {

        if (mojSamochod != null) {
            txtModel.setText(mojSamochod.getModel());
            txtRejestracja.setText(mojSamochod.nrRejestracji); // lub getNrRejestracji()
            txtPredkosc.setText(String.valueOf(mojSamochod.predkość_max)); // lub getPredkoscMax()
            txtWagaSamochod.setText(String.valueOf(mojSamochod.getWaga()));
            // Jeśli masz pole waga:
            // txtWagaSamochod.setText(String.valueOf(mojSamochod.getWaga()));
        }
    }

    public void onStart(ActionEvent actionEvent) {
        System.out.println("Próba włączenia silnika...");
        if (mojSamochod != null) {
            mojSamochod.wlacz();
            System.out.println("Samochód włączony");
        }

    }

    public void onEnd(ActionEvent actionEvent) {
        System.out.println("Próba wyłączenia silnika...");
        if (mojSamochod != null) {
            mojSamochod.wylacz();
            System.out.println("Samochód wyłączony");
        }

    }

    public void zmniejszBieg(ActionEvent actionEvent) {
        System.out.println("Zmniejszanie biegu...");
        if (mojSamochod != null) {
            mojSamochod.zmniejszBieg();
            System.out.println("Bieg: " + mojSamochod.dajBieg());
        }
    }

    public void zwiekszBieg(ActionEvent actionEvent) {
        System.out.println("Zwiekszenie biegu...");
        if (mojSamochod != null) {
            mojSamochod.zwiekszBieg();
            System.out.println("Bieg: " + mojSamochod.dajBieg());
        }
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




    // Tutaj możesz dodawać metody obsługi przycisków, np.:
    // @FXML
    // private void handleDodajNowy() { ... }
}