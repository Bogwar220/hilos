package hilos;

import java.util.concurrent.Semaphore;

import restaurante.Contador;
import restaurante.Controlador;

public class Postre extends Thread{

	private Semaphore semPostre;
	
	public Postre(Semaphore semPostre) {
		this.semPostre = semPostre;
	}
	
	public void run() {
		
		try {
			semPostre.acquire();
			
			Contador.asientos++;
			Controlador.rellenarMesas("Postre ",Contador.arrayMesa[Contador.asientos],"");								
			Contador.platos++;
			Controlador.pintarMesas(Contador.asientos);	
			
			if(Contador.platos == 5) {
				
				Contador.asientos--;
			}
			
			semPostre.release();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}

