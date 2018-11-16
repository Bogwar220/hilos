package restaurante;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class Vista extends JFrame {

	private JPanel contentPane;
	public JTextArea lblEntrada;
	public JTextArea lblMesa_1;
	public JTextArea lblMesa_2;
	public JTextArea lblMesa_3;
	public JTextArea lblMesa_4;

	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEntrada = new JTextArea("");
		lblEntrada.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Entrada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblEntrada.setBounds(463, 28, 151, 500);
		contentPane.add(lblEntrada);
		
		lblMesa_4 = new JTextArea("");
		lblMesa_4.setBorder(new TitledBorder(null, "Mesa 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblMesa_4.setBounds(45, 42, 106, 179);
		contentPane.add(lblMesa_4);
		
		lblMesa_1 = new JTextArea("");
		lblMesa_1.setBorder(new TitledBorder(null, "Mesa 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblMesa_1.setBounds(198, 42, 127, 179);
		contentPane.add(lblMesa_1);
		
		lblMesa_2 = new JTextArea("");
		lblMesa_2.setBorder(new TitledBorder(null, "Mesa 3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblMesa_2.setBounds(45, 275, 106, 179);
		contentPane.add(lblMesa_2);
		
		lblMesa_3 = new JTextArea("");
		lblMesa_3.setBorder(new TitledBorder(null, "Mesa 4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblMesa_3.setBounds(198, 275, 127, 179);
		contentPane.add(lblMesa_3);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
