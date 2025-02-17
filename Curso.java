import java.util.List;

public class Curso {
    private String nombre;
    private List<Materia> materias;
    private int creditosTotales;

    // Constructor por defecto
    public Curso() {
        this.nombre = "Sin nombre";
        this.materias = null;
        this.creditosTotales = 0;
    }

    // Constructor con parámetros
    public Curso(String nombre, List<Materia> materias) {
        this.nombre = nombre;
        this.materias = materias;
        calcularCreditos();
    }

    // Constructor de copia
    public Curso(Curso otroCurso) {
        this.nombre = otroCurso.nombre;
        this.materias = otroCurso.materias;
        this.creditosTotales = otroCurso.creditosTotales;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
        calcularCreditos();
    }

    public int getCreditosTotales() {
        return creditosTotales;
    }

    // Método para calcular créditos totales del curso
    void calcularCreditos() {
        this.creditosTotales = 0;
        for (Materia materia : materias) {
            this.creditosTotales += materia.getCreditos();
        }
    }

    // Método para mostrar información del curso
    public void mostrarInformacion() {
        System.out.println("Curso: " + nombre);
        System.out.println("Materias:");
        for (Materia materia : materias) {
            System.out.println(" - " + materia.getNombre() + " (" + materia.getCreditos() + " créditos)");
        }
        System.out.println("Créditos totales del curso: " + creditosTotales);
        System.out.println("----------------------");
    }
}
