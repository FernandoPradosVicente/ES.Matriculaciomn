public class GestorITV {
	private Vehiculo[] listVehiculos;
	private Informe[] listInformes; 	
	
	public static void main(String[] args) {
			GestorITV gestorITV = new GestorITV(10);

			gestorITV.listVehiculos[0] = new Vehiculo("3451-GTS",Tipo.TURISMO);
			gestorITV.listVehiculos[1] = new Vehiculo("5558-HYT",Tipo.CAMION);
	
			gestorITV.iniciarProceso("9992-DHT",Tipo.FURGONETA);
			gestorITV.iniciarProceso("3451-GTS",Tipo.TURISMO);
			gestorITV.iniciarProceso("8811-KRS",Tipo.CAMION);
			
			gestorITV.cerrarInforme(2,3.0,true);
			gestorITV.cerrarInforme(3,3.1,true);
			
			gestorITV.printVehiculos();
			gestorITV.printAllInformes();
			gestorITV.printNoFavorInformes();
		}
		
	GestorITV (int N) {
		this.listVehiculos = new Vehiculo[N];
		this.listInformes = new Informe[N];
	}
	
	int lastVehicPos() {
		boolean found = false;
		int i = 0;
		while (i < this.listVehiculos.length && !found) {
			if (this.listVehiculos[i] == null) {
				found = true;
			}
			else {
				i++;
			}
		}
		return i;
	}
	
	int nextInfPos = 0;
	
	void iniciarProceso(String matricula,Tipo tipo) {
		int i = 0;
		Vehiculo vPruebas = new Vehiculo(matricula,tipo);
		boolean found = false;
		while(i < lastVehicPos() && !found) {
			if(this.listVehiculos[i].miraMatricula().equals(vPruebas.miraMatricula())) {
				i++;
			}
			else if (this.listVehiculos[i].equals(vPruebas)){
					found = true;
				}
				else {
					i++;
				}
		}
		if (!found) {
			this.listVehiculos[i] = vPruebas;
		}
		this.listInformes[nextInfPos] = new Informe(listVehiculos[i],nextInfPos);
		System.out.println("El Id es: " + this.listInformes[nextInfPos].miraId());
		nextInfPos++;
	}
	
	void cerrarInforme(int id,double gases,boolean cinturon) {
		this.listInformes[id-1].completarInforme(gases,cinturon);
	}
	
	void printVehiculos() {
		System.out.println("----------");
		for(int i = 0;i < lastVehicPos();i++) {
				System.out.println(this.listVehiculos[i]);
		}
	}
	
	void printAllInformes() {
		System.out.println("----------");
		for (int i = 0;i < nextInfPos;i++) {
			System.out.println(this.listInformes[i]);
		}
	}
	
	void printNoFavorInformes() {
		System.out.println("----------");
		for(int i = 0; i < nextInfPos; i++) {
			if(!this.listInformes[i].testITV()) {
				System.out.println(this.listInformes[i] + ", pero no favorable");
			}
		}
	}
}