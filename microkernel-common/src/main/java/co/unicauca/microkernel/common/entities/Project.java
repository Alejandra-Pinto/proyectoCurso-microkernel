package co.unicauca.microkernel.common.entities;

public class Project {
    private String id;
    private String nombre;
    private String fechaFormatoA; // uso String para simplificar la salida
    private String estudiante1;
    private String estudiante2;
    private String profesor;
    private String tipo;
    private String programa;

    public Project() {}

    public Project(String id, String nombre, String fechaFormatoA, String estudiante1, String estudiante2,
                   String profesor, String tipo, String programa) {
        this.id = id;
        this.nombre = nombre;
        this.fechaFormatoA = fechaFormatoA;
        this.estudiante1 = estudiante1;
        this.estudiante2 = estudiante2;
        this.profesor = profesor;
        this.tipo = tipo;
        this.programa = programa;
    }

    // getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFechaFormatoA() { return fechaFormatoA; }
    public void setFechaFormatoA(String fechaFormatoA) { this.fechaFormatoA = fechaFormatoA; }

    public String getEstudiante1() { return estudiante1; }
    public void setEstudiante1(String estudiante1) { this.estudiante1 = estudiante1; }

    public String getEstudiante2() { return estudiante2; }
    public void setEstudiante2(String estudiante2) { this.estudiante2 = estudiante2; }

    public String getProfesor() { return profesor; }
    public void setProfesor(String profesor) { this.profesor = profesor; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getPrograma() { return programa; }
    public void setPrograma(String programa) { this.programa = programa; }
}
