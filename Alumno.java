public class Alumno {
    private String matricula;
    private String nombre;
    private int edad;
    private Curso curso;

    // Constructor por defecto
    public Alumno() {
        this.matricula = "Sin matrícula";
        this.nombre = "Desconocido";
        this.edad = 0;
        this.curso = null;
    }

    // Constructor con parámetros
    public Alumno(String matricula, String nombre, int edad, Curso curso) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    // Constructor de copia
    public Alumno(Alumno otroAlumno) {
        this.matricula = otroAlumno.matricula;
        this.nombre = otroAlumno.nombre;
        this.edad = otroAlumno.edad;
        this.curso = otroAlumno.curso;
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    // Método para mostrar información del alumno
    public void mostrarInformacion() {
        System.out.println("Alumno: " + nombre);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Edad: " + edad);
        System.out.println("Curso: " + (curso != null ? curso.getNombre() : "No asignado"));
        System.out.println("----------------------");
    }
}
