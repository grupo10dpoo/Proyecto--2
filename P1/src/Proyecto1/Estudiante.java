package Proyecto1;

import java.util.HashMap;
import java.util.Map;

public class Estudiante extends Usuario {
    private int idEstudiante;
    private Map<Integer, ProgresoEstudiante> progresos; 

    public Estudiante(String nombreUsuario, String contrasena, String correo, int idEstudiante) {
        super(nombreUsuario, contrasena, correo);
        this.idEstudiante = idEstudiante;
        this.progresos = new HashMap<>();
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

   
    public void inscribirseEnLearningPath(LearningPath lp) {
        if (!progresos.containsKey(lp.getId())) {
            ProgresoEstudiante progreso = new ProgresoEstudiante(lp.getActividades().size());
            progresos.put(lp.getId(), progreso);
            System.out.println("Estudiante inscrito en el Learning Path: " + lp.getTitulo());
        } else {
            System.out.println("Ya está inscrito en este Learning Path.");
        }
    }

    
    public void completarActividad(int idLearningPath, String nombreActividad) {
        ProgresoEstudiante progreso = progresos.get(idLearningPath);
        if (progreso != null) {
            progreso.completarActividad(nombreActividad);
        } else {
            System.out.println("No está inscrito en este Learning Path.");
        }
    }

    
    public ProgresoEstudiante getProgreso(int idLearningPath) {
        return progresos.get(idLearningPath);
    }



public void hacerReseña(LearningPath lp, String comentario, int calificacion) {
    if (progresos.containsKey(lp.getId())) {
        Reseña reseña = new Reseña(comentario, calificacion, this.getNombreUsuario());
        lp.agregarReseña(reseña);
        System.out.println("Reseña añadida al Learning Path: " + lp.getTitulo());
    } else {
        System.out.println("Debe estar inscrito en el Learning Path para hacer una reseña.");
    }
}
}
