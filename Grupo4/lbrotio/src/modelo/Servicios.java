package modelo;

import java.util.Date;

public class Servicios {

	private String codigo,nombre;
	private int tipo;
	private double costo;
	
	 public Servicios(String codigo, String nombre, int tipo, double costo){ 
		this.codigo= codigo;
		this.nombre=nombre;
		this.tipo=tipo;
		this.costo=costo;
	 }
	 
	 public String getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(String codigo) {
	        this.codigo = codigo;
	    }
	    
	 public String getNombre() {
		 return nombre;
	 }
	 
	 public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	 
	 public int getTipo() {
		 return tipo;
	 }
	 
	 public void setTipo(int tipo) {
	        this.tipo = tipo;
	    }
	 public double getCosto() {
		 return costo;
	 }
	 
	 public void setCosto(int tipo) {
	        this.costo = costo;
	    }
}
