package restaurante;

import java.util.concurrent.Semaphore;

import hilos.Clientes;

public class Main {

	public static void main (String [] args) {			
		
		Semaphore semaClientes = new Semaphore (Contador.CLIENTES);
		
		Clientes[] clientes = new Clientes[Contador.CLIENTES];
		
		while(Contador.ok == true) {
			
			for (int i=0; i<Contador.CLIENTES; i++) {
				
				clientes[i] = new Clientes(semaClientes);
				clientes[i].start();			

				try {
					clientes[i].join();
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}				
			}
		}
	}	
}
