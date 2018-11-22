package hilos;

import java.util.concurrent.Semaphore;

import restaurante.Contador;
import restaurante.Controlador;

public class Mesas extends Thread{
	
	private Semaphore semMesas;	
	
	public Mesas(Semaphore semMesas) {
		
		this.semMesas = semMesas;
	}

	Semaphore semPlato1 = new Semaphore(5);
	Plato1 plato1= new Plato1(semPlato1);
	
	public void run() {			
		try {		
			semMesas.acquire();	
			
			sleep(100);
			Contador.asientos++;					
			Controlador.rellenarMesas("",Contador.arrayClientes[Contador.clientes],"\n", Contador.arrayMesa, Contador.asientos);
			Controlador.pintarMesas(Contador.asientos,Contador.arrayMesa);
			
			plato1.start();		
			sleep(1000);
			semMesas.release();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
