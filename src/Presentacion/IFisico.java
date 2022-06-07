/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.ConexionBD;
import Datos.DArticulos;
import Metodos.Metodos;
import static Presentacion.Bitacora.Fechaa;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import menu.menu;

/**
 *
 * @author del.sistemas_res
 */
public class IFisico extends javax.swing.JFrame {
    
    Statement sentenciaSQL;
    float sistema = 0, fisico = 0;
    ConexionBD con;
    public static PreparedStatement sentencia_preparada;
    
    public static ResultSet resultado;
    
    public static String url;
    String FECHAI = "";
    String FECHAF = "";
    String[] Opcion = {"Salir", "Cancelar"};
    String[] Opcion2 = {"Eliminar", "Cancelar"};
    String[] Opcion3 = {"Confirmar", "Cancelar"};
    int Id;
    float Cantidad;
    String Nombre, Descripcion, Categoria, Unidad_Medida;
    
    Metodos Met = new Metodos();
    String tipo;
    
    public IFisico() {
        
    }
    
    public IFisico(String tipoDeUsuario) {
        initComponents();
        tipo = tipoDeUsuario;
        if ("Almacenista".equals(tipo)) {
            btnGuardar.setVisible(false);
            b1.setVisible(false);
            b2.setVisible(false);
        }
        TablaSistema.setEnabled(false);
        MostrarTablaSistema();
        Fecha1.setDate(Fechaa());
        Fecha2.setDate(Fechaa());
        llenarcombo();
        b1.setEnabled(false);
        b2.setEnabled(false);
        Met.MostrarTablaIF(Tabla, num);
        setLocationRelativeTo(null);
        setResizable(false);
        txtId.requestFocus();
        num.setText("" + Met.numInventario());
        Titulo.setText("Inventario Numero: " + num.getText());
    }
    
    public void MostrarTablaSistema() {
        Met.MostrarTablaInventarioSistema(TablaSistema);
    }
    
    public void MostrarTablaDiferencia() {
        Met.MostrarTablaDiferencia(TablaDiferencia, Integer.parseInt(num.getText()));
    }
    
    public void MostrarTablaDiferenciaCombo() {
        Met.MostrarTablaDiferenciaCombo(TablaDiferencia, Integer.parseInt(NI.getSelectedItem().toString()));
    }
    
    public static Date Fechaa() {
        Date FechaA = new Date();
        SimpleDateFormat FormatoFecha = new SimpleDateFormat("MM/dd/YYYY");
        return FechaA;
    }
    
    public String Fecha() {
        Date Fecha = new Date() {
        };
        SimpleDateFormat FormatoFecha = new SimpleDateFormat("MM-dd-YYYY");
        return FormatoFecha.format(Fecha);
    }
    
    public void llenarcombo() {
        
        Metodos me = new Metodos();
        NI.setModel(me.llenarNumeroInventarioFisico());
    }
    public void Modif(){
   
                Met.ModificarCantidad(fisico, ID.getText());
                MostrarTablaDiferenciaCombo();
                MostrarTablaSistema();
            
    }
    public void BitacoraBetween() {
        try {
            if (Fecha1.getDate() == null && Fecha2.getDate() == null) {
                System.out.println("Valor nulo");
            } else {
                try {
                    Date date = new Date();
                    
                    Date Variable = Fecha1.getDate();
                    SimpleDateFormat FormatoFecha = new SimpleDateFormat("MM-dd-YYYY");
                    // System.out.println(Variable);
                    FormatoFecha.format(Variable);
                    //System.out.println(FormatoFecha.format(Variable));
                    FECHAI = "'" + FormatoFecha.format(Variable) + "'";
                    System.out.println(FECHAI);
                    
                    Date date1 = new Date();
                    
                    Date Variable1 = Fecha2.getDate();
                    SimpleDateFormat FormatoFecha1 = new SimpleDateFormat("MM-dd-YYYY");
                    // System.out.println(Variable);
                    FormatoFecha1.format(Variable1);
                    //System.out.println(FormatoFecha.format(Variable));
                    FECHAF = "'" + FormatoFecha1.format(Variable1) + "'";
                    System.out.println(FECHAF);
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            // String sql = "SELECT * FROM pagos WHERE  Fecha Between '03-03-2022' AND '12-03-2022' ";

            String sql = "SELECT Numero as '#Inventario',Id, Nombre,Descripcion,Categoria,Unidad_Medida,Cantidad,Fecha  FROM InventarioFisico WHERE  Fecha Between " + FECHAI + "AND" + FECHAF + " Order by Numero Desc, id Asc";

// String sql = "SELECT * FROM asistencia WHERE Fecha=" + Fecha.getText();
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            Tabla.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void Procesar() {
        TablaDiferencia.setVisible(false);
        
        try {
            Date date = new Date();
            
            Date Variable = Fecha1.getDate();
            SimpleDateFormat FormatoFecha = new SimpleDateFormat("MM-dd-YYYY");
            // System.out.println(Variable);
            FormatoFecha.format(Variable);
            //System.out.println(FormatoFecha.format(Variable));
            FECHAI = "'" + FormatoFecha.format(Variable) + "'";
            System.out.println(FECHAI);
            Date date1 = new Date();
            
            Date Variable1 = Fecha2.getDate();
            SimpleDateFormat FormatoFecha1 = new SimpleDateFormat("MM-dd-YYYY");
            // System.out.println(Variable);
            FormatoFecha1.format(Variable1);
            //System.out.println(FormatoFecha.format(Variable));
            FECHAF = "'" + FormatoFecha1.format(Variable1) + "'";
            System.out.println(FECHAF);
            Titulo.setText("Inventario de dia: " + FECHAI + " al dia: " + FECHAF);
            BitacoraBetween();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        num = new javax.swing.JLabel();
        historia = new javax.swing.JButton();
        NI = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        Fecha2 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Fecha1 = new com.toedter.calendar.JDateChooser();
        xd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaSistema = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        ide = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaDiferencia = new javax.swing.JTable();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        ID = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 700, 410));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 164, 29));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ARTICULOS DEL SISTEMA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 164, 29));

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/10.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 140, -1));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/9.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 140, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Inventario Numero:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, -1));

        num.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num.setForeground(new java.awt.Color(255, 255, 255));
        num.setText("jLabel5");
        jPanel1.add(num, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        historia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        historia.setText("Historial");
        historia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historiaActionPerformed(evt);
            }
        });
        jPanel1.add(historia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 440, -1, -1));

        NI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIActionPerformed(evt);
            }
        });
        jPanel1.add(NI, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 130, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ver inventario:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 140, -1, -1));

        Titulo.setBackground(new java.awt.Color(255, 255, 255));
        Titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("TODOS LOS INVENTARIOS");
        jPanel1.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 700, 30));

        Fecha2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Fecha2PropertyChange(evt);
            }
        });
        jPanel1.add(Fecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 70, 180, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("De:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("A:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 70, 20, 20));

        Fecha1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Fecha1PropertyChange(evt);
            }
        });
        jPanel1.add(Fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 30, 180, -1));

        xd.setBackground(new java.awt.Color(102, 102, 102));
        xd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        xd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/16.png"))); // NOI18N
        xd.setText("Reporte");
        xd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        xd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(xd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 100, 80));

        TablaSistema.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TablaSistema);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 270, 150));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Vaciar Numero:");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 480, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Vaciar Todo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 440, -1, -1));

        ide.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ideKeyTyped(evt);
            }
        });
        jPanel1.add(ide, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 480, 40, 30));

        TablaDiferencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaDiferencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDiferenciaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaDiferencia);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 180, 230, 180));

        b1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        b1.setText("Sistema");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel1.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 400, 90, -1));

        b2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        b2.setText("Fisico");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        jPanel1.add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 400, 80, -1));

        ID.setText("ID");
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 400, 50, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 20, 510));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 20, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1309, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor de Escanear un codigo");
        } else {
            
            Metodos me = new Metodos();
            DArticulos Datos = new DArticulos();
            Datos.setId(Integer.parseInt(txtId.getText()));
            me.Search(Datos);
            
            Id = Datos.getId();
            Unidad_Medida = Datos.getUnidad_Medida();
            Nombre = Datos.getNombre();
            Descripcion = Datos.getDescripcion();
            Categoria = Datos.getCategoria();
            
            if (Nombre.equals("")) {
                txtId.setText("");
            } else {
                String BusquedaID = Metodos.Buscar_Repetido(txtId.getText(), Integer.parseInt(num.getText()));
                if (BusquedaID.equals("Id ya existe")) {
                    JOptionPane.showMessageDialog(null, "Ya se encuentra inventariado");
                    txtId.setText("");
                } else {
                    txtCantidad.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        TablaDiferencia.setVisible(true);
        
        if (txtCantidad.getText().isEmpty() || txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los datos");
        } else {
            Cantidad = Float.parseFloat(txtCantidad.getText());
            String fecha = Fecha();
            Met.GuardarInventarioFisico(num, Id, Nombre, Descripcion, Categoria, Unidad_Medida, Cantidad, fecha);
            Met.MostrarTablaIF(Tabla, num);
            Titulo.setText("Inventario Numero: " + num.getText() + " Del dia: " + Tabla.getValueAt(0, 7));
            llenarcombo();
            txtId.setText("");
            txtCantidad.setText("");
            txtId.requestFocus();
            MostrarTablaDiferencia();
        }       // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            System.out.println(Tabla.getValueAt(0, 0));
            if (num.getText().equals(Tabla.getValueAt(0, 0))) {
                JOptionPane.showMessageDialog(null, "Inventario Numero: " + num.getText() + " Guardado con exito");
                num.setText("" + Met.numInventario());
                llenarcombo();
                Met.MostrarTablaIF(Tabla, num);
            } else {
                JOptionPane.showMessageDialog(null, "No se han agregador datos nuevos");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se agregaron datos a la tabla");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void historiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historiaActionPerformed
        Historial hi=new Historial();
        hi.setVisible(true);
    }//GEN-LAST:event_historiaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        int i = JOptionPane.showOptionDialog(null, "Salir sin Guardar?", "Atencion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, Opcion, Opcion[0]);
        
        if (i == 0) {
            
            try {
                menu men = new menu(tipo);
                men.setVisible(true);
                dispose();
                Met.BorrarTablaProvisional(Integer.parseInt(num.getText()));
//Met.MostrarTablaIF(Tabla,num);
//num.setText("" + Met.numInventario());

//llenarcombo();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void NIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIActionPerformed
        if (NI.getSelectedItem().toString().equals("Todos")) {
            TablaDiferencia.setEnabled(false);
        } else {
            TablaDiferencia.setEnabled(true);
        }
        TablaDiferencia.setVisible(true);
        
        Met.MostrarTablaInventarioPorNumero(Tabla, NI);
        if (NI.getSelectedItem().toString().equals("Todos")) {
            Titulo.setText("Todos los inventarios");
        } else {
            Titulo.setText("Inventario Numero: " + NI.getSelectedItem().toString() + " Del dia: " + Tabla.getValueAt(0, 7));
            MostrarTablaDiferenciaCombo();
        }
    }//GEN-LAST:event_NIActionPerformed

    private void Fecha1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Fecha1PropertyChange
        TablaDiferencia.setVisible(false);
        Procesar();
    }//GEN-LAST:event_Fecha1PropertyChange

    private void Fecha2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Fecha2PropertyChange
        Procesar();        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha2PropertyChange

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char car = evt.getKeyChar();
        if (car != '.' && car != '0' && car != '1' && car != '2' && car != '3' && car != '4' && car != '5' && car != '6' && car != '7' && car != '8' && car != '9')
            evt.consume();
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (ide.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes introducir un numero de inventario");
        } else {
            int i = JOptionPane.showOptionDialog(null, "Desea Eliminar el inventario numero " + ide.getText() + "?", "Atencion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, Opcion2, Opcion2[0]);
            
            if (i == 0) {
                
                Met.BorrarEspecifico(Integer.parseInt(ide.getText()));
                ide.setText("");
                llenarcombo();
                num.setText("" + Met.numInventario());
            }
            Titulo.setText("Inventario Numero: " + num.getText());
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int i = JOptionPane.showOptionDialog(null, "Desea Eliminar todos los registros", "Atencion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, Opcion2, Opcion2[0]);
        
        if (i == 0) {
            Met.BorrarTodo();
            
            num.setText("" + Met.numInventario());
            Met.MostrarTablaIF(Tabla, num);
            MostrarTablaDiferencia();
            llenarcombo();
        }
        Titulo.setText("Inventario Numero: " + num.getText());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ideKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ideKeyTyped
        char car = evt.getKeyChar();
        if (car < '0' || car > '9')
            evt.consume();          // TODO add your handling code here:
    }//GEN-LAST:event_ideKeyTyped

    private void TablaDiferenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDiferenciaMouseClicked
        if (evt.getButton() == 1) {
            int fila = TablaDiferencia.getSelectedRow();
            ID.setText(TablaDiferencia.getValueAt(fila, 1).toString());
            sistema = Float.parseFloat((String) TablaDiferencia.getValueAt(fila, 2));
            fisico = Float.parseFloat((String) TablaDiferencia.getValueAt(fila, 3));
            b1.setEnabled(true);
            b2.setEnabled(true);
        }
    }//GEN-LAST:event_TablaDiferenciaMouseClicked

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        
        if (NI.getSelectedItem().toString().equals("Todos")) {
            JOptionPane.showMessageDialog(null, "Consulte un numero de inventario");
        } else {
          
             int i = JOptionPane.showOptionDialog(null, "En el Inventario Fisico se modificá el stock a: " + sistema + " con el Id: " + ID.getText() + "\n ¿Deseas continuar?", "Atencion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, Opcion3, Opcion3[0]);

            if (i == 0) {
                  Motivos mo = new Motivos();
            mo.txtTipo.setText("Sistema");
            mo.txtArticulo.setText(ID.getText());
            mo.setVisible(true);
            Met.ModificarCantidad(fisico, ID.getText());
                MostrarTablaDiferenciaCombo();
                MostrarTablaSistema();}
        }
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        if (NI.getSelectedItem().toString().equals("Todos")) {
            JOptionPane.showMessageDialog(null, "Consulte un numero de inventario");
        } else {
          
            int i = JOptionPane.showOptionDialog(null, "En el Inventario Fisico se modificá el stock a: " + sistema + " con el Id: " + ID.getText() + "\n ¿Deseas continuar?", "Atencion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, Opcion3, Opcion3[0]);

            if (i == 0) {
                  Motivos mo = new Motivos();
            mo.txtTipo.setText("Fisico");
            mo.txtArticulo.setText(ID.getText());
            mo.setVisible(true);
                Met.ModificarCantidad2(sistema, ID.getText(), Integer.parseInt(NI.getSelectedItem().toString()));
                MostrarTablaDiferenciaCombo();
                MostrarTablaSistema();
            }
        }      // TODO add your handling code here:
    }//GEN-LAST:event_b2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IFisico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IFisico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IFisico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IFisico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IFisico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Fecha1;
    private com.toedter.calendar.JDateChooser Fecha2;
    private javax.swing.JLabel ID;
    private javax.swing.JComboBox<String> NI;
    public javax.swing.JTable Tabla;
    public javax.swing.JTable TablaDiferencia;
    public javax.swing.JTable TablaSistema;
    public javax.swing.JLabel Titulo;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    public javax.swing.JButton historia;
    private javax.swing.JTextField ide;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel num;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtId;
    public javax.swing.JButton xd;
    // End of variables declaration//GEN-END:variables
}
