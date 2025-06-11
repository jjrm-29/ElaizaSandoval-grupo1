package DAO;

import Modelo.Turno;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAO {
    // Método para insertar un nuevo turno en la base de datos

    public void crearTurno(Turno turno) throws SQLException {
        String sql = "INSERT INTO Turno (descripcion) VALUES (?)";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, turno.getDescripcion());
            stmt.executeUpdate();
        }
    }

    // Método para leer todos los turnos desde la base de datos
    public List<Turno> leerTurno() throws SQLException {
        String sql = "SELECT * FROM Turno";
        List<Turno> turnos = new ArrayList<>();                                // Lista que almacenará los resultados

        try (Connection c = ConexionBD.getConnection(); // Abre conexión
                 PreparedStatement stmt = c.prepareStatement(sql); // Prepara la consulta
                 ResultSet rs = stmt.executeQuery()) {                             // Ejecuta la consulta y guarda el resultado
            while (rs.next()) {                                                // Itera sobre cada fila del resultado
                Turno turno = new Turno();
                turno.setID_Turno(rs.getInt("ID_Turno"));                      // Establece el ID
                turno.setDescripcion(rs.getString("Descripcion"));             // Establece la descripción
                turnos.add(turno);                                             // Agrega a la lista
            }
        }
        return turnos;                                                         // Devuelve la lista de turnos
    }

    // Método para actualizar un turno existente
    public void actualizarTurno(Turno turno) throws SQLException {
        String sql = "UPDATE Turno SET Descripcion = ? WHERE ID_Turno = ?";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, turno.getDescripcion());                         // Asigna nueva descripción
            stmt.setInt(2, turno.getID_Turno());// ❌ Falta asignar el ID del turno en el parámetro 2 (ver abajo)
            stmt.executeUpdate();                                              // Ejecuta la actualización
        }
    }

    // Método para eliminar un turno por ID
    public void eliminarTurno(int ID_Turno) throws SQLException {
        String sql = "DELETE FROM Turno WHERE ID_Turno = ?";                   // ❌ ERROR: Tabla incorrecta (debería ser 'Turno')

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, ID_Turno);                                          // Asigna ID del turno a eliminar
            stmt.executeUpdate();                                              // Ejecuta la eliminación
        }
    }

// Método Main
    public static void main(String args[]) {
        try {

            TurnoDAO dao = new TurnoDAO();

            // Actualizar un cliente
            Turno Turnos = new Turno();
            Turnos.setID_Turno(1);
            Turnos.setDescripcion("Matutino");// ID existente
            System.out.println("Turno actualizado.");

            // Eliminar un cliente
            dao.eliminarTurno(1); // ID a eliminar
            System.out.println("Turno eliminado.");

            // Leer y mostrar todos los clientes para verificar
            List<Turno> turnos = dao.leerTurno();
            System.out.println("Lista de Grado:");
            for (Turno turn : turnos) {
                System.out.println("ID: " + turn.getID_Turno()
                        + ", Descripcion:" + turn.getDescripcion());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
