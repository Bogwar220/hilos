package hilos;

import java.util.concurrent.Semaphore;

import restaurante.Contador;
import restaurante.Controlador;

public class Mesas extends Thread{
	
	private Semaphore semMesas;
	
	public Mesas(Semaphore semMesas) {
		
		this.semMesas = semMesas;
	}

	
	public void run() {
			
		try {	
			
			semMesas.acquire();			
			
				if(Contador.mesas <= Contador.CLIENTES / 4) {
					
					Controlador.mesa_2("Cliente" + Contador.clientes + ".\n");
					Contador.mesas++;
				}
				
				else if(Contador.mesas <= Contador.CLIENTES / 2) {
					
					Controlador.mesa_3("Cliente" + Contador.clientes + ".\n");
					Contador.mesas++;
				}
				
				else if(Contador.mesas <= Contador.CLIENTES  / 4 * 3) {
					
					Controlador.mesa_4("Cliente" + Contador.clientes + ".\n");
					Contador.mesas++;
				}
				
				else if(Contador.mesas <= Contador.CLIENTES) {
					
					Controlador.mesa_1("Cliente" + Contador.clientes + ".\n");
					Contador.mesas++;
				}		
				
			
			semMesas.release();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
