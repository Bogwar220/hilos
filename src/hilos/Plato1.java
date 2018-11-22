package hilos;

import java.util.concurrent.Semaphore;

import Vista.Vista;
import restaurante.Contador;
import restaurante.Controlador;

public class Plato1 extends Thread{
	
	private Semaphore semPlatos;
	
	private String[] arrayPlato1 = new String[6]; 
	
	public Plato1(Semaphore semPlatos) {
		this.semPlatos = semPlatos;
	}
	
	Semaphore semPlato2 = new Semaphore (5);
	Plato2 plato2 = new Plato2(semPlato2);
	
	public void run() {	
		int platos=0;
		
		try {
			
			semPlatos.acquire();
			
			sleep(100);
			platos++;			
			if(!Contador.arrayMesa[Contador.asientos].isEmpty()) {
				Controlador.rellenarMesas("1º plato ",Contador.arrayMesa[Contador.asientos],"",arrayPlato1,platos);			
				Controlador.pintarMesas(platos, arrayPlato1);		
				plato2.start();
				sleep(1000);	
		}
			
			semPlatos.release();							
		} catch (InterruptedException e) {
		
		e.printStackTrace();
		}	
	}
}
