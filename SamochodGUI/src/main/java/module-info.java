module org.example.samochodgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires Samochod;
    requires java.desktop;

    opens org.example.samochodgui to javafx.fxml;
    exports org.example.samochodgui;
}