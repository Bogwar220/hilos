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
			Contador.platos++;
			

			if(Contador.platos == 5) {				
				platos.start();
				Contador.platos=1;
				sleep(100);
			}
			
			sleep(100);			
			
			semMesas.release();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
