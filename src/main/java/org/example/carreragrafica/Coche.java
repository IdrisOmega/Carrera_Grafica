package org.example.carreragrafica;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;

public class Coche extends Thread {

    String nombre;
    int distancia_recorrida;
    int velocidad_max;
    int velocidad_min;
    Podios podio;
    ProgressBar barra;

    static final int longitud = 1000;

    public Coche(String nombre, int velocidad_max, Podios podio, ProgressBar barra) {
        this.nombre = nombre;
        this.distancia_recorrida = 0;
        this.velocidad_max = velocidad_max;
        this.velocidad_min = 100;
        this.podio = podio;
        this.barra = barra;
    }

    @Override
    public void run() {

        while (distancia_recorrida < longitud) {
            try {
                Thread.sleep((int)(Math.random() * 3000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int avance = velocidad_min + (int)(Math.random() * (velocidad_max - velocidad_min));
            distancia_recorrida += avance;

            if (distancia_recorrida > longitud) {
                distancia_recorrida = longitud;
            }

            double progreso = (double) distancia_recorrida / longitud;

            Platform.runLater(() -> barra.setProgress(progreso));
        }

        podio.registrarLlegada(this);
    }
}
