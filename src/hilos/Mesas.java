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
	Platos platos = new Platos(semPlatos);
	
	
	public void run() {
			
		try {	
			
			semMesas.acquire();			
			
				if(Contador.mesas <= Contador.CLIENTES / 4) {					
					
					Controlador.mesa_2(Contador.arrayClientes[Contador.clientes] + ".\n");
					Contador.mesas++;
				}
				
				else if(Contador.mesas <= Contador.CLIENTES / 2) {					
					
					Controlador.mesa_3( Contador.arrayClientes[Contador.clientes] + ".\n");
					Contador.mesas++;
				}
				
				else if(Contador.mesas <= Contador.CLIENTES  / 4 * 3) {					
					
					Controlador.mesa_4( Contador.arrayClientes[Contador.clientes] + ".\n");
					Contador.mesas++;
				}
				
				else if(Contador.mesas <= Contador.CLIENTES) {					
					
					Controlador.mesa_1(Contador.arrayClientes[Contador.clientes] + ".\n");
					Contador.mesas++;
				}		
				
				platos.start();
			
			semMesas.release();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
