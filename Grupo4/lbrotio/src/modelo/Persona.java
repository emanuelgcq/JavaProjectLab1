package modelo;

import java.util.Date;

public class Persona {
    private String
            cedula,
            nombre,
            apellido,
            direccion,
            email,
       telefono,fechanac,
   estatus;
    
    public Persona(String cedula, String nombre,String apellido,
    		String telefono,String direccion,String fechanac,
            String email, String estatus){
        
        super();
        
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
        this.direccion=direccion;
        this.fechanac=fechanac;
        this.email=email;
        this.estatus=estatus;
        
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setfechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getemail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

}

