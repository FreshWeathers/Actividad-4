import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creación de materias (3 materias para asignarlas a cursos y maestros)
        List<Materia> materias = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese el nombre de la materia " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la clave de la materia: ");
            String clave = scanner.nextLine();
            System.out.println("Ingrese el número de créditos: ");
            int creditos = scanner.nextInt();
            System.out.println("Ingrese las horas semanales: ");
            int horas = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            materias.add(new Materia(nombre, clave, creditos, horas));
        }
        
        // Creación de cursos (1 curso con 3 materias)
        System.out.println("Ingrese el nombre del curso: ");
        String nombreCurso = scanner.nextLine();
        Curso curso = new Curso(nombreCurso, materias);
        curso.calcularCreditos();
        
        // Creación de maestros (1 maestro por cada materia creada)
        List<Maestro> maestros = new ArrayList<>();
        for (int i = 0; i < materias.size(); i++) {
            System.out.println("Ingrese el nombre del maestro " + (i + 1) + ": ");
            String nombreMaestro = scanner.nextLine();
            System.out.println("Ingrese el número de nómina del maestro: ");
            String numeroNomina = scanner.nextLine();
            System.out.println("Ingrese el sueldo por hora: ");
            double sueldoPorHora = scanner.nextDouble();
            scanner.nextLine(); // Consumir salto de línea
            maestros.add(new Maestro(nombreMaestro, numeroNomina, sueldoPorHora, materias.get(i)));
        }
        
        // Creación de alumnos (2 alumnos inscritos en el curso creado)
        List<Alumno> alumnos = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Ingrese el nombre del alumno " + (i + 1) + ": ");
            String nombreAlumno = scanner.nextLine();
            System.out.println("Ingrese la matrícula del alumno: ");
            String matricula = scanner.nextLine();
            System.out.println("Ingrese la edad del alumno: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            alumnos.add(new Alumno(matricula, nombreAlumno, edad, curso));
        }
    
        // Mostrar información
        System.out.println("\n--- Información del Curso ---");
        curso.mostrarInformacion();
        
        System.out.println("\n--- Información de Materias ---");
        for (Materia materia : materias) {
            materia.mostrarInformacion();
        }
        
        System.out.println("\n--- Información de Maestros ---");
        for (Maestro maestro : maestros) {
            maestro.mostrarInformacion();
        }
        
        System.out.println("\n--- Información de Alumnos ---");
        for (Alumno alumno : alumnos) {
            alumno.mostrarInformacion();
        }
        scanner.close();



        // Menu modificar informacion
        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Cambiar maestro de una materia");
            System.out.println("2. Agregar un nuevo maestro (sin materia)");
            System.out.println("3. Asignar una materia a un maestro");
            System.out.println("4. Agregar un nuevo alumno");
            System.out.println("5. Mostrar información de cursos, maestros y alumnos");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("=== Cambiar Maestro de Materia ===");
                    for (int i = 0; i < maestros.size(); i++) {
                        System.out.println(i + ". " + maestros.get(i).getNombre() + " - Materia: " +
                                (maestros.get(i).getMateria() != null ? maestros.get(i).getMateria().getNombre() : "Ninguna"));
                    }
                    System.out.print("Selecciona el maestro a cambiar (número): ");
                    int indexMaestro = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Materias disponibles:");
                    for (int i = 0; i < materias.size(); i++) {
                        System.out.println(i + ". " + materias.get(i).getNombre());
                    }
                    System.out.print("Selecciona la nueva materia (número): ");
                    int indexMateria = scanner.nextInt();
                    scanner.nextLine();

                    maestros.get(indexMaestro).setMateria(materias.get(indexMateria));
                    System.out.println("El maestro " + maestros.get(indexMaestro).getNombre() +
                            " ahora imparte " + materias.get(indexMateria).getNombre());
                    break;

                case 2:
                    System.out.println("=== Agregar Nuevo Maestro ===");
                    System.out.print("Nombre del maestro: ");
                    String nombreMaestro = scanner.nextLine();
                    System.out.print("Número de nómina: ");
                    String nomina = scanner.nextLine();
                    System.out.print("Sueldo por hora: ");
                    double sueldo = scanner.nextDouble();
                    scanner.nextLine();
                    maestros.add(new Maestro(nombreMaestro, nomina, sueldo, null));
                    System.out.println("Maestro agregado sin materia asignada.");
                    break;

                case 3:
                    System.out.println("=== Asignar Materia a Maestro ===");
                    for (int i = 0; i < maestros.size(); i++) {
                        System.out.println(i + ". " + maestros.get(i).getNombre() + " - Materia: " +
                                (maestros.get(i).getMateria() != null ? maestros.get(i).getMateria().getNombre() : "Ninguna"));
                    }
                    System.out.print("Selecciona el maestro (número): ");
                    int indexMaestroAsignar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Materias disponibles:");
                    for (int i = 0; i < materias.size(); i++) {
                        System.out.println(i + ". " + materias.get(i).getNombre());
                    }
                    System.out.print("Selecciona la materia (número): ");
                    int indexMateriaAsignar = scanner.nextInt();
                    scanner.nextLine();

                    maestros.get(indexMaestroAsignar).setMateria(materias.get(indexMateriaAsignar));
                    System.out.println("Materia asignada correctamente.");
                    break;

                case 4:
                    System.out.println("=== Agregar Nuevo Alumno ===");
                    System.out.print("Nombre del alumno: ");
                    String nombreAlumno = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Cursos disponibles:");
                    System.out.println("1. " + curso.getNombre());
                    System.out.print("Selecciona el curso (1): ");
                    int cursoSeleccionado = scanner.nextInt();
                    scanner.nextLine();

                    Curso cursoAsignado = curso;
                    alumnos.add(new Alumno(matricula, nombreAlumno, edad, cursoAsignado));
                    System.out.println("Alumno agregado correctamente.");
                    break;

                case 5:
                    System.out.println("\n=== Información Actualizada ===");
                    curso.mostrarInformacion();
                    for (Maestro maestro : maestros) {
                        maestro.mostrarInformacion();
                    }
                    for (Alumno alumno : alumnos) {
                        alumno.mostrarInformacion();
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
}

   


    }

