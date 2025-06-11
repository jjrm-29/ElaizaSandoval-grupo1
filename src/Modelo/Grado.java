package Modelo;


public class Grado {
    private int ID_Grado;
    private String Descripcion;
    private String Seccion;

    public Grado() {
    }

    public Grado(int ID_Grado, String Descripcion, String Seccion) {
        this.ID_Grado = ID_Grado;
        this.Descripcion = Descripcion;
        this.Seccion = Seccion;
    }

    public int getID_Grado() {
        return ID_Grado;
    }

    public void setID_Grado(int ID_Grado) {
        this.ID_Grado = ID_Grado;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getSeccion() {
        return Seccion;
    }

    public void setSeccion(String Seccion) {
        this.Seccion = Seccion;
    }
    
    
}
