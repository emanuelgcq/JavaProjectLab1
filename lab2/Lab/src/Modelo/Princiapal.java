package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.*;
import java.io.*;
import java.time.LocalDateTime;

public class Princiapal {
	
	public static void main(String[] args) {
		
		// leer beneficiario
		File archivo;
		FileReader leer;
		BufferedReader almacenamiento;
		String cadena="", nombre, cedula, apellido,telefono, direccion, fechanac, email, estatus;
		archivo= new File("C:\\Users\\Usuario\\Downloads\\JavaProjectLab1-main\\src\\Modelo\\usuarios.txt");
		Gobernacion gobernacion = new Gobernacion();

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
				
				Beneficiario beneficiario = new Beneficiario(nombre, cedula, apellido,telefono, direccion, fechanac, email, estatus);
				gobernacion.AggBeneficiario(beneficiario);	
				}
			}
		
			catch(Exception e){
				System.err.println(e.getMessage());	
			}
		
		// leer empleado
		File archivo2;
		FileReader leer2;
		BufferedReader almacenamiento2;
		archivo2= new File ("C:\\Users\\Usuario\\Downloads\\JavaProjectLab1-main\\src\\Modelo\\empleados.txt");
		String nombrefund="",cadena2="";;
		double partida=0;
		Fundacion fundacion = new Fundacion(nombrefund,partida);
		try {
			leer2 = new FileReader(archivo2);
			almacenamiento2= new BufferedReader(leer2);
		
			
			while(cadena2!=null ) {
	

				cadena2=almacenamiento2.readLine();													
				String variables[]= cadena2.split(",");	

				nombre=variables[0];
				cedula=variables[1];
				apellido=variables[2];
				telefono=variables[3];
				direccion=variables[4];
				fechanac=variables[5];
				email=variables[6];
				estatus=variables[7];
				
				Empleado empleado = new Empleado(nombre, cedula, apellido,telefono, direccion, fechanac, email, estatus);
				fundacion.AggEmpleado(empleado);
			}
		}		
			catch(Exception e){
				System.err.println(e.getMessage());
			}
		System.out.println(fundacion.ContarEmpleado());
		
		
		// leer Servicios
		File archivo3;
		FileReader leer3;
		BufferedReader almacenamiento3;
		archivo3= new File ("C:\\Users\\Usuario\\Downloads\\JavaProjectLab1-main\\src\\Modelo\\servicios.txt");
		
		//Servicios
		String codigo_serv="", nombre_serv="", pasador="";
		int tipo_serv=0;
		double costo_serv=0;
		
		//solicitudes
		String Nombre_soli="", ced_beneficiario="", ced_empledo="", cadena3="", estatus_solic="",tipo_prioridad="";
		int numero_soli=0;
		double presupuesto=0;
		LocalDateTime fecha_emision=null;
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
		System.out.println(solicitud.ContarServicios());
		
		// leer Fundacion
		File archivo4;
		FileReader leer4;
		BufferedReader almacenamiento4;
		String cadena4 ="";
		archivo4=new File ("C:\\Users\\Usuario\\Downloads\\JavaProjectLab1-main\\src\\Modelo\\fundaciones.txt");
		
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
		System.out.println(gobernacion.ContarFundacion());
		
		
		//Generar solicitud aleatoria
		
		  
		  try {
				
				while(gobernacion.ContarBeneficiario()>0 ) {
					
					//seleccion aleatoria Fundacion
					 Fundacion fundacionsolicitud;
					 int indicefund=gobernacion.Seleccion_aleatorea_Fundacion();
					 fundacionsolicitud=gobernacion.sacarFundacion(indicefund);
					
					//seleccion aleatoria beneficiario
					  Beneficiario beneficiariosolicitud;
					  int indicebenef=gobernacion.Seleccion_aleatorea_Benefic();
					  beneficiariosolicitud=gobernacion.sacarBeneficiario(indicebenef);
					  
					//seleccion aleatoria empleado
					  Empleado empleadosolicitud;
					  int indiceemp=fundacion.Seleccion_aleatorea_Empleado();
					  empleadosolicitud=fundacion.sacarEmpleado(indiceemp);
					  
					//seleccion aleatoria servicio  
					  Servicios serviciosolicitud;
					  int indiceservicio=solicitud.Seleccion_aleatorea_Servicios();
					  serviciosolicitud=solicitud.sacarServicios(indiceservicio);
					  
					  int numerosolicitud=1;
					  String vecprioridad[] = {"Baja", "Media", "Alta"};
					  

						  String nomfun= fundacionsolicitud.getNombre();
						  String cedemp= empleadosolicitud.getCedula();
						  String cedben= beneficiariosolicitud.getCedula();
						  String codserv= serviciosolicitud.getCodigo();
						  String servnom=serviciosolicitud.getNombre();
						  double servcost=serviciosolicitud.getCosto();
						  int tipserv=serviciosolicitud.getTipo();
						  numerosolicitud++;
						  String estatussol= "A";
						  int indicePrio=(int)Math.floor(Math.random()*3);
						  String prioridad = vecprioridad[indicePrio];
						  LocalDateTime fecha= LocalDateTime.now();
						 
						  Solicitudes solicitudes= new Solicitudes(nomfun, cedben, cedemp, prioridad, numerosolicitud, presupuesto, 
									estatussol, fecha);
						  
						  fundacion.AggSolicitud(solicitudes);
						  
						  
						  
					  }
				
			}
				catch(Exception e){
					System.err.println(e.getMessage());
				}
	}	 
}