package Proyecto1;

import java.util.HashSet;
import java.util.Set;

public class ProgresoEstudiante {
    private double porcentajeCompletado;
    private int totalActividades;
    private Set<String> actividadesCompletadas;

    public ProgresoEstudiante(int totalActividades) {
        this.totalActividades = totalActividades;
        this.porcentajeCompletado = 0.0;
        this.actividadesCompletadas = new HashSet<>();
    }

    public double getPorcentajeCompletado() {
        return porcentajeCompletado;
    }

    public void completarActividad(String nombreActividad) {
        if (!actividadesCompletadas.contains(nombreActividad)) {
            actividadesCompletadas.add(nombreActividad);
            actualizarProgreso();
            System.out.println("Actividad " + nombreActividad + " completada.");
        } else {
            System.out.println("Ya completó esta actividad.");
        }
    }

    private void actualizarProgreso() {
        this.porcentajeCompletado = (double) actividadesCompletadas.size() / totalActividades * 100;
    }
}

