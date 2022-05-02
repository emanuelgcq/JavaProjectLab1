package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

import vista.*;
import modelo.*;

public class controladorVentana1 implements ActionListener {
	
	private ventana1 ventana1;
	private Gobernacion gobernacion = new Gobernacion();
	private Fundacion fundacion;
	private int contarBtnCargarDatos = 0, contarBtnConsulta = 1;
	
	public controladorVentana1() {
		
		generarAleatorio();

		ventana1 = new ventana1();
		ventana1.setLocationRelativeTo(null);
		ventana1.setResizable(false);
		ventana1.setVisible(true);
		ventana1.setBounds(0,0,600,600);
		ventana1.agregarListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("CARGAR DATOS")) {
			Ingresar_Datos();
		} else {
			if (e.getActionCommand().equalsIgnoreCase("GENERAR")) {
				generar();
			} else {
				if(e.getActionCommand().equalsIgnoreCase("CARGAR CONSULTA")) {
					cargarSolicitud();	
				} 
			}
		}
		if(e.getActionCommand().equalsIgnoreCase("VENTANA 2")) {
			controladorVentana2 control2 = new controladorVentana2(gobernacion,fundacion);
			ventana1.hide();
		}
		if(e.getActionCommand().equalsIgnoreCase("LIMPIAR")) { 
			   ventana1.setTaVistaConsultaSecc2(""); 
			   ventana1.seleccionCbEstatus(); 
			  } 
			  if(e.getActionCommand().equalsIgnoreCase("ROJO")) { 
			   ventana1.getContentPane().setBackground(new Color(255,0,0)); 
			   ventana1.colormenu(255,0,0); 
			  } 
			  if(e.getActionCommand().equalsIgnoreCase("VERDE")) { 
			   ventana1.getContentPane().setBackground(new Color(0,255,0)); 
			   ventana1.colormenu(0,255,0); 
			  } 
			  if(e.getActionCommand().equalsIgnoreCase("AZUL")) { 
			   ventana1.getContentPane().setBackground(new Color(0,0,255)); 
			   ventana1.colormenu(0,0,255); 
			  } 
			  if(e.getActionCommand().equalsIgnoreCase("MORADO")) { 
			   ventana1.getContentPane().setBackground(new Color(121,0,121)); 
			   ventana1.colormenu(121,0,121); 
			  } 
			  if(e.getActionCommand().equalsIgnoreCase("CREADORES")) { 
				   JOptionPane.showMessageDialog(null,"     CREADORES:" 
				     + "\n Gabriel Torrealba" 
				     + "\n Emanuel Chirinos" 
				     + "\n Jezymar Lopez" 
				     + "\n Deibys Chavez"); 
				  }
	}
	
	
	
	//INGRESAR DATOS NUEVOS AL PROGRAMA
	
	
	private void Ingresar_Datos() {
		
		int i=0;
		
		while(i==0) {
			String [] vector = {"Seleccione...",
					"Cargar nuevo empleado.",
					"Cargar nuevo beneficiario.",
					"Cargar nuevo servicio."};
			String temp = (String) JOptionPane.showInputDialog(null, "Por favor selecciona la categoria a cargar datos:", "Ventada de consultas", JOptionPane.PLAIN_MESSAGE, null, vector, vector.toString());
			
			if(temp == "Seleccione...") {
				JOptionPane.showMessageDialog(null,"Por favor selecciona una opcion valida.");
			} else {
					if(temp == "Cargar nuevo empleado.") {
						cargarEmpleado();
						contarBtnCargarDatos = contarBtnConsulta;
						i=1;
					} else {
						if(temp == "Cargar nuevo beneficiario.") {
							cargarBeneficiario();
							contarBtnCargarDatos = contarBtnConsulta;
							i=1;
						} else {
							if(temp == "Cargar nuevo servicio.") {
								cargarServicio();
								contarBtnCargarDatos = contarBtnConsulta;
								i=1;
							}
						}//Cuato eslse
					}//tercer else
				}//segundo else
			}//primer else
	}
	
	
	//--------------Parte de cargarDatos	
	
	
	
	//INGRESAR NUEVO EMPLEADO
	
	
	
	private void cargarEmpleado() {
		BufferedWriter bw = null;
	     FileWriter fw = null;
	     try {
	          
	          File file = new File("C:\\Users\\kloux\\trabajo\\lbrotio\\src\\modelo\\empleados.txt");
	          // Si el archivo no existe, se crea!
	          if (!file.exists()) {
	              file.createNewFile();
	          }
	          fw = new FileWriter(file.getAbsoluteFile(), true);
	          bw = new BufferedWriter(fw);
	          String cadenaes="", nombre5="", cedula5="", apellido5="",telefono5="", direccion5="", fechanac5="", email5="", estatus5="";
	          
	          while(nombre5.isEmpty()==true) {
	            nombre5= JOptionPane.showInputDialog(null, "ingresa el nombre\n" + "Ej: Manuel","");
	            if(nombre5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(cedula5.isEmpty()==true) {
	            cedula5= JOptionPane.showInputDialog(null, "ingresa la cedula\n" + "Ej: 27209996", "");
	            if(nombre5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(apellido5.isEmpty()==true) {
	            apellido5 = JOptionPane.showInputDialog(null, "ingresa el apellido\n" + "Ej: Perez" ,"");
	            if(apellido5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(telefono5.isEmpty()==true) {
	            telefono5 = JOptionPane.showInputDialog(null, "ingresa el telefono\n" + "Ej: 0412691202","");
	            if(telefono5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(direccion5.isEmpty()==true) {
	            direccion5 = JOptionPane.showInputDialog(null, "ingresa la direccion\n" + "Ej: Urb El Obelisco","");
	            if(direccion5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(fechanac5.isEmpty()==true) {
	            fechanac5 = JOptionPane.showInputDialog(null, "ingresa el fechanac\n Dd/MM/YY\n "+ "Ej: 02/05/2000","");
	            if(fechanac5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(email5.isEmpty()==true) {
	            email5 = JOptionPane.showInputDialog(null, "ingresa el email\n" + "Ej manuelperez@gmail.com","");
	            if(email5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	      bw.newLine();
	          bw.write(nombre5+ ","+cedula5+ "," + apellido5 + "," + telefono5 + "," + direccion5 + "," + fechanac5 + "," + email5 + "," + "estatus");
	          ventana1.mostrarMensaje("Se Agrego un Nuveo Empleado");
	      } catch (IOException e1) {
	          e1.printStackTrace();
	      } finally {
	          try {
	                          
	              if (bw != null)
	                  bw.close();
	              if (fw != null)
	                  fw.close();
	          } catch (IOException ex) {
	              ex.printStackTrace();
	          }
	      }
	}
	
	
	//INGRESAR NUEVO BENEFICIARIO
	
	
	private void cargarBeneficiario() {
		BufferedWriter bw = null;
	      FileWriter fw = null;
	      try {
	          File file = new File("C:\\Users\\kloux\\trabajo\\lbrotio\\src\\modelo\\usuarios.txt");
	          // Si el archivo no existe, se crea!
	          if (!file.exists()) {
	              file.createNewFile();
	          }
	          fw = new FileWriter(file.getAbsoluteFile(), true);
	          bw = new BufferedWriter(fw);
	          String cadenaes="", nombre5="", cedula5="", apellido5="",telefono5="", direccion5="", fechanac5="", email5="", estatus5="";
	          while(nombre5.isEmpty()==true) {
	            nombre5= JOptionPane.showInputDialog(null, "ingresa el nombre\n" + "Ej: Manuel","");
	            if(nombre5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(cedula5.isEmpty()==true) {
	            cedula5= JOptionPane.showInputDialog(null, "ingresa la cedula\n" + "Ej: 27209996", "");
	            if(nombre5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(apellido5.isEmpty()==true) {
	            apellido5 = JOptionPane.showInputDialog(null, "ingresa el apellido\n" + "Ej: Perez" ,"");
	            if(apellido5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(telefono5.isEmpty()==true) {
	            telefono5 = JOptionPane.showInputDialog(null, "ingresa el telefono\n" + "Ej: 0412691202","");
	            if(telefono5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(direccion5.isEmpty()==true) {
	            direccion5 = JOptionPane.showInputDialog(null, "ingresa la direccion\n" + "Ej: Urb El Obelisco","");
	            if(direccion5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(fechanac5.isEmpty()==true) {
	            fechanac5 = JOptionPane.showInputDialog(null, "ingresa el fechanac\n Dd/MM/YY\n "+ "Ej: 02/05/2000","");
	            if(fechanac5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(email5.isEmpty()==true) {
	            email5 = JOptionPane.showInputDialog(null, "ingresa el email\n" + "Ej manuelperez@gmail.com","");
	            if(email5.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	      bw.newLine();
	          bw.write(nombre5+ ","+ cedula5+ "," + apellido5 + "," + telefono5 + "," + direccion5 + "," + fechanac5 + "," + email5+ "," + "estatus");
	          ventana1.mostrarMensaje("Se Agrego un Nuveo Beneficiario");
	      } catch (IOException e1) {
	          e1.printStackTrace();
	      } finally {
	          try {
	                          
	              if (bw != null)
	                  bw.close();
	              if (fw != null)
	                  fw.close();
	          } catch (IOException ex) {
	              ex.printStackTrace();
	          }
	      }
	}
	
	
	
	//INGRESAR NUEVO SERVICIOS
	
	
	
	private void cargarServicio() {
		 BufferedWriter bw = null;
	      FileWriter fw = null;
	try {
	          
	          File file = new File("C:\\Users\\kloux\\trabajo\\lbrotio\\src\\modelo\\servicios.txt");
	          // Si el archivo no existe, se crea!
	          if (!file.exists()) {
	              file.createNewFile();
	          }
	          fw = new FileWriter(file.getAbsoluteFile(), true);
	          bw = new BufferedWriter(fw);
	          String codigo_serv2="", nombre_serv2="", costo_serv2="", tipo_serv2="";
	          
	          while(codigo_serv2.isEmpty()==true) {
	             codigo_serv2= JOptionPane.showInputDialog(null, "ingresa el codigo del servicio\n" + "Ej: 0662" ,"");
	            if(codigo_serv2.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(nombre_serv2.isEmpty()==true) {
	            nombre_serv2 = JOptionPane.showInputDialog(null, "ingresa el nombre del servicio\n" + "Ej: Examen Radiologia" ,"");
	            if(nombre_serv2.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(costo_serv2.isEmpty()==true) {
	            costo_serv2= JOptionPane.showInputDialog(null, "ingresa el costo del servicio\n" + "Ej: 2000" ,"");
	            if(costo_serv2.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	          while(tipo_serv2.isEmpty()==true) {
	             tipo_serv2 = JOptionPane.showInputDialog(null, "ingresa el tipo de servicio\n" + "Ej: 1" ,"");
	            if(tipo_serv2.isEmpty()) {
	              JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
	            }
	          }
	      bw.newLine();
	          bw.write(codigo_serv2+ "," + nombre_serv2 + "," + costo_serv2 + "," + tipo_serv2);
	          ventana1.mostrarMensaje("Se Agrego un Nuveo Servicio");
	      } catch (IOException e1) {
	          e1.printStackTrace();
	      } finally {
	          try {
	                          
	              if (bw != null)
	                  bw.close();
	              if (fw != null)
	                  fw.close();
	          } catch (IOException ex) {
	              ex.printStackTrace();
	          }
	      }
	}
	
	
	
	
	//METODO VALIDA BOTON GENERAR CON NUEVOS DATOS INGRESADOS

	
	
	private void generar() {
		if(contarBtnCargarDatos == contarBtnConsulta) {
			try {
				generarAleatorio();
				contarBtnConsulta++;
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
			JOptionPane.showMessageDialog(null,"Operacion realizada exitosamente!");
		} else {
			JOptionPane.showMessageDialog(null,"La operacion no se pudo ejecutar:"
											 + "\n\n ADVERTENCIA: Desbes cargar datos antes de generar.");
		}
	}
	
	

	
	//LECTURA Y GENERAR ALEATORIO
	
	
	
	private void generarAleatorio() {
		// leer beneficiario
		
		File archivo;
		FileReader leer;
		BufferedReader almacenamiento;
		String cadena="", nombre, cedula, apellido,telefono, direccion, fechanac, email, estatus;
		archivo = new File("C:\\Users\\kloux\\trabajo\\lbrotio\\src\\modelo\\usuarios.txt");
		//Gobernacion gobernacion = new Gobernacion();

		try {
			leer = new FileReader(archivo);
			almacenamiento= new BufferedReader(leer);
		
			
				while(cadena!=null ) {
	

				cadena=almacenamiento.readLine();													
				String variables[]= cadena.split(",");	

				nombre=variables[0];
				cedula=variables[1];
				apellido=variables[2];
				telefono=variables[3];
				direccion=variables[4];
				fechanac=variables[5];
				email=variables[6];
				estatus=variables[7];
				
				Beneficiario beneficiario = new Beneficiario(cedula, nombre, apellido,telefono, direccion, fechanac, email, estatus);
				gobernacion.AggBeneficiario(beneficiario);	
				}
			}
		
			catch(Exception e){
				System.err.println(e.getMessage());	
			}
		
		// Fin del leer beneficiario
		
		
		
		// leer Fundacion
		
		File archivo4;
		FileReader leer4;
		BufferedReader almacenamiento4;
		String cadena4 ="",nombrefund="";
		double partida=0;
		//Fundacion fundacion = new Fundacion(nombrefund,partida);
		archivo4=new File ("C:\\Users\\kloux\\trabajo\\lbrotio\\src\\modelo\\fundaciones.txt");
			
		try {
			leer4 = new FileReader(archivo4);
			almacenamiento4= new BufferedReader(leer4);
				
			while(cadena4!=null ) {
			
				cadena4=almacenamiento4.readLine();													
				String variables[]= cadena4.split(",");	

				nombrefund=variables[0];
				partida=Double.parseDouble(variables[1]);
						
				fundacion = new Fundacion(nombrefund,partida);
				gobernacion.AggFundacion(fundacion);
				}
			}
			catch(Exception e){
					System.err.println(e.getMessage());
			}
		
		// Fin del leer Fundacion
		
		
		
		// leer Empleado
		
		File archivo8;
		FileReader leer8;
		BufferedReader almacenamiento8;
		String cadena8="", nombre8, cedula8, apellido8,telefono8, direccion8, fechanac8, email8, estatus8;
		archivo8= new File("C:\\Users\\kloux\\trabajo\\lbrotio\\src\\modelo\\empleados.txt");

		try {
			leer8 = new FileReader(archivo8);
			almacenamiento8= new BufferedReader(leer8);	
			
				while(cadena8!=null ) {

				cadena8=almacenamiento8.readLine();													
				String variables[]= cadena8.split(",");	

				nombre8=variables[0];
				cedula8=variables[1];
				apellido8=variables[2];
				telefono8=variables[3];
				direccion8=variables[4];
				fechanac8=variables[5];
				email8=variables[6];
				estatus8=variables[7];
				
				Empleado empleado = new Empleado(cedula8, nombre8, apellido8,telefono8, direccion8, fechanac8, email8, estatus8);
				fundacion.AggEmpleado(empleado);
				}
			}
		
			catch(Exception e){
				System.err.println(e.getMessage());	
			}
	
		// Fin del leer Empleado
		
		
		
		// leer Servicios
		
		File archivo3;
		FileReader leer3;
		BufferedReader almacenamiento3;
		archivo3= new File ("C:\\Users\\kloux\\trabajo\\lbrotio\\src\\modelo\\servicios.txt");
		
			//Servicios
		
			String codigo_serv="", nombre_serv="", pasador="";
			int tipo_serv=0;
			double costo_serv=0;
		
			//solicitudes
		
			String Nombre_soli="", ced_beneficiario="", ced_empledo="", cadena3="", estatus_solic="",tipo_prioridad="";
			Date fecha_emision=null;
			int numero_soli=0;
			double presupuesto=0;

		Solicitudes solicitud = new Solicitudes(Nombre_soli,ced_beneficiario, ced_empledo,tipo_prioridad, numero_soli,presupuesto,
				estatus_solic,fecha_emision);
		try {
			leer3 = new FileReader(archivo3);
			almacenamiento3= new BufferedReader(leer3);
		
			while(cadena3!=null ) {
	
				cadena3=almacenamiento3.readLine();													
				String variables[]= cadena3.split(",");	

				codigo_serv=variables[0];
				nombre_serv=variables[1];	
				tipo_serv=Integer.parseInt(variables[2]);
				costo_serv=Double.parseDouble(variables[3]);
				
				Servicios servicios = new Servicios(codigo_serv,nombre_serv, tipo_serv,costo_serv);
				solicitud.AggServicios(servicios);
			}
		}
			catch(Exception e){
				System.err.println(e.getMessage());
			}
		
		// Fin del leer Servicios
		
		
		
		//Generar Charlas aleatoriamente
        try {
          int numeroCharlas=0;
          for (int i=0;i<5;i++) {
              
        	  String veclugar[] = {"Aula 331", "Aula 442", "Aula 122","Aula 003", "Aula 224", "Aula 554", "Aula 444" };
              String vecorganismo[]= {"Gobernacion", "Acaldia", "Contraloria", "Intt", "ProcuradurÃ­a General de la RepÃºblica", "Defensoria del pueblo", "Sundde", "Conatel", "Hidrolara" }; 
              String vectema[]= {"Ser un buen ciudadano", "Cuidar el medioambiente", "Psicologia del buen jefe comunitario", "La importancia del liberalismo", "Vida y Obra de Simon Bolivar", "Aprender a emprender"};              
              
              int indiceNomtema=(int)Math.floor(Math.random()*veclugar.length);
              int indiceSitio=(int)Math.floor(Math.random()*vecorganismo.length);
              int indiceOrganismo=(int)Math.floor(Math.random()*vectema.length);
              
              String Nomtema=vectema[indiceOrganismo];
              String sitio = veclugar[indiceNomtema];
              String organismo =vecorganismo[indiceSitio];
              Date fecha = gobernacion.getRandomDate();
              
              
             //Nro de cedu seleccionada
              int nro=gobernacion.Seleccion_aleatorea_Benefic();
              ArrayList<String> CedBenefic_asist =new ArrayList<String>();
              
              for (int a=0;a<nro;a++) {
            	  CedBenefic_asist.add(gobernacion.sacarBeneficiario(a).getCedula());
              }
              	DateFormat Formato = new SimpleDateFormat("HH:mm:ss");
        		numeroCharlas++;
        		
        		Charlas charla = new Charlas(numeroCharlas, Nomtema, sitio, organismo, fecha, Formato.format(fecha),CedBenefic_asist);
        		gobernacion.AggCharlas(charla);
              }
        }
          catch(Exception e){
            System.err.println(e.getMessage());
          }
        
        // Fin del Generar Charlas aleatoriamente
		
		
		
		//Generar aleatoriamente las solicitudes
        
        try {
        	
          int numerosolicitud=0;
          for (int i=0;i<gobernacion.ContarBeneficiario();i++) {
        	  
              //seleccion aleatoria beneficiario
              Beneficiario beneficiariosolicitud;
              int indicebenef=gobernacion.Seleccion_aleatorea_Benefic();
              beneficiariosolicitud=gobernacion.sacarBeneficiario(indicebenef);
              
              //seleccion aleatoria Fundacion
              Fundacion fundacionsolicitud;
              int indicefund=gobernacion.Seleccion_aleatorea_Fundacion();
              fundacionsolicitud=gobernacion.sacarFundacion(indicefund);
               
             //seleccion aleatoria empleado
               Empleado empleadosolicitud;
               int indiceemp=fundacion.Seleccion_aleatorea_Empleado();
               empleadosolicitud=fundacion.sacarEmpleado(indiceemp);
               
              //seleccion aleatoria servicio  
              Servicios serviciosolicitud;
              int indiceservicio=solicitud.Seleccion_aleatorea_Servicios();
              serviciosolicitud=solicitud.sacarServicios(indiceservicio);
              
              String vecprioridad[] = {"Baja", "Media", "Alta"};
              String vecestatus[]= {"Aprobada","Rechazado"};
              int indicePrio=(int)Math.floor(Math.random()*3);
              int indiceEst=(int)Math.floor(Math.random()*2);
              Date fecha = fundacion.getRandomDate();
              
              if (gobernacion.Validar_Ced_3Charla(beneficiariosolicitud.getCedula())==1) {
                  if(gobernacion.validar_beneficiario_6meses (fundacion, beneficiariosolicitud.getCedula(),fecha)==1 
                		  || gobernacion.PresupuestoDispFundacion_porcentaje(fundacion)[indicefund]>25 && gobernacion.Validar_fecha(fecha)==1) {
                	  
                	  String nomfun= fundacionsolicitud.getNombre();
                      String cedemp= empleadosolicitud.getCedula();
                      String cedben= beneficiariosolicitud.getCedula();
                      String codserv= serviciosolicitud.getCodigo();
                      String servnom=serviciosolicitud.getNombre();
                      double servcost=serviciosolicitud.getCosto();
                      int tipserv=serviciosolicitud.getTipo();
                      numerosolicitud++;
                      String estatussol= vecestatus[indiceEst];
                      String prioridad = vecprioridad[indicePrio];
                      
                     
                      Solicitudes solicitudes= new Solicitudes(nomfun, cedben, cedemp, prioridad, numerosolicitud, servcost, 
                          estatussol,fecha);
                      
                      fundacion.AggSolicitud(solicitudes);
                	  
                  }
                  else {
                	  String nomfun= fundacionsolicitud.getNombre();
                	  String cedemp= empleadosolicitud.getCedula();
                	  String cedben= beneficiariosolicitud.getCedula();
                	  String codserv= serviciosolicitud.getCodigo();
                	  String servnom=serviciosolicitud.getNombre();
                	  double servcost=serviciosolicitud.getCosto();
                	  int tipserv=serviciosolicitud.getTipo();
                	  numerosolicitud++;
                	  String estatussol= vecestatus[2];
                	  String prioridad = vecprioridad[indicePrio];
                
               
                	  Solicitudes solicitudes= new Solicitudes(nomfun, cedben, cedemp, prioridad, numerosolicitud, servcost, 
                			  estatussol,fecha);
                
                	  fundacion.AggSolicitud(solicitudes);
                  }
                
              }
          	}    
        }
        catch(Exception e){
			System.err.println(e.getMessage());
		}
        
        // Fin del Generar aleatoriamente las solicitudes
	}
	
	
	
	//IMPRIMIR SOLICITUDES POR ESTATUS
	
	
	
	private void cargarSolicitud() {
		if(ventana1.getOpcionSeleccionada() == "Seleccione") {
			JOptionPane.showMessageDialog(null,"Debes seleccionar una opcion valida.");
		} else {
			if(ventana1.getOpcionSeleccionada() == "Aprobada") {
				//ventana1.setListado(fundacion.Buscar_Solicitudes_Aprod());
				String cadena = "SOLICITUDES Aprobadas \n\n";
		        for (int c=0;c<fundacion.Buscar_Solicitudes_Aprod().size();c++) {
		        	
		        	cadena = cadena.concat("Numero Solicitud: " + fundacion.Buscar_Solicitudes_Aprod().get(c).getNro_solicitud() + ","
		                + " \n Cedula del beneficiario: " + fundacion.Buscar_Solicitudes_Aprod().get(c).get_CedBeneficiario()  + ","
		                + " \n Cedula del empleado: " + fundacion.Buscar_Solicitudes_Aprod().get(c).get_CedEmpleado()  + ","
		                + " \n Fundacion: " + fundacion.Buscar_Solicitudes_Aprod().get(c).getFundacion()+ ","
		                + " \n Presupuesto: " + fundacion.Buscar_Solicitudes_Aprod().get(c).getPresupuesto() + ","
		                + " \n Prioridad: " + fundacion.Buscar_Solicitudes_Aprod().get(c).getPrioridad() + ","
		                + " \n Fecha: " + fundacion.Buscar_Solicitudes_Aprod().get(c).getFecha_emision() + ","
		                + " \n Estatus: " + fundacion.Buscar_Solicitudes_Aprod().get(c).getEstatus() + "\n\n");
		        	
		          }
		        ventana1.setTaVistaConsultaSecc2(cadena);
			} else{
				if(ventana1.getOpcionSeleccionada() == "Rechazado") {
					//ventana1.setListado(fundacion.Buscar_Solicitudes_Rechazado());
					String cadena = "SOLICITUDES RECHAZADAS \n\n";
			        
			        for (int c=0;c<fundacion.Buscar_Solicitudes_Rechazado().size();c++) {
			        	
			        	cadena = cadena.concat("Numero Solicitud: " + fundacion.Buscar_Solicitudes_Rechazado().get(c).getNro_solicitud() + ","
			                + " \n Cedula del beneficiario: " + fundacion.Buscar_Solicitudes_Rechazado().get(c).get_CedBeneficiario()  + ","
			                + " \n Cedula del empleado: " + fundacion.Buscar_Solicitudes_Rechazado().get(c).get_CedEmpleado()  + ","
			                + " \n Fundacion: " + fundacion.Buscar_Solicitudes_Rechazado().get(c).getFundacion()+ ","
			                + " \n Presupuesto: " + fundacion.Buscar_Solicitudes_Rechazado().get(c).getPresupuesto() + ","
			                + " \n Prioridad: " + fundacion.Buscar_Solicitudes_Rechazado().get(c).getPrioridad() + ","
			                + " \n Fecha: " + fundacion.Buscar_Solicitudes_Rechazado().get(c).getFecha_emision() + ","
			                + " \n Estatus: " + fundacion.Buscar_Solicitudes_Rechazado().get(c).getEstatus()+ "\n\n");
			          }
			        ventana1.setTaVistaConsultaSecc2(cadena);
				}
			}//Segundo else
		} //primer else
	}
}
