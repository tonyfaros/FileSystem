/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author mariapizarro
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    DefaultTreeModel model;
    DefaultMutableTreeNode root;
    
    
    JFrame frame = new JFrame();
    
    private static Globales instance= Globales.getInstance();
    public Main() {
        initComponents();
        this.setTitle("File System");
        model = (DefaultTreeModel)jTree.getModel();
        
    }
    
    private TreePath find(DefaultMutableTreeNode root, String s) {
    @SuppressWarnings("unchecked")
    Enumeration<DefaultMutableTreeNode> e = root.depthFirstEnumeration();
    while (e.hasMoreElements()) {
        DefaultMutableTreeNode node = e.nextElement();
        if (node.toString().equalsIgnoreCase(s)) {
            TreePath tree =  new TreePath(node.getPath());
            return tree;
        }
    }
    return null;
}
    public DefaultMutableTreeNode reloadTree(Directorio directorio, DefaultMutableTreeNode actual){
        //DefaultMutableTreeNode actual = null;
        //System.out.println(root.getChildCount());
        
        //DefaultMutableTreeNode ArchivoNode:
        if(!directorio.getListaArchivos().isEmpty())
            for(Archivo i : directorio.getListaArchivos()){
                
                actual.add(new DefaultMutableTreeNode(i.getNombre()));
                
            }
        if(!directorio.getdHijo().isEmpty()){
            for(Directorio i : directorio.getdHijo()){
                DefaultMutableTreeNode aux;
                aux = new DefaultMutableTreeNode(i.getNombre());
                System.out.println(i.getNombre());
                //aux.add();
                
                actual.add(reloadTree(i,aux));
            }
        }
        if(directorio.getListaArchivos().isEmpty() && directorio.getdHijo().isEmpty()){
            actual.add(new DefaultMutableTreeNode("."));
            System.out.println("hola");
        }
        //model.reload(actual);
        return actual;
        
    
    private void actualizaDatos(){
        String rutaActual = rutaActualEdit.getText().toString();
        Directorio dirActual = FileSystem.accederDirectorio(rutaActual);
        
        DefaultTableModel model = (DefaultTableModel) jTableContenido.getModel();
        DefaultTableModel modelMod = (DefaultTableModel) jTableModContenido.getModel();
        DefaultTableModel modelProp = (DefaultTableModel) jTablePropiedades.getModel();
        DefaultTableModel modelCons = (DefaultTableModel) jTableConsulta.getModel();
        DefaultTableModel modelCopia = (DefaultTableModel) jTableCopiar.getModel();
        DefaultTableModel modelMover = (DefaultTableModel) jTableMover.getModel();
        DefaultTableModel modelEliminar = (DefaultTableModel) jTablaEliminar.getModel();
        
        model.setRowCount(0);
        modelMod.setRowCount(0);
        modelProp.setRowCount(0);
        modelCons.setRowCount(0);
        modelCopia.setRowCount(0);
        modelMover.setRowCount(0);
        modelEliminar.setRowCount(0);
        
        if(dirActual!= null){
            Object rowData[] = new Object[2];
            Object rowData2[] = new Object[2];
            Object rowData3[] = new Object[5];
            Object rowData4[] = new Object[3];
            //Object rowData4[] = new Object[2];
            //ArrayList<>
            for(int i =0 ; i<dirActual.getListaArchivos().size();i++){
                
                rowData[0] = dirActual.getListaArchivos().get(i).getNombre()+ dirActual.getListaArchivos().get(i).getExtension();
                rowData2[0] = dirActual.getListaArchivos().get(i).getNombre();
                rowData4[0] = dirActual.getListaArchivos().get(i).getNombre();
                
                rowData4[1] = dirActual.getListaArchivos().get(i).getExtension();
                
                rowData3[0] = dirActual.getListaArchivos().get(i).getNombre();
                rowData3[1] = dirActual.getListaArchivos().get(i).getExtension();
                rowData3[2] = dirActual.getListaArchivos().get(i).getFechaCreacion();
                rowData3[3] = dirActual.getListaArchivos().get(i).getFechaMod();
                rowData3[4] = dirActual.getListaArchivos().get(i).getTamano();
                
                rowData[1] = "archivo";
                rowData4[2] = "archivo";
                rowData2[1] = dirActual.getListaArchivos().get(i).getExtension();
                
                model.addRow(rowData);
                modelMod.addRow(rowData2);
                modelProp.addRow(rowData3);
                modelCons.addRow(rowData2);
                modelCopia.addRow(rowData);
                modelMover.addRow(rowData);
                modelEliminar.addRow(rowData4);
            }
            for(int j = 0; j<dirActual.getdHijo().size();j++){
                
                rowData[0] = dirActual.getdHijo().get(j).getNombre();
                rowData[1] = "directorio";
                
                rowData4[0] = dirActual.getdHijo().get(j).getNombre();
                rowData4[2] = "directorio";
                rowData4[1] = "";
                
                
                model.addRow(rowData);
                modelCopia.addRow(rowData);
                modelMover.addRow(rowData);
                modelEliminar.addRow(rowData4);
            }
        }
        else{
            System.out.println("Error");
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

        jMenu3 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextCantSectores = new javax.swing.JTextField();
        jTextTamSectores = new javax.swing.JTextField();
        jTextRoot = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nombreEdit = new javax.swing.JTextField();
        extensionEdit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contenidoEdit = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextNombreDirectorio = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rutaActualEdit = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableContenido = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableModContenido = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jContenidoArchivo = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTablePropiedades = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextContenidoCons = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableCopiar = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        destinoEdit = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableMover = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        rutaDestinoEdit = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTablaEliminar = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        nombreArchivoEdit = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton10 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();

        jMenu3.setText("jMenu3");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenu17.setText("jMenu17");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Crear Memoria Virtual:");

        jLabel2.setText("Cantidad de sectores:");

        jLabel3.setText("Tamaño del sector:");

        jLabel4.setText("Nombre de la raíz:");

        jTextTamSectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTamSectoresActionPerformed(evt);
            }
        });

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextRoot)
                            .addComponent(jTextTamSectores)
                            .addComponent(jTextCantSectores, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(98, 98, 98)
                .addComponent(jButton1)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextCantSectores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextTamSectores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(291, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CRT", jPanel1);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel5.setText("Crear un Archivo");

        jLabel6.setText("Nombre:");

        extensionEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extensionEditActionPerformed(evt);
            }
        });

        jLabel7.setText("Extensión:");

        jLabel8.setText("Contenido:");

        contenidoEdit.setColumns(20);
        contenidoEdit.setRows(5);
        jScrollPane1.setViewportView(contenidoEdit);

        jButton2.setText("Crear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nombreEdit)
                            .addComponent(extensionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(164, 164, 164)))
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addGap(128, 128, 128))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(nombreEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(extensionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(235, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("FLE", jPanel2);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel9.setText("Crear Directorio");

        jLabel10.setText("Nombre:");

        jButton3.setText("Crear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextNombreDirectorio))
                    .addComponent(jLabel9))
                .addGap(209, 209, 209))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jTextNombreDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jButton3)
                .addContainerGap(297, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MKDIR", jPanel3);

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel11.setText("Cambiar el directorio actual");

        jLabel12.setText("Ruta:");

        jButton4.setText("Cambiar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rutaActualEdit))
                    .addComponent(jLabel11))
                .addGap(209, 209, 209))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel11)
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(rutaActualEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jButton4)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CHDIR", jPanel4);

        jTableContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContenido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContenidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableContenido);

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel13.setText("Lista de contenido");

        jButton9.setText("Cargar Datos");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel13))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jButton9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton9)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("LDIR", jPanel5);

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel14.setText("Modificar contenido");

        jTableModContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                " Nombre", "Extensión"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableModContenido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableModContenidoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableModContenido);

        jLabel17.setText("Contenido:");

        jContenidoArchivo.setColumns(20);
        jContenidoArchivo.setRows(5);
        jScrollPane4.setViewportView(jContenidoArchivo);

        jButton5.setText("Modificar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(236, 236, 236))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel14)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(170, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("MFLE", jPanel6);

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel15.setText("Propiedades de un archivo");

        jTablePropiedades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Extensión", "Fecha de Creación", "Fecha de Modificacion", "Tamaño"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTablePropiedades);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PPT", jPanel7);

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel16.setText("Consultar Contenido");

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                " Nombre", "Extensión"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConsultaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableConsulta);

        jTextContenidoCons.setEditable(false);
        jTextContenidoCons.setColumns(20);
        jTextContenidoCons.setRows(5);
        jScrollPane7.setViewportView(jTextContenidoCons);

        jLabel18.setText("Contenido:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(236, 236, 236))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(128, 128, 128))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("VIEW", jPanel8);

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel19.setText("Copiar archivo/directorio");

        jTableCopiar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Tipo"
            }
        ));
        jScrollPane10.setViewportView(jTableCopiar);

        jLabel26.setText("Nombre:");

        jTextField10.setEditable(false);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setLabel("Real");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setLabel("Virtual");

        jLabel27.setText("Ruta de la copia:");

        jButton8.setText("Copiar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel28.setText("Directorio:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel19))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton1)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                    .addGap(331, 331, 331)
                                    .addComponent(jButton8)))
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(destinoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(destinoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CPY", jPanel9);

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel20.setText("Mover archivo/directorio");

        jTableMover.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Tipo"
            }
        ));
        jScrollPane9.setViewportView(jTableMover);

        jLabel24.setText("Nombre:");

        jTextField8.setEditable(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel25.setText("Directorio:");

        jButton7.setText("Mover");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(232, 232, 232))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(rutaDestinoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(rutaDestinoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MOV", jPanel10);

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel21.setText("Eliminar archivo/directorio");

        jTablaEliminar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Extensión", "Tipo"
            }
        ));
        jScrollPane8.setViewportView(jTablaEliminar);

        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(202, 202, 202))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(135, 135, 135))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel21)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton6)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REM", jPanel11);

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel23.setText("Buscar");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane12.setViewportView(jTextArea1);

        jButton10.setText("Buscar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel23))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(nombreArchivoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel23)
                .addGap(37, 37, 37)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreArchivoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("FIND", jPanel13);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane11.setViewportView(jTree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addComponent(jScrollPane11)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        String contenido = jContenidoArchivo.getText().toString();
        
        int row = jTableModContenido.getSelectedRow();
        int column = jTableModContenido.getSelectedColumn();
        String nombre = jTableModContenido.getValueAt(row, column).toString();
        String extension = jTableModContenido.getValueAt(row, column+1).toString();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String fecha  = dateFormat.format(date).toString();
        System.out.println(fecha);
        Archivo ar = FileSystem.searchFile(instance.getDirectorioActual().getListaArchivos(), nombre, extension);
        if(ar != null){
            jContenidoArchivo.setText("");
            ar.setContenido(contenido);
            ar.setFechaMod(fecha);
            jContenidoArchivo.setText(ar.getContenido());
        }else{
            System.out.println("fuck");
        }
        actualizaDatos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        
        String rutaActual = rutaActualEdit.getText().toString();
        System.out.println(rutaActual);
        Directorio dirActual = FileSystem.accederDirectorio(rutaActual);
        if(dirActual != null){
            instance.setDirectorioActual(dirActual);
            JOptionPane.showMessageDialog(frame,"Ruta actualizada");
        }else{
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame,"El directorio seleccionado no existe","Error",JOptionPane.ERROR_MESSAGE);
        }
        actualizaDatos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        /*
        DefaultMutableTreeNode aux;
        TreePath tree;
        TreePath treeaux;
        
        tree = find(root,instance.getDirectorioActual().getNombre());
        System.out.println("esto:" + tree.getPathComponent(0).toString());
        if(tree.getPathCount()-1 != 0){
            for(int i = 0; i<)
            aux = (DefaultMutableTreeNode)root.getChildAt(tree.getPathCount()-1);
            
        }
        else
            aux = root;
        
        
        DefaultMutableTreeNode Node = new DefaultMutableTreeNode(jTextNombreDirectorio.getText());
        Node.add(new DefaultMutableTreeNode("."));
        aux.add(Node);
        model.reload(aux);
        */
        
        //TreePath tree;
        //tree = find(root,instance.getDirectorioActual().getNombre());
        //System.out.println(tree.toString());
        //DefaultMutableTreeNode aux = (DefaultMutableTreeNode)root.getChildAt(tree.getPathCount()-1);
        //Node.add(new DefaultMutableTreeNode(".a"));
        
        String nombreDir = jTextNombreDirectorio.getText().toString();
        int crearDir = FileSystem.crearDirectorio(nombreDir);
        if(crearDir == -1){
            //ERROOOOOOOOORRRRRRRR
           
            JOptionPane.showMessageDialog(frame,"Error al crear el directorio","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            root.removeAllChildren();
            root = reloadTree(instance.getRoot(),root);
            //System.out.println(root.getChildCount());
            model.reload(root);
            System.out.println("exit");
        }
      
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
       String nombre = nombreEdit.getText().toString();
       String extension = extensionEdit.getText().toString();
       String contenido = contenidoEdit.getText().toString();
        int crear = FileSystem.crearArchivo(extension, nombre, contenido, false);
        /*
        DefaultMutableTreeNode aux;
        TreePath tree;
        tree = find(root,instance.getDirectorioActual().getNombre());
        if(tree.getPathCount()-1 != 0){
            aux = (DefaultMutableTreeNode)root.getChildAt(tree.getPathCount()-1);
            
        }
        else
            aux = root;*/
        
        if(crear == -1){
            //errooooooooooooorrrrrrrrrr
        }else{
            root.removeAllChildren();
            root = reloadTree(instance.getRoot(),root);
            //System.out.println(root.getChildCount());
            model.reload(root);;
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public
    private void extensionEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extensionEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_extensionEditActionPerformed

    private void jTextTamSectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTamSectoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTamSectoresActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //create the root node
        
        root = (DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren(); 
        root.setUserObject(jTextRoot.getText());
        root.setAllowsChildren(true);
        model.nodeChanged(root);
        
        root.add(new DefaultMutableTreeNode("."));
        
        model.reload(root);
        //actual = root;
        Directorio raiz = new Directorio(jTextRoot.getText(),null);
        
        FileSys filesys = new FileSys(raiz,Integer.parseInt(jTextCantSectores.getText()),Integer.parseInt(jTextTamSectores.getText()),jTextRoot.getText());
        instance.setRoot(raiz);
        instance.setDirectorioActual(raiz);
        //if(FileSystem. != null){
            //System.out.println(instance.get);
        //}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTableContenidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContenidoMouseClicked
        // TODO add your handling code here:
        
        
        /*JTable source = (JTable)evt.getSource();
            int row = source.rowAtPoint( evt.getPoint() );
            int column = source.columnAtPoint( evt.getPoint() );
            String s=source.getModel().getValueAt(row, column)+"";*/
    }//GEN-LAST:event_jTableContenidoMouseClicked

    private void jTableModContenidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableModContenidoMouseClicked
        // TODO add your handling code here:
        int row = jTableModContenido.getSelectedRow();
        int column = jTableModContenido.getSelectedColumn();
        String nombre = jTableModContenido.getValueAt(row, column).toString();
        //System.out.println(column);
        
        if(column < jTableModContenido.getColumnCount()-1){
            String extension = jTableModContenido.getValueAt(row, column+1).toString();
        
            Archivo ar = FileSystem.searchFile(instance.getDirectorioActual().getListaArchivos(), nombre, extension);
            if(ar != null){
                jContenidoArchivo.setText("");
                jContenidoArchivo.setText(ar.getContenido());
            }else{
            System.out.println("fuck");
        }
        }else{
            System.out.println("fuck");
        }
        
      
            
    }//GEN-LAST:event_jTableModContenidoMouseClicked

    private void jTableConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsultaMouseClicked
        // TODO add your handling code here:
        int row = jTableConsulta.getSelectedRow();
        int column = jTableConsulta.getSelectedColumn();
        String nombre = jTableConsulta.getValueAt(row, column).toString();
        //System.out.println(column);
        
        if(column < jTableConsulta.getColumnCount()-1){
            String extension = jTableConsulta.getValueAt(row, column+1).toString();
        
            Archivo ar = FileSystem.searchFile(instance.getDirectorioActual().getListaArchivos(), nombre, extension);
            if(ar != null){
                jTextContenidoCons.setText("");
                jTextContenidoCons.setText(ar.getContenido());
            }else{
            System.out.println("fuck");
        }
        }else{
            System.out.println("fuck");
        }
    }//GEN-LAST:event_jTableConsultaMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int row = jTableCopiar.getSelectedRow();
        int column = jTableCopiar.getSelectedColumn();
        String rutaDestino = destinoEdit.getText().toString();
        String nombre = jTableCopiar.getValueAt(row, column).toString();
        //System.out.println(column);
        
        if(column < jTableCopiar.getColumnCount()-1){
            String tipo = jTableCopiar.getValueAt(row, column+1).toString();
            String[] nombreExt = nombre.split("\\.");
            System.out.println(Arrays.toString(nombreExt));
            if(tipo.equals("archivo")){
                FileSystem.copiarVirtualVirtualAr(rutaActualEdit.getText().toString(),rutaDestino,nombreExt[0],"."+nombreExt[1]);
                actualizaDatos();
            }else{
                FileSystem.copiarVirtualVirtualDir(rutaActualEdit.getText().toString()+nombre+"/",rutaDestino);
                actualizaDatos();
            }
        
        }else{
            System.out.println("fuck");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        //asdf
        int row = jTableMover.getSelectedRow();
        int column = jTableMover.getSelectedColumn();
        String rutaDestino = rutaDestinoEdit.getText().toString();
        String nombre = jTableMover.getValueAt(row, column).toString();
        //System.out.println(column);
        
        if(column < jTableMover.getColumnCount()-1){
            String tipo = jTableMover.getValueAt(row, column+1).toString();
            String[] nombreExt = nombre.split("\\.");
            System.out.println(Arrays.toString(nombreExt));
            if(tipo.equals("archivo")){
                FileSystem.moverVirtualVirtualAr(rutaActualEdit.getText().toString(),rutaDestino,nombreExt[0],"."+nombreExt[1]);
                actualizaDatos();
            }else{
                FileSystem.moverVirtualVirtualDir(rutaActualEdit.getText().toString()+nombre+"/",rutaDestino);
                actualizaDatos();
            }
        
        }else{
            System.out.println("fuck");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int row = jTablaEliminar.getSelectedRow();
        int column = jTablaEliminar.getSelectedColumn();
       
        String nombre = jTablaEliminar.getValueAt(row, column).toString();
        //System.out.println(column);
        
        if(column < jTablaEliminar.getColumnCount()-1){
            String tipo = jTablaEliminar.getValueAt(row, column+2).toString();
            String[] nombreExt = nombre.split("\\.");
            System.out.println(Arrays.toString(nombreExt));
            if(tipo.equals("archivo")){
                String extension = jTablaEliminar.getValueAt(row, column+1).toString();
                instance.getDirectorioActual().getListaArchivos().remove(FileSystem.searchFile(instance.getDirectorioActual().getListaArchivos(), nombre, extension));
               
            }else{
                instance.getDirectorioActual().getdHijo().remove(FileSystem.searchDirectorio(nombre, instance.getDirectorioActual()));
                
            }
        
        }else{
            System.out.println("fuck");
        }
        
        actualizaDatos();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String nombre = nombreArchivoEdit.getText().toString();
        String[] nombreExt = nombre.split("\\.");
        
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea contenidoEdit;
    private javax.swing.JTextField destinoEdit;
    private javax.swing.JTextField extensionEdit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JTextArea jContenidoArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablaEliminar;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTable jTableContenido;
    private javax.swing.JTable jTableCopiar;
    private javax.swing.JTable jTableModContenido;
    private javax.swing.JTable jTableMover;
    private javax.swing.JTable jTablePropiedades;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextCantSectores;
    private javax.swing.JTextArea jTextContenidoCons;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextNombreDirectorio;
    private javax.swing.JTextField jTextRoot;
    private javax.swing.JTextField jTextTamSectores;
    private javax.swing.JTree jTree;
    private javax.swing.JTextField nombreArchivoEdit;
    private javax.swing.JTextField nombreEdit;
    private javax.swing.JTextField rutaActualEdit;
    private javax.swing.JTextField rutaDestinoEdit;
    // End of variables declaration//GEN-END:variables
}
