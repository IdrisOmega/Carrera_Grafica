package org.example.carreragrafica;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Podios {

    private final ArrayList<Coche> lista = new ArrayList<>();
    private final Label salida;

    public Podios(Label salidaLabel) {
        this.salida = salidaLabel;
    }

    public  void reiniciar() {
        lista.clear();
    }

    public void registrarLlegada(Coche c) {
        lista.add(c);
        if (lista.size() == 4) {
            mostrarPodio();
        }
    }

    private void mostrarPodio() {
        Platform.runLater(() -> {
            StringBuilder sb = new StringBuilder("podio:\n");
            int posicion = 1;
            for (Coche c : lista) {
                sb.append(posicion++).append("º posición \n ").append(c.nombre).append("\n");
            }
            salida.setText(sb.toString());
        });
    }
}
