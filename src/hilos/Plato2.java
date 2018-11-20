package hilos;

import java.util.concurrent.Semaphore;

import restaurante.Contador;
import restaurante.Controlador;

public class Plato2 extends Thread{

	private Semaphore semPlato2;
	
	public Plato2(Semaphore semPlato2) {
		this.semPlato2 = semPlato2;
	}
	
	Semaphore semPlatos = new Semaphore(5);
	Platos platos = new Platos(semPlatos);
	
	public void run() {
		
		try {
			semPlato2.acquire();
			
			Contador.asientos++;
			Controlador.rellenarMesas("Segundo plato ",Contador.arrayMesa[Contador.clientes],"");
			
			if(Contador.asientos == Contador.CAMARERO / 4 || Contador.asientos == Contador.CAMARERO / 2 || Contador.asientos == Contador.CAMARERO / 4*3 || Contador.asientos == Contador.CAMARERO) {				
				platos.start();			
				sleep(100);
			}
			
			semPlato2.release();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}

