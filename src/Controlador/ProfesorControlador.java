/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAOProfesor;
import Modelo.Profesor;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author welvi
 */
public class ProfesorControlador {

    private final DAOProfesor DAOprofesor;

    public ProfesorControlador() {
        this.DAOprofesor = new DAOProfesor();
    }

    // Método para crear un nuevo cliente
    public void crearProfesor(String Nombre1, String Nombre2, String Apellido1,
            String Apellido2, String Cedula, String Telefono) {
        try {
            Profesor profesor = new Profesor();
            profesor.setNombre1(Nombre1);
            profesor.setNombre2(Nombre2);
            profesor.setApellido1(Apellido1);
            profesor.setApellido2(Apellido2);
            profesor.setCedula(Cedula);
            profesor.setTelefono(Telefono);
            DAOprofesor.crearProfesor(profesor);
            JOptionPane.showMessageDialog(null, "Profesor creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el profesor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todos los clientes
    public List<Profesor> ObtnerTodosProfesores(){
        try {
            return DAOprofesor.leerTodosProfesores();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los Profesor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar un cliente existente
    public void actualizarProfesor(int ID_Profesor, String Nombre1, String Nombre2, String Apellido1,
            String Apellido2, String Cedula, String Telefono) {
        try {
            Profesor profesor = new Profesor();
            profesor.setID_Profesor(ID_Profesor);
            profesor.setNombre1(Nombre1);
            profesor.setNombre2(Nombre2);
            profesor.setApellido1(Apellido1);
            profesor.setApellido2(Apellido2);
            profesor.setCedula(Cedula);
            profesor.setTelefono(Telefono);
            DAOprofesor.actualizarProfesor(profesor);
            JOptionPane.showMessageDialog(null, "Profesor actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el profesor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un cliente
    public void eliminarProfesor(int ID_Profesor) {
        try {
            DAOprofesor.eliminarProfesor(ID_Profesor);
            JOptionPane.showMessageDialog(null, "Profesor eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el profesor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método main para pruebas
     public static void main(String args[]) {
        ProfesorControlador controlador = new ProfesorControlador();

        // Crear un cliente
        controlador.crearProfesor("Juan", "Carlos", "Pérez", "Gómez", "12305678-9", "12345678");

        // Leer todos los clientes
        List<Profesor> profesores = controlador.ObtnerTodosProfesores();
        if (profesores != null) {
            System.out.println("Lista de Profesor:");
            for (Profesor prof : profesores) {
                System.out.println("ID: " + prof.getID_Profesor()
                        + ", Nombre1:" + prof.getNombre1()
                        + ", Nombre2:" + prof.getNombre2()
                        + ", Apellido1: " + prof.getApellido1()
                        + " , Apellido2:" + prof.getApellido2()
                        + ", Cedula: " + prof.getCedula()
                        + ", Telefono: " + prof.getTelefono());
            }
        }

        // Actualizar un cliente (suponiendo que ID 1 existe)
        controlador.actualizarProfesor(1, "Juan", "Carlos", "Pérez", "López", "12305678-9", "12345678");

        // Eliminar un cliente
        controlador.eliminarProfesor(1);
    }
}
