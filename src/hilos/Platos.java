package hilos;

import java.util.concurrent.Semaphore;

import restaurante.Contador;
import restaurante.Controlador;

public class Platos extends Thread{

	private Semaphore semPlatos;	
	
	public Platos(Semaphore semPlatos) {
		
		this.semPlatos = semPlatos;
	}
	
	public void run() {
		
		try {
			semPlatos.acquire();
			

			if(Contador.mesas <= Contador.CLIENTES / 4) {				
				
				Controlador.mesa_2(Contador.arrayClientes[Contador.clientes] + " pide plato 1.\n");
				Controlador.borrar();
			}
			
			else if(Contador.mesas <= Contador.CLIENTES / 2) {					
				
				Controlador.mesa_3( Contador.arrayClientes[Contador.clientes] + " pide plato 1.\n");
				
			}
			
			else if(Contador.mesas <= Contador.CLIENTES  / 4 * 3) {					
				
				Controlador.mesa_4( Contador.arrayClientes[Contador.clientes] + " pide plato 1.\n");
				
			}
			
			else if(Contador.mesas <= Contador.CLIENTES) {					
				
				Controlador.mesa_1(Contador.arrayClientes[Contador.clientes] + " pide plato 1.\n");
				
			}		
			
			semPlatos.release();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	
	}
}
