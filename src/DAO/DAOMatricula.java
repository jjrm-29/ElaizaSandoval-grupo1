/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Matricula;
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
public class DAOMatricula {

    public void crearMatricula(Matricula matricula) throws SQLException {

        String sql = """
        INSERT INTO Matricula (
            ID_Estudiante, 
            ID_Profesor,
            ID_Grado, 
            ID_Turno,
            Fecha_Mat
        ) VALUES (?, ?, ?, ?, ?)""";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, matricula.getID_Estudiante());
            stmt.setInt(2, matricula.getID_Profesor());
            stmt.setInt(3, matricula.getID_Grado());
            stmt.setInt(4, matricula.getID_Turno());
            stmt.setDate(5, new java.sql.Date(matricula.getFecha_Mat().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Matricula> obtenerTodosMatricula() throws SQLException {
        String sql = "SELECT * FROM Matricula";
        List<Matricula> matriculas = new ArrayList<>();

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Matricula matricula = new Matricula();
                matricula.setID_Matricula(rs.getInt("ID_Matricula"));
                matricula.setID_Estudiante(rs.getInt("ID_Estudiante"));
                matricula.setID_Profesor(rs.getInt("ID_Profesor"));
                matricula.setID_Grado(rs.getInt("ID_Grado"));
                matricula.setID_Turno(rs.getInt("ID_Turno"));
                matricula.setFecha_Mat(rs.getDate("Fecha_Mat"));
                matriculas.add(matricula);
            }
        }
        return matriculas;
    }

    public void actualizarMatricula(Matricula matricula) throws SQLException {
        String sql = "UPDATE Matricula SET  ID_Estudiante = ?, ID_Profesor = ?, ID_Grado = ?, ID_Turno = ?, Fecha_Mat = ? WHERE ID_Matricula = ?";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, matricula.getID_Estudiante());
            stmt.setInt(2, matricula.getID_Profesor());
            stmt.setInt(3, matricula.getID_Grado());
            stmt.setInt(4, matricula.getID_Turno());
            stmt.setDate(5, new java.sql.Date(matricula.getFecha_Mat().getTime()));
            stmt.setInt(6, matricula.getID_Matricula());
            stmt.executeUpdate();
        }
    }

// Método para eliminar un cliente
    public void eliminarMatricula(int ID_Matricula) throws SQLException {
        String sql = "DELETE FROM Matricula WHERE ID_Matricula = ?";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, ID_Matricula);
            stmt.executeUpdate();
        }
    }

// Método Main
    public static void main(String[] args) {
        try {

            DAOMatricula dao = new DAOMatricula();

            // Actualizar un cliente
            Matricula matricula = new Matricula();
            matricula.setID_Matricula(1); // ID existente
            matricula.setID_Estudiante(1);
            matricula.setID_Profesor(1);
            matricula.setID_Grado(1);
            matricula.setID_Turno(1);
            matricula.setFecha_Mat(new java.util.Date());
            dao.actualizarMatricula(matricula);
            System.out.println("Profesor actualizado.");

            // Eliminar un cliente
            dao.eliminarMatricula(1); // ID a eliminar
            System.out.println("Profesor eliminado.");

            // Leer y mostrar todos los clientes para verificar
            List<Matricula> matriculas = dao.obtenerTodosMatricula();
            System.out.println("Lista de Matricula:");
            for (Matricula matr : matriculas) {
                System.out.println("ID: " + matr.getID_Matricula()
                        + "ID ID_Estudiante : " + matr.getID_Estudiante()
                        + "ID ID_Profesor : " + matr.getID_Profesor()
                        + "ID ID_Grado: " + matr.getID_Grado()
                        + "ID ID_Turno: " + matr.getID_Turno()
                        + ", Fecha_Mat: " + matr.getFecha_Mat());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
