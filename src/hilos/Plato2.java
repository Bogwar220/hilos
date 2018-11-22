package hilos;

import java.util.concurrent.Semaphore;

import restaurante.Contador;
import restaurante.Controlador;

public class Plato2 extends Thread{

	private Semaphore semPlato2;
	
	public Plato2(Semaphore semPlato2) {
		this.semPlato2 = semPlato2;
	}	
	
	Semaphore semPostre = new Semaphore(5);
	Postre postre = new Postre(semPostre);
	
	public void run() {
		
		try {
			semPlato2.acquire();
			
			Contador.asientos++;
			Controlador.rellenarMesas("Segundo plato ",Contador.arrayMesa[Contador.asientos],"");
			Contador.platos++;
			Controlador.pintarMesas(Contador.asientos);		
			
			if(Contador.platos == 5) {				
				postre.start();	
				Contador.platos=1;
				sleep(100);
			}			
			
			semPlato2.release();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}

