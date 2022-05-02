package modelo;

import java.util.Date;

public class Empleado extends Persona {
	
	private String solicitud;
	
	public Empleado(String cedula, String nombre,String apellido, String telefono,
            String direccion,String fechanac,String email, String estatus) {
		
		super(cedula, nombre, apellido, telefono, direccion, fechanac, email, estatus);
		
		this.solicitud=solicitud;
		
	}
}
