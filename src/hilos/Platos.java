package hilos;

import java.util.concurrent.Semaphore;

import Vista.Vista;
import restaurante.Contador;
import restaurante.Controlador;

public class Platos extends Thread{
	
	private Semaphore semPlatos;
	
	public Platos(Semaphore semPlatos) {
		this.semPlatos = semPlatos;
	}
	
	Semaphore semPlato2 = new Semaphore (5);
	Plato2 plato2 = new Plato2(semPlato2);
	
	public void run() {
		
		try {					
			Controlador.rellenarMesas("Primer plato ",Contador.arrayMesa[Contador.asientos],"");			
			Contador.platos++;
			Controlador.pintarMesas(Contador.asientos);			
			
			if(Contador.asientos == Contador.CAMARERO / 4 || Contador.asientos == Contador.CAMARERO / 2 || Contador.asientos == Contador.CAMARERO / 4*3 || Contador.asientos == Contador.CAMARERO) {				
				plato2.start();
				Contador.platos=1;
				sleep(100);
			}
			
			Controlador.pintarMesas(Contador.asientos);						
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	
	}
}
