package Controlador;

import DAO.GradoDAO;
import Modelo.Grado;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class GradoControlador {

    private final GradoDAO gradoDAO;  // Instancia del DAO para acceso a la base de datos

    // Constructor que inicializa el DAO
    public GradoControlador() {
        this.gradoDAO = new GradoDAO();
    }

    // Método para crear un nuevo grado con su descripción y sección
    public void crearGrado(String Descripcion, String Seccion) {
        try {
            Grado grado = new Grado();              // Se crea un nuevo objeto Grado
            grado.setDescripcion(Descripcion);      // Se asignan los valores recibidos
            grado.setSeccion(Seccion);
            gradoDAO.crearGrado(grado);             // Se guarda en la base de datos
            JOptionPane.showMessageDialog(null, "Grado creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // Se muestra mensaje si ocurre un error
            JOptionPane.showMessageDialog(null, "Error al crear el Grado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todos los grados registrados
    public List<Grado> leerTodosGrados() {
        try {
            return gradoDAO.leerGrado();   // Se llama al DAO para obtener la lista
        } catch (SQLException e) {
            // Se muestra un mensaje en caso de error
            JOptionPane.showMessageDialog(null, "Error al leer los Grado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar un grado existente usando su ID
    public void actualizarGrado(int idGrado, String Descripcion, String Seccion) {
        try {
            Grado grado = new Grado();               // Se crea un objeto Grado
            grado.setID_Grado(idGrado);              // Se establece el ID existente
            grado.setDescripcion(Descripcion);       // Se actualizan los datos
            grado.setSeccion(Seccion);
            gradoDAO.actualizarGrado(grado);         // Se guarda en la base de datos
            JOptionPane.showMessageDialog(null, "Grado actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // Se muestra mensaje de error si algo falla
            JOptionPane.showMessageDialog(null, "Error al actualizar el Grado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un grado dado su ID
    public void eliminarGrado(int idGrado) {
        try {
            gradoDAO.eliminarGrado(idGrado);         // Se elimina mediante el DAO
            JOptionPane.showMessageDialog(null, "Grado eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // En caso de error al eliminar
            JOptionPane.showMessageDialog(null, "Error al eliminar el grado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método principal para probar la lectura de los grados desde la consola
    public static void main(String[] args) {
        GradoControlador controlador = new GradoControlador();  // Se instancia el controlador

        controlador.crearGrado("4to Gado", "A");
        
        System.out.println("Lista de Grado:");
        List<Grado> grados = controlador.leerTodosGrados();     // Se obtiene la lista de grados
        if (grados != null) {
            for (Grado grad : grados) {
                // Se imprime cada grado con su ID y sección
                System.out.println("ID: " + grad.getID_Grado()
                        + ",Descripcion" + grad.getDescripcion()
                        +",Seccion" + grad.getSeccion());
            }
        }
        
         controlador.actualizarGrado(1, "4to Gado", "A");

        controlador.eliminarGrado(1);
    }
}
