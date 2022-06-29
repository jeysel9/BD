package HotelesGt;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
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
	JButton Agregar  = new JButton();
	JButton salir = new JButton();
	JButton Modificar  = new JButton();
	JButton Eliminar = new JButton();
	JTable tabla = new JTable();
	JScrollPane scroll = new JScrollPane();
	JButton guardar = new JButton();
	JButton cancelar = new JButton();
	Conexion con = new Conexion();
	Clientes cl = new Clientes();
	Usuarios u = new Usuarios();
	Object[][] clientes = new Object[100][6];

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
		Connection conexion = con.Conectar();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("No");//1
		model.addColumn("Nombre");//2
		model.addColumn("Apellido");//3
		model.addColumn("Teléfono");//4		
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
		JRadioButton inactivo = new JRadioButton("inactivo", false);
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

		l3.setText("Teléfono");
		l3.setFont(new Font("Serig", Font.PLAIN, 12));
		l3.setBounds(60, 180, 100, 80);
		panelCrear.add(l3);

		l4.setText("Dirección");
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

		l7.setText("Contraseña");
		l7.setFont(new Font("Serig", Font.PLAIN, 12));
		l7.setBounds(60, 380, 180, 80);
		panelCrear.add(l7);

		
		
		ventana_crear.setTitle("Hoteles GT - Administrador ");
		ventana_crear.setBounds(500, 150, 500, 600);
		ventana_crear.setLocationRelativeTo(null);
		ventana_crear.setVisible(true);
		
		ventana_crear.add(panelCrear);

		// textfield
		t6.setText("[dd-mm-yy]");
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
					
					cl.agregar(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()),t4.getText(), t5.getText(), t6.getText(),2,u.getActivo(),t7.getText());
					JOptionPane.showMessageDialog(null, "se agregó un nuevo usiario...");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
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
		
				ventana_crear.setVisible(false);
				
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

		l3.setText("Teléfono");
		l3.setFont(new Font("Serig", Font.PLAIN, 12));
		l3.setBounds(60, 180, 100, 80);
		panelCrear.add(l3);

		l4.setText("Dirección");
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

		l7.setText("Contraseña");
		l7.setFont(new Font("Serig", Font.PLAIN, 12));
		l7.setBounds(60, 380, 180, 80);
		panelCrear.add(l7);
		
		ventana_crear.setTitle("Hoteles GT - Administrador ");
		ventana_crear.setBounds(500, 150, 500, 600);
		ventana_crear.setLocationRelativeTo(null);
		ventana_crear.setVisible(true);
		
		ventana_crear.add(panelCrear);

		// textfield
		t6.setText("[dd-mm-yy]");
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
		ActionListener funcion_modificar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Usuarios> lista = cl.listaUsuario();
				int p = tabla.getSelectedRow();
				cl.modificar(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()),t4.getText(), t5.getText(), t6.getText(),2,u.getActivo(),t7.getText());
				JOptionPane.showMessageDialog(null, "se agregó un nuevo usiario...");
				t1.setText(u.getNombre());
				t2.setText(u.getApellido());
			//	t3.setText(u.getTelefono().);
				t4.setText(u.getDireccion());
				t5.setText(u.getCorreo());
				t6.setText(u.getFecha_nacimiento());
				t7.setText(u.getContrasena());
		
			}
			
		};
		guardar.addActionListener(funcion_modificar);
		
		cancelar.setText("Cancelar");
		cancelar.setBounds(250, 500, 100, 30);
		panelCrear.add(cancelar);
		ActionListener elim = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
				ventana_crear.setVisible(false);
				
		}
			
		};
		cancelar.addActionListener(elim);
		}}
	
	private void eliminar() {
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

		l3.setText("Teléfono");
		l3.setFont(new Font("Serig", Font.PLAIN, 12));
		l3.setBounds(60, 180, 100, 80);
		panelCrear.add(l3);

		l4.setText("Dirección");
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

		l7.setText("Contraseña");
		l7.setFont(new Font("Serig", Font.PLAIN, 12));
		l7.setBounds(60, 380, 180, 80);
		panelCrear.add(l7);
				
		ventana_crear.setTitle("Hoteles GT - Administrador ");
		ventana_crear.setBounds(500, 150, 500, 600);
		ventana_crear.setLocationRelativeTo(null);
		ventana_crear.setVisible(true);
		ventana_crear.add(panelCrear);

		// textfield
		t6.setText("[dd-mm-yy]");
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
		
		
		cancelar.setText("Cancelar");
		cancelar.setBounds(250, 500, 100, 30);
		panelCrear.add(cancelar);
		ActionListener elim = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
				ventana_crear.setVisible(false);
		}
			
		};
		cancelar.addActionListener(elim);
	}
	public void ejecutar() {
		boton();
		mostrar();
		
	}
}
