module org.example.carreragrafica {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.carreragrafica to javafx.fxml;
    exports org.example.carreragrafica;
}