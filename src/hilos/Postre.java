package hilos;

import java.util.concurrent.Semaphore;

import restaurante.Contador;
import restaurante.Controlador;

public class Postre extends Thread{

	private Semaphore semPostre;	
	private String[] arrayPostre = new String[5];
	
	public Postre(Semaphore semPostre) {
		this.semPostre = semPostre;
	}
	
	public void run() {
		int platos=0;
		try {
			semPostre.acquire();
			
			sleep(100);	
			platos++;	
			if(!Contador.arrayMesa[Contador.asientos].isEmpty()) {
				Controlador.rellenarMesas("Postre ",Contador.arrayMesa[Contador.asientos],"",arrayPostre,platos);				
				Controlador.pintarMesas(platos, arrayPostre);	
				sleep(1000);
			}
			if(Contador.asientos == Contador.CAMARERO) {
				Controlador.borrar(1);				
				Controlador.borrar(2);				
				Controlador.borrar(3);				
				Controlador.borrar(4);			
				
				Contador.asientos = 0;
			}
			semPostre.release();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}

