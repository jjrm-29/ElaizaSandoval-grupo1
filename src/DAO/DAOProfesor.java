/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Profesor;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author welvi
 */
public class DAOProfesor {

    public void crearProfesor(Profesor profesor) throws SQLException {

        String sql = """
        INSERT INTO Profesor (
            Nombre1,
            Nombre2,
            Apellido1,
            Apellido2,
            Cedula,
            Telefono
        ) VALUES (?, ?, ?, ?, ?, ?)""";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, profesor.getNombre1());
            stmt.setString(2, profesor.getNombre2());
            stmt.setString(3, profesor.getApellido1());
            stmt.setString(4, profesor.getApellido2());
            stmt.setString(5, profesor.getCedula());
            stmt.setString(6, profesor.getTelefono());
            stmt.executeUpdate();
        }
    }

    public List<Profesor> leerTodosProfesores() throws SQLException {
        String sql = "SELECT * FROM Profesor";
        List<Profesor> profesores = new ArrayList<>();

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setID_Profesor(rs.getInt("ID_Profesor"));
                profesor.setNombre1(rs.getString("Nombre1"));
                profesor.setNombre2(rs.getString("Nombre2"));
                profesor.setApellido1(rs.getString("Apellido1"));
                profesor.setApellido2(rs.getString("Apellido2"));
                profesor.setCedula(rs.getString("Cedula"));
                profesor.setTelefono(rs.getString("Telefono"));
                profesores.add(profesor);
            }
        }
        return profesores;
    }

    public Profesor obtenerProfesorPorId(int ID_Profesor) throws SQLException {
        String sql = "SELECT * FROM Profesor WHERE ID_Profesor = ?";
        Profesor profesores = null;
        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, ID_Profesor);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    profesores = new Profesor();
                    profesores.setID_Profesor(rs.getInt("ID_Profesor"));
                    profesores.setNombre1(rs.getString("Nombre1"));
                    profesores.setNombre2(rs.getString("Nombre2"));
                    profesores.setApellido1(rs.getString("Apellido1"));
                    profesores.setApellido2(rs.getString("Apellido2"));
                    profesores.setCedula(rs.getString("Cedula"));
                    profesores.setTelefono(rs.getString("Telefono"));
                }
            }
        }

        return profesores;
    }

    public void actualizarProfesor(Profesor profesor) throws SQLException {
        String sql = "UPDATE Profesor SET Nombre1 = ?, Nombre2 = ?, Apellido1 = ?, Apellido2 = ?, Cedula = ?, Telefono = ? WHERE ID_Profesor = ?";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, profesor.getNombre1());
            stmt.setString(2, profesor.getNombre2());
            stmt.setString(3, profesor.getApellido1());
            stmt.setString(4, profesor.getApellido2());
            stmt.setString(5, profesor.getCedula());
            stmt.setString(6, profesor.getTelefono());
            stmt.setInt(7, profesor.getID_Profesor());
            stmt.executeUpdate();
        }
    }

// Método para eliminar un cliente
    public void eliminarProfesor(int ID_Profesor) throws SQLException {
        String sql = "DELETE FROM Profesor WHERE ID_Profesor = ?";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, ID_Profesor);
            stmt.executeUpdate();
        }
    }

// Método Main
    public static void main(String args[]) {
        try {

            DAOProfesor dao = new DAOProfesor();

            // Actualizar un cliente
            Profesor profesor = new Profesor();
            profesor.setID_Profesor(1); // ID existente
            profesor.setNombre1("Marlo");
            profesor.setNombre2("David");
            profesor.setApellido1("Cruz");
            profesor.setApellido2("Gómez");
            profesor.setCedula("12305678-9");
            profesor.setTelefono("12345678");
            dao.actualizarProfesor(profesor);
            System.out.println("Profesor actualizado.");

            // Eliminar un cliente
            dao.eliminarProfesor(1); // ID a eliminar
            System.out.println("Profesor eliminado.");

            // Leer y mostrar todos los clientes para verificar
            List<Profesor> profesores = dao.leerTodosProfesores();
            System.out.println("Lista de profesores:");
            for (Profesor prof : profesores) {
                System.out.println("ID: " + prof.getID_Profesor()
                        + ", Nombre1:" + prof.getNombre1()
                        + ", Nombre2:" + prof.getNombre2()
                        + ", Apellido1: " + prof.getApellido1()
                        + " , Apellido2:" + prof.getApellido2()
                        + ", Cedula: " + prof.getCedula()
                        + ", Telefono: " + prof.getTelefono());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
