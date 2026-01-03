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


    @FXML private Button btnZatwierdz;
    @FXML private Button btnAnuluj;

    // Referencja do głównego kontrolera, żebyśmy mogli mu oddać nowe auto
    private SamochodController mainController;

    // Metoda, którą wywoła HelloController, żeby się "przedstawić"
    public void setMainController(SamochodController mainController) {
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

        if (model.isEmpty() || rejestracja.isEmpty() || inputWaga.getText().isEmpty()) {
            pokazBlad("Wszystkie pola muszą być wypełnione!");
            return;
        }

        // Walidacja danych
        try {
            waga = Double.parseDouble(inputWaga.getText());

        } catch (NumberFormatException e) {
            pokazBlad("Błąd: Waga musi być liczbą!");
            return;
        }

        // Tworzymy nowy obiekt samochodu
        // UWAGA: Upewnij się, że Twój konstruktor w klasie Samochód przyjmuje double dla wagi
        // Jeśli waga w klasie Samochód to int, rzutuj: (int) waga
        Samochod noweAuto = new Samochod(rejestracja,model, (int)waga);
        noweAuto.start();

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

    private void pokazBlad(String komunikat) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("Błąd danych");
        alert.setHeaderText(null);
        alert.setContentText(komunikat);
        alert.showAndWait();
    }
}