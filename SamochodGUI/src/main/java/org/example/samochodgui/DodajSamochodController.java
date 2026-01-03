package org.example.samochodgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Symulator.Samochod;

public class DodajSamochodController {


    @FXML private TextField inputModel;
    @FXML private TextField inputRejestracja;
    @FXML private TextField inputWaga;
    @FXML private TextField inputPredkosc;

    @FXML private Button btnZatwierdz;
    @FXML private Button btnAnuluj;

    // Referencja do głównego kontrolera, żebyśmy mogli mu oddać nowe auto
    private HelloController mainController;

    // Metoda, którą wywoła HelloController, żeby się "przedstawić"
    public void setMainController(HelloController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void initialize() {
        // Tu podpinamy akcje pod przyciski (lub można to zrobić w FXML onAction="#...")
        btnZatwierdz.setOnAction(event -> zatwierdz());
        btnAnuluj.setOnAction(event -> zamknijOkno());
    }

    private void zatwierdz() {
        String model = inputModel.getText();
        String rejestracja = inputRejestracja.getText();
        double waga;
        int predkosc;

        // Walidacja danych
        try {
            waga = Double.parseDouble(inputWaga.getText());
            predkosc = Integer.parseInt(inputPredkosc.getText());
        } catch (NumberFormatException e) {
            System.out.println("Błąd: Waga i prędkość muszą być liczbami!");
            // Tu można dodać np. Alert z błędem
            return;
        }

        // Tworzymy nowy obiekt samochodu
        // UWAGA: Upewnij się, że Twój konstruktor w klasie Samochód przyjmuje double dla wagi
        // Jeśli waga w klasie Samochód to int, rzutuj: (int) waga
        Samochod noweAuto = new Samochod(model, rejestracja, predkosc, (int)waga);

        // Przekazujemy auto do głównego kontrolera
        if (mainController != null) {
            mainController.odbierzNowySamochod(noweAuto);
        }

        zamknijOkno();
    }

    private void zamknijOkno() {
        Stage stage = (Stage) btnAnuluj.getScene().getWindow();
        stage.close();
    }
}