/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import org.w3c.dom.Document;
/**
 *
 * @author Marta
 */
public class Ventana extends javax.swing.JFrame {

    DomClass gesDom= new DomClass();
    JaxClass gesJax= new JaxClass();
    SaxClass gesSax= new SaxClass();
    
    File fichero;  //Lo declaramos de instancia porque lo vamos a utilizar en múltiples sitios
    
    int valorDeGuardado=0; //nos permite alternar entre uno y otro para llamar al método de guardado correspondiente
                           //en cada caso.
    
    public Ventana() {
        initComponents();
        Font font=new Font("MV Boli",Font.PLAIN,16);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(font);
        //Esta parte nos permite añadir los radiobuttons a un button group para que sólo se seleccione uno por vez
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4);
        buttonGroup1.add(jRadioButton5);
        buttonGroup1.add(jRadioButton7);
        //El botón de modificar información permanece deshabilitado hasta que lo necesitemos
        botonModificarJAXB.setEnabled(false);
        //El botón de guardado permanece desabilitado hasta que lo necesitemos.
        botonGuardar.setEnabled(false);
        
    }

    //Método que nos permite abrir un jFileChooser para abrir un archivo.
    private File dialogoSeleccion(){
      int rv;
      
      try{
        JFileChooser fc=new JFileChooser(); //Creamos un filechooser
        fc.setMultiSelectionEnabled(false); //Nos impide seleccionar más de un archivo.
        fc.setDialogType(JFileChooser.OPEN_DIALOG); //Abrimos el filechooser
        rv=fc.showOpenDialog(this); //Guardamos el valor del archivo seleccionado en un int
        //Si el usuario presiona aceptar, entonces obtiene el archivo seleccionado.
        if(rv==JFileChooser.APPROVE_OPTION){
           fichero=fc.getSelectedFile();
          
        }    
      }catch(NullPointerException e){
          System.out.println("No se ha podido obtener el fichero");
          return null;
      }         
      return fichero;
    }
    
    //Método para guardar usando el fileChooser
     private void guardaArchivo(){
        JFileChooser fc=new JFileChooser(); //Creamos un nuevo objeto fileChooser
        fc.setMultiSelectionEnabled(false); //Nos impide seleccionar más de un archivo.
        fc.setDialogType(JFileChooser.OPEN_DIALOG); //Abrimos el fileChooser
        //En un int guardamos el valor que nos da cuando el usuario elige un archivo
        int seleccion= fc.showSaveDialog(this);
        
        if(seleccion==JFileChooser.APPROVE_OPTION){
          //Si llego aquí es que el usuario ha pulsado en guardar cuando ha salido el menú de jFileChooser.
          //Tenemos la opción de guardar el contenido sobre un fichero.
          File archivo= fc.getSelectedFile(); //Obtiene el archivo seleccionado
          String nombre= archivo.getName(); //Obtiene el nombre del archivo seleccionado
          //Necesitamos saber si es un png o un jpg. La extensión, para poder guardarlo y que no de error.
          //Para ello declaramos un string y tomamos un substring del nombre del archivo, tomando como referencia
          //el lastIndex del punto +1. Esto es para que no dé error.
          String extension=nombre.substring(nombre.lastIndexOf('.')+1);
          //Si la extensión es xml, ejecuta.
          if(extension.equalsIgnoreCase("xml")){
                  System.out.println("Ha entrado");
                  if(valorDeGuardado==1){  //Esto nos va a permitir alternar entre uno u otro dependiendo
                    gesDom.guardarDomComoFile(archivo);  //de si hemos usado JaxB o Dom para generar los datos.
                  }else if(valorDeGuardado==2){       //El valor se asigna cuandos se usa el botón de añadir datos
                    gesJax.guardarJaxB(archivo);      //o el de editar datos.
                  }
          }
        }

    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        botonEjecutarXPATH = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BotonInsertarDOM = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        botonBuscarJAXB = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        botonModificarJAXB = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        botonMenuAbirSAX = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jRadioButton1.setText("Todos los Registros");

        jRadioButton2.setText("Afijos");

        jRadioButton3.setText("Razas");

        jRadioButton4.setText("Deportes");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setText("Selección por Club");

        jRadioButton7.setText("Selección por Grado");

        botonEjecutarXPATH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonEjecutarXPATH.setText("Ejecutar");
        botonEjecutarXPATH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonEjecutarXPATHMousePressed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(0, 102, 153));
        jTextField2.setForeground(new java.awt.Color(0, 102, 153));

        jTextField5.setBackground(new java.awt.Color(0, 102, 153));
        jTextField5.setText("jTextField5");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Chip;");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nacimiento;");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Afijo;");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nombre;");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Raza;");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Deporte;");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Propietario;");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Grado;");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Club;");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Sexo;");

        BotonInsertarDOM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotonInsertarDOM.setText("Insertar");
        BotonInsertarDOM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonInsertarDOMMousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Número de Chip;");

        botonBuscarJAXB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonBuscarJAXB.setText("Buscar");
        botonBuscarJAXB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonBuscarJAXBMousePressed(evt);
            }
        });

        jTextField3.setText("Nombre Club");

        botonModificarJAXB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonModificarJAXB.setText("Modificar");
        botonModificarJAXB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonModificarJAXBMousePressed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonGuardarMousePressed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brevet", "Grado 1", "Grado 2", "Grado 3" }));

        jMenu1.setText("File");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });

        botonMenuAbirSAX.setText("Abrir");
        botonMenuAbirSAX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonMenuAbirSAXMousePressed(evt);
            }
        });
        botonMenuAbirSAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuAbirSAXActionPerformed(evt);
            }
        });
        jMenu1.add(botonMenuAbirSAX);

        jMenuItem2.setText("Guardar");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jRadioButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jRadioButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton5))
                                .addGap(57, 57, 57)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton7)
                                    .addComponent(jRadioButton4))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(botonEjecutarXPATH, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(botonBuscarJAXB, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonModificarJAXB, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonInsertarDOM, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(4, 4, 4)
                        .addComponent(jRadioButton3)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jRadioButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(botonEjecutarXPATH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addComponent(botonBuscarJAXB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(botonModificarJAXB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(BotonInsertarDOM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonMenuAbirSAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuAbirSAXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMenuAbirSAXActionPerformed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        
    }//GEN-LAST:event_jMenu1MousePressed

    private void botonMenuAbirSAXMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenuAbirSAXMousePressed
        //Le asignamos a esta variable temporal el valor del fichero que abrimos con el jDialog.
        File ficheroTemp=dialogoSeleccion();
        //Guardamos el valor integer que nos devuelve el método abrirSax.
        int temp=gesSax.abrirSAX(ficheroTemp);
        
        if(temp==0){
          System.out.print("se ha abierto el fichero");
          //En caso que se haya abierto correctamente el fichero, ejecutamos el método recorrerSax para parsear
          //el contenido del fichero a través del manejador y lo guardamos en una variable String.
          String contenido=gesSax.recorrerSAX();
          //En el jTextArea asignamos el contenido de la variable (contenido) y lo muestra.
          jTextArea1.setText(contenido);
        }else if(temp==-1){
          System.out.print("No se ha podido abrir el fichero");
        }
    }//GEN-LAST:event_botonMenuAbirSAXMousePressed

    private void botonBuscarJAXBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBuscarJAXBMousePressed
        gesJax.abrirJAXB(fichero); //Abrimos el fichero usando JaxB para poder trabajar con él
        String entrada=jTextField4.getText(); //Obtenemos el nº de chip que le vamos a pasar como variable de entrada
        String[] temp=new String[10]; //Declaramos un array de strings que nos va a servir para cargar el contenido.
        temp=gesJax.recorrerJaxB(entrada); //Obtenemos el array que nos devuelve recorrerJaxB.
        
        //Vamos a sacar los datos a través de los textfields.
        jTextField12.setText(temp[0]);
        jTextField7.setText(temp[1]);
        jTextField8.setText(temp[2]);
        jTextField9.setText(temp[3]);
        jTextField10.setText(temp[4]);
        jTextField13.setText(temp[5]);
        jTextField14.setText(temp[6]);
        jTextField6.setText(temp[7]);
        jTextField15.setText(temp[8]);
        jTextField16.setText(temp[9]);
        //Deshabilitamos el textfield del chip y el botón de añadir información nueva
        jTextField12.setEditable(false);
        BotonInsertarDOM.setEnabled(false);
        //Habilitamos el botón de modificar información.
        botonModificarJAXB.setEnabled(true);
    }//GEN-LAST:event_botonBuscarJAXBMousePressed

    private void BotonInsertarDOMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonInsertarDOMMousePressed
        //Asignamos valor a las variables que vamos a utilizar. Obtenemos ese valor de los textfields.
        String chip=jTextField12.getText();
        String afijo=jTextField7.getText();
        String nacimiento=jTextField8.getText();
        String nombre=jTextField9.getText();
        String raza=jTextField10.getText();
        String sexo=jTextField13.getText();
        String propietario=jTextField14.getText();
        String deporte=jTextField6.getText();
        String grado=jTextField15.getText();
        String club=jTextField16.getText();
        //Guardamos el valor que nos devuelve el método abrirDom en esta variable int
        int temp=gesDom.abrirDom(fichero);
        String datos=""; //Nos va a permitir sacar el DOM con la inserción por pantalla para comprobar que se ha hecho correctamente
         //Si el método abrirDom nos devuelve 0, procesamos el contenido del árbol y lo mostramos.
        if(temp==0){
            //Añadimos un nuevo elemento perro al árbol DOM.
            gesDom.addDom(chip, afijo,  nacimiento,  nombre,  raza, 
             sexo,  propietario,  deporte,  grado,  club);
          //En el String datos guardamos el contenido del árbol
          datos=gesDom.recorrerDom();
          jTextArea1.setText(datos); //Sacamos el contenido del árbol por pantalla
        }else if(temp==-1){
          jTextArea1.setText("No se puede mostrar el contenido del árbol");
        }
        //Habilitamos el botón de guardado para que se permita su uso una vez insertados los datos.
        botonGuardar.setEnabled(true);
        valorDeGuardado=1; //Nos va a permitir guardar el árbol en un archivo
    }//GEN-LAST:event_BotonInsertarDOMMousePressed

    private void botonEjecutarXPATHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEjecutarXPATHMousePressed
        String consulta=""; //Aquí vamos a guardar el parámetro de entrada que le vamos a pasar.
        String seleccionClub=jTextField3.getText();  //Variable que vamos a usar en la consulta
        int temp=gesDom.abrirDom(fichero);
        //Creamos una estructura con el árbol DOM y, si se crea correctamente, ejecutamos el XPath
        if(temp==0){
           //A través de los ifs seleccionamos lo que ocurre dependiendo del botón que esté seleccionado.
           if(jRadioButton1.isSelected()){
              consulta="/perros/perro"; //Damos un valor a la variable consulta
              jTextArea1.setText(gesDom.ejecutaXPATH(consulta)); //Se ejecuta el método del XPath y aparece en el textArea     
           }else if(jRadioButton2.isSelected()){
              consulta="/perros/perro/@afijo";
              jTextArea1.setText(gesDom.ejecutaXPATH(consulta));
           }else if(jRadioButton3.isSelected()){
              consulta="/perros/perro/raza";
              jTextArea1.setText(gesDom.ejecutaXPATH(consulta));
           }else if(jRadioButton4.isSelected()){
              consulta="/perros/perro/deporte";
              jTextArea1.setText(gesDom.ejecutaXPATH(consulta));
           }else if(jRadioButton5.isSelected()){
              consulta="/perros/perro[./club='"+seleccionClub+"']"; //Obtenemos el valor escrito en el textfield y
              jTextArea1.setText(gesDom.ejecutaXPATH(consulta));    //se lo asignamos al string que asignamos como valor
           }else if(jRadioButton7.isSelected()){                    //a la variable consulta.
               String cajaSeleccionada=(String) jComboBox1.getSelectedItem(); //Tomamos el valor del jComboBox. Casteamos a
               if(cajaSeleccionada.equals("Brevet")){                         //String porque getSelectedItem no devuelve String
                 consulta="/perros/perro[./grado='Brevet']";
               }else if(cajaSeleccionada.equals("Grado 1")){
                 consulta="/perros/perro[./grado='1']";  
               }else if(cajaSeleccionada.equals("Grado 2")){ //Dependiendo de cual caja del jComboBox esté seleccionada
                 consulta="/perros/perro[./grado='2']";      //ejecutará una consulta u otra.
               }else if(cajaSeleccionada.equals("Grado 3")){
                 consulta="/perros/perro[./grado='3']";
               }
              jTextArea1.setText(gesDom.ejecutaXPATH(consulta));
           }
        }else if(temp==-1){
           jTextArea1.setText("No se puede mostrar el contenido del árbol");
        }
        //El botón de guardado permanece desabilitado porque sólo vamos a hacer consultas
        botonGuardar.setEnabled(false);
    }//GEN-LAST:event_botonEjecutarXPATHMousePressed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void botonModificarJAXBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonModificarJAXBMousePressed
        // Botón que controla las modificaciones con JAXB
        //Obtenemos los datos de los textareas.
        String chip=jTextField12.getText();
        String afijo=jTextField7.getText();
        String nacimiento=jTextField8.getText();
        String nombre=jTextField9.getText();
        String raza=jTextField10.getText();
        String sexo=jTextField13.getText();
        String propietario=jTextField14.getText();
        String deporte=jTextField6.getText();
        String grado=jTextField15.getText();
        String club=jTextField16.getText();
        //Guardamos el valor int que nos devuelve JaxB en un int.
        int valor=gesJax.editarJaxB(chip, afijo, nacimiento, nombre, raza, sexo, propietario, deporte, grado, club);
        //Si el valor del int es 0.
        if(valor==0){
            String aux[]=gesJax.recorrerJaxB(chip); //Recorre JaxB y nos lo guarda en un array de strings, pasándole el chip como parámetro.
            String salida=""; //Declaramos un String que nos va a permitir visualizar el contenido por pantalla
           for(int i=0; i<10;i++){
               salida=salida + "\n" + aux[i];  //A través de este bucle for guardamos el contenido del array en 
           }                                   //un String.
           jTextArea1.setText(salida); //Sacamos el String por pantalla.
        }else if(valor==-1){
            jTextArea1.setText("No se ha podido editar");
        }
        
        //Vamos a colocar los valores en 0 y reiniciar. Así el usuario puede hacer inserciones nuevas sin problema
        //Limpiamos los textFields.
        jTextField12.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
        jTextField6.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        //Reiniciamos los botones y volvemos a permitir la escritura en el textfield de chip.
        botonModificarJAXB.setEnabled(false);
        jTextField12.setEditable(true);
        BotonInsertarDOM.setEnabled(true);
        //Habilitamos el botón de guardado para que se permita su uso una vez insertados los datos.
        botonGuardar.setEnabled(true);
        //Le damos valor al int para poder proceder al guardado.
        valorDeGuardado=2;
    }//GEN-LAST:event_botonModificarJAXBMousePressed

    private void botonGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMousePressed
        guardaArchivo();
    }//GEN-LAST:event_botonGuardarMousePressed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonInsertarDOM;
    private javax.swing.JButton botonBuscarJAXB;
    private javax.swing.JButton botonEjecutarXPATH;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JMenuItem botonMenuAbirSAX;
    private javax.swing.JButton botonModificarJAXB;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
