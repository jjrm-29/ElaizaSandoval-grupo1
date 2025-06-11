/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author welvi
 */
public class Matricula {

    private int ID_Matricula;
    private int ID_Estudiante;
    private int ID_Profesor;
    private int ID_Grado;
    private int ID_Turno;
    private Date Fecha_Mat;

    public Matricula() {
    }

    public Matricula(int ID_Matricula, int ID_Estudiante, int ID_Profesor, int ID_Grado, int ID_Turno, Date Fecha_Mat) {
        this.ID_Matricula = ID_Matricula;
        this.ID_Estudiante = ID_Estudiante;
        this.ID_Profesor = ID_Profesor;
        this.ID_Grado = ID_Grado;
        this.ID_Turno = ID_Turno;
        this.Fecha_Mat = Fecha_Mat;
    }

    public int getID_Matricula() {
        return ID_Matricula;
    }

    public void setID_Matricula(int ID_Matricula) {
        this.ID_Matricula = ID_Matricula;
    }

    public int getID_Estudiante() {
        return ID_Estudiante;
    }

    public void setID_Estudiante(int ID_Estudiante) {
        this.ID_Estudiante = ID_Estudiante;
    }

    public int getID_Profesor() {
        return ID_Profesor;
    }

    public void setID_Profesor(int ID_Profesor) {
        this.ID_Profesor = ID_Profesor;
    }

    public int getID_Grado() {
        return ID_Grado;
    }

    public void setID_Grado(int ID_Grado) {
        this.ID_Grado = ID_Grado;
    }

    public int getID_Turno() {
        return ID_Turno;
    }

    public void setID_Turno(int ID_Turno) {
        this.ID_Turno = ID_Turno;
    }

    public Date getFecha_Mat() {
        return Fecha_Mat;
    }

    public void setFecha_Mat(Date Fecha_Mat) {
        this.Fecha_Mat = Fecha_Mat;
    }

}
