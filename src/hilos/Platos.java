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
	
	Semaphore semComida = new Semaphore(1);
	//Plato1 comida1 = new Plato1(semComida);
	
	public void run() {
		
		try {
			semPlatos.acquire();	
						
			sleep(100);		
			switch (Contador.asientos) {
			case Contador.CAMARERO /4 :
				Controlador.borrar(1);
				for (int i=1; i<=Contador.CAMARERO/4;i++) {
					Controlador.pintarMesas(i);
					sleep(100);
				}	
				break;
			case Contador.CAMARERO /2 :
				Controlador.borrar(2);
				for (int i=Contador.CAMARERO/4+1; i<=Contador.CAMARERO/2;i++) {
					Controlador.pintarMesas(i);
					sleep(100);
				}
				break;
			case (Contador.CAMARERO /4)*3:
				Controlador.borrar(3);
				for(int i=Contador.CAMARERO/2+1;i<=(Contador.CAMARERO/4)*3;i++) {
					Controlador.pintarMesas(i);
					sleep(100);
				}
				break;
			case Contador.CAMARERO:
				Controlador.borrar(4);
				for(int i=((Contador.CAMARERO/4)*3)+1;i<=Contador.CAMARERO;i++) {
					Controlador.pintarMesas(i);
					sleep(100);
				}
				break;
			}	
			
			sleep(100);
			semPlatos.release();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	
	}
}
