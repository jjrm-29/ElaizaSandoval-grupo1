package Modelo;

import java.util.Date;



public class Alumno {
    private int ID_Estudiante;
    private String Nombre1;
    private String Nombre2;
    private String Apellido1;
    private String Apellido2;
    private String Nombre_Tutor;
    private String Telefono_Tutor;
    private String Direccion;
    private String Sexo;
    private Date Fecha_Nac;

    public Alumno() {
    }

    public Alumno(int ID_Estudiante, String Nombre1, String Nombre2, String Apellido1, String Apellido2, String Nombre_Tutor, String Telefono_Tutor, String Direccion, String Sexo, Date Fecha_Nac) {
        this.ID_Estudiante = ID_Estudiante;
        this.Nombre1 = Nombre1;
        this.Nombre2 = Nombre2;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.Nombre_Tutor = Nombre_Tutor;
        this.Telefono_Tutor = Telefono_Tutor;
        this.Direccion = Direccion;
        this.Sexo = Sexo;
        this.Fecha_Nac = Fecha_Nac;
    }

    public int getID_Alumno() {
        return ID_Estudiante;
    }

    public void setID_Alumno(int ID_Estudiante) {
        this.ID_Estudiante = ID_Estudiante;
    }

    public String getNombre1() {
        return Nombre1;
    }

    public void setNombre1(String Nombre1) {
        this.Nombre1 = Nombre1;
    }

    public String getNombre2() {
        return Nombre2;
    }

    public void setNombre2(String Nombre2) {
        this.Nombre2 = Nombre2;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    public String getNombre_Tutor() {
        return Nombre_Tutor;
    }

    public void setNombre_Tutor(String Nombre_Tutor) {
        this.Nombre_Tutor = Nombre_Tutor;
    }

    public String getTelefono_Tutor() {
        return Telefono_Tutor;
    }

    public void setTelefono_Tutor(String Telefono_Tutor) {
        this.Telefono_Tutor = Telefono_Tutor;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public Date getFecha_Nac() {
        return Fecha_Nac;
    }

    public void setFecha_Nac(Date Fecha_Nac) {
        this.Fecha_Nac = Fecha_Nac;
    }
    
    
}
