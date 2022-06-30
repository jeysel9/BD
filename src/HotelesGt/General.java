package HotelesGt;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




public class General {
	JFrame menuP = new JFrame();
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel();
	
	JButton Agregar  = new JButton();
	JButton salir = new JButton();
	JButton Modificar  = new JButton();
	JButton Eliminar = new JButton();
	JTable tabla = new JTable();
	JScrollPane scroll = new JScrollPane();
	JButton guardar = new JButton();
	JButton cancelar = new JButton();
	Conexion c = new Conexion();
	Clientes cl = new Clientes();
	Usuarios u = new Usuarios();
	Object[][] obj = new Object[100][6];
		

	Usuarios pro = new Usuarios();
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
		
			
	}
	
	public void boton () {
		Agregar.setText("Agregar Usuario");
		Agregar.setBounds(0, 0, 180, 40);
		ActionListener funcion_agregar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crear();
			}
		};
		Agregar.addActionListener(funcion_agregar);
		
		salir.setText("Salir");
		salir.setBounds(180, 0, 180, 40);
		ActionListener funcion_salir = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		salir.addActionListener(funcion_salir);
		
		
		Modificar.setText("Modificar Usuario");
		Modificar.setBounds(200, 450, 180, 40);
		ActionListener funcion_modificar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Modificar();
			}
		};
		Modificar.addActionListener(funcion_modificar);
		
		Eliminar.setText("Eliminar Usuario");
		Eliminar.setBounds(500, 450, 180, 40);
		ActionListener funcion_Eliminar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		};
		Eliminar.addActionListener(funcion_Eliminar);
		
	}
	private void mostrar() {
		
		Statement st;
		String sql = " select * from usuarios";
		Connection conexion = c.Conectar();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("No");//1
		model.addColumn("Nombre");//2
		model.addColumn("Apellido");//3
		model.addColumn("Tel�fono");//4		
		model.addColumn("Correo");//6
		model.addColumn("Rol");//8
		
		
		tabla.setModel(model);
		String[] dato = new String[6];
		try {
			
			st= conexion.createStatement();
			ResultSet result = st.executeQuery(sql);
			
			while (result.next()) {
				dato[0] = result.getString(1);
				dato[1] = result.getString(2);
				dato[2] = result.getString(3);
				dato[3] = result.getString(4);
				dato[4] = result.getString(6);
				dato[5] = result.getString(8);
				model.addRow(dato);
				//System.out.println(result.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		scroll = new JScrollPane(tabla);
		scroll.setBounds(40, 100, 800, 300);
		
	}
	
	private void crear() {
		JFrame ventana_crear = new JFrame();
		JPanel panelCrear = new JPanel();
		panelCrear.setLayout(null);
		ButtonGroup bg = new ButtonGroup();
		JLabel titulo = new JLabel();
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		JLabel l3 = new JLabel();
		JLabel l4 = new JLabel();
		JLabel l5 = new JLabel();
		JLabel l6 = new JLabel();
		JLabel l7 = new JLabel();
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField();
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();
		JTextField t6 = new JTextField();
		JPasswordField t7 = new JPasswordField();

		JRadioButton activo = new JRadioButton("activo", true);
		activo.setFont(new Font("Serig", Font.PLAIN, 12));
		activo.setBounds(150, 10, 200, 100);
		bg.add(activo);
		JRadioButton inactivo = new JRadioButton("inactivo", false);
		inactivo.setFont(new Font("Serig", Font.PLAIN, 12));
		inactivo.setBounds(150, 10, 200, 100);
		bg.add(inactivo);
		activo.setBounds(100, 450, 100, 30);
		inactivo.setBounds(200, 450, 100, 30);
		panelCrear.add(activo);
		panelCrear.add(inactivo);
		
		
		titulo.setText("Agregar Usuario");
		titulo.setFont(new Font("Serig", Font.PLAIN, 25));
		titulo.setBounds(150, 10, 200, 100);
		panelCrear.add(titulo);
		
		l1.setText("Nombre");
		l1.setFont(new Font("Serig", Font.PLAIN, 12));
		l1.setBounds(60, 80, 100, 80);
		panelCrear.add(l1);

		l2.setText("Apellido");
		l2.setFont(new Font("Serig", Font.PLAIN, 12));
		l2.setBounds(60, 130, 180, 80);
		panelCrear.add(l2);

		l3.setText("Tel�fono");
		l3.setFont(new Font("Serig", Font.PLAIN, 12));
		l3.setBounds(60, 180, 100, 80);
		panelCrear.add(l3);

		l4.setText("Direcci�n");
		l4.setFont(new Font("Serig", Font.PLAIN, 12));
		l4.setBounds(60, 230, 180, 80);
		panelCrear.add(l4);

		l5.setText("Correo");
		l5.setFont(new Font("Serig", Font.PLAIN, 12));
		l5.setBounds(60, 280, 180, 80);
		panelCrear.add(l5);
		
		l6.setText("Fecha Nacimiento");
		l6.setFont(new Font("Serig", Font.PLAIN, 12));
		l6.setBounds(60, 330, 180, 80);
		panelCrear.add(l6);

		l7.setText("Contrase�a");
		l7.setFont(new Font("Serig", Font.PLAIN, 12));
		l7.setBounds(60, 380, 180, 80);
		panelCrear.add(l7);

		if (activo.equals(true)) {
			u.setActivo(1);
		}else {
			u.setActivo(0);
		}
		
		ventana_crear.setTitle("Hoteles GT - Administrador ");
		ventana_crear.setBounds(500, 150, 500, 600);
		ventana_crear.setLocationRelativeTo(null);
		ventana_crear.setVisible(true);
		
		ventana_crear.add(panelCrear);

		// textfield
		
		t1.setBounds(180, 100, 200, 30);
		t2.setBounds(180, 150, 200, 30);
		t3.setBounds(180, 200, 200, 30);
		t4.setBounds(180, 250, 200, 30);
		t5.setBounds(180, 300, 200, 30);
		t6.setBounds(180, 350, 200, 30);
		t7.setBounds(180, 400, 200, 30);

		panelCrear.add(t1);
		panelCrear.add(t2);
		panelCrear.add(t3);
		panelCrear.add(t4);
		panelCrear.add(t5);
		panelCrear.add(t6);
		panelCrear.add(t7);
				
		
		guardar.setText("Guardar");
		guardar.setBounds(100, 500, 100, 30);
		panelCrear.add(guardar);
		ActionListener funcion_agregar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Usuarios> lista = cl.listaUsuario();
				int x = 1;
				
				for (int i = 0; i < lista.size(); i++) {
					x=x+1;
				}
				if (!("".equals(t1.getText()))&&!("".equals(t2.getText()))&&!("".equals(t3.getText()))&&!("".equals(t4.getText()))&&!("".equals(t5.getText()))
						&&!("".equals(t6.getText()))&&!("".equals(t7.getText()))) {
					
					cl.agregar(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()),t4.getText(), t5.getText(), t6.getText(),2,1,t7.getText());
					JOptionPane.showMessageDialog(null, "se agreg� un nuevo usiario...");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					
					tabla();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "se deben llenar todos los campos");
				}
				
			}
		};
		guardar.addActionListener(funcion_agregar);
		cancelar.setText("Cancelar");
		cancelar.setBounds(250, 500, 100, 30);
		panelCrear.add(cancelar);
		ActionListener elim = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana_crear.dispose();				
		}			
		};
		cancelar.addActionListener(elim);
		
	}
	private void Modificar() {

		int seleccionar = tabla.getSelectedRow();
		if (seleccionar != -1) {	
		JFrame ventana_crear = new JFrame();
		JPanel panelCrear = new JPanel();
		panelCrear.setLayout(null);
		JLabel titulo = new JLabel();
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		JLabel l3 = new JLabel();
		JLabel l4 = new JLabel();
		JLabel l5 = new JLabel();
		JLabel l6 = new JLabel();
		JLabel l7 = new JLabel();
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField();
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();
		JTextField t6 = new JTextField();
		JPasswordField t7 = new JPasswordField();

		titulo.setText("Modificar Usuario");
		titulo.setFont(new Font("Serig", Font.PLAIN, 25));
		titulo.setBounds(150, 10, 200, 100);
		panelCrear.add(titulo);
		
		l1.setText("Nombre");
		l1.setFont(new Font("Serig", Font.PLAIN, 12));
		l1.setBounds(60, 80, 100, 80);
		panelCrear.add(l1);

		l2.setText("Apellido");
		l2.setFont(new Font("Serig", Font.PLAIN, 12));
		l2.setBounds(60, 130, 180, 80);
		panelCrear.add(l2);

		l3.setText("Tel�fono");
		l3.setFont(new Font("Serig", Font.PLAIN, 12));
		l3.setBounds(60, 180, 100, 80);
		panelCrear.add(l3);

		l4.setText("Direcci�n");
		l4.setFont(new Font("Serig", Font.PLAIN, 12));
		l4.setBounds(60, 230, 180, 80);
		panelCrear.add(l4);

		l5.setText("Correo");
		l5.setFont(new Font("Serig", Font.PLAIN, 12));
		l5.setBounds(60, 280, 180, 80);
		panelCrear.add(l5);
		
		l6.setText("Fecha Nacimiento");
		l6.setFont(new Font("Serig", Font.PLAIN, 12));
		l6.setBounds(60, 330, 180, 80);
		panelCrear.add(l6);

		l7.setText("Contrase�a");
		l7.setFont(new Font("Serig", Font.PLAIN, 12));
		l7.setBounds(60, 380, 180, 80);
		panelCrear.add(l7);
		
		ventana_crear.setTitle("Hoteles GT - Administrador ");
		ventana_crear.setBounds(500, 150, 500, 600);
		ventana_crear.setLocationRelativeTo(null);
		ventana_crear.setVisible(true);
		
		ventana_crear.add(panelCrear);

		
		// textfield
		t1.setBounds(180, 100, 200, 30);
		t2.setBounds(180, 150, 200, 30);
		t3.setBounds(180, 200, 200, 30);
		t4.setBounds(180, 250, 200, 30);
		t5.setBounds(180, 300, 200, 30);
		t6.setBounds(180, 350, 200, 30);
		t7.setBounds(180, 400, 200, 30);
		
		t1.setText(tabla.getValueAt(seleccionar, 1).toString());
		t2.setText(tabla.getValueAt(seleccionar, 2).toString());
		t3.setText(tabla.getValueAt(seleccionar, 5).toString());
		t5.setText(tabla.getValueAt(seleccionar, 4).toString());
		
		
		panelCrear.add(t1);
		panelCrear.add(t2);
		panelCrear.add(t3);
		panelCrear.add(t4);
		panelCrear.add(t5);
		panelCrear.add(t6);
		panelCrear.add(t7);


		guardar.setText("Guardar");
		guardar.setBounds(100, 500, 100, 30);
		panelCrear.add(guardar);
		ActionListener funcion_modif = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
				 
				List<Usuarios> lista = cl.listaUsuario();
				int x = 1;
				
				for (int i = 0; i < lista.size(); i++) {
					x=x+1;
				}
			 
					
					cl.modificar(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()),t4.getText(), t5.getText(), t6.getText(),2,1,t7.getText());
					JOptionPane.showMessageDialog(null, "se modific�");
					
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					
					tabla();
					
				
				
				
			}
		};
		guardar.addActionListener(funcion_modif);
		
		cancelar.setText("Cancelar");
		cancelar.setBounds(250, 500, 100, 30);
		panelCrear.add(cancelar);
		ActionListener elim = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana_crear.dispose();				
		}			
		};
		cancelar.addActionListener(elim);
		}else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");

		}
		tabla.clearSelection(); // deseleccionar la fila
	}
	
	private void eliminar() {
		int seleccionar = tabla.getSelectedRow();
		if (seleccionar != -1) {
		JFrame ventana_crear = new JFrame();
		JPanel panelCrear = new JPanel();
		panelCrear.setLayout(null);
		JLabel titulo = new JLabel();
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		JLabel l3 = new JLabel();
		JLabel l4 = new JLabel();
		JLabel l5 = new JLabel();
		JLabel l6 = new JLabel();
		JLabel l7 = new JLabel();
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField();
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();
		JTextField t6 = new JTextField();
		JPasswordField t7 = new JPasswordField();
		
		titulo.setText("Eliminar Usuario");
		titulo.setFont(new Font("Serig", Font.PLAIN, 25));
		titulo.setBounds(150, 10, 200, 100);
		panelCrear.add(titulo);
		
		l1.setText("Nombre");
		l1.setFont(new Font("Serig", Font.PLAIN, 12));
		l1.setBounds(60, 80, 100, 80);
		panelCrear.add(l1);

		l2.setText("Apellido");
		l2.setFont(new Font("Serig", Font.PLAIN, 12));
		l2.setBounds(60, 130, 180, 80);
		panelCrear.add(l2);

		l3.setText("Tel�fono");
		l3.setFont(new Font("Serig", Font.PLAIN, 12));
		l3.setBounds(60, 180, 100, 80);
		panelCrear.add(l3);

		l4.setText("Direcci�n");
		l4.setFont(new Font("Serig", Font.PLAIN, 12));
		l4.setBounds(60, 230, 180, 80);
		panelCrear.add(l4);

		l5.setText("Correo");
		l5.setFont(new Font("Serig", Font.PLAIN, 12));
		l5.setBounds(60, 280, 180, 80);
		panelCrear.add(l5);
		
		l6.setText("Fecha Nacimiento");
		l6.setFont(new Font("Serig", Font.PLAIN, 12));
		l6.setBounds(60, 330, 180, 80);
		panelCrear.add(l6);

		l7.setText("Contrase�a");
		l7.setFont(new Font("Serig", Font.PLAIN, 12));
		l7.setBounds(60, 380, 180, 80);
		panelCrear.add(l7);
				
		ventana_crear.setTitle("Hoteles GT - Administrador ");
		ventana_crear.setBounds(500, 150, 500, 600);
		ventana_crear.setLocationRelativeTo(null);
		ventana_crear.setVisible(true);
		ventana_crear.add(panelCrear);

		// textfield
		t1.setBounds(180, 100, 200, 30);
		t2.setBounds(180, 150, 200, 30);
		t3.setBounds(180, 200, 200, 30);
		t4.setBounds(180, 250, 200, 30);
		t5.setBounds(180, 300, 200, 30);
		t6.setBounds(180, 350, 200, 30);
		t7.setBounds(180, 400, 200, 30);

		t1.setText(tabla.getValueAt(seleccionar, 1).toString());
		t2.setText(tabla.getValueAt(seleccionar, 2).toString());
		t3.setText(tabla.getValueAt(seleccionar, 5).toString());
		t5.setText(tabla.getValueAt(seleccionar, 4).toString());
		
		panelCrear.add(t1);
		panelCrear.add(t2);
		panelCrear.add(t3);
		panelCrear.add(t4);
		panelCrear.add(t5);
		panelCrear.add(t6);
		panelCrear.add(t7);
		

		guardar.setText("Guardar");
		guardar.setBounds(100, 500, 100, 30);
		panelCrear.add(guardar);
		
		
		cancelar.setText("Cancelar");
		cancelar.setBounds(250, 500, 100, 30);
		panelCrear.add(cancelar);
		ActionListener elim = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana_crear.dispose();				
		}			
		};
		cancelar.addActionListener(elim);
		}else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");

		}
		tabla.clearSelection(); 
	
	}
	private void tabla() {
		List<Usuarios> lista = cl.listaUsuario();
		int x = 1;
		
		for (int i = 0; i < lista.size(); i++) {
			x=x+1;
		}
		Object[][] o = new Object[x][6];
		for (int i = 0; i < lista.size(); i++) {
			o[i][0] = lista.get(i).getUsuario_id();
			o[i][1] = lista.get(i).getNombre();
			o[i][2] = lista.get(i).getApellido();
			o[i][3] = lista.get(i).getRol_id();
			o[i][4] = lista.get(i).getCorreo();
			o[i][5] = lista.get(i).getTelefono();
		}
		String[] encabezados= {"No.","Nombre","Apellido","Rol","Correo","Tel�fono"};
		tabla =new JTable(o,encabezados);
		scroll= new JScrollPane(tabla);
		scroll.setBounds(20, 80, 800, 350);
	
	}

	public void ejecutar() {
		boton();
		tabla();
	}
}
