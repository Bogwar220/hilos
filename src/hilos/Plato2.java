package hilos;

import java.util.concurrent.Semaphore;

import restaurante.Contador;
import restaurante.Controlador;

public class Plato2 extends Thread{

	private Semaphore semPlato2;	
	private String[] arrayPlato2 = new String[5];
	
	public Plato2(Semaphore semPlato2) {
		this.semPlato2 = semPlato2;
	}	
	
	Semaphore semPostre = new Semaphore(5);
	Postre postre = new Postre(semPostre);
	
	
	public void run() {
		
		int platos=0;
		try {
			semPlato2.acquire();
			
			sleep(100);	
			platos++;	
				if(!Contador.arrayMesa[Contador.asientos].isEmpty()) {
				Controlador.rellenarMesas("2º plato ",Contador.arrayMesa[Contador.asientos],"",arrayPlato2,platos);			
				Controlador.pintarMesas(platos, arrayPlato2);			
				postre.start();	
				sleep(1000);
			}
		
			
			semPlato2.release();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}

