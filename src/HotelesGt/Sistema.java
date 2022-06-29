package HotelesGt;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.*;

public class Sistema {
	JFrame menuP = new JFrame();
	JPanel panel = new JPanel();
	/*JMenuBar bm = new JMenuBar();
	JMenu agregar = new JMenu("agregar");
	JMenu salir = new JMenu("salir");*/
	JLabel label1 = new JLabel();
	JTable tabla = new JTable();
	JScrollPane scroll = new JScrollPane();

	General gral = new General();

	Object[][] clientes = new Object[100][6];
	public void componentes() {
		menuP.setTitle("Hoteles GT - Usuarios ");
		menuP.setBounds(500, 300, 900, 600);
		menuP.setLocationRelativeTo(null);
		panel.setBounds(500, 300, 900, 600);
		panel.setLayout(null);
		/*menuP.setJMenuBar(bm);
		salir.addSeparator();
		
		bm.add(agregar);
		bm.add(salir);*/

		menuP.add(panel);
		label1.setText("USUARIO: ");
		label1.setFont(new Font("Serig", Font.PLAIN,15));
		label1.setBounds(600,0,100,60);
		panel.add(label1);
		
		menuP.setVisible(true);
		menuP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gral.ejecutar();
		panel.add(gral.scroll);
		panel.add(gral.Agregar);
		panel.add(gral.salir);
		panel.add(gral.Modificar);
		panel.add(gral.Eliminar);
		
	}
	
	

	public void ejecutar() {
		componentes();
	}

	public static void main(String[] args) {

		Sistema s = new Sistema();
		s.ejecutar();

	}

}
