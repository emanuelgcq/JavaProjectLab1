package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;

import vista.ventana1;
import vista.ventana2;
import modelo.Beneficiario;
import modelo.Charlas;
import modelo.Empleado;
import modelo.Fundacion;
import modelo.Gobernacion;
import modelo.Servicios;
import modelo.Solicitudes;


public class controladorVentana2 implements ActionListener {
	
	private ventana2 ventana2;
	controladorVentana1 controladorVentana1;
	private Gobernacion gobernacion;
	private Fundacion fundacion;
	private Empleado empleado;
	private Beneficiario beneficiario;
	private Servicios servicios;
	private Solicitudes solicitud;
	
	private int val = 1;
	
	public controladorVentana2(Gobernacion gobernacion,Fundacion fundacion) {
		ventana2 = new ventana2();
		ventana2.setLocationRelativeTo(null);
		ventana2.setResizable(false);
		ventana2.setVisible(true);
		ventana2.setBounds(0,0,600,700);
		ventana2.agregarListener(this);
		this.gobernacion=gobernacion;
		this.fundacion=fundacion;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("CALCULAR COSTO")) {
			calcularCosto();
		} else {
			if(e.getActionCommand().equalsIgnoreCase("CALCULAR PRESUPUESTO")) {
				calcularPresupuesto();
				
			} else {
				if(e.getActionCommand().equalsIgnoreCase("CONSULTAR")) {
					consultar();
				} else {
					if(e.getActionCommand().equalsIgnoreCase("VENTANA 1")) {
						controladorVentana1 control2 = new controladorVentana1();
						ventana2.hide();
					}
				}
			}//else segundo
		}//else primer
		if(e.getActionCommand().equalsIgnoreCase("LIMPIAR")) { 
			   ventana2.setTaVistaConsultaSecc4("");
			   ventana2.setTaVistaConsultaSecc5(""); 
			  }
		if(e.getActionCommand().equalsIgnoreCase("ROJO")) { 
			   ventana2.getContentPane().setBackground(new Color(255,0,0)); 
			   ventana2.colormenu(255,0,0); 
			  } 
			  if(e.getActionCommand().equalsIgnoreCase("VERDE")) { 
			   ventana2.getContentPane().setBackground(new Color(0,255,0)); 
			   ventana2.colormenu(0,255,0); 
			  } 
			  if(e.getActionCommand().equalsIgnoreCase("AZUL")) { 
			   ventana2.getContentPane().setBackground(new Color(0,0,255)); 
			   ventana2.colormenu(0,0,255); 
			  } 
			  if(e.getActionCommand().equalsIgnoreCase("MORADO")) { 
			   ventana2.getContentPane().setBackground(new Color(121,0,121)); 
			   ventana2.colormenu(121,0,121); 
			  } 
			  if(e.getActionCommand().equalsIgnoreCase("CREADORES")) { 
				   JOptionPane.showMessageDialog(null,"     CREADORES:" 
				     + "\n Gabriel Torrealba" 
				     + "\n Emanuel Chirinos" 
				     + "\n Jezymar Lopez" 
				     + "\n Deibys Chavez"); 
				  }
	}
	
	//-----------------------------------------------------------------------------------------------calcularCosto
	private void calcularCosto(){
		if(ventana2.getDia1() == "" && ventana2.getMes1() == "" && ventana2.getAno1() == "" || ventana2.getDia2() == "" && ventana2.getMes2() == "" && ventana2.getAno2() == "" ) {
			JOptionPane.showMessageDialog(null,"Por favor no dejes en blanco el/los campo(s) de texto vacio(s).");
		} else {
			ventana2.setTaVistaConsultaSecc4(calcularSecc3(ventana2.getDia1(),ventana2.getMes1(), ventana2.getAno1(), ventana2.getDia2(),ventana2.getMes2(),ventana2.getAno2()));
		}
	}
	
	//--------------Parte de calcularCosto
	private String calcularSecc3(String dia1, String mes1, String ano1,String dia2, String mes2, String ano2){
				
        Date fecha1 = new Date(Integer.parseInt(ano1)-1900,Integer.parseInt(mes1)-1,Integer.parseInt(dia1));
        Date fecha2 = new Date(Integer.parseInt(ano2)-1900,Integer.parseInt(mes2)-1,Integer.parseInt(dia2)); 
        
		String cadena;
		cadena = "Total del Presupuesto de las Solicitudes Aprobadas por fundaciones\n";   
        for(int i=0;i<gobernacion.Total_Presupuesto(fundacion, fecha1, fecha2).length;i++) {
        	cadena = cadena.concat(i+1+"-"+gobernacion.sacarFundacion_Nombre(i)+": "+ gobernacion.Total_Presupuesto(fundacion, fecha1, fecha2)[i]+"\n");
        }
        return cadena;
	}

	
	//-----------------------------------------------------------------------------------------------calcularPresupuesto
	private void calcularPresupuesto(){
		if(ventana2.getDia3() == "" && ventana2.getMes3() == "" && ventana2.getAno3() == "" || ventana2.getDia4() == "" && ventana2.getMes4() == "" && ventana2.getAno4() == "" ) {
			JOptionPane.showMessageDialog(null,"Por favor no dejes en blanco el/los campo(s) de texto vacio(s).");
		} else {
			ventana2.setResultado(calcularSecc4(ventana2.getDia3(),ventana2.getMes3(), ventana2.getAno3(), ventana2.getDia4(),ventana2.getMes4(),ventana2.getAno4()));
		}
	}
	
	//--------------Parte de calcularPresupuesto
	private String calcularSecc4(String dia3, String mes3, String ano3,String dia4, String mes4, String ano4){
		
		 Date fecha1 = new Date(Integer.parseInt(ano3)-1900,Integer.parseInt(mes3)-1,Integer.parseInt(dia3));
	     Date fecha2 = new Date(Integer.parseInt(ano4)-1900,Integer.parseInt(mes4)-1,Integer.parseInt(dia4)); 
	        
			String cadena;
		
		cadena = String.valueOf(fundacion.Total_Presupuesto(fecha1,fecha2));
        
        return cadena;
	}
	
	
	//------------------------------------------------------------------------------------------------consultar
	private void consultar() { 
		  String [] vector = {"Seleccione...", 
		    "Detalles de solicitantes por fundacion.", 
		    "Listado de presupuesto por estatus.", 
		    "Listado de asistencia de participantes por charla realizada.", 
		    "Detalles de presupuesto disponible por fundacion y porcentaje gastado.", 
		    "Listado de las diferentes solicitudes asignadas a un determinado responsable."}; 
		  String temp = (String) JOptionPane.showInputDialog(null, "Por favor selecciona la consulta a realizar:", "Ventada de consultas", JOptionPane.PLAIN_MESSAGE, null, vector, vector.toString()); 
		   
		  if(temp == "Detalles de solicitantes por fundacion.") { 
		   ventana2.setTaVistaConsultaSecc5(detSolFun()); 
		  } else { 
		   if(temp == "Listado de presupuesto por estatus.") { 
			   ventana2.setTaVistaConsultaSecc5(listPreEst());    
		   } else { 
		    if(temp == "Listado de asistencia de participantes por charla realizada.") { 
		     ventana2.setTaVistaConsultaSecc5(Asistencias_Charlas());
		    } else { 
		     if(temp == "Detalles de presupuesto disponible por fundacion y porcentaje gastado.") { 
		      ventana2.setTaVistaConsultaSecc5(detPresDispFund());
		     } else { 
		      if(temp == "Listado de las diferentes solicitudes asignadas a un determinado responsable.") { 
		       ventana2.setTaVistaConsultaSecc5(listDifSolAsigResp(JOptionPane.showInputDialog(null, "Ingresa la cedula del responsable" + "Ej 24814555",""))); 
		      } else { 
		       if(temp == "Seleccione...") { 
		        JOptionPane.showMessageDialog(null,"Por favor selecciona una opcion valida!"); 
		        ventana2.setTaVistaConsultaSecc5("easter egg"); 
		       } 
		      }//Quinto else 
		     }//Cuarto else 
		    }//Tercer else 
		   }//Segundo else 
		  }//Primer else 
		 }

	//--------------Parte de consultar
	private String detSolFun() {
        String cadena = "Destalles de Solicitantes por Fundacion\n\n";
        for (int i=0;i<gobernacion.ContarFundacion();i++) {
        	cadena = cadena.concat(gobernacion.sacarFundacion_Nombre(i)+"\n");
        		for(int a=0;a<gobernacion.Cedulas_BeneficiariosxFun(fundacion, gobernacion.sacarFundacion_Nombre(i)).size();a++) {
        			cadena = cadena.concat(a+1+"-"+ gobernacion.Cedulas_BeneficiariosxFun(fundacion,gobernacion.sacarFundacion_Nombre(i)).get(a).getCedula()+ "   "+
        					gobernacion.Cedulas_BeneficiariosxFun(fundacion,gobernacion.sacarFundacion_Nombre(i)).get(a).getNombre()+ "   "+
        					gobernacion.Cedulas_BeneficiariosxFun(fundacion,gobernacion.sacarFundacion_Nombre(i)).get(a).getApellido()+ "   "+
        					gobernacion.Cedulas_BeneficiariosxFun(fundacion,gobernacion.sacarFundacion_Nombre(i)).get(a).getFechanac()+ "   "+
        					gobernacion.Cedulas_BeneficiariosxFun(fundacion,gobernacion.sacarFundacion_Nombre(i)).get(a).getDireccion()+ "   "+
        					gobernacion.Cedulas_BeneficiariosxFun(fundacion,gobernacion.sacarFundacion_Nombre(i)).get(a).getTelefono()+ "   "+
        					gobernacion.Cedulas_BeneficiariosxFun(fundacion,gobernacion.sacarFundacion_Nombre(i)).get(a).getemail()
        					+"\n\n");
    	}
    }
          return cadena;
	}
	
	private String listPreEst() {
		
		String cadena = "Presupuestos de Solicitudes por estatus Activo \n\n";
         for (int i=0;i<fundacion.Buscar_Solicitudes_Aprod().size();i++) {   
        	 cadena = cadena.concat("Numero de Solicitud: " + fundacion.Buscar_Solicitudes_Aprod().get(i).getNro_solicitud() + " Presupuesto: " + fundacion.Buscar_Solicitudes_Aprod().get(i).getPresupuesto() + "\n"); 
         }
         
         cadena = cadena.concat("\nPresupuesto Total Activo \n");
         cadena = cadena.concat(fundacion.PresupuestoATotal() + "\n\n"); 
         
         cadena = cadena.concat("Presupuestos de Solicitudes por estatus Rechazado \n\n");
         for (int i=0;i<fundacion.Buscar_Solicitudes_Rechazado().size();i++) {
        	 cadena = cadena.concat("Numero de Solicitud: " + fundacion.Buscar_Solicitudes_Rechazado().get(i).getNro_solicitud() + " Presupuesto: " + fundacion.Buscar_Solicitudes_Rechazado().get(i).getPresupuesto() + "\n");
         }
         cadena = cadena.concat("\nPresupuesto Total Rechazado\n");
         cadena = cadena.concat(String.valueOf(fundacion.PresupuestoRTotal()));
        
        return cadena;
	}
	
	private String detPresDispFund() {
		
		String cadena = "Presupuesto Disponible en las Fundaciones\n  ";
		cadena = cadena.concat("\n Presupuesto Disponible en las Fundaciones\n");
        for (int i=0;i<gobernacion.PresupuestoDispFundacion(fundacion).length;i++) {
        	cadena = cadena.concat("Presupuesto disponible en la fundacion: " + gobernacion.sacarFundacion(i).getNombre() + ":  " + gobernacion.PresupuestoDispFundacion(fundacion)[i] + "     Porcentaje gastado:  " + (gobernacion.Total_PresupuestoFund(fundacion)[i] * 100) / gobernacion.sacarFundacion(i).getpartida() + "%" + "        Total gastado: " + gobernacion.Total_PresupuestoFund(fundacion)[i] + "\n");
        }
        
        return cadena;
	}
	
	private String Asistencias_Charlas() {	
		String cadena = "\nAsistencia de Participantes por Charla";
         for(int c=0; c<gobernacion.ContarCharlas();c++) {
        	 cadena = cadena.concat("\n"+gobernacion.sacarCharlas(c).getTema()+"\n");
      	   for(int i=0; i<gobernacion.sacarCharlas(c).ContarCedBenefic();i++) {
      		 cadena = cadena.concat(i+1+"--"+gobernacion.sacarCharlas(c).sacarCedBenefi(i));
             }
         }
         return cadena;
	}
	
	private String listDifSolAsigResp(String ced) {
		
		String cadena = "\n Solicitudes Asignadas a un Determinado Responsable\n";
		
    	for (int i=0;i<fundacion.Buscar_Solicitudes_Emp(ced).size();i++) {
        
    		cadena = cadena.concat(i+1+"--"+"Numero solicitud: " + fundacion.Buscar_Solicitudes_Emp(ced).get(i).getNro_solicitud() + 
    				"Cedula de benificario: " + "  " + fundacion.Buscar_Solicitudes_Emp(ced).get(i).get_CedBeneficiario() + 
    				"Cedula de Empleado: " + ced + "  " +
    				"Estatus: " + fundacion.Buscar_Solicitudes_Emp(ced).get(i).getEstatus() + "  " + 
    				"Presupuesto: " + fundacion.Buscar_Solicitudes_Emp(ced).get(i).getPresupuesto() + "  " + 
    				"Prioridad: " + fundacion.Buscar_Solicitudes_Emp(ced).get(i).getPrioridad() + "  " +
    				"Fecha de emision: " + fundacion.Buscar_Solicitudes_Emp(ced).get(i).getFecha_emision()
    				+"\n\n");
    	}
    	return cadena;
	}
	
	
	//--------------Validar
	
	private Date validadFecha(String fecha) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
		try {
			cal.setTime(sdf.parse(fecha));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// all done
		
		Date fecha1= cal.getTime();
		
		return fecha1;
	}
}
