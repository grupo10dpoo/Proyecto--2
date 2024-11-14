package Interface;


import java.util.List;
import java.util.Scanner;
import Persistencia.ArchivoPersistencia;
import Proyecto1.Estudiante;

public class EstudianteUi {

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

        List<Estudiante> estudiantes = ArchivoPersistencia.cargarEstudiantes();
        boolean encontrado = false;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombreUsuario().equals(nombreUsuario) && estudiante.getContrasena().equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso. Bienvenido, " + nombreUsuario + "!");
                encontrado = true;
                // Aquí puedes agregar el código para redirigir al menú principal de Estudiante.
                break;
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

        int idEstudiante = generarIdEstudiante();  // Método para generar un nuevo ID
        Estudiante nuevoEstudiante = new Estudiante(nombreUsuario, contrasena, correo, idEstudiante);

        // Guardar el nuevo estudiante en el archivo
        List<Estudiante> estudiantes = ArchivoPersistencia.cargarEstudiantes();
        estudiantes.add(nuevoEstudiante);
        ArchivoPersistencia.guardarEstudiante(estudiantes);

        System.out.println("Registro exitoso. Ahora puede iniciar sesión.");
    }

    private static int generarIdEstudiante() {
        List<Estudiante> estudiantes = ArchivoPersistencia.cargarEstudiantes();
        return estudiantes.size() + 1;
    }
}


