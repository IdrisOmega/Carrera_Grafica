package org.example.carreragrafica;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class RaceController {

    @FXML private ProgressBar barraZoro;
    @FXML private ProgressBar barraAnne;
    @FXML private ProgressBar barraYuta;
    @FXML private ProgressBar barraYogo;

    @FXML private Label podioLabel;

    private Podios podio;

    @FXML
    public void initialize() {
        podio = new Podios(podioLabel);

        barraZoro.setProgress(0);
        barraAnne.setProgress(0);
        barraYuta.setProgress(0);
        barraYogo.setProgress(0);

        iniciarCarrera(); // empieza sola al abrir
    }

    private void iniciarCarrera() {
        podio.reiniciar();
        podioLabel.setText("Corriendo carrera...");

        Coche p1 = new Coche("Zoro", 300, podio, barraZoro);
        Coche p2 = new Coche("Anne", 300, podio, barraAnne);
        Coche p3 = new Coche("Yuta", 300, podio, barraYuta);
        Coche p4 = new Coche("Yogo", 300, podio, barraYogo);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }
}
