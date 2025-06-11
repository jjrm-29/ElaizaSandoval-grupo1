package Modelo;



public class Turno {
    private int ID_Turno;
    private String Descripcion;

    public Turno() {
    }

    public Turno(int ID_Turno, String Descripcion) {
        this.ID_Turno = ID_Turno;
        this.Descripcion = Descripcion;
    }

    public int getID_Turno() {
        return ID_Turno;
    }

    public void setID_Turno(int ID_Turno) {
        this.ID_Turno = ID_Turno;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
}
