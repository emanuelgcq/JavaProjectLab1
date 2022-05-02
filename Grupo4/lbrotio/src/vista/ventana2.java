package vista;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;

import java.awt.*;
import java.awt.event.ActionListener;


public class ventana2 extends JFrame {

	//--------------Declaracion de los objetos paneles:
	//private JPanel panContenedorv2, panSecc3, panSecc4, panSecc5;
	
	//--------------Declaracion de los objetos del menu:
	private JMenuBar menuc;
	private JMenu mopciones, mventanas, mvista, mayuda;
	private JMenuItem moLimpiar, mventana2, mviRojo, mviAzul, mviVerde, mviMorado, maInfo, maCreadores;
	
	//--------------Declaracion de los objetos de la ventana:
	private JLabel lblSeccion3, lblSeccion4, lblSeccion5, lblDia1, lblDia2, lblMes1, lblMes2, lblAno1, lblAno2,
	lblDia3, lblDia4, lblMes3, lblMes4, lblAno3, lblAno4, lblResultado, lblEscrito1, lblEscrito2, lblEscrito3, lblEscrito4;
	private JTextField tfDia1, tfDia2, tfMes1, tfMes2, tfAno1, tfAno2, tfDia3, tfDia4, tfMes3, tfMes4, tfAno3, tfAno4,  tfResultado;
    private JButton btnResultado1, btnResultado2, btnConsulta;
    private JTextArea taVistaConsultaSecc4, taVistaConsultaSecc5;
    private JScrollPane scpVistaConsultaSecc4, scpVistaConsultaSecc5; 
    
    //--------------Metodo constructor
    public ventana2() {
    	super();
    	initGUI();
    }
    
    private void initGUI() {
    	try {
    		//--------------Creacion del objeto panel.
    		
    		setLayout(null);
    		getContentPane().setBackground(new Color(120,0,120));
   	     	setTitle("Ventana 2");
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
		            	mventana2 = new JMenuItem("VENTANA 1");
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
		            	maInfo = new JMenuItem("INFORMACION");
		                maInfo.setFont(new Font("Eras Demi ITC", 1, 14));
		                maInfo.setForeground(new Color(0,0,0));
		                mayuda.add(maInfo);
		            }
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
				//--------------
				//panSecc3 = new JPanel();
				//panContenedorv2.add(panSecc3);
				//panSecc3.setBounds(72, 107, 337, 207);
				//panSecc3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
				//panSecc3.setLayout(null);
				{
					lblSeccion3 = new JLabel("<html>SECCION 3: Costo total solicitudes aprobadas por fundación en <p>un lapso de tiempo.");
					lblSeccion3.setBounds(20, 10, 540, 40);
					lblSeccion3.setForeground(new Color(255, 255, 255));
					lblSeccion3.setFont(new Font("Andale Mono", 1, 16));
			        add(lblSeccion3);
				}
				{
					lblDia1 = new JLabel("Dia:");
					lblDia1.setBounds(20, 82, 30, 20);
					lblDia1.setForeground(new Color(255, 255, 255));
					lblDia1.setFont(new Font("Andale Mono", 2, 14));
			        add(lblDia1);
				}
				{
					lblMes1 = new JLabel("Mes:");
					lblMes1.setBounds(95, 82, 35, 20);
			        lblMes1.setForeground(new Color(255, 255, 255));
			        lblMes1.setFont(new Font("Andale Mono", 2, 14));
			        add(lblMes1);
				}
				{
					lblAno1 = new JLabel("Ano:");
					lblAno1.setBounds(175, 82, 30, 20);
			        lblAno1.setForeground(new Color(255, 255, 255));
			        lblAno1.setFont(new Font("Andale Mono", 2, 14));
			        add(lblAno1);
				}
				{
					lblDia2 = new JLabel("Dia:");
					lblDia2.setBounds(270, 82, 30, 20);
					lblDia2.setForeground(new Color(255, 255, 255));
					lblDia2.setFont(new Font("Andale Mono", 2, 14));
			        add(lblDia2);
				}
				{
					lblMes2 = new JLabel("Mes:");
					lblMes2.setBounds(345, 82, 35, 20);
			        lblMes2.setForeground(new Color(255, 255, 255));
			        lblMes2.setFont(new Font("Andale Mono", 2, 14));
			        add(lblMes2);
				}
				{
					lblAno2 = new JLabel("Ano:");
					lblAno2.setBounds(425, 82, 30, 20);
			        lblAno2.setForeground(new Color(255, 255, 255));
			        lblAno2.setFont(new Font("Andale Mono", 2, 14));
			        add(lblAno2);
				}
				{
					tfDia1 = new JTextField();
			        tfDia1.setBounds(55, 82, 35, 25);
			        add(tfDia1);
				}
				{
					tfMes1 = new JTextField();
			        tfMes1.setBounds(135, 82, 35, 25);
			        add(tfMes1);
				}
				{
					tfAno1 = new JTextField();
			        tfAno1.setBounds(205, 82, 50, 25);
			        add(tfAno1);
				}
				
				{
					tfDia2 = new JTextField();
			        tfDia2.setBounds(305, 82, 35, 25);
			        add(tfDia2);
				}
				{
					tfMes2 = new JTextField();
			        tfMes2.setBounds(385, 82, 35, 25);
			        add(tfMes2);
				}
				{
					tfAno2 = new JTextField();
			        tfAno2.setBounds(455, 82, 50, 25);
			        add(tfAno2);
				}
				{
					lblEscrito1 = new JLabel("Digite por favor las fechas desde y hasta para realizar la consulta:");
			        lblEscrito1.setBounds(20, 55, 540, 20);
			        lblEscrito1.setForeground(new Color(255, 255, 255));
			        lblEscrito1.setFont(new Font("Andale Mono", 2, 14));
			        add(lblEscrito1);
				}
				{
					lblEscrito2 = new JLabel("Seleccione la fundación:");
			        lblEscrito2.setBounds(20, 110, 300, 20);
			        lblEscrito2.setForeground(new Color(255, 255, 255));
			        lblEscrito2.setFont(new Font("Andale Mono", 2, 14));
			        add(lblEscrito2);
				}
				{
					btnResultado1 = new JButton("CALCULAR COSTO");
			        btnResultado1.setBounds(20, 135, 545, 25);
			        add(btnResultado1);
				}
			}
			{
				//--------------
				//panSecc4 = new JPanel();
				//panContenedorv2.add(panSecc4);
				//panSecc4.setBounds(72, 107, 337, 207);
				//panSecc4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
				//panSecc4.setLayout(null);
				{
					lblSeccion4 = new JLabel("SECCION 4: Costo total presupuestos en un lapso de tiempo.");
					lblSeccion4.setBounds(20, 265, 540, 20);
					lblSeccion4.setForeground(new Color(255, 255, 255));
					lblSeccion4.setFont(new Font("Andale Mono", 1, 16));
			        add(lblSeccion4);
				}
				{
					lblDia3 = new JLabel("Dia:");
					lblDia3.setBounds(20, 315, 30, 20);
					lblDia3.setForeground(new Color(255, 255, 255));
					lblDia3.setFont(new Font("Andale Mono", 2, 14));
			        add(lblDia3);
				}
				{
					lblMes3 = new JLabel("Mes:");
					lblMes3.setBounds(95, 315, 35, 20);
			        lblMes3.setForeground(new Color(255, 255, 255));
			        lblMes3.setFont(new Font("Andale Mono", 2, 14));
			        add(lblMes3);
				}
				{
					lblAno3 = new JLabel("Ano:");
					lblAno3.setBounds(175, 315, 30, 20);
			        lblAno3.setForeground(new Color(255, 255, 255));
			        lblAno3.setFont(new Font("Andale Mono", 2, 14));
			        add(lblAno3);
				}
				{
					lblDia4 = new JLabel("Dia:");
					lblDia4.setBounds(270, 315, 30, 20);
					lblDia4.setForeground(new Color(255, 255, 255));
					lblDia4.setFont(new Font("Andale Mono", 2, 14));
			        add(lblDia4);
				}
				{
					lblMes4 = new JLabel("Mes:");
					lblMes4.setBounds(345, 315, 35, 20);
			        lblMes4.setForeground(new Color(255, 255, 255));
			        lblMes4.setFont(new Font("Andale Mono", 2, 14));
			        add(lblMes4);
				}
				{
					lblAno4 = new JLabel("Ano:");
					lblAno4.setBounds(425, 315, 30, 20);
			        lblAno4.setForeground(new Color(255, 255, 255));
			        lblAno4.setFont(new Font("Andale Mono", 2, 14));
			        add(lblAno4);
				}
				{
					tfDia3 = new JTextField();
			        tfDia3.setBounds(55, 315, 35, 25);
			        add(tfDia3);
				}
				{
					tfMes3 = new JTextField();
			        tfMes3.setBounds(135, 315, 35, 25);
			        add(tfMes3);
				}
				{
					tfAno3 = new JTextField();
			        tfAno3.setBounds(205, 315, 50, 25);
			        add(tfAno3);
				}
				
				{
					tfDia4 = new JTextField();
			        tfDia4.setBounds(305, 315, 35, 25);
			        add(tfDia4);
				}
				{
					tfMes4 = new JTextField();
			        tfMes4.setBounds(385, 315, 35, 25);
			        add(tfMes4);
				}
				{
					tfAno4 = new JTextField();
			        tfAno4.setBounds(455, 315, 50, 25);
			        add(tfAno4);
				}
				{
					lblResultado = new JLabel("Resultado:");
			        lblResultado.setBounds(210, 345, 70, 20);
			        lblResultado.setForeground(new Color(255, 255, 255));
			        lblResultado.setFont(new Font("Andale Mono", 2, 14));
			        add(lblResultado);
				}
				{
					lblEscrito3 = new JLabel("Digite por favor las fechas desde y hasta para realizar la consulta:");
			        lblEscrito3.setBounds(20, 290, 540, 20);
			        lblEscrito3.setForeground(new Color(255, 255, 255));
			        lblEscrito3.setFont(new Font("Andale Mono", 2, 14));
			        add(lblEscrito3);
				}
				
				{
					tfResultado = new JTextField();
			        tfResultado.setBounds(290, 345, 270, 25);
			        add(tfResultado);
				}
				{
					btnResultado2 = new JButton("CALCULAR PRESUPUESTO");
			        btnResultado2.setBounds(20, 345, 180, 25);
			        add(btnResultado2);
				}
				{
					taVistaConsultaSecc4 = new JTextArea();
			        taVistaConsultaSecc4.setEditable(false);
			        taVistaConsultaSecc4.setBackground(new Color(224, 224, 224));
			        taVistaConsultaSecc4.setFont(new Font("Andale Mono", 1, 12));
			        taVistaConsultaSecc4.setForeground(new Color(0, 0, 0));
			        taVistaConsultaSecc4.setText("\n   Aquí encontraras el resultado de la consulta");
			        scpVistaConsultaSecc4 = new JScrollPane(taVistaConsultaSecc4);
			        scpVistaConsultaSecc4.setBounds(20, 165, 545, 90);
			        add(scpVistaConsultaSecc4);
				}
			}
			{
				//--------------
				//panSecc5 = new JPanel();
				//panContenedorv2.add(panSecc5);
				//panSecc5.setBounds(20, 165, 545, 90);
				//panSecc5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
				//panSecc5.setLayout(null);
				{
					lblSeccion5 = new JLabel("SECCION 5: Consultas");
					lblSeccion5.setForeground(new Color(255, 255, 255));
			        lblSeccion5.setBounds(20, 380, 540, 20);
			        lblSeccion5.setFont(new Font("Andale Mono", 1, 16));
			        add(lblSeccion5);
				}
				{
					btnConsulta = new JButton("CONSULTAR");
			        btnConsulta.setBounds(20, 410, 540, 25);
			        add(btnConsulta);
				}
				{
					lblEscrito4 = new JLabel("...");
					lblEscrito4.setForeground(new Color(255, 255, 255));
			        lblEscrito4.setBounds(20, 380, 540, 20);
			        lblEscrito4.setFont(new Font("Andale Mono", 2, 14));
			        add(lblEscrito4);
				}
				{
					taVistaConsultaSecc5 = new JTextArea();
			        taVistaConsultaSecc5.setEditable(false);
			        taVistaConsultaSecc5.setBackground(new Color(224, 224, 224));
			        taVistaConsultaSecc5.setFont(new Font("Andale Mono", 1, 12));
			        taVistaConsultaSecc5.setForeground(new Color(0, 0, 0));
			        taVistaConsultaSecc5.setText("\n   Aquí encontraras el resultado de la consulta");
			        scpVistaConsultaSecc5 = new JScrollPane(taVistaConsultaSecc5);
			        scpVistaConsultaSecc5.setBounds(20, 445, 540, 150);
			        add(scpVistaConsultaSecc5);
				}
			}
			
			pack();
    		this.setSize(600,700);
			
    	} catch (Exception e) {
    		//add your error handling code here (---------------------------------------------)
			e.printStackTrace();
    	}
    }
    
    public void agregarListener(ActionListener actionListener) {
    	//--------------
    	btnResultado1.addActionListener(actionListener);
    	//--------------
    	btnResultado2.addActionListener(actionListener);
    	//--------------
    	btnConsulta.addActionListener(actionListener);
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
  //--------------Todos los metodos de la SECCION 3--------------
    //-----------------------------------------------------------
    
    public String getDia1() {
    	return tfDia1.getText();
    }
    public String getMes1() {
    	return tfMes1.getText();
    }
    public String getAno1() {
    	return tfAno1.getText();
    }
    public String getDia2() {
    	return tfDia2.getText();
    }
    public String getMes2() {
    	return tfMes2.getText();
    }
    public String getAno2() {
    	return tfAno2.getText();
    }
    public void setTaVistaConsultaSecc4(String cadena) {
    	taVistaConsultaSecc4.setText(cadena);
    }
    
    //-----------------------------------------------------------
  //--------------Todos los metodos de la SECCION 4--------------
    //-----------------------------------------------------------
    
    public String getDia3() {
    	return tfDia3.getText();
    }
    public String getMes3() {
    	return tfMes3.getText();
    }
    public String getAno3() {
    	return tfAno3.getText();
    }
    public String getDia4() {
    	return tfDia4.getText();
    }
    public String getMes4() {
    	return tfMes4.getText();
    }
    public String getAno4() {
    	return tfAno4.getText();
    }
    public void setResultado(String temp) {
    	tfResultado.setText(temp);;
    }
    
    public String getResultado() {
    	return tfResultado.getText();
    }
    
    //-----------------------------------------------------------
  //--------------Todos los metodos de la SECCION 5--------------
    //-----------------------------------------------------------
    
    public void setLblEscrito4(String cadena) {
    	lblEscrito4.setText(cadena);
    }
    
    public void setTaVistaConsultaSecc5(String cadena) {
    	taVistaConsultaSecc5.setText(cadena);
    }
	     
	public void colormenu(int r,int g,int b) { 
	     menuc.setBackground(new Color(r,g,b)); 
	}

}