package DAO;

import Modelo.Grado;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradoDAO {

    // Método para insertar un nuevo grado en la base de datos
    public void crearGrado(Grado grado) throws SQLException {
        String sql = """
        INSERT INTO Grado (
          Descripcion,
          Seccion
        ) VALUES (?, ?)""";

        try (Connection c = ConexionBD.getConnection(); // Abre conexión a la BD
                 PreparedStatement stmt = c.prepareStatement(sql)) {                 // Prepara la consulta SQL
            stmt.setString(1, grado.getDescripcion());                           // Asigna el valor de Descripción
            stmt.setString(2, grado.getSeccion());                               // Asigna el valor de Sección
            stmt.executeUpdate();                                                // Ejecuta la inserción
        }
    }

    // Método para leer todos los registros de grado desde la base de datos
    public List<Grado> leerGrado() throws SQLException {
        String sql = "SELECT * FROM Grado";                                      // Consulta para obtener todos los grados
        List<Grado> grados = new ArrayList<>();                                  // Lista donde se almacenarán los resultados

        try (Connection c = ConexionBD.getConnection(); // Abre conexión
                 PreparedStatement stmt = c.prepareStatement(sql); // Prepara la consulta
                 ResultSet rs = stmt.executeQuery()) {                               // Ejecuta la consulta
            while (rs.next()) {                                                  // Recorre cada fila de resultados
                Grado grado = new Grado();                                       // Crea un objeto Grado
                grado.setID_Grado(rs.getInt("ID_Grado"));                        // Asigna el ID
                grado.setDescripcion(rs.getString("Descripcion"));               // Asigna la descripción
                grado.setSeccion(rs.getString("Seccion"));                       // Asigna la sección
                grados.add(grado);                                               // Agrega el objeto a la lista
            }
        }
        return grados;                                                           // Retorna la lista de grados
    }

    // Método para actualizar un registro de grado
    public void actualizarGrado(Grado grado) throws SQLException {
        String sql = "UPDATE Grado SET Descripcion = ?, Seccion = ?  WHERE ID_Grado = ?";  // Consulta para actualizar

        try (Connection c = ConexionBD.getConnection(); // Abre conexión
                 PreparedStatement stmt = c.prepareStatement(sql)) {                // Prepara la consulta
            stmt.setString(1, grado.getDescripcion());                          // Asigna la nueva descripción
            stmt.setString(2, grado.getSeccion());                              // Asigna la nueva sección
            stmt.setInt(3, grado.getID_Grado());
            stmt.executeUpdate();                                               // Ejecuta la actualización
        }
    }

    // Método para eliminar un grado por su ID
    public void eliminarGrado(int ID_Grado) throws SQLException {
        String sql = "DELETE FROM Grado WHERE ID_Grado = ?";                 // Consulta para eliminar (posiblemente con columna incorrecta)

        try (Connection c = ConexionBD.getConnection(); // Abre conexión
                 PreparedStatement stmt = c.prepareStatement(sql)) {                // Prepara la consulta
            stmt.setInt(1, ID_Grado);                                           // Asigna el ID a eliminar
            stmt.executeUpdate();                                               // Ejecuta la eliminación
        }
    }

// Método Main
    public static void main(String args[]) {
        try {

            GradoDAO dao = new GradoDAO();

            // Actualizar un cliente
            Grado Grados = new Grado();
            Grados.setID_Grado(1);
            Grados.setDescripcion("4to Grado");// ID existente
            Grados.setSeccion("A");
            System.out.println("Profesor actualizado.");

            // Eliminar un cliente
            dao.eliminarGrado(1); // ID a eliminar
            System.out.println("Grado eliminado.");

            // Leer y mostrar todos los clientes para verificar
            List<Grado> setID_Grado = dao.leerGrado();
            System.out.println("Lista de Grado:");
            for (Grado Gra : setID_Grado) {
                System.out.println("ID: " + Gra.getID_Grado()
                        + ", Descripcion:" + Gra.getDescripcion()
                        + ", Seccion:" + Gra.getSeccion());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
