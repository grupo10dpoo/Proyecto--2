package Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Persistencia.ArchivoPersistencia;
import Proyecto1.LearningPath;
import Proyecto1.Profesor;

public class ProfesorUi {
		
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Registrarse");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        switch (opcion) {
            case 1:
                iniciarSesion();
                break;
            case 2:
                registrarse();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    private static void iniciarSesion() {
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();

        List<Profesor> profesores = ArchivoPersistencia.cargarProfesores();
        boolean encontrado = false;

        for (Profesor profesor : profesores) {
            if (profesor.getNombreUsuario().equals(nombreUsuario) && profesor.getContrasena().equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso. Bienvenido, " + nombreUsuario + "!");
                encontrado = true;
                
                mostrarMenuProfesor(profesor);
                // Aquí puedes agregar el código para redirigir al menú principal de Profesor.
               
            }
        }

        if (!encontrado) {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
    }

    private static void registrarse() {
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.print("Ingrese correo: ");
        String correo = scanner.nextLine();

        int idProfesor = generarIdProfesor();  // Método para generar un nuevo ID
        Profesor nuevoProfesor = new Profesor(nombreUsuario, contrasena, correo, idProfesor);

        // Guardar el nuevo profesor en el archivo
        ArchivoPersistencia.guardarProfesor(nuevoProfesor);  // Cambiado a guardarProfesor

        System.out.println("Registro exitoso. De ahora en adelante podrias iniciar sesión.");
        
        mostrarMenuProfesor(nuevoProfesor);
    }
    
    private static void mostrarMenuProfesor(Profesor profesor) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nBienvenido, " + profesor.getNombreUsuario());
            System.out.println("1. Ver perfil");
            System.out.println("2. Crear Learning Path");
            System.out.println("3. Modificar Learning Path");
            System.out.println("4. Agregar Actividad");
            System.out.println("5. Calificar Examenes");
            System.out.println("6. Calificar Quizzes");

            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Perfil del Profesor:");
                    System.out.println("Nombre: " + profesor.getNombreUsuario());
                    System.out.println("Correo: " + profesor.getCorreo());
                    break;
                /*
                case 2:
                    crearLearningPathProfesor(profesor);
                    break;
				*/
                case 5:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
    private static int generarIdProfesor() {
        List<Profesor> profesores = ArchivoPersistencia.cargarProfesores();
        return profesores.size() + 1;
    }
    
    //Funcionalidades
    
}



