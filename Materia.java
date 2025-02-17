public class Materia {
    private String nombre;
    private String clave;
    private int creditos;
    private int horasSemanales;

    // Constructor por defecto
    public Materia() {
        this.nombre = "Desconocido";
        this.clave = "XXX000";
        this.creditos = 0;
        this.horasSemanales = 0;
    }

    // Constructor con parámetros
    public Materia(String nombre, String clave, int creditos, int horasSemanales) {
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
    }

    // Constructor de copia
    public Materia(Materia otraMateria) {
        this.nombre = otraMateria.nombre;
        this.clave = otraMateria.clave;
        this.creditos = otraMateria.creditos;
        this.horasSemanales = otraMateria.horasSemanales;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    // Método para mostrar información de la materia
    public void mostrarInformacion() {
        System.out.println("Materia: " + nombre);
        System.out.println("Clave: " + clave);
        System.out.println("Créditos: " + creditos);
        System.out.println("Horas semanales: " + horasSemanales);
        System.out.println("----------------------");
    }
}
