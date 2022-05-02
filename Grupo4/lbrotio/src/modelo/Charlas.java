package modelo;
import java.util.ArrayList;
import java.util.Date;

public class Charlas {

	private String tema,
	lugar, organismo, hora;
	private Date fecha; 
	private ArrayList<String> Vector_CedBenefic;
	private int Numero_charla;
	
	public Charlas(int Numero_charla, String tema,String lugar, String organismo,Date fecha,String hora, ArrayList<String> Vector_CedBenefic) {
		this.Numero_charla=Numero_charla;
		this.tema=tema;
		this.lugar=lugar;
		this.organismo=organismo;
		this.fecha=fecha;
		this.hora=hora;
		this.Vector_CedBenefic=Vector_CedBenefic;
	}
	
	public int getNumero_charla() {
        return Numero_charla;
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

    public void setNumero_charla(int Numero_charla) {
        this.Numero_charla = Numero_charla;
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
    
    public String getHora() {
        return hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
  //Metodos de Vector Ced de Beneficiario que asisitio
    
    public int ContarCedBenefic() {			//contar Ced de Beneficiario que asisitio
   	 return this.Vector_CedBenefic.size();
   };

   public void AggCedBenefic(String ced) {			//agregar un nuevo Ced de Beneficiario que asisitio
   	 this.Vector_CedBenefic.add(ced);
   }
   public String  sacarCedBenefi (int indice) {
		 if (this.ContarCedBenefic() > indice) {
			 String ced = Vector_CedBenefic.get(indice);
			 return ced;
		 }
		 else 
			 return null;
	}

}
