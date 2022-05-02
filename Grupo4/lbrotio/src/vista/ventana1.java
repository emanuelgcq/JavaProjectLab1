package vista;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import modelo.Solicitudes;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ventana1 extends JFrame {
	
	//--------------Declaracion de los objetos paneles:
	//private JPanel panContenedorv1, panSecc1, panSecc2;
	
	//--------------Declaracion de los objetos del menu:
	private JMenuBar menuc;
	private JMenu mopciones, mventanas, mvista, mayuda;
	private JMenuItem moLimpiar, mventana2, mviRojo, mviAzul, mviVerde, mviMorado, maCreadores;
	
	//--------------Declaracion de los objetos de la ventana:
	private JLabel lbltitulo, lblsecc1, lblsecc2, lblesc1;
	private JButton btncargar, btngenerar, btnconsultar;
    private JComboBox cbestatus;
	private JTable tblconsulta;
	private JScrollPane scpVistaConsultaSecc2;
	private JTextArea taVistaConsultaSecc2;
    
    //--------------Metodo constructor
    public ventana1() {
    	super();
    	initGUI();
    }
    
    private void initGUI() {
    	try {
    		//--------------Metodo que permite concluir el programa una vez dado clic al boton cerrar (a la "x" de arriba a la dereha).
    		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    		 setLayout(null);
    	     getContentPane().setBackground(new Color(120,0,120));
    	     setTitle("Ventana 1");
    		{
    			//--------------Creacion del objeto panel.
        		//panContenedorv1 = new JPanel();
    			//getContentPane().add(panContenedorv1);
    			//panContenedorv1.setBounds(5, 5, 59, 59);
    			//panContenedorv1.setLayout(null);
    			//panContenedorv1.setVisible(true);
    			//panContenedorv1.setPreferredSize(new java.awt.Dimension(595, 595));
    			{
    				//--------------Creacion del objeto menuBar
    				menuc = new JMenuBar();
    		        menuc.setBackground(new Color(120,0,120));
    		        setJMenuBar(menuc);
    		        {
    		        	//--------------
    		        	mopciones = new JMenu("OPCIONES");
    		            mopciones.setBackground(new Color(0,0,0));
    		            mopciones.setFont(new Font("Eras Demi ITC", 1, 14));
    		            mopciones.setForeground(new Color(255,255,255));
    		            menuc.add(mopciones);
    		            {
    		            	//--------------
    		            	moLimpiar = new JMenuItem("LIMPIAR");
    		                moLimpiar.setFont(new Font("Eras Demi ITC", 1, 14));
    		                moLimpiar.setForeground(new Color(0,0,0));
    		                mopciones.add(moLimpiar);
    		            }
    		        }
    		        {
    		        	//--------------
    		        	mventanas = new JMenu("VENTANAS");
    		            mventanas.setBackground(new Color(0, 0, 0));
    		            mventanas.setFont(new Font("Eras Demi ITC", 1, 14));
    		            mventanas.setForeground(new Color(255,255,255));
    		            menuc.add(mventanas);
    		            {
    		            	//--------------
    		            	mventana2 = new JMenuItem("VENTANA 2");
    		                mventana2.setFont(new Font("Eras Demi ITC", 1, 14));
    		                mventana2.setForeground(new Color(0,0,0));
    		                mventanas.add(mventana2);
    		            }
    		        }
    		        {
    		        	//--------------
    		        	mvista = new JMenu("VISTA");
    		            mvista.setBackground(new Color(0,0,0));
    		            mvista.setFont(new Font("Eras Demi ITC", 1, 14));
    		            mvista.setForeground(new Color(255,255,255));
    		            menuc.add(mvista);
    		            {
    		            	//--------------
    		            	mviRojo = new JMenuItem("ROJO");
    		                mviRojo.setFont(new Font("Eras Demi ITC", 1, 14));
    		                mviRojo.setForeground(new Color(0,0,0));
    		                mvista.add(mviRojo);
    		            }
    		            {
    		            	//--------------
    		            	mviAzul = new JMenuItem("AZUL");
    		                mviAzul.setFont(new Font("Eras Demi ITC", 1, 14));
    		                mviAzul.setForeground(new Color(0,0,0));
    		                mvista.add(mviAzul);
    		            }
    		            {
    		            	//--------------
    		            	mviVerde = new JMenuItem("VERDE");
    		                mviVerde.setFont(new Font("Eras Demi ITC", 1, 14));
    		                mviVerde.setForeground(new Color(0,0,0));
    		                mvista.add(mviVerde);
    		            }
    		            {
    		            	//--------------
    		                mviMorado = new JMenuItem("MORADO");
    		                mviMorado.setFont(new Font("Eras Demi ITC", 1, 14));
    		                mviMorado.setForeground(new Color(0,0,0));
    		                mvista.add(mviMorado);
    		            }
    		        }
    		        {
    		        	//--------------
    		        	mayuda = new JMenu("AYUDA");
    		            mayuda.setBackground(new Color(0,0,0));
    		            mayuda.setFont(new Font("Eras Demi ITC", 1, 14));
    		            mayuda.setForeground(new Color(255,255,255));
    		            menuc.add(mayuda);
    		            {
    		            	//--------------
    		                maCreadores = new JMenuItem("CREADORES");
    		                maCreadores.setFont(new Font("Eras Demi ITC", 1, 14));
    		                maCreadores.setForeground(new Color(0,0,0));
    		                mayuda.add(maCreadores);
    		            }
    		        }
    			}
    			{
					lbltitulo = new JLabel("Gobernacion Edo. Lara");
					//panContenedorv1.add(lbltitulo);
			        lbltitulo.setBounds(150, 10, 300, 20);
			        lbltitulo.setForeground(new Color(255, 255, 255));
			        lbltitulo.setFont(new Font("Andale Mono", 2, 24));
			        add(lbltitulo);
				}
    			{
    				//--------------
    				//panSecc1 = new JPanel();
					//panContenedorv1.add(panSecc1);
					//panSecc1.setBounds(10, 10, 540, 170);
					//panSecc1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
					//panSecc1.setLayout(null);
					//panSecc1.setVisible(true);
					{
						lblsecc1 = new JLabel("SECCION 1: Carga de datos.");
						//panSecc1.add(lblsecc1);
				        lblsecc1.setBounds(20, 50, 540, 20);
				        lblsecc1.setForeground(new Color(255, 255, 255));
				        lblsecc1.setFont(new Font("Andale Mono", 1, 16));
				        add(lblsecc1);
					}
					{
						btncargar = new JButton("CARGAR DATOS");
						//panSecc1.add(btncargar);
				        btncargar.setBounds(20, 90, 545, 30);
				        add(btncargar);
					}
					{
				        btngenerar = new JButton("GENERAR");
				        //panSecc1.add(btngenerar);
				        btngenerar.setBounds(20, 130, 545, 30);
				        add(btngenerar);
					}
    			}
    			{
    				//panSecc2 = new JPanel();
					//panContenedorv1.add(panSecc2);
					//panSecc2.setBounds(72, 107, 337, 207);
					//panSecc2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
					//panSecc2.setLayout(null);
					//panSecc2.setVisible(true);
					{
						lblsecc2 = new JLabel("SECCION 2: Estado de solicitudes");
						//panSecc2.add(lblsecc2);
				        lblsecc2.setBounds(20, 190, 540, 20);
				        lblsecc2.setForeground(new Color(255, 255, 255));
				        lblsecc2.setFont(new Font("Andale Mono", 1, 16));
				        add(lblsecc2);
					}
					{
						lblesc1 = new JLabel("Elija el estatus de las solicitudes a consultar:");
						//panSecc2.add(lblesc1);
						lblesc1.setBounds(20,215,560,20);
						lblesc1.setForeground(new Color(255, 255, 255));
						lblesc1.setFont(new Font("Andale Mono", 2, 14));
				        add(lblesc1);
					}
					{
						btnconsultar = new JButton("CARGAR CONSULTA");
						//panSecc2.add(btnconsultar);
						btnconsultar.setBounds(330, 240, 235, 25);
				        add(btnconsultar);
					}
					{
						cbestatus = new JComboBox();
						//panSecc2.add(cbestatus);
						cbestatus.setBounds(20,240,300,25);
						cbestatus.setBackground(new Color(224,224,224));
						cbestatus.setFont(new java.awt.Font("Andale Mono", 1, 14));
						cbestatus.setForeground(new Color(0,0,0));
				        add(cbestatus);
				        cbestatus.addItem("Seleccione");
				        cbestatus.addItem("Aprobada");
				        cbestatus.addItem("Rechazado");
					}
					{
						taVistaConsultaSecc2 = new JTextArea();
				        taVistaConsultaSecc2.setEditable(false);
				        taVistaConsultaSecc2.setBackground(new Color(224, 224, 224));
				        taVistaConsultaSecc2.setFont(new Font("Andale Mono", 1, 12));
				        taVistaConsultaSecc2.setForeground(new Color(0, 0, 0));
				        taVistaConsultaSecc2.setText("\n   Aqui encontraras el resultado de la consulta");
				        scpVistaConsultaSecc2 = new JScrollPane(taVistaConsultaSecc2);
				        scpVistaConsultaSecc2.setBounds(20, 280, 545, 240);
				        add(scpVistaConsultaSecc2);
					}
    			}
    		}
    		pack();
    		this.setSize(600,600);
    		
    	} catch (Exception e) {
    		//add your error handling code here (---------------------------------------------)
			e.printStackTrace();
    	}
    }
	
    public void agregarListener(ActionListener actionListener) {
    	//--------------
    	btncargar.addActionListener(actionListener);
    	//--------------
    	btngenerar.addActionListener(actionListener);
    	//--------------
    	btnconsultar.addActionListener(actionListener);
    	//--------------
    	mventana2.addActionListener(actionListener);
    	//-------------
    	mviRojo.addActionListener(actionListener); 
        //-------------- 
        mviAzul.addActionListener(actionListener); 
        //-------------- 
        mviVerde.addActionListener(actionListener); 
        //-------------- 
        mviMorado.addActionListener(actionListener); 
        //-------------- 
        maCreadores.addActionListener(actionListener); 
        //-------------- 
        moLimpiar.addActionListener(actionListener);
	}
    
    //-----------------------------------------------------------
  //--------------Todos los metodos de la SECCION 1--------------
    //-----------------------------------------------------------
    

    
    
    //-----------------------------------------------------------
  //--------------Todos los metodos de la SECCION 2--------------
    //-----------------------------------------------------------
    
    public String getOpcionSeleccionada() {
		if (cbestatus.getSelectedItem() == "")
			return "error";
		else
		   return cbestatus.getSelectedItem().toString();	
	}
    
    public void setTaVistaConsultaSecc2(String cadena) {
    	taVistaConsultaSecc2.setText(cadena);
    }
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	public void seleccionCbEstatus() { 
	     cbestatus.setSelectedIndex(0); 
	    } 
	     
	    public void colormenu(int r,int g,int b) { 
	     menuc.setBackground(new Color(r,g,b)); 
	    }
}