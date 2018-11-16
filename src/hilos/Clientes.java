package hilos;

import java.util.concurrent.Semaphore;

import restaurante.Contador;
import restaurante.Controlador;

public class Clientes extends Thread {

	private Semaphore semaClientes;
	
	public Clientes(Semaphore semaClientes) {
		
		this.semaClientes = semaClientes;
	}
	
	Semaphore semMesas = new Semaphore(Contador.CLIENTES);
	
	Mesas mesas = new Mesas(semMesas);
		
	public void run() {
		
		try {		
			
			semaClientes.acquire();
			
			Contador.clientes++;
			Controlador.entrada("Ha llegado el cliente "+Contador.clientes+".\n");			
			
			sleep(100);	
			
			mesas.start();			
			
			if(Contador.clientes == 20)
				Contador.ok = false;

			semaClientes.release();
			
			sleep(100);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
}
