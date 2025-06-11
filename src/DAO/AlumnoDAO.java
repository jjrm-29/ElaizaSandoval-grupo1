package DAO;



import Modelo.Alumno;
import Util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    // Método para insertar un nuevo alumno en la base de datos
    public void crearAlumno(Alumno alumno) throws SQLException {
        String sql = """
            INSERT  INTO Alumno (
                Nombre1, 
                Nombre2, 
                Apellido1,
                Apellido2,
                Nombre_Tutor, 
                Telefono_Tutor,
                Direccion,
                Sexo,
                Fecha_Nac
              ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)""";
        
        try (Connection c = ConexionBD.getConnection(); // Abre la conexión a la base de datos
                 PreparedStatement stmt = c.prepareStatement(sql)) {   // Prepara la consulta SQL
            stmt.setString(1, alumno.getNombre1());                // Asigna valores a cada parámetro
            stmt.setString(2, alumno.getNombre2());
            stmt.setString(3, alumno.getApellido1());
            stmt.setString(4, alumno.getApellido2());
            stmt.setString(5, alumno.getNombre_Tutor());
            stmt.setString(6, alumno.getTelefono_Tutor());
            stmt.setString(7, alumno.getDireccion());
            stmt.setString(8, alumno.getSexo());
            stmt.setDate(9, new java.sql.Date(alumno.getFecha_Nac().getTime()));
            stmt.executeUpdate();                                  // Ejecuta la consulta de inserción
        }
    }

    // Método para leer todos los alumnos de la base de datos
    public List<Alumno> obtenerTodosAlumno() throws SQLException {
        String sql = "SELECT * FROM Alumno";
        List<Alumno> alumnos = new ArrayList<>();

        try (Connection c = ConexionBD.getConnection(); // Abre la conexión
                 PreparedStatement stmt = c.prepareStatement(sql); // Prepara la consulta
                 ResultSet rs = stmt.executeQuery()) {                 // Ejecuta la consulta y obtiene los resultados
            while (rs.next()) {                                    // Recorre cada fila del resultado
                Alumno alumno = new Alumno();                      // Crea un nuevo objeto Alumno
                alumno.setID_Alumno(rs.getInt("ID_Estudiante"));   // Asigna valores desde la BD al objeto
                alumno.setNombre1(rs.getString("Nombre1"));
                alumno.setNombre2(rs.getString("Nombre2"));
                alumno.setApellido1(rs.getString("Apellido1"));
                alumno.setApellido2(rs.getString("Apellido2"));
                alumno.setNombre_Tutor(rs.getString("Nombre_Tutor"));
                alumno.setTelefono_Tutor(rs.getString("Telefono_Tutor"));
                alumno.setDireccion(rs.getString("Direccion"));
                alumno.setSexo(rs.getString("Sexo"));
                alumno.setFecha_Nac(rs.getDate("Fecha_Nac"));
                alumnos.add(alumno);                               // Agrega el alumno a la lista
            }
        }
        return alumnos;                                            // Retorna la lista de alumnos
    }

    // Método para actualizar una categoría
    public void actualizarAlumno(Alumno alumno) throws SQLException {
        String sql = "UPDATE Alumno SET Nombre1 = ?, Nombre2 = ?, Apellido1 = ?, Apellido2 = ?, Nombre_Tutor = ?, Telefono_Tutor = ?, Direccion = ?, Sexo = ?, Fecha_Nac = ? WHERE ID_Estudiante = ?";
        
        try (Connection c = ConexionBD.getConnection(); // Abre la conexión
           PreparedStatement stmt = c.prepareStatement(sql)) {   // Prepara la consulta
            stmt.setString(1, alumno.getNombre1());
            stmt.setString(2, alumno.getNombre2());
            stmt.setString(3, alumno.getApellido1());
            stmt.setString(4, alumno.getApellido2());
            stmt.setString(5, alumno.getNombre_Tutor());
            stmt.setString(6, alumno.getTelefono_Tutor());
            stmt.setString(7, alumno.getDireccion());
            stmt.setString(8, alumno.getSexo());
            stmt.setDate(9, new java.sql.Date(alumno.getFecha_Nac().getTime()));
            stmt.setInt(10, alumno.getID_Alumno());               // ID del alumno que se va a actualizar
            stmt.executeUpdate();
        }
    }

    public Alumno obtenerAlumnoPorId(int ID_Estudiante) throws SQLException {
        String sql = "SELECT * FROM Alumno WHERE ID_Estudiante = ?";
        Alumno alumno = null;

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, ID_Estudiante);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    alumno = new Alumno();
                    alumno.setID_Alumno(rs.getInt("ID_Estudiante"));
                    alumno.setNombre1(rs.getString("nombre1"));
                    alumno.setNombre2(rs.getString("nombre2"));
                    alumno.setApellido1(rs.getString("apellido1"));
                    alumno.setApellido2(rs.getString("apellido2"));
                    alumno.setNombre_Tutor(rs.getString("Nombre_Tutor"));
                    alumno.setTelefono_Tutor(rs.getString("Telefono_Tutor"));
                    alumno.setDireccion(rs.getString("Direccion"));
                    alumno.setSexo(rs.getString("sexo"));
                    alumno.setFecha_Nac(rs.getDate("Fecha_Nac"));
                }
            }
        }
        return alumno;
    }

    // Método para eliminar un alumno por su ID
    public void eliminarAlumno(int ID_Estudiante) throws SQLException {
        String sql = "DELETE FROM Alumno WHERE ID_Estudiante = ?";

        try (Connection c = ConexionBD.getConnection(); // Abre la conexión
                 PreparedStatement stmt = c.prepareStatement(sql)) {   // Prepara la consulta
            stmt.setInt(1, ID_Estudiante);                             // Asigna el ID a eliminar
            stmt.executeUpdate();                                  // Ejecuta la eliminación
        }
    }

// Método Main
    public static void main(String[] args) {
        try {

            AlumnoDAO dao = new AlumnoDAO();

            // Actualizar un cliente
            Alumno Alum = new Alumno();
            Alum.setID_Alumno(1); // ID existente
            Alum.setNombre1("Marlo");
            Alum.setNombre2("David");
            Alum.setApellido1("Cruz");
            Alum.setApellido2("Gómez");
            Alum.setNombre_Tutor("Marvin Zelaya");
            Alum.setTelefono_Tutor("12345678");
            Alum.setDireccion("Lomalinda");
            Alum.setSexo("M");
            Alum.setFecha_Nac(new java.util.Date());
            dao.actualizarAlumno(Alum);
            System.out.println("Alumno actualizado.");

            // Eliminar un cliente
            dao.eliminarAlumno(1); // ID a eliminar
            System.out.println("Profesor eliminado.");

            // Leer y mostrar todos los clientes para verificar
            List<Alumno> Alumnos = dao.obtenerTodosAlumno();
            System.out.println("Lista de Alumnos:");
            for (Alumno prof : Alumnos) {
                System.out.println("ID: " + prof.getID_Alumno()
                        + ", Nombre1:" + prof.getNombre1()
                        + ", Nombre2:" + prof.getNombre2()
                        + ", Apellido1: " + prof.getApellido1()
                        + " , Apellido2:" + prof.getApellido2()
                        + ", Nombre_Tutor: " + prof.getNombre_Tutor()
                        + ", Telefono: " + prof.getTelefono_Tutor()
                        + ", Direccion: " + prof.getDireccion()
                        + ", Sexo: " + prof.getSexo()
                        + ", Fecha: " + prof.getFecha_Nac());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
