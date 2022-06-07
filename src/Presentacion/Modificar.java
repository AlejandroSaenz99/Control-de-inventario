/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.DArticulos;
import Metodos.Metodos;
import Puentes.PuenteArticulo;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

/**
 *
 * @author del.sistemas_res
 */
public class Modificar extends javax.swing.JFrame {

    String tipoDeUsuario;
    Metodos Metodos = new Metodos();
    String[] Opcion = {"Eliminar", "Desactivar", "Cancelar"};
    /**
     *
     * Creates new form Modificar
     */
    public TextAutoCompleter ac;

    public Modificar() {

    }

    public Modificar(String tipo) {
        initComponents();
        tipoDeUsuario = tipo;
        btnActivar.setVisible(false);
        ac = Metodos.autocompletarNombre(txtbN);
        llenarcombo();
        setLocationRelativeTo(null);
        setResizable(false);
        btna.setEnabled(false);
        btnm.setEnabled(false);
        btne.setEnabled(false);
        txtId2.setEnabled(false);
    }

    public void llenarcombo() {

        Metodos me = new Metodos();
        Categoria.setModel(me.llenarCategorias());
    }

    public void buscar() {
        String BusquedaTicket = Metodos.Buscar_Id(txtId.getText());
        if (BusquedaTicket.equals("Id no existe")) {
            JOptionPane.showMessageDialog(null, "Producto no existe");
            txtId.setText("");
            btnm.setEnabled(false);
        } else {

            DArticulos prov = new DArticulos();
            prov.setId(Integer.parseInt(this.txtId.getText()));
            (new PuenteArticulo()).PuenteBuscarDatosArticulo(prov);
            this.txtId2.setText("" + prov.getId());
            this.txtNombre.setText("" + prov.getNombre());
            this.txtDescripcion.setText("" + prov.getDescripcion());
            this.txtCostoEntrada.setText("" + prov.getCosto_Entrada());
            this.txtStock.setText("" + prov.getStock());
            txtEstado.setText("" + prov.getEstado());
            txtReorden.setText("" + prov.getPunto_Reorden());
            FechaEntrada.setDate(prov.getFecha_Ultima_Entrada());
            txtMedida.setSelectedItem("" + prov.getUnidad_Medida());

            try {

                generarBarcode();
            } catch (BarcodeException ex) {
                Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (OutputException ex) {
                Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
            }

            btnm.setEnabled(true);
        }
        if (txtEstado.getText().equals("Inactivo")) {
            btnm.setEnabled(false);
            btne.setEnabled(false);
            btnActivar.setVisible(true);
        }

    }

    public void buscarPorNombre() {

        String BusquedaTicket = Metodos.Buscar_Nombre(txtbN.getText());
        if (BusquedaTicket.equals("Id no existe")) {
            JOptionPane.showMessageDialog(null, "Producto no existe");
            txtbN.setText("");
            btne.setEnabled(false);
        } else {

            DArticulos prov = new DArticulos();
            prov.setNombre(txtbN.getText());
            (new PuenteArticulo()).PuenteBuscarDatosArticuloNombre(prov);
            this.txtId2.setText("" + prov.getId());
            this.txtNombre.setText("" + prov.getNombre());
            this.txtDescripcion.setText("" + prov.getDescripcion());
            this.txtCostoEntrada.setText("" + prov.getCosto_Entrada());
            this.txtStock.setText("" + prov.getStock());
            txtEstado.setText("" + prov.getEstado());
            txtReorden.setText("" + prov.getPunto_Reorden());
            FechaEntrada.setDate(prov.getFecha_Ultima_Entrada());
            txtMedida.setSelectedItem("" + prov.getUnidad_Medida());

            try {
                generarBarcode();
            } catch (BarcodeException ex) {
                Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (OutputException ex) {
                Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
            }

            btnm.setEnabled(true);
        }
        if (txtEstado.getText().equals("Inactivo")) {
            btnm.setEnabled(false);
            btne.setEnabled(false);
            btnActivar.setVisible(true);
        }

    }

    public void generarBarcode() throws BarcodeException, OutputException {
        final Barcode barcode = BarcodeFactory.createCode128(txtId2.getText());
        barcode.setBarHeight(60);
        barcode.setBarWidth(2);
        lbBarcode.setIcon(new ImageIcon(BarcodeImageHandler.getImage(barcode)));
    }

    public void limpiar() {
        txtId.setText("");
        txtId2.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtCostoEntrada.setText("");
        txtStock.setText("");
        txtReorden.setText("");
        FechaEntrada.setDate(null);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btna = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btne = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnm = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtId2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtCostoEntrada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtReorden = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        FechaEntrada = new com.toedter.calendar.JDateChooser();
        Categoria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtEstado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtbN = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnActivar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lbBarcode = new javax.swing.JLabel();
        txtMedida = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENÚ ARTICULOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));

        btna.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/5.png"))); // NOI18N
        btna.setText("AGREGAR");
        btna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 255));

        btne.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/6.png"))); // NOI18N
        btne.setText("ELIMINAR");
        btne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btne.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 255));

        btnm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4.png"))); // NOI18N
        btnm.setText("MODIFICAR");
        btnm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnm.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 9, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 102, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID:");
        jLabel11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel11FocusLost(evt);
            }
        });
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        txtId2.setToolTipText("Ingrese un Id y presione enter");
        txtId2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId2ActionPerformed(evt);
            }
        });
        txtId2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtId2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtId2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtId2KeyTyped(evt);
            }
        });
        jPanel6.add(txtId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 90, 60, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel6.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 200, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripción:");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
        jPanel6.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 360, -1));

        txtCostoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoEntradaActionPerformed(evt);
            }
        });
        txtCostoEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoEntradaKeyTyped(evt);
            }
        });
        jPanel6.add(txtCostoEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 102, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Costo de Entrada:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cantidad:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });
        jPanel6.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 110, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Reorden:");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        txtReorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReordenActionPerformed(evt);
            }
        });
        txtReorden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReordenKeyTyped(evt);
            }
        });
        jPanel6.add(txtReorden, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 150, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fecha:");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));
        jPanel6.add(FechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 107, -1));

        Categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria", " " }));
        Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriaActionPerformed(evt);
            }
        });
        jPanel6.add(Categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 107, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID:");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 30, 30));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        jPanel6.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 70, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/12.png"))); // NOI18N
        jButton4.setText("BUSCAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 120, 35));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/10.png"))); // NOI18N
        jButton5.setText("Regresar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 130, -1));

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });
        txtEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEstadoKeyTyped(evt);
            }
        });
        jPanel6.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 320, 150, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Estado:");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Unidad de medida:");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

        txtbN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbNActionPerformed(evt);
            }
        });
        txtbN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbNKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbNKeyTyped(evt);
            }
        });
        jPanel6.add(txtbN, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 120, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        btnActivar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/13.png"))); // NOI18N
        btnActivar.setText("Activar");
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });
        jPanel6.add(btnActivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));
        jPanel6.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 530, 20));
        jPanel6.add(lbBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 80));

        txtMedida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tonelada", "Kilogramo", "Gramo", "Galon", "Litro", "Mililitro", "Centimetro", "Metro", "Kilometro", "Volumen", "Pieza" }));
        jPanel6.add(txtMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 150, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        buscar();       // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmActionPerformed
        if (txtId2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Busque un producto");
        } else {

            DArticulos prod = new DArticulos();
            prod.setId(Integer.parseInt(this.txtId2.getText()));
            prod.setNombre(this.txtNombre.getText());
            prod.setDescripcion(this.txtDescripcion.getText());
            prod.setCosto_Entrada(Float.parseFloat(txtCostoEntrada.getText()));
            prod.setCosto_Promedio_U(Float.parseFloat(txtCostoEntrada.getText()));
            prod.setStock(Float.parseFloat(txtStock.getText()));
            prod.setEntrada(Float.parseFloat(txtStock.getText()));
            Date fechaEntrada = FechaEntrada.getDate();
            long d = fechaEntrada.getTime();
            java.sql.Date soloFecha = new java.sql.Date(d);
            prod.setFecha_Ultima_Entrada(soloFecha);
            prod.setCategoria(Categoria.getSelectedItem().toString());
            prod.setPunto_Reorden(Float.parseFloat(txtReorden.getText()));
            prod.setEstado("Activo");
            prod.setUnidad_Medida(txtMedida.getSelectedItem().toString());
            ac = Metodos.autocompletarNombre(txtNombre);
            (new PuenteArticulo()).PuenteActualizar(prod);
            limpiar();

            //Limpiar2(); cc-999-999-9999
        }             // TODO add your handling code here:
    }//GEN-LAST:event_btnmActionPerformed

    private void btneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneActionPerformed
        int i = JOptionPane.showOptionDialog(null, "Deseas eliminar este producto?", "Atencion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, Opcion, Opcion[0]);

        if (i == 0) {
            if (this.txtId2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Busque un producto");
            } else {
                this.Metodos.Eliminar(Integer.parseInt(txtId2.getText()));
                limpiar();

            }
        } else if (i == 1) {

            DArticulos prod = new DArticulos();
            prod.setId(Integer.parseInt(this.txtId.getText()));
            prod.setNombre(this.txtNombre.getText());
            prod.setDescripcion(this.txtDescripcion.getText());
            prod.setCosto_Entrada(Float.parseFloat(this.txtCostoEntrada.getText()));

            prod.setEntrada(Float.parseFloat(this.txtStock.getText()));
            prod.setStock(Float.parseFloat(this.txtStock.getText()));
            //prod.setPunto_Reorden(Float.parseFloat(this.txtReorden.getText()));
            prod.setEstado("Inactivo");
            prod.setUnidad_Medida(txtMedida.getSelectedItem().toString());

            //Actualizar la fecha con formato java.sql.Date
            // Date fecha=FechaEntrada.getDate();
            // long d=fecha.getTime();
            //java.sql.Date soloFecha=new java.sql.Date(d);
            //  prod.setFecha_Ultima_Entrada(soloFecha);
            (new PuenteArticulo()).PuenteEstado(prod);
            limpiar();
            Marticulos m = new Marticulos(tipoDeUsuario);
            m.setVisible(true);
            dispose();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btneActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        char car = evt.getKeyChar();
        if (car < '0' || car > '9')
            evt.consume();           // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        if (txtId.getText().length() >= 5) {

            txtId.setText(txtId.getText().substring(0, 5));
            buscar();
            txtEstado.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Marticulos m = new Marticulos(tipoDeUsuario);
        m.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtReordenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReordenKeyTyped
        char car = evt.getKeyChar();
        if (car != '.' && car != '0' && car != '1' && car != '2' && car != '3' && car != '4' && car != '5' && car != '6' && car != '7' && car != '8' && car != '9')
            evt.consume();         // TODO add your handling code here:
    }//GEN-LAST:event_txtReordenKeyTyped

    private void txtCostoEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoEntradaKeyTyped
        char car = evt.getKeyChar();
        if (car != '.' && car != '0' && car != '1' && car != '2' && car != '3' && car != '4' && car != '5' && car != '6' && car != '7' && car != '8' && car != '9')
            evt.consume();         // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoEntradaKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        char car = evt.getKeyChar();
        if (car != '.' && car != '0' && car != '1' && car != '2' && car != '3' && car != '4' && car != '5' && car != '6' && car != '7' && car != '8' && car != '9')
            evt.consume();         // TODO add your handling code here:
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased

    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void jLabel11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel11FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11FocusLost

    private void txtId2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId2ActionPerformed

    private void txtId2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtId2KeyPressed

    }//GEN-LAST:event_txtId2KeyPressed

    private void txtId2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtId2KeyReleased
        if (txtId.getText().length() >= 5) {

            txtId.setText(txtId.getText().substring(0, 5));
            String BusquedaTicket = Metodos.Buscar_Id(txtId.getText());
            if (BusquedaTicket.equals("Id ya existe")) {
                JOptionPane.showMessageDialog(null, "Producto ya existe");
                txtId.setText("");
            } else {

                btna.setEnabled(true);
                txtNombre.requestFocus();
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtId2KeyReleased

    private void txtId2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtId2KeyTyped
        char car = evt.getKeyChar();
        if (car < '0' || car > '9')
            evt.consume();           // TODO add your handling code here:
    }//GEN-LAST:event_txtId2KeyTyped

    private void txtEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoKeyTyped

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed

        DArticulos d = new DArticulos();
        d.setId(Integer.parseInt(txtId2.getText()));
        String Estado = "Activo";
        d.setEstado(Estado);
        (new PuenteArticulo()).PuenteActualizarEstado(d);
    }//GEN-LAST:event_btnActivarActionPerformed

    private void txtbNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbNActionPerformed
        buscarPorNombre();        // TODO add your handling code here:
    }//GEN-LAST:event_txtbNActionPerformed

    private void txtbNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbNKeyReleased

    }//GEN-LAST:event_txtbNKeyReleased

    private void txtbNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbNKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbNKeyTyped

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtId2.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        txtNombre.requestFocus();
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtCostoEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoEntradaActionPerformed
        txtStock.requestFocus();
    }//GEN-LAST:event_txtCostoEntradaActionPerformed

    private void txtReordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReordenActionPerformed
        txtCostoEntrada.requestFocus();
    }//GEN-LAST:event_txtReordenActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        txtReorden.requestFocus();
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaActionPerformed
 Metodos m=new Metodos();
       String Estado= m.BuscarEstadoCategoria(Categoria);
        if(Estado.equals("Inactivo")){JOptionPane.showMessageDialog(null, "Categoria Inactiva");
        Categoria.setSelectedIndex(0);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_CategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> Categoria;
    public com.toedter.calendar.JDateChooser FechaEntrada;
    public javax.swing.JButton btnActivar;
    private javax.swing.JButton btna;
    public javax.swing.JButton btne;
    public javax.swing.JButton btnm;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lbBarcode;
    public javax.swing.JTextField txtCostoEntrada;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtEstado;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtId2;
    private javax.swing.JComboBox<String> txtMedida;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtReorden;
    public javax.swing.JTextField txtStock;
    public javax.swing.JTextField txtbN;
    // End of variables declaration//GEN-END:variables
}
