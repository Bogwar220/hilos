package restaurante;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import Vista.Vista;

public class Controlador {

	static Vista vista = new Vista();
	
	public Controlador(Vista vista) {
		this.vista = vista;
	}
	
	public static void entrada(String text) {
		
		vista.lblEntrada.setText(vista.lblEntrada.getText() + text);
	}	
	
	public static void pintar(JTextArea textArea, String text) {
		
		textArea.setText(textArea.getText() + text);
	}
	
	public static void pintarMesas(int num) {		
		
		if(num <= Contador.CAMARERO / 4) {		
		
			vista.lblMesa_1.setText(vista.lblMesa_1.getText() + Contador.arrayMesa[num]);
		}
		
		else if(num <= Contador.CAMARERO / 2) {				
			
			
			vista.lblMesa_2.setText(vista.lblMesa_2.getText() + Contador.arrayMesa[num]);
		}
		
		else if(num <= Contador.CAMARERO  / 4 * 3) {				
			
			vista.lblMesa_3.setText(vista.lblMesa_3.getText() + Contador.arrayMesa[num]);
		}
		
		else if(num <= Contador.CAMARERO) {				
			
			
			vista.lblMesa_4.setText(vista.lblMesa_4.getText() + Contador.arrayMesa[num]);
		}			
	}
	
	public static void rellenarMesas(String text, String arrayText, String salto) {
		
		Contador.arrayMesa[Contador.asientos] = text + arrayText + salto;
	}	
	
	public static void borrar(int num) {
		
		if(comprobar()) {
			switch (num) {
			case 1:
				vista.lblMesa_1.setText("");
				break;
			case 2:
				vista.lblMesa_2.setText("");
				break;
			case 3:
				vista.lblMesa_3.setText("");
				break;
			case 4:
				vista.lblMesa_4.setText("");
				break;
			default :
				break;
			}	
		}
	}	
	
	public static boolean comprobar() {
		
		boolean algo = false;
		switch (Contador.asientos) {
		case 5:			
		case 10:			
		case 15:			
		case 20:
			algo=true;
		default:
			algo=false;
			break;
		}
		
		return algo;
	}
}
