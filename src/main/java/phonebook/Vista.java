package phonebook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import phonebook.db.Conection;

/**
 *
 * @author javier
 */
public class Vista extends javax.swing.JFrame {

    public static final String servidor = "localhost";
    public static final String database = "escuela";
    public static final String usuario = "escuela";
    public static final String password = "P@ssw0rd";
    PreparedStatement st;
    ResultSet rs;

    private void clear() {
        txtboleta.setText(null);
        txtNombre.setText(null);
        txtApellido1.setText(null);
        txtApellido2.setText(null);
        txtId.setText(null);
    }

    public Vista() {
        initComponents();

        try {
            showStudents();
        } catch (Exception e) {
            System.out.println("error de conecition" + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblShow = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtboleta = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnChange.setText("Modificar");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        tblShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Boleta", "Nombre", "Apellido Paterno", "Apellido Materno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSelect(evt);
            }
        });
        jScrollPane2.setViewportView(tblShow);

        jLabel1.setText("Boleta");

        jLabel2.setText("Primer Apellido");

        jLabel3.setText("Nombre");

        jLabel4.setText("Segundo Apellido");

        txtId.setEditable(false);
        txtId.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtboleta, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnChange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(29, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtboleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnAdd))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnChange)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDelete)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(0, 113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, "");

        //Conection con = null;
        try {
            Conection conn = new Conection(servidor, database, usuario, password);
            st = conn.getConexion().prepareStatement("INSERT INTO estudiantes ( boleta, nombre, apellido_paterno, apellido_materno) value (?, ?, ?, ?)");
            st.setString(1, txtboleta.getText());
            st.setString(2, txtNombre.getText());
            st.setString(3, txtApellido1.getText());
            st.setString(4, txtApellido2.getText());

            int res = st.executeUpdate();
            
            showStudents();
            
            if (res > 0) {
                //JOptionPane.showMessageDialog(null, "se agrego");
                clear();
            } else {
                JOptionPane.showMessageDialog(null, "no se agrego");
                clear();
            }

            conn.cerrarConexion();

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            Conection conn = new Conection(servidor, database, usuario, password);
            System.out.println("aqui entro");
            st = conn.getConexion().prepareStatement("DELETE FROM estudiantes WHERE boleta=?");
            st.setString(1, txtboleta.getText());
//            st = conn.getConexion().prepareStatement("DELETE FROM estudiantes WHERE id=?");
//            st.setInt(1, Integer.parseInt(txtId.getText()));

            int res = st.executeUpdate();
            
            showStudents();
            
            if (res > 0) {
                //JOptionPane.showMessageDialog(null, "se elimino");
                clear();
            } else {
                JOptionPane.showMessageDialog(null, "no se elimino");
                clear();
            }

            conn.cerrarConexion();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        // TODO add your handling code here:
        try {
            Conection conn = new Conection(servidor, database, usuario, password);
            st = conn.getConexion().prepareStatement("UPDATE estudiantes SET boleta=?, nombre=?, apellido_paterno=?, apellido_materno=? WHERE id=?");
            //st = conn.getConexion().prepareStatement("UPDATE estudiantes SET boleta=?, nombre=?, apellido_paterno=?, apellido_materno=? WHERE id=?");
            st.setString(1, txtboleta.getText());
            st.setString(2, txtNombre.getText());
            st.setString(3, txtApellido1.getText());
            st.setString(4, txtApellido2.getText());
            st.setString(5, txtId.getText());

            int res = st.executeUpdate();
            
            showStudents();
            
            if (res > 0) {
                //JOptionPane.showMessageDialog(null, "se modifico");
                clear();
            } else {
                JOptionPane.showMessageDialog(null, "no se modifico");
                clear();
            }

            conn.cerrarConexion();

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_btnChangeActionPerformed

    private void tblSelect(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelect
        // TODO add your handling code here:
        st = null;
        rs = null;
        try{
            Conection conn = new Conection(servidor, database, usuario, password);
            
            int fila = tblShow.getSelectedRow();
            String boleta = tblShow.getValueAt(fila, 0).toString();
            
            st = conn.getConexion().prepareStatement("SELECT id, boleta, nombre, apellido_paterno, apellido_materno FROM estudiantes WHERE boleta=?");
            st.setString(1, boleta);
            rs = st.executeQuery();
             while (rs.next()) {
                txtboleta.setText(rs.getString("boleta"));
                txtNombre.setText(rs.getString("nombre"));
                txtApellido1.setText(rs.getString("apellido_paterno"));
                txtApellido2.setText(rs.getString("apellido_materno"));
                txtId.setText(rs.getString("id"));
            }
            
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_tblSelect

    public void showStudents() throws SQLException {
        //dbHelper aux;
        DefaultTableModel modelo = new DefaultTableModel();
            tblShow.setModel(modelo);
            Conection conn = new Conection(servidor, database, usuario, password);
            st = null;
            rs = null;

            String sql = "SELECT boleta, nombre, apellido_paterno, apellido_materno FROM estudiantes";
            st = conn.getConexion().prepareStatement(sql);
            rs = st.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Boleta");
            modelo.addColumn("Nombre");
            modelo.addColumn("Primer Apellido");
            modelo.addColumn("Segundo Apellido");

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                
                modelo.addRow(filas);
            }

    }

    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblShow;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtboleta;
    // End of variables declaration//GEN-END:variables
}
