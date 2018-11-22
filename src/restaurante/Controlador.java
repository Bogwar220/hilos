package restaurante;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import Vista.Vista;

public class Controlador {

	static Vista vista = new Vista();
	private static String mensajeBorrado ="\n\n\n***Se van***\n\n\n";
	
	public Controlador(Vista vista) {
		this.vista = vista;
	}
	
	public static void entrada(String text) {
		
		vista.lblEntrada.setText(vista.lblEntrada.getText() + text);
	}	
	
	public static void pintar(JTextArea textArea, String text) {
		
		textArea.setText(textArea.getText() + text);
	}
	
	public static void pintarMesas(int num, String[] array) {		
		
		if(Contador.asientos <= Contador.CAMARERO / 4) {		
		
			vista.lblMesa_1.setText(vista.lblMesa_1.getText() +array[num]);
		}
		
		else if(Contador.asientos <= Contador.CAMARERO / 2) {				
			
			
			vista.lblMesa_2.setText(vista.lblMesa_2.getText() + array[num]);
		}
		
		else if(Contador.asientos <= Contador.CAMARERO  / 4 * 3) {				
			
			vista.lblMesa_3.setText(vista.lblMesa_3.getText() + array[num]);
		}
		
		else if(Contador.asientos <= Contador.CAMARERO) {				
			
			
			vista.lblMesa_4.setText(vista.lblMesa_4.getText() + array[num]);
		}			
	}
	
	public static void rellenarMesas(String text, String arrayText, String salto,String[] array, int num) {
		
		array[num] = text + arrayText + salto;
	}	
	
	public static void borrar(int num) {	
		switch (num) {
		case 1:
			vista.lblMesa_1.setText(mensajeBorrado);
			break;
		case 2:
			vista.lblMesa_2.setText(mensajeBorrado);
			break;
		case 3:
			vista.lblMesa_3.setText(mensajeBorrado);
			break;
		case 4:
			vista.lblMesa_4.setText(mensajeBorrado);
			break;
		default :
			break;
		}	
		
	}	
}
