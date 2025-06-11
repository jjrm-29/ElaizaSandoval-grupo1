/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAOMatricula;
import Modelo.Matricula;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author welvi
 */
public class MatriculaControlador {

    public static void crearMatricula(String ID_Estudiante, String ID_Profesor, String ID_Grado, String ID_Turno, java.sql.Date Fecha_Mat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private final DAOMatricula DAOmatricula;

    public MatriculaControlador() {
        this.DAOmatricula = new DAOMatricula();
    }

    // Método para crear un nuevo cliente
    public void crearMatricula(int ID_Estudiante, int ID_Profesor, int ID_Grado, int ID_Turno, Date Fecha_Mat) {
        try {
            Matricula matricula = new Matricula();
            matricula.setID_Estudiante(ID_Estudiante);
            matricula.setID_Profesor(ID_Profesor);
            matricula.setID_Grado(ID_Grado);
            matricula.setID_Turno(ID_Turno);
            matricula.setFecha_Mat(Fecha_Mat);
            DAOmatricula.crearMatricula(matricula);
            JOptionPane.showMessageDialog(null, "Matricula creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el Matricula: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todos los clientes
    public List<Matricula> ObtnerTodosMatricula() {
        try {
            return DAOmatricula.obtenerTodosMatricula();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los Matricula: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar un cliente existente
    public void actualizarMatricula(int ID_Matricula, int ID_Estudiante, int ID_Profesor,
            int ID_Grado, int ID_Turno, Date Fecha_Mat) {
        try {
            Matricula matricula = new Matricula();
            matricula.setID_Estudiante(ID_Matricula);
            matricula.setID_Estudiante(ID_Estudiante);
            matricula.setID_Profesor(ID_Profesor);
            matricula.setID_Grado(ID_Grado);
            matricula.setID_Turno(ID_Turno);
            matricula.setFecha_Mat(Fecha_Mat);
            DAOmatricula.actualizarMatricula(matricula);
            JOptionPane.showMessageDialog(null, "Matricula actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el Matricula: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un cliente
    public void eliminarMatricula(int ID_Matricula) {
        try {
            DAOmatricula.eliminarMatricula(ID_Matricula);
            JOptionPane.showMessageDialog(null, "Matricula eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el Matricula: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método main para pruebas
    public static void main(String args[]) {
      MatriculaControlador controlador = new MatriculaControlador();

        // Crear un cliente
        controlador.crearMatricula(1, 2, 3, 4, new Date());

        // Leer todos los clientes
        List<Matricula> matricula = controlador.ObtnerTodosMatricula();
        if (matricula != null) {
            System.out.println("Lista de Profesor:");
            for (Matricula matr : matricula) {
                System.out.println("ID: " + matr.getID_Matricula()
                        + "ID ID_Estudiante : " + matr.getID_Estudiante()
                        + "ID ID_Profesor : " + matr.getID_Profesor()
                        + "ID ID_Grado: " + matr.getID_Grado()
                        + "ID ID_Turno: " + matr.getID_Turno()
                        + ", Fecha_Mat: " + matr.getFecha_Mat());
            
            }
        }

        // Actualizar un cliente (suponiendo que ID 1 existe)
        controlador.actualizarMatricula(1, 2, 3, 4, 5, new Date());

        // Eliminar un cliente
        controlador.eliminarMatricula(1);
    }
}
