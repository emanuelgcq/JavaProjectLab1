package Modelo;

import java.util.Date;
import Modelo.Servicios;
import java.util.ArrayList;
import java.math.*;
import java.time.LocalDateTime;

public class Solicitudes {
	
	private ArrayList<Servicios> Vector_servicios;
	private String fundacion, cedbeneficiario, cedempledo,prioridad, estatus;
	private int  nro_solicitud;
	private double presupuesto;
	private LocalDateTime fecha_emision;
	
	public Solicitudes(String fundacion, String cedbeneficiario, String cedempledo, String prioridad, int nro_solicitud, double presupuesto, 
			String estatus, LocalDateTime fecha_emision ) {
		 this.Vector_servicios= new ArrayList<Servicios>();
		 this.cedbeneficiario=cedbeneficiario;
		 this.cedempledo=cedempledo;
		 this.fundacion=fundacion;
		 this.nro_solicitud=nro_solicitud;
		 this.prioridad = prioridad;
		 this.presupuesto = presupuesto;
		 this.estatus = estatus;
		 this.fecha_emision = fecha_emision;
	};
	
	//Metodos Set y Get
	
	 public void setFundacion(String fundacion) {
		 this.fundacion = fundacion; 
	 };
	 public void set_CedBeneficiario(String cedbeneficiario) {
		 this.cedbeneficiario = cedbeneficiario; 
	 };
	 public void set_CedEmpleado(String cedempledo) {
		 this.cedempledo = cedempledo; 
	 };
	 public void setPrioridad(String prioridad) {
		 this.prioridad = prioridad; 
	 };
	 
	 public void setNro_solicitud(int nro_solicitud) {
		 this.nro_solicitud = nro_solicitud; 
	 };
	 
	 public void setPresupuesto(double presupuesto) {
		 this.presupuesto = presupuesto; 
	 };
	 public void setFecha_emision(LocalDateTime fecha_emision) {
		 this.fecha_emision = fecha_emision; 
	 };
	 public void setEstatus(String estatus) {
		 this.estatus = estatus; 
	 };
	 public String getFundacion() {
		 return fundacion;
	 }
	 public LocalDateTime getFecha_emision() {
		return fecha_emision; 
	 };
	 public String getEstatus() {
		 return estatus; 
	 };
	 public double setPresupuesto() {
		 return presupuesto; 
	 };
	 public String getPrioridad() {
		 return prioridad; 
	 };
	 public int getNro_solicitud() {
		 return nro_solicitud; 
	 };
	 public String get_CedBeneficiario() {
		 return cedbeneficiario; 
	 };
	 public String get_CedEmpleado() {
		 return	cedempledo; 
	 };
	 
	 //Metodos de Vectores
	 
	 //Servicios
	
	 public int ContarServicios() {			//contar servicios
		 return this.Vector_servicios.size();
	 };
	 
	 public void AggServicios(Servicios serv) {			//agregar un nuevo servicios
		 this.Vector_servicios.add(serv);
	 }
	 
	 public Servicios sacarServicios (int indice) {
		 if (this.ContarServicios() > indice) {
			 Servicios servicios = (Servicios)this.Vector_servicios.get(indice);
			 return servicios;
		 }
		 else 
			 return null;
	 }
	 
	//seleccion aleatoria de Servicios
	 public int Seleccion_aleatorea_Servicios() {
		 int total_servicios = ContarServicios();
		 int indice = (int)Math.floor(Math.random()*total_servicios);
		 return indice;
	}
	 
	 //Presuspuestos total de la solicitud 
	 public double Presupuesto_Total(int indice[]) { 
		 
		 int posicion=0;
		 double acumulado_presupuesto=0;
		 
		 for(int i=0; indice.length>i; i++) {
			 indice[i]= posicion;
			 acumulado_presupuesto += Vector_servicios.get(posicion).getCosto();
		 }
		 return acumulado_presupuesto;
	 }

}
