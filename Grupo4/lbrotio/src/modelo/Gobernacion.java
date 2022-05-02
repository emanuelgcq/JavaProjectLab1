package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.math.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.Beneficiario;
import modelo.Fundacion;

public class Gobernacion {
	
private double partida_anual, costo_total;
private ArrayList<Beneficiario> Vector_beneficiario;
private ArrayList<Fundacion> Vector_fundacion;
private ArrayList<Charlas> Vector_charlas;

public Gobernacion(){
	this.Vector_beneficiario= new ArrayList<Beneficiario>();
	this.Vector_fundacion= new ArrayList<Fundacion>();
	this.Vector_charlas= new ArrayList<Charlas>();
 }

//Fundacion

public int ContarFundacion() {			//contar Fundacion
	 return this.Vector_fundacion.size();
};

public void AggFundacion(Fundacion fun) {			//agregar un nuevo Fundacion
	 this.Vector_fundacion.add(fun);
}

public Fundacion sacarFundacion (int indice) {
	 if (this.ContarFundacion() > indice) {
		 Fundacion fun = (Fundacion)this.Vector_fundacion.get(indice);
		 return fun;
	 }
	 else 
		 return null;
}
public String sacarFundacion_Nombre (int indice) {
	 if (this.ContarFundacion() > indice) {
		 String fun = this.Vector_fundacion.get(indice).getNombre();
		 return fun;
	 }
	 else 
		 return null;
}

public int Seleccion_aleatorea_Fundacion() {
	 int total_fundacion = ContarFundacion();
	 int indice = (int)Math.floor(Math.random()*total_fundacion);
	 return indice;
}


//Beneficiario

public int ContarBeneficiario() {			//contar Beneficiario
	 return this.Vector_beneficiario.size();
};

public void AggBeneficiario(Beneficiario benef) {			//agregar un nuevo Beneficiario
	 this.Vector_beneficiario.add(benef);
}

//sacar beneficiario
public Beneficiario sacarBeneficiario (int indice) {
	 if (this.ContarBeneficiario() > indice) {
		 Beneficiario benefic = (Beneficiario)this.Vector_beneficiario.get(indice);
		 return benefic;
	 }
	 else 
		 return null;
}

//sacar cedula de beneficiario
public String sacarBeneficiario_ced (int indice) {
	 if (this.ContarBeneficiario() > indice) {
		 String benefic = this.Vector_beneficiario.get(indice).getCedula();
		 return benefic;
	 }
	 else 
		 return null;
}

//sacar beneficiario por cedula
public int sacarBeneficiario_ced (String ced) {
	 int i=0;
	 boolean encontro=false;
	 while(encontro!=true){
		 if (ced==Vector_beneficiario.get(i).getCedula()) {
			 encontro=true;	
		 }
		 else {
			 encontro=false;
			 i++;
		 }
	 } ;
		return i;
}


//seleccion aleatoria de Beneficiario
public int Seleccion_aleatorea_Benefic() {
	 int total_beneficiario = ContarBeneficiario();
	 int indice = (int)Math.floor(Math.random()*total_beneficiario);
	 return indice;
}

//Metodos

public double Total_PresupuestoSolicitudes(Date fecha1, Date fecha2) {
    
	  double Total_PresupuestoSolicituds=0; 
	    for (int c=0;c<Vector_fundacion.size();c++)
	      Total_PresupuestoSolicituds+=Vector_fundacion.get(c).Total_Presupuesto(fecha1, fecha2);        
	    
	    return Total_PresupuestoSolicituds;
	}

public double[] Total_Presupuesto(Fundacion fun, Date fecha1, Date fecha2) {
	double[] Total_Presupuesto=new double[ContarFundacion()];
    for (int c=0;c<fun.Buscar_Solicitudes_Aprod().size();c++) {
    	if (fun.Buscar_Solicitudes_Aprod().get(c).fecha_emision.compareTo(fecha1)>0 && fun.Buscar_Solicitudes_Aprod().get(c).fecha_emision.compareTo(fecha2)<0) {
    		for(int a=0; a<ContarFundacion(); a++) {
    			if(fun.Buscar_Solicitudes_Aprod().get(c).getFundacion()==Vector_fundacion.get(a).getNombre()) {
    				Total_Presupuesto[a]+=fun.Buscar_Solicitudes_Aprod().get(c).getPresupuesto();
    			}
    		}
    	}
     }
    return Total_Presupuesto;
	}


public ArrayList<Beneficiario> Cedulas_BeneficiariosxFun(Fundacion fun, String nombreFun) {
	ArrayList<Beneficiario> AuxBenefic = new ArrayList<Beneficiario>();
			 for(int c=0;c<fun.ContarSolicitud(); c++) {
				 if(fun.sacarSolicitudes(c).getFundacion()==nombreFun) {
					int posi = sacarBeneficiario_ced(fun.sacarSolicitudes(c).get_CedBeneficiario());
					AuxBenefic.add(this.Vector_beneficiario.get(posi));
				 }
		 }
 return AuxBenefic;
}


	public double[] Total_PresupuestoFund(Fundacion fun) {
		double[] Total_Presupuesto=new double[ContarFundacion()];
			for (int c=0;c<fun.Buscar_Solicitudes_Aprod().size();c++) {
				for(int a=0; a<ContarFundacion(); a++) {
					if(fun.Buscar_Solicitudes_Aprod().get(c).getFundacion()==Vector_fundacion.get(a).getNombre()) {
						Total_Presupuesto[a]+=fun.Buscar_Solicitudes_Aprod().get(c).getPresupuesto();
	          }
	        }
	     }
	    return Total_Presupuesto;
	  }

	public double[] PresupuestoDispFundacion(Fundacion fun) {
	  double[] Total_Presupuesto_fund=new double[ContarFundacion()];
	  	for (int i= 0;i<ContarFundacion();i++) {    
	  		Total_Presupuesto_fund[i] =  sacarFundacion(i).getpartida() - Total_PresupuestoFund(fun)[i];
	  	}
	  return Total_Presupuesto_fund;
	}
	public double[] PresupuestoDispFundacion_porcentaje(Fundacion fun) {
		  double[] Total_Presupuesto_fund=new double[ContarFundacion()];
		  	for (int i= 0;i<ContarFundacion();i++) {    
		  		Total_Presupuesto_fund[i] =  (sacarFundacion(i).getpartida() - Total_PresupuestoFund(fun)[i])*100/sacarFundacion(i).getpartida();
		  	}
		  return Total_Presupuesto_fund;
	}
	

	
	//Metodos de Charlas

	public int ContarCharlas() {			//contar Charlas
		 return this.Vector_charlas.size();
	};

	public void AggCharlas(Charlas charla) {			//agregar un nuevo Charlas
		 this.Vector_charlas.add(charla);
	}

	public Charlas sacarCharlas (int indice) {
		 if (this.ContarCharlas() > indice) {
			 Charlas charla = (Charlas)this.Vector_charlas.get(indice);
			 return charla;
		 }
		 else 
			 return null;
	}
	
	public int Seleccion_aleatorea_Charlas() {
		 int total_Charlas = ContarCharlas();
		 int indice = (int)Math.floor(Math.random()*total_Charlas);
		 return indice;
	}
	
	public Date getRandomDate() {
		Random rand = new Random();
		Calendar cal = Calendar.getInstance();
		cal.set(2022, 0, 1);
		long start = cal.getTimeInMillis();
		cal.set(2022, 8, 19);
		long end = cal.getTimeInMillis();
		Date d = new Date(start + (long) (rand.nextDouble() * (end - start)));
		return d;
	}
	
	//Solicitudes por beneficiario	
    public ArrayList<Solicitudes> Buscar_Solicitudes_Benef(Fundacion fun,String cedulabenef) { 
        ArrayList<Solicitudes> AuxSoli = new ArrayList<Solicitudes>() ;
        for (int i=0;i<fun.ContarSolicitud();i++) {
          if (fun.sacarSolicitudes(i).get_CedEmpleado().equals(cedulabenef)) {
            AuxSoli.add(fun.sacarSolicitudes(i));
          }
        }
        return AuxSoli;
      }
	
	//VALIDARES
	
	
	public int Validar_Ced_3Charla(String ced) {
	 int contador =0;
	 	 for (int i=0;i<ContarCharlas();i++) {
	 		 for (int c=0; c<sacarCharlas(i).ContarCedBenefic();c++) {
		 		 if(sacarCharlas(i).sacarCedBenefi(c).equals(ced))
		 			 contador++;	 
	 		 }
	 	 }
	 	 if(contador>3)
	 		 return 1;
	 	 else 
	 		 return -1;	
 	}
	
	public int validar_beneficiario_6meses (Fundacion fun, String ced, Date fechasoli) {
		int valido=0;
		Calendar original = Calendar.getInstance();
		original.setTime(fechasoli);
		original.add(Calendar.MONTH, -5);
		for(int i=Buscar_Solicitudes_Benef(fun,ced).size()-1;i>=0;i--) {	
			Date fecha = Buscar_Solicitudes_Benef(fun,ced).get(i).fecha_emision;
	    	if (fecha.compareTo(original.getTime())<0 || Buscar_Solicitudes_Benef(fun,ced).get(i).getEstatus().equals("Aprobada")) {
	    		valido++;
	        }   			
		}
		if (valido==0)
			return 1;
		else 
			return -1;
	}
	
	public int Validar_fecha(Date fecha) {
		Calendar anno = Calendar.getInstance();
		int annoactual = anno.getWeekYear();
		Date fech1 = new Date(annoactual-1900,8,1);
			if(fecha.compareTo(fech1)<0)
				return 1;
			else 
				return -1;			
	}
	
}


