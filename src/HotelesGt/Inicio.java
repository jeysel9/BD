package HotelesGt;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Inicio {

	JFrame inicio = new JFrame();
	JPanel panel = new JPanel();
	JLabel Lblimagen = new JLabel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JTextField user = new JTextField();
	JPasswordField pass = new JPasswordField();
	JButton boton = new JButton();
	Clientes cl = new Clientes();
	public void frame() {
		inicio.setTitle("Iniciar Sesión");
		inicio.setBounds(300, 300, 400, 400);
		inicio.setLocationRelativeTo(null);
		inicio.setVisible(true);

		
		panel.setBounds(300, 300, 350, 420);
		panel.setLayout(null);

		inicio.add(panel);
		inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ejecutar();

	}

	public void etiquetas() {
		//imagen
		Lblimagen.setBounds(10, 10, 250, 150);
		Lblimagen.setIcon(new ImageIcon("imagen.png"));
		panel.add(Lblimagen);
	
		label1.setText("USUARIO");
		label1.setFont(new Font("Serig", Font.PLAIN, 10));
		label1.setBounds(50, 110, 250, 80);
		panel.add(label1);

		label2.setText("CONTRASEÑA");
		label2.setFont(new Font("Serig", Font.PLAIN, 10));
		label2.setBounds(50, 180, 250, 80);
		panel.add(label2);

		user.setBounds(50, 160, 200, 40);
		pass.setBounds(50, 240, 200, 40);

		panel.add(user);
		panel.add(pass);
	}

	public void boton() {
		boton.setText("INGRESAR");
		boton.setBounds(75, 300, 100, 40);
		panel.add(boton);
		ActionListener funcion_ingresar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					login();
				
				
			}
		};
		boton.addActionListener(funcion_ingresar);
		
	}
	
	public void login () {
		Boolean correcto = false;
		int intentos = 3;
		int y = 0;
		String nombre = "";
		List<Usuarios> lista = cl.listaUsuario();
		for (int i = 0; i < lista.size(); i++) {
			y=y+1;
			System.out.println(lista.get(i));
		}
		Object[][] ob = new Object[y][3];
		for (int i = 0; i < ob.length; i++) {
			ob[i][0] = lista.get(i).getCorreo();
			ob[i][1] = lista.get(i).getContrasena();
			ob[i][2] = lista.get(i).getNombre();
		}
		for (int i = 0; i < ob.length; i++) {
			
			if (user.getText().equals(ob[i][0]) && pass.getText().equals(ob[i][1])) {
				correcto = true;
				nombre = (String)ob[i][2].toString();
				JOptionPane.showMessageDialog(null, "bienvenido");
								
				break;
			}else if(intentos == 0){
				JOptionPane.showMessageDialog(null, "incorrecto- initente nuevamente");
				System.exit(0);
			}else{				
				
			}
			
		}
		if(correcto) {
			
			Sistema s = new Sistema();
			
			inicio.setVisible(false);
			s.ejecutar();
		}
		
	}
	public void ejecutar() {
			
		etiquetas();
		boton();
	}

	public static void main(String[] args) {
		Inicio p1 = new Inicio();
		p1.frame();
	}

}
