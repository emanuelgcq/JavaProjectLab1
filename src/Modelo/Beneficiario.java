package Modelo;

import java.util.Date;

public class Beneficiario extends Persona {
	
	private Date asistencia;
	
	public Beneficiario(String cedula, String nombre,String apellido, long telefono,
	            String direccion,Date fechanac,String email, char estatus) {
		
		super(cedula, nombre, apellido, telefono, direccion, fechanac, email, estatus);
	}
	 
	
	 
	 
}
