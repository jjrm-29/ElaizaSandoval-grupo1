package VISTA;

import Controlador.AlumnoControlador;
import Modelo.Alumno;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JTextField;



public class VistaAlumno extends javax.swing.JPanel {

    private final AlumnoControlador AlumnoControlador;

    public VistaAlumno() {
        initComponents();
        this.AlumnoControlador = new AlumnoControlador();
        selectorfechaNacimiento.setDate(new Date());
        ((JTextField) selectorfechaNacimiento.getDateEditor().getUiComponent()).setEditable(false);
        cargarDatosTabla();
    }

    private Integer ID_Estudiante = null;

    private void cargarDatosTabla() {
        List<Alumno> alumno = AlumnoControlador.obtenerTodosAlumno();
        if (alumno != null) {
            DefaultTableModel model = (DefaultTableModel) TablaAlumno.getModel();
            model.setRowCount(0);
            for (Alumno alm : alumno) {
                Object[] row = {
                    alm.getID_Alumno(),
                    alm.getNombre1(),
                    alm.getNombre2(),
                    alm.getApellido1(),
                    alm.getApellido2(),
                    alm.getNombre_Tutor(),
                    alm.getTelefono_Tutor(),
                    alm.getDireccion(),
                    alm.getSexo(),
                    alm.getFecha_Nac()
                };
                model.addRow(row);
            }
        }
    }

    private void limpiar() {
        textNombre1.setText("");
        textNombre2.setText("");
        textApellido1.setText("");
        textApellido2.setText("");
        textnombreTutor.setText("");
        texttelefonoTutor.setText("");
        textDireccion.setText("");
        textSexo.setText("");
        textBuscar.setText("");

        ID_Estudiante = null;
        selectorfechaNacimiento.setDate(new Date());

        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(true);
    }

    /**
     * Creates new form VistaEmpleado
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textNombre1 = new javax.swing.JTextField();
        textNombre2 = new javax.swing.JTextField();
        textApellido1 = new javax.swing.JTextField();
        textApellido2 = new javax.swing.JTextField();
        textnombreTutor = new javax.swing.JTextField();
        texttelefonoTutor = new javax.swing.JTextField();
        textDireccion = new javax.swing.JTextField();
        selectorfechaNacimiento = new com.toedter.calendar.JDateChooser();
        textSexo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        textBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAlumno = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(textNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 101, 36));
        jPanel1.add(textNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 104, 34));

        textApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textApellido1ActionPerformed(evt);
            }
        });
        jPanel1.add(textApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 97, 34));

        textApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textApellido2ActionPerformed(evt);
            }
        });
        jPanel1.add(textApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 101, 36));
        jPanel1.add(textnombreTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 104, 36));
        jPanel1.add(texttelefonoTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 120, 36));

        textDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(textDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 127, 110, 35));
        jPanel1.add(selectorfechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 127, 130, 35));

        textSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSexoActionPerformed(evt);
            }
        });
        jPanel1.add(textSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 127, 80, 35));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
                accionBotonGuardar(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 110, 30));

        jButton2.setText("Actualizar ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionBotonActualizar(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 110, 30));

        btnEliminar.setText("Eliminar ");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
                accionBotonEliminar(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 110, 29));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionBotonLimpiar(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 110, 31));

        textBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscarActionPerformed(evt);
                textBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(textBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 160, 20));

        TablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Estudiante", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Nombre Tutor", "Telefono Tutor", "Dirección", "Fecha Nacimiento", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaAlumno);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 750, 230));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Apellido1");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Apellido2");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Nombre Tutor");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Telefono Tutor");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Direccion");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Fecha Nacimiento");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Sexo");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jButton3.setText("Generar Reportes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionBotonGenerarReporte(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 120, 30));

        jLabel5.setText("Buscar");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 40, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textApellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textApellido1ActionPerformed

    private void textApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textApellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textApellido2ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void accionBotonGuardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonGuardar
        Date fecha = this.selectorfechaNacimiento.getDate();
        java.sql.Date fechaNacimiento = new java.sql.Date(fecha.getTime());

        String Nombre1 = textNombre1.getText();
        String Nombre2 = textNombre2.getText();
        String Apellido1 = textApellido1.getText();
        String Apellido2 = textApellido2.getText();
        String NombreTutor = textnombreTutor.getText();
        String TelefonoTutor = texttelefonoTutor.getText();
        String Direccion = textDireccion.getText();
        String Sexo = textSexo.getText();

        if (!Nombre1.isEmpty() && !Apellido1.isEmpty() && !TelefonoTutor.isEmpty() && !Direccion.isEmpty() && !Sexo.isEmpty()) {
            try {
                AlumnoControlador.crearAlumno(Nombre1, Nombre2, Apellido1, Apellido2, NombreTutor, TelefonoTutor, Direccion, Sexo, fechaNacimiento);
                limpiar();
                cargarDatosTabla();
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error al crear alumno", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Llene los campos requeridos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_accionBotonGuardar

    private void textBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscarActionPerformed

    private void textBuscarKeyTyped(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscarKeyTyped
        String textoBusqueda = textBuscar.getText().trim().toLowerCase();
        List<Alumno> alumno = AlumnoControlador.obtenerTodosAlumno();

        DefaultTableModel modelo = (DefaultTableModel) TablaAlumno.getModel();
        modelo.setRowCount(0);

        if (alumno != null) {
            for (Alumno alm : alumno) {
                if (textoBusqueda.isEmpty()
                        || alm.getNombre1().toLowerCase().contains(textoBusqueda)
                        || (alm.getNombre2() != null && alm.getNombre2().toLowerCase().contains(textoBusqueda))
                        || alm.getApellido1().toLowerCase().contains(textoBusqueda)
                        || (alm.getApellido2() != null && alm.getApellido2().toLowerCase().contains(textoBusqueda)
                        || alm.getNombre_Tutor().toLowerCase().contains(textoBusqueda)
                        || alm.getTelefono_Tutor().toLowerCase().contains(textoBusqueda)
                        || alm.getDireccion().toLowerCase().contains(textoBusqueda))
                        || alm.getSexo().toLowerCase().contains(textoBusqueda)) {

                    Object[] fila = {
                        alm.getNombre1(),
                        alm.getNombre2(),
                        alm.getApellido1(),
                        alm.getApellido2(),
                        alm.getNombre_Tutor(),
                        alm.getTelefono_Tutor(),
                        alm.getDireccion(),
                        alm.getFecha_Nac(),
                        alm.getSexo()
                    };
                    modelo.addRow(fila);
                }
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscarKeyTyped

    private void textSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSexoActionPerformed

    private void accionBotonActualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonActualizar
        String Nombre1 = textNombre1.getText();
        String Nombre2 = textNombre2.getText();
        String Apellido1 = textApellido1.getText();
        String Apellido2 = textApellido2.getText();
        String NombreTutor = textnombreTutor.getText();
        String TelefonoTutor = texttelefonoTutor.getText();
        String Direccion = textDireccion.getText();
        String Sexo = textSexo.getText();
        Date fecha = this.selectorfechaNacimiento.getDate();
        java.sql.Date fechaNacimiento = new java.sql.Date(fecha.getTime());

        if (!Nombre1.isEmpty() && !Nombre2.isEmpty() && !Apellido1.isEmpty() && !Apellido2.isEmpty() && !NombreTutor.isEmpty()
                && !TelefonoTutor.isEmpty() && !Direccion.isEmpty() && !Sexo.isEmpty()) {

            AlumnoControlador.actualizarAlumno(1, Nombre1, Nombre2, Apellido1, Apellido2, NombreTutor, TelefonoTutor, Direccion, Sexo, fecha);
            cargarDatosTabla();

            textNombre1.setText(Nombre1);
            textNombre2.setText(Nombre2);
            textApellido1.setText(Apellido1);
            textApellido2.setText(Apellido2);
            texttelefonoTutor.setText("");
            textDireccion.setText("");
            textSexo.setText("");

            btnEliminar.setEnabled(true);
            btnGuardar.setEnabled(true);

        } else {

            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, llene los campos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_accionBotonActualizar

    private void accionBotonEliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonEliminar
        int filaSeleccionada = TablaAlumno.getSelectedRow();
        if (filaSeleccionada != -1) {
            int ID_Estudiante = (int) TablaAlumno.getValueAt(filaSeleccionada, 0);
            AlumnoControlador.eliminarAlumno(ID_Estudiante);
            cargarDatosTabla();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.", "Error ", javax.swing.JOptionPane.ERROR_MESSAGE);
        } // TODO add your handling code here:
    }//GEN-LAST:event_accionBotonEliminar

    private void accionBotonLimpiar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonLimpiar
        textNombre1.setText("");
        textNombre2.setText("");
        textApellido1.setText("");
        textApellido2.setText("");
        textnombreTutor.setText("");
        texttelefonoTutor.setText("");
        textDireccion.setText("");
        textSexo.setText("");
        textBuscar.setText("");
        btnGuardar.setEnabled(true);
        cargarDatosTabla(); // Reload
    }//GEN-LAST:event_accionBotonLimpiar

    private void tablaEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEstudiantesMouseClicked
        if (evt.getClickCount() == 2) {
            int filaSeleccionada = TablaAlumno.getSelectedRow();
            if (filaSeleccionada != -1) {
                ID_Estudiante = (int) TablaAlumno.getValueAt(filaSeleccionada, 0);
                String Nombre1 = (String) TablaAlumno.getValueAt(filaSeleccionada, 1);
                String Nombre2 = (String) TablaAlumno.getValueAt(filaSeleccionada, 2);
                String Apellido1 = (String) TablaAlumno.getValueAt(filaSeleccionada, 3);
                String Apellido2 = (String) TablaAlumno.getValueAt(filaSeleccionada, 4);
                String NombreTutor = (String) TablaAlumno.getValueAt(filaSeleccionada, 5);
                String TelefonoTutor = (String) TablaAlumno.getValueAt(filaSeleccionada, 6);
                String Direccion = (String) TablaAlumno.getValueAt(filaSeleccionada, 7);
                String Sexo = (String) TablaAlumno.getValueAt(filaSeleccionada, 8);
                java.sql.Date fechaSql = (java.sql.Date) TablaAlumno.getValueAt(filaSeleccionada, 9);
                selectorfechaNacimiento.setDate(new java.util.Date(fechaSql.getTime()));

                textNombre1.setText(Nombre1);
                textNombre2.setText(Nombre2);
                textApellido1.setText(Apellido1);
                textApellido2.setText(Apellido2);
                textnombreTutor.setText(NombreTutor);
                texttelefonoTutor.setText(TelefonoTutor);
                textDireccion.setText(Direccion);
                textSexo.setText(Sexo);
                btnEliminar.setEnabled(false);
                btnGuardar.setEnabled(false);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tablaEstudiantesMouseClicked

    private void textDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDireccionActionPerformed

    private void accionBotonGenerarReporte(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonGenerarReporte

                // TODO add your handling code here:
    }//GEN-LAST:event_accionBotonGenerarReporte


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAlumno;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser selectorfechaNacimiento;
    private javax.swing.JTextField textApellido1;
    private javax.swing.JTextField textApellido2;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textNombre1;
    private javax.swing.JTextField textNombre2;
    private javax.swing.JTextField textSexo;
    private javax.swing.JTextField textnombreTutor;
    private javax.swing.JTextField texttelefonoTutor;
    // End of variables declaration//GEN-END:variables
}
