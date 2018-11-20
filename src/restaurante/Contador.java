package restaurante;

public class Contador {
	
	public static final int CAMARERO=20;
	public static final int CLIENTES = 1000;
	
	public static int clientes = 0;
	public static boolean ok = false;
	public static String[] arrayClientes = new String[CLIENTES];
	public static int asientos = 0;
	public static String[] arrayMesa = new String[CAMARERO +1];	
	public static int auxContMesas = 1;
}
