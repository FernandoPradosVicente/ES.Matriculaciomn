enum Tipo {							
		TURISMO,FURGONETA,CAMION;
	}

public class Vehiculo {
	private String matricula;
	private Tipo tipo;
	
	Vehiculo(String matricula,Tipo tipo) {
		this.matricula = matricula;
		this.tipo = tipo;
	}
	
	public String toString() {
		return "Este vehiculo es " + this.tipo + ", con matricula " + this.matricula;
	}
	
	public boolean equals(Vehiculo v) {
		return this.matricula.equals(v.matricula) && this.tipo.equals(v.tipo);
	}
	
	String miraMatricula() {
		return this.matricula;
	}
	
	Tipo miraTipo() {
		return this.tipo;
	}

}