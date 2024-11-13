package Proyecto1;

public class Actividad {
    private String nombre;
    private String tipo; 
    private boolean completado;

    public Actividad(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.completado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void marcarCompletado() {
        this.completado = true;
    }
}

