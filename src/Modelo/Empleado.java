package Modelo;

import java.util.Date;

public class Empleado extends Persona {
	
	private String solicitud;
	
	public Empleado(String cedula, String nombre,String apellido, long telefono,
            String direccion,Date fechanac,String email, char estatus) {
		
		super(cedula, nombre, apellido, telefono, direccion, fechanac, email, estatus);
		
		this.solicitud=solicitud;
		
	}
}
