package org.example.samochodgui;

import Symulator.SkrzyniaBiegow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import Symulator.Samochod;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SamochodController {

    private Samochod mojSamochod;
    private List<Samochod> listaSamochodow = new ArrayList<>();
    private SkrzyniaBiegow skrzynia;
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
    public Label carIkonka;
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

        if (carIkonka != null) {
            System.out.println("Inicjalizacja ikony samochodu");

            // Ustawienie pozycji (0,0)
            carIkonka.setLayoutX(0);
            carIkonka.setLayoutY(0);
            System.out.println("Pozycja auta ustawiona na: X=" + carIkonka.getLayoutX() + ", Y=" + carIkonka.getLayoutY());
        }

        Samochod fiat = new Samochod("WA 12345","Fiat 126p",   1500);
        Samochod polonez = new Samochod("WB 98765","Polonez Caro" , 1300);
        Samochod syrena = new Samochod("WE 55555", "Syrena 105",  1700);

        fiat.start();
        polonez.start();
        syrena.start();

        listaSamochodow.add(fiat);
        listaSamochodow.add(polonez);
        listaSamochodow.add(syrena);

        mojSamochod = fiat;
        aktualizujWyswietlaneDane();
        // Przykładowe dodanie danych do ComboBoxa
        if (cmbSamochod != null) {
            for (Samochod s : listaSamochodow) {
                // Używamy gettera (musisz go mieć w klasie Samochód) lub pola publicznego
                cmbSamochod.getItems().add(s.getModel());
            }
            // Ustawiamy domyślną wartość w ComboBoxie
            cmbSamochod.setValue(fiat.getModel());
        }

        Thread refreshThread = new Thread(() -> {
            while (true) {
                try {
                    // Odświeżamy co 100ms (10 razy na sekundę)
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }

                // WAŻNE: Aktualizacje GUI muszą być robione w wątku JavaFX
                javafx.application.Platform.runLater(() -> {
                    aktualizujWyswietlaneDane();

                    // Tu dodamy później aktualizację kropki na mapie
                    if (mojSamochod != null && carIkonka != null) {
                        carIkonka.setLayoutX(mojSamochod.getPozycja().getX());
                        carIkonka.setLayoutY(mojSamochod.getPozycja().getY());
                    }
                });
            }
        });
        // Ustawiamy jako Daemon - żeby wątek zginął razem z zamknięciem okna
        refreshThread.setDaemon(true);
        refreshThread.start();
    }



    @FXML
    public void oncmbSamochod(ActionEvent actionEvent) {
        // 1. Pobieramy nazwę wybraną przez użytkownika
        String wybranyModel = cmbSamochod.getValue();


        // 2. Szukamy obiektu samochodu na liście, który pasuje do tej nazwy
        for (Samochod auto : listaSamochodow) {
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
            txtRejestracja.setText(mojSamochod.getNrRejestracyjny()); // lub getNrRejestracji()
            txtPredkosc.setText(String.format("%.1f km/h", mojSamochod.getPredkosc())); // lub getPredkoscMax()
            txtWagaSamochod.setText(String.valueOf(mojSamochod.getSilnik().getWaga() + mojSamochod.getSkrzynia().getWaga() + mojSamochod.getSprzeglo().getWaga()));

            txtNazwaSB.setText(mojSamochod.getSkrzynia().getNazwa());
            txtBiegSB.setText(String.valueOf(mojSamochod.getSkrzynia().getAktualnyBieg()));
            txtCenaSB.setText(String.valueOf(mojSamochod.getSkrzynia().getCena()));
            txtWagaSB.setText(String.valueOf(mojSamochod.getSkrzynia().getWaga()));

            txtNazwaS.setText(mojSamochod.getSilnik().getNazwa());
            txtCenaS.setText(String.valueOf(mojSamochod.getSilnik().getCena()));
            txtWagaS.setText(String.valueOf(mojSamochod.getSilnik().getWaga()));
            txtObrotyS.setText(String.valueOf(mojSamochod.getSilnik().getObroty()));

            txtNazwaSprz.setText(mojSamochod.getSprzeglo().getNazwa());
            txtCenaSprz.setText(String.valueOf(mojSamochod.getSprzeglo().getCena()));
            txtWagaSprz.setText(String.valueOf(mojSamochod.getSprzeglo().getWaga()));
            if (mojSamochod.getSprzeglo().isStanSprzegla()) {
                txtStanSprz.setText("Wciśnięte");
            } else {
                txtStanSprz.setText("Zwolnione");
            }

        }
    }

    public void onStart(ActionEvent actionEvent) {
        System.out.println("Próba włączenia silnika...");
        if (mojSamochod != null) {
            mojSamochod.getSilnik().uruchom();
            System.out.println("Samochód włączony");
        }
        aktualizujWyswietlaneDane();
    }

    public void onEnd(ActionEvent actionEvent) {
        System.out.println("Próba wyłączenia silnika...");
        if (mojSamochod != null) {
            mojSamochod.getSilnik().zatrzymaj();
            System.out.println("Samochód wyłączony");

        }
        aktualizujWyswietlaneDane();
    }

    public void zmniejszBieg(ActionEvent actionEvent) {
        if (mojSamochod != null) {
            boolean stan = mojSamochod.getSprzeglo().isStanSprzegla();
            mojSamochod.getSkrzynia().zmniejszBieg(stan);
            aktualizujWyswietlaneDane();
        }
    }

    public void zwiekszBieg(ActionEvent actionEvent) {
        if (mojSamochod != null) {
            boolean stan = mojSamochod.getSprzeglo().isStanSprzegla();
            mojSamochod.getSkrzynia().zwiekszBieg(stan);
            aktualizujWyswietlaneDane();
        }
    }

    public void ujmijGaz(ActionEvent actionEvent) {
        if (mojSamochod != null){
            mojSamochod.getSilnik().zmniejszObroty(500);
        }
        aktualizujWyswietlaneDane();
    }

    public void dodajGaz(ActionEvent actionEvent) {
        if (mojSamochod != null){
            mojSamochod.getSilnik().zwiekszObroty(500);

        }
        aktualizujWyswietlaneDane();
    }

    public void nacisnijSprzeglo(ActionEvent actionEvent) {
        if (mojSamochod != null) {
            mojSamochod.getSprzeglo().wcisnij();
            System.out.println("Sprzęgło jest wciśnięte");
            aktualizujWyswietlaneDane();
        }
    }

    public void zwolnijSprzeglo(ActionEvent actionEvent) {
        if (mojSamochod != null) {
            mojSamochod.getSprzeglo().zwolnij();
            System.out.println("Sprzęgło nie jest wciśnięte");
            aktualizujWyswietlaneDane();
        }
    }



    public void usunNowy(ActionEvent actionEvent) {
        // 1. Sprawdź, czy w ogóle jest wybrany jakiś samochód
        if (mojSamochod == null) {
            System.out.println("Nie wybrano samochodu do usunięcia.");
            return;
        }

        System.out.println("Usuwanie samochodu: " + mojSamochod.getModel());

        // 2. Usuń auto z listy obiektów (logika)
        listaSamochodow.remove(mojSamochod);

        // 3. Usuń nazwę auta z ComboBoxa (wygląd)
        cmbSamochod.getItems().remove(mojSamochod.getModel());

        // Czyścimy wybór w ComboBoxie
        cmbSamochod.setValue(null);

        // 4. Sprzątanie po usunięciu
        mojSamochod = null; // Aktualny samochód przestaje istnieć

        // 5. Decyzja co wyświetlić teraz
        if (!listaSamochodow.isEmpty()) {
            // Jeśli są jeszcze inne auta, wybierzmy automatycznie pierwsze z listy
            Samochod inneAuto = listaSamochodow.get(0);
            mojSamochod = inneAuto;

            // Ustawiamy w ComboBoxie i odświeżamy pola
            cmbSamochod.setValue(inneAuto.getModel());
            aktualizujWyswietlaneDane();
        } else {
            // Jeśli lista jest pusta, czyścimy wszystkie pola tekstowe
            wyczyscPola();
        }
    }


    private void wyczyscPola() {
        txtModel.clear();
        txtRejestracja.clear();
        txtPredkosc.clear();
        txtWagaSamochod.clear();
        txtNazwaSB.clear();
        txtBiegSB.clear();

    }

    public void Button(ActionEvent actionEvent) {

    }


    // 1. Metoda wywoływana przez przycisk "Dodaj nowy" w głównym oknie
    @FXML
    public void dodajNowy(ActionEvent actionEvent) {
        try {
            // Ładujemy plik FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajSamochod.fxml"));
            Parent root = loader.load();

            // Pobieramy kontroler nowo utworzonego okna
            DodajSamochodController controller = loader.getController();

            // KLUCZOWE: Przekazujemy "siebie" (główny kontroler) do nowego okna
            controller.setMainController(this);

            // Tworzymy i wyświetlamy nowe okno
            Stage stage = new Stage();
            stage.setTitle("Dodaj nowy samochód");
            stage.setScene(new Scene(root));

            // Ustawiamy, że to okno blokuje okno główne dopóki nie zostanie zamknięte
            stage.initModality(Modality.WINDOW_MODAL);
            // stage.initOwner(startButton.getScene().getWindow()); // Opcjonalne: ustawia rodzica

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nie udało się otworzyć okna dodawania.");
            throw new RuntimeException(e);
        }
    }

    // 2. Metoda publiczna, którą wywoła DodajSamochodController po kliknięciu "Zatwierdź"
    public void odbierzNowySamochod(Samochod noweAuto) {
        // Dodajemy do listy logicznej
        listaSamochodow.add(noweAuto);

        // Dodajemy nazwę do ComboBoxa
        if (cmbSamochod != null) {
            cmbSamochod.getItems().add(noweAuto.getModel());

            // Opcjonalnie: od razu wybieramy nowo dodane auto
            cmbSamochod.setValue(noweAuto.getModel());
            // Wywołujemy obsługę zmiany, żeby zaktualizować pola tekstowe
            oncmbSamochod(null);
        }

        System.out.println("Dodano nowe auto: " + noweAuto.getModel());
    }
}