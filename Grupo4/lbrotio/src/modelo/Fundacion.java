package modelo;

import modelo.Empleado;
import modelo.Solicitudes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.math.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class Fundacion {
	
	private ArrayList<Empleado> Vector_empleado;
	private ArrayList<Solicitudes> Vector_solicitudes;
	private String nombre;
	private double partida;
	
	public Fundacion(String nombre, double partida){
		 this.Vector_empleado= new ArrayList<Empleado>();
		 this.Vector_solicitudes= new ArrayList<Solicitudes>();
		 this.nombre = nombre;
		 this.partida = partida;
	}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public void setpartida(double partida){
			this.partida= partida;
		}
		public double getpartida() {
			return partida;
		}
		public String getNombre() {
	        return nombre;
		}
		
		 public void AggSolicitud(Solicitudes sol) {			//agregar una nueva Solicitud
			 this.Vector_solicitudes.add(sol);
		 }
		 public int ContarSolicitud() {			//Contar las Solicitudes
			return  this.Vector_solicitudes.size();
		 }
		 
		 public Solicitudes sacarSolicitudes (int indice) {
			 if (this.ContarSolicitud() > indice) {
				 Solicitudes soli = (Solicitudes)this.Vector_solicitudes.get(indice);
				 return soli;
			 }
			 else 
				 return null;
		 }


		 // Empleado
		 public int ContarEmpleado() {			//contar Empleado
			 return this.Vector_empleado.size();
		 };
		 
		 public void AggEmpleado(Empleado emp) {			//agregar un nuevo Empleado
			 this.Vector_empleado.add(emp);
		 }
		 
		 // sacar empleado
		 public Empleado sacarEmpleado (int indice) {
			 if (this.ContarEmpleado() > indice) {
				 Empleado empleado = (Empleado)this.Vector_empleado.get(indice);
				 return empleado;
			 }
			 else 
				 return null;
		 }
		 
		//sacar Empleado por cedula
		 public int sacarEmpleado_ced (String ced) {
		 	 int i=0;
		 	 boolean encontro=false;
		 	 while(encontro!=true){
		 		 if (ced==Vector_empleado.get(i).getCedula()) {
		 			 encontro=true;	
		 		 }
		 		 else {
		 			 encontro=false;
		 			 i++;
		 		 }
		 	 } ;
		 		return i;
		 }
		 
		//seleccion aleatoria de Empleado
		 public int Seleccion_aleatorea_Empleado() {
			 int total_empleado = ContarEmpleado();
			 int indice = (int)Math.floor(Math.random()*total_empleado);
			 return indice;
		}
		 
		//Consulata de solicitudes por estatus
		 public ArrayList<Solicitudes> Buscar_Solicitudes_Aprod() {
			 ArrayList<Solicitudes> AuxSoli = new ArrayList<Solicitudes>() ;
			 for (int i=0;i<ContarSolicitud();i++) {
				 if (Vector_solicitudes.get(i).getEstatus()=="Aprobada")
					 AuxSoli.add(Vector_solicitudes.get(i));
			 }
			 return AuxSoli;
		 }
		 public ArrayList<Solicitudes> Buscar_Solicitudes_Rechazado() {
			 ArrayList<Solicitudes> AuxSoli = new ArrayList<Solicitudes>() ;
			 for (int i=0;i<ContarSolicitud();i++) {
				 if (Vector_solicitudes.get(i).getEstatus()=="Rechazado")
					 AuxSoli.add(Vector_solicitudes.get(i));
			 }
			 return AuxSoli;
		 }
		 
		 // Fechas randoms
		 public Date getRandomDate() {
				Random rand = new Random();
				Calendar cal = Calendar.getInstance();
				cal.set(2022, 0, 1);
				long start = cal.getTimeInMillis();
				cal.set(2022, 4, 19);
				long end = cal.getTimeInMillis();
				Date d = new Date(start + (long) (rand.nextDouble() * (end - start)));
				return d;
			}
		 // Presupuesto total de todas las fundaciones con solicitudes aprobadas
		 public double Total_Presupuesto(Date fecha1, Date fecha2) {
	          double Total_Presupuesto=0;
	          for (int c=0;c<Buscar_Solicitudes_Aprod().size();c++) {
	            if (Buscar_Solicitudes_Aprod().get(c).fecha_emision.compareTo(fecha1)>0 && Buscar_Solicitudes_Aprod().get(c).fecha_emision.compareTo(fecha2)<0)
	            Total_Presupuesto += Buscar_Solicitudes_Aprod().get(c).getPresupuesto();
	            }
	          return Total_Presupuesto;
	      }
		 
		 
		 public double PresupuestoATotal() {
		       
		       double presupuesto = 0;
		       for (int i=0;i<Buscar_Solicitudes_Aprod().size();i++) {
		         presupuesto += Buscar_Solicitudes_Aprod().get(i).getPresupuesto();
		       }
		       return presupuesto;
		     }
		     
		     public double PresupuestoRTotal() {
		       
		       double presupuesto = 0;
		       for (int i=0;i<Buscar_Solicitudes_Rechazado().size();i++) {
		         presupuesto += Buscar_Solicitudes_Rechazado().get(i).getPresupuesto();
		       }
		       return presupuesto;
		     }
		     
		     
		     public ArrayList<Solicitudes> Buscar_Solicitudes_Emp(String cedulaemp) { 
		         ArrayList<Solicitudes> AuxSoli = new ArrayList<Solicitudes>() ;
		         for (int i=0;i<ContarSolicitud();i++) {
		           if (Vector_solicitudes.get(i).get_CedEmpleado().equals(cedulaemp)) {
		             AuxSoli.add(Vector_solicitudes.get(i));
		           }
		         }
		         return AuxSoli;
		       }
}
		
