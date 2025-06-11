package Controlador;

import DAO.AlumnoDAO;
import Modelo.Alumno;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class AlumnoControlador {

    private final AlumnoDAO alumnoDAO; // Objeto que permite interactuar con la base de datos

    // Constructor que inicializa el DAO
    public AlumnoControlador() {
        this.alumnoDAO = new AlumnoDAO();
    }

    // Método para crear un nuevo alumno con todos sus datos
    public void crearAlumno(String Nombre1, String Nombre2, String Apellido1, String Apellido2, String Nombre_Tutor, String Telefono_Tutor, String Direccion, String Sexo, Date Fecha_Nac) {
        try {
            Alumno alumno = new Alumno();                        // Se crea un nuevo objeto Alumno
            alumno.setNombre1(Nombre1);
            alumno.setNombre2(Nombre2);
            alumno.setApellido1(Apellido1);
            alumno.setApellido2(Apellido2);
            alumno.setNombre_Tutor(Nombre_Tutor);
            alumno.setTelefono_Tutor(Telefono_Tutor);
            alumno.setDireccion(Direccion);
            alumno.setSexo(Sexo);
            alumno.setFecha_Nac(Fecha_Nac);
            alumnoDAO.crearAlumno(alumno);                      // Se guarda el alumno en la base de datos
            JOptionPane.showMessageDialog(null, "Alumno creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // Muestra un mensaje si ocurre un error al guardar
            JOptionPane.showMessageDialog(null, "Error al crear el Alumno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todos los empleados
    public List<Alumno> obtenerTodosAlumno() {
        try {
            return alumnoDAO.obtenerTodosAlumno();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener todos los alumno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar los datos de un alumno existente
    public void actualizarAlumno(int ID_Estudiante, String Nombre1, String Nombre2, String Apellidos1,
            String Apellidos2, String Nombre_Tutor, String Telefono_Tutor,
            String Direccion, String Sexo, Date Fecha_Nac) {
        try {
            Alumno alumnos = new Alumno();                      // Se crea un objeto Alumno con nuevos datos
            alumnos.setID_Alumno(ID_Estudiante);                     // Se especifica el ID del alumno a actualizar
            alumnos.setNombre1(Nombre1);
            alumnos.setNombre2(Nombre2);
            alumnos.setApellido1(Apellidos1);
            alumnos.setApellido2(Apellidos2);
            alumnos.setNombre_Tutor(Nombre_Tutor);
            alumnos.setTelefono_Tutor(Telefono_Tutor);
            alumnos.setDireccion(Direccion);
            alumnos.setSexo(Sexo);
            alumnos.setFecha_Nac(Fecha_Nac);
            alumnoDAO.actualizarAlumno(alumnos);               // Se actualiza el alumno en la base de datos
            JOptionPane.showMessageDialog(null, "Alumno actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // Muestra mensaje si ocurre un error al actualizar
            JOptionPane.showMessageDialog(null, "Error al actualizar el Alumno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un alumno usando su ID
    public void eliminarAlumno(int ID_Estudiante) {
        try {
            alumnoDAO.eliminarAlumno(ID_Estudiante);               // Se elimina de la base de datos
            JOptionPane.showMessageDialog(null, "Alumno eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // Muestra mensaje si ocurre un error
            JOptionPane.showMessageDialog(null, "Error al eliminar alumno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método principal para probar la lectura de alumnos en consola
    public static void main(String[] args) {
        AlumnoControlador controlador = new AlumnoControlador();

// Se crea una instancia del controlador
        controlador.crearAlumno("Juan", "David", "Ramos", "Molina", "Ramon Flores", "12345678", "Lomalinda", "M",  new Date());
         
          
        List<Alumno> Alumnos = controlador.obtenerTodosAlumno();
        if (Alumnos != null) {
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
        }

        // Actualizar un cliente (suponiendo que ID 1 existe)
        controlador.actualizarAlumno(1, "Juan", "David", "Ramos", "Molina", "Ramon Flores", "12345678", "Lomalinda", "M",  new Date());

        // Eliminar un cliente
        controlador.eliminarAlumno(1);
    }
}
