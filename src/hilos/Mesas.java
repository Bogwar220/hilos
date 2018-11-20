package hilos;

import java.util.concurrent.Semaphore;

import restaurante.Contador;
import restaurante.Controlador;

public class Mesas extends Thread{
	
	private Semaphore semMesas;	
	
	public Mesas(Semaphore semMesas) {
		
		this.semMesas = semMesas;
	}

	Semaphore semPlatos = new Semaphore(5);
	Platos platos= new Platos(semPlatos);
	
	
	public void run() {
			
		try {	
			
			semMesas.acquire();	
			
			Contador.asientos++;			
			Controlador.rellenarMesas("",Contador.arrayClientes[Contador.clientes],"\n");
			Controlador.pintarMesas(Contador.asientos);
			
			sleep(100);
			Controlador.rellenarMesas("Primer plato ",Contador.arrayMesa[Contador.clientes],"");
			
			if(Contador.asientos == Contador.CAMARERO / 4 || Contador.asientos == Contador.CAMARERO / 2 || Contador.asientos == Contador.CAMARERO / 4*3 || Contador.asientos == Contador.CAMARERO) {				
				platos.start();	
				sleep(100);
			}	
			
			semMesas.release();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
