package Modelo;

import Modelo.Empleado;
import Modelo.Solicitudes;
import java.util.ArrayList;
import java.math.*;

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
		
		 public void AggSolicitud(Solicitudes sol) {			//agregar un nuevo Empleado
			 this.Vector_solicitudes.add(sol);
		 }

		 // Empleado
		 public int ContarEmpleado() {			//contar Empleado
			 return this.Vector_empleado.size();
		 };
		 
		 public void AggEmpleado(Empleado emp) {			//agregar un nuevo Empleado
			 this.Vector_empleado.add(emp);
		 }
		 
		 public Empleado sacarEmpleado (int indice) {
			 if (this.ContarEmpleado() > indice) {
				 Empleado empleado = (Empleado)this.Vector_empleado.remove(indice);
				 return empleado;
			 }
			 else 
				 return null;
		 }
		 
		//seleccion aleatoria de Empleado
		 public int Seleccion_aleatorea_Empleado() {
			 int total_empleado = ContarEmpleado();
			 int indice = (int)Math.floor(Math.random()*total_empleado);
			 return indice;
		}
}
