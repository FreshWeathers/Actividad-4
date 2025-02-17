public class Maestro {
    private String nombre;
    private String numeroNomina;
    private double sueldoPorHora;
    private Materia materia;

    // Constructor por defecto
    public Maestro() {
        this.nombre = "Desconocido";
        this.numeroNomina = "N/A";
        this.sueldoPorHora = 0.0;
        this.materia = null;
    }

    // Constructor con parámetros
    public Maestro(String nombre, String numeroNomina, double sueldoPorHora, Materia materia) {
        this.nombre = nombre;
        this.numeroNomina = numeroNomina;
        this.sueldoPorHora = sueldoPorHora;
        this.materia = materia;
    }

    // Constructor de copia
    public Maestro(Maestro otroMaestro) {
        this.nombre = otroMaestro.nombre;
        this.numeroNomina = otroMaestro.numeroNomina;
        this.sueldoPorHora = otroMaestro.sueldoPorHora;
        this.materia = otroMaestro.materia;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroNomina() {
        return numeroNomina;
    }

    public void setNumeroNomina(String numeroNomina) {
        this.numeroNomina = numeroNomina;
    }

    public double getSueldoPorHora() {
        return sueldoPorHora;
    }

    public void setSueldoPorHora(double sueldoPorHora) {
        this.sueldoPorHora = sueldoPorHora;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    // Método para calcular sueldo semanal
    public double calcularSueldoSemanal() {
        return sueldoPorHora * (materia != null ? materia.getHorasSemanales() : 0);
    }

    // Método para mostrar información del maestro
    public void mostrarInformacion() {
        System.out.println("Maestro: " + nombre);
        System.out.println("Número de nómina: " + numeroNomina);
        System.out.println("Sueldo por hora: $" + sueldoPorHora);
        System.out.println("Materia impartida: " + (materia != null ? materia.getNombre() : "Ninguna"));
        System.out.println("Sueldo semanal: $" + calcularSueldoSemanal());
        System.out.println("----------------------");
    }
}
