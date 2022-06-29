package HotelesGt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class Clientes {

	int r;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	Conexion acceso = new Conexion();
	Usuarios pro = new Usuarios();
		
	public List listaUsuario() {
		String sql = " select * from usuarios";
		List<Usuarios> listap = new ArrayList<>();
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Usuarios p = new Usuarios();
				p.setUsuario_id(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setApellido(rs.getString(3));
				p.setTelefono(rs.getInt(4));
				p.setDireccion(rs.getString(5));
				p.setCorreo(rs.getString(6));
				p.setFecha_nacimiento(rs.getString(7));
				p.setRol_id(rs.getInt(8));
				p.setActivo(rs.getInt(9));
				p.setContrasena(rs.getString(10));
				listap.add(p);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return listap;
		
	}
	public void agregar (String nombre, String apellido, int telefono,String direccion, String correo, String fecha_nacimiento, int rol_id, int activo, String contraseña) {
		String sql = "insert into usuarios(nombre,apellido,telefono,direccion,correo_electronico,fecha_nacimiento,rol_id,activo,contrasenia) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			con = acceso.Conectar();
			ps =con.prepareStatement(sql);
			
			ps.setString(1,nombre);
			ps.setString(2,apellido);
			ps.setInt(3,telefono);
			ps.setString(4,direccion);
			ps.setString(5,correo);
			ps.setString(6,fecha_nacimiento);
			ps.setInt(7,rol_id);
			ps.setInt(8,activo);
			ps.setString(9,contraseña);
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void modificar (String nombre, String apellido, int telefono,String direccion, String correo, String fecha_nacimiento, int rol_id, int activo, String contraseña) {
		String sql = "update usuarios set nombre=?,apellido,telefono=?,direccion=?,correo_electronico=?,fecha_nacimiento=?"
				+ ",rol_id=?,activo=?,contrasenia=? where usuario_id= ?";
		try {
			con = acceso.Conectar();
			ps =con.prepareStatement(sql);
			
			ps.setString(1,nombre);
			ps.setString(2,apellido);
			ps.setInt(3,telefono);
			ps.setString(4,direccion);
			ps.setString(5,correo);
			ps.setString(6,fecha_nacimiento);
			ps.setInt(7,rol_id);
			ps.setInt(8,activo);
			ps.setString(9,contraseña);
			//ps.setInt(10, usuario_id);
			ps.executeUpdate();
				
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void eliminar(int id) {
		String sql = "delete from usuarios where usuario_id = ?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		Clientes cl = new Clientes();
		//cl.agregar("ana", "perez", 45789632, "km 65", "ap@gmail.com", "1980-02-17", 2, 1, "asd123");
	
	}
	
	
}
