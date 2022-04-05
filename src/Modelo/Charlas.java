package Modelo;
import java.util.Date;

public class Charlas {

	private String tema,
	lugar, organismo;
	
	private Date fecha, hora;
	
	public Charlas(String tema,String lugar, String organismo,Date fecha,Date hora) {
		
		this.tema=tema;
		this.lugar=lugar;
		this.organismo=organismo;
		this.fecha=fecha;
		this.hora=hora;
	}
	
	public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
	
    public String getLugar() {
        return tema;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public String getOrganismo() {
        return tema;
    }

    public void setOrganismo(String organismo) {
        this.organismo = organismo;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Date getHora() {
        return hora;
    }
    
    public void setHora(Date hora) {
        this.hora = hora;
    }

}
