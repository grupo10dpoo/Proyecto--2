package Proyecto1;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Usuario {
    private int idProfesor;
    private List<LearningPath> learningPaths;
    private List<Estudiante> estudiantes;

    public Profesor(String nombreUsuario, String contrasena, String correo, int idProfesor) {
        super(nombreUsuario, contrasena, correo);
        this.idProfesor = idProfesor;
        this.learningPaths = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public List<LearningPath> getLearningPaths() {
        return learningPaths;
    }

    public void crearLearningPath(LearningPath lp) {
        learningPaths.add(lp);
    }

    public void modificarLearningPath(LearningPath lp, String nuevoTitulo, String nuevaDescripcion) {
        lp.setTitulo(nuevoTitulo);
        lp.setDescripcion(nuevaDescripcion);
    }

    public void eliminarLearningPath(LearningPath lp) {
        learningPaths.remove(lp);
    }

    public void listarLearningPaths() {
        System.out.println("Learning Paths creados por el profesor:");
        for (LearningPath lp : learningPaths) {
            System.out.println("Título: " + lp.getTitulo() + ", Descripción: " + lp.getDescripcion());
        }
    }
    public void calificarEvaluacion(Quiz quiz, List<String> respuestasEstudiante, List<String> respuestasCorrectas) {
        int puntaje = 0;

        for (int i = 0; i < respuestasEstudiante.size(); i++) {
            if (respuestasEstudiante.get(i).equals(respuestasCorrectas.get(i))) {
                puntaje++;
            }
        }

        boolean aprobado = quiz.esAprobado(puntaje);

        System.out.println("Calificación para el quiz: " + puntaje + " respuestas correctas.");
        System.out.println("Resultado: " + (aprobado ? "Aprobado" : "No aprobado"));
    }
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    public List<ProgresoEstudiante> verProgresoEstudiantes(int idLearningPath) {
        List<ProgresoEstudiante> progresoEstudiantes = new ArrayList<>();
    
        for (Estudiante estudiante : estudiantes) {
            ProgresoEstudiante progreso = estudiante.getProgreso(idLearningPath);
            if (progreso != null) { 
                progresoEstudiantes.add(progreso);
            }
        }
    
        return progresoEstudiantes;
    }
    public void asignarActividad(int idLearningPath, Actividad actividad) {
        for (LearningPath lp : learningPaths) {
            if (lp.getId() == idLearningPath) {
                lp.agregarActividad(actividad);
                System.out.println("Actividad asignada al Learning Path: " + lp.getTitulo());
                return;
            }
        }
        System.out.println("Learning Path con ID " + idLearningPath + " no encontrado.");
    }
    public void modificarLearningPath(int idLearningPath, String nuevoTitulo, String nuevaDescripcion, String nuevoTipo, String nuevoObjetivo, String nuevoNivelDificultad, double nuevoTiempoEstimado) {
        for (LearningPath lp : learningPaths) {
            if (lp.getId() == idLearningPath) {
                lp.setTitulo(nuevoTitulo);
                lp.setDescripcion(nuevaDescripcion);
                lp.setTipo(nuevoTipo);
                lp.setObjetivo(nuevoObjetivo);
                lp.setNivelDificultad(nuevoNivelDificultad);
                lp.setTiempoEstimado(nuevoTiempoEstimado);
                System.out.println("Learning Path modificado: " + lp.getTitulo());
                return;
            }
        }
        System.out.println("Learning Path con ID " + idLearningPath + " no encontrado.");
    }
}

