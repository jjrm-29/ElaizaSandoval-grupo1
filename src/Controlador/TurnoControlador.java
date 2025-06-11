package Controlador;

import DAO.TurnoDAO;
import Modelo.Turno;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class TurnoControlador {

 // Objeto que se encarga de acceder a los datos de Turno
    private final TurnoDAO turnoDAO;

    // Constructor que inicializa el DAO
    public TurnoControlador() {
        this.turnoDAO = new TurnoDAO();
    }

    // Método para crear un nuevo turno
    public void crearTurno(String Descripcion) {
        try {
            Turno turno = new Turno();             // Creamos un nuevo objeto Turno
            turno.setDescripcion(Descripcion);     // Le asignamos la descripción recibida
            turnoDAO.crearTurno(turno);            // Guardamos el turno en la base de datos
            JOptionPane.showMessageDialog(null, "Grado creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // Mostramos un mensaje si ocurre un error
            JOptionPane.showMessageDialog(null, "Error al crear el Grado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para leer todos los turnos desde la base de datos
    public List<Turno> leerTurnos() {
        try {
            return turnoDAO.leerTurno();   // Llama al DAO para obtener la lista de turnos
        } catch (SQLException e) {
            // En caso de error, muestra un mensaje y devuelve null
            JOptionPane.showMessageDialog(null, "Error al leer los Grado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar un turno existente
    public void actualizarTurno(int idTurno, String Descripcion) {
        try {
            Turno turno = new Turno();                // Creamos un objeto Turno
            turno.setID_Turno(idTurno);               // Establecemos el ID del turno a actualizar
            turno.setDescripcion(Descripcion);        // Asignamos la nueva descripción
            turnoDAO.actualizarTurno(turno);          // Actualizamos en la base de datos
            JOptionPane.showMessageDialog(null, "turno actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // En caso de error, se muestra un mensaje
            JOptionPane.showMessageDialog(null, "Error al actualizar el turno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un turno por su ID
    public void eliminarTurno(int idTurno) {
        try {
            turnoDAO.eliminarTurno(idTurno);   // Llama al DAO para eliminar el turno
            JOptionPane.showMessageDialog(null, "turno eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // Muestra un mensaje si ocurre un turno
            JOptionPane.showMessageDialog(null, "Error al eliminar el turno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método principal para probar la lectura de turnos
    public static void main(String[] args) {
        TurnoControlador controlador = new TurnoControlador();  // Creamos el controlador

        controlador.crearTurno("Matutino");
        
        
        System.out.println("Leyendo turnos...");
        List<Turno> turnos = controlador.leerTurnos();          // Obtenemos la lista de turnos
        if (turnos != null) {
            // Mostramos cada turno en consola
            for (Turno t : turnos) {
                System.out.println("ID: " + t.getID_Turno() + " - Descripción: " + t.getDescripcion());
            }
        }
        controlador.actualizarTurno(1, "Matutino");
        
        controlador.eliminarTurno(1);
    }
}
