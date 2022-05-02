package modelo;

import java.util.Date;

public class Beneficiario extends Persona {
	
	private Date asistencia;
	
	public Beneficiario(String cedula, String nombre,String apellido, String telefono,
	            String direccion,String fechanac,String email, String estatus) {
		
		super(cedula, nombre, apellido, telefono, direccion, fechanac, email, estatus);
	}
	 
	
	 
	 
}
