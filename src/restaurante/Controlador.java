package restaurante;

public class Controlador {

	static Vista vista = new Vista();
	
	public Controlador(Vista vista) {
		this.vista = vista;
	}
	
	public static void entrada(String text) {
		
		vista.lblEntrada.setText(vista.lblEntrada.getText() + text);
	}
	
	public static void mesa_2(String text) {
		
		vista.lblMesa_1.setText(vista.lblMesa_1.getText() + text);
	}
	
	public static void mesa_3(String text) {
		
		vista.lblMesa_2.setText(vista.lblMesa_2.getText() + text);
	}
	
	public static void mesa_4(String text) {
		
		vista.lblMesa_3.setText(vista.lblMesa_3.getText() + text);
	}
	
	public static void mesa_1(String text) {
		
		vista.lblMesa_4.setText(vista.lblMesa_4.getText() + text);
	}
	
	public static void borrar() {
		
		vista.lblEntrada.setText("");
	}
}
