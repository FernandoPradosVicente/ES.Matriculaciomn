public class Informe {
	private Vehiculo vehiculo; 
	private double gasesTest;	
	private boolean cinturonTest; 
	private String estado;
	private int id;
	
	Informe(Vehiculo vehiculo,int j) {
		this.vehiculo = vehiculo;
		this.estado = "En proceso";
		this.id = j+1;
	}
	
	public String toString() {
		return this.vehiculo + ", tiene su inspeccion: " + this.estado;
	}
	
	int miraId() {
		return this.id;
	}
	
	void completarInforme(double gases,boolean cinturon) {
		this.gasesTest = gases;
		this.cinturonTest = cinturon;
		this.estado = "Completada";
	}	
	
	boolean testITV() {
		boolean pasaITV = false;
		if (this.estado.equals("En proceso")) {
			pasaITV = true;
		}
		else if (this.vehiculo.miraTipo().equals(Tipo.CAMION)) {
			if (this.cinturonTest && this.gasesTest < 4.0) {
				pasaITV = true;
			}
		}
			else {
				if (this.cinturonTest && this.gasesTest < 2.0) {
					pasaITV = true;
				}
			}
		return pasaITV;
	}
}