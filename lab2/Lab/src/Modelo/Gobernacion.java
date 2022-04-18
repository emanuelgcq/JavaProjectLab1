package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.math.*;
import Modelo.Beneficiario;
import Modelo.Fundacion;

public class Gobernacion {
	
private double partida_anual, costo_total;
private ArrayList<Beneficiario> Vector_beneficiario;
private ArrayList<Fundacion> Vector_fundacion;

public Gobernacion(){
	this.Vector_beneficiario= new ArrayList<Beneficiario>();
	this.Vector_fundacion= new ArrayList<Fundacion>();
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

public Beneficiario sacarBeneficiario (int indice) {
	 if (this.ContarBeneficiario() > indice) {
		 Beneficiario benefic = (Beneficiario)this.Vector_beneficiario.get(indice);
		 return benefic;
	 }
	 else 
		 return null;
}

//seleccion aleatoria de Beneficiario
public int Seleccion_aleatorea_Benefic() {
	 int total_beneficiario = ContarBeneficiario();
	 int indice = (int)Math.floor(Math.random()*total_beneficiario);
	 return indice;
}

}
