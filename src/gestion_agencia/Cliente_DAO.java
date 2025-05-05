package gestion_agencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente_DAO {
	
	private Connection conexion;
	public static Scanner scanner= new Scanner(System.in);
	
	
	private Connection conectar() {
		
		Connection con= null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/agencia_viajes","root","root");
			System.out.println("Conexion ok");
		}catch (SQLException ex) {
			System.out.println("error de conexion");
			
		}
		return con;
			
	}
	
	
	
	public Cliente_DAO() {
		conexion=conectar();
	}
	
	public List<Cliente> array() {
		
		List<Cliente> lista= new ArrayList<>();
		Cliente cliente=null;
		String sql= "SELECT * FROM cliente";
		try {
			PreparedStatement sentencia= conexion.prepareStatement(sql);
			ResultSet rs= sentencia.executeQuery();
			
			while(rs.next()) {
				
				
				int id_cliente= rs.getInt("id_cliente");
				String NIF= rs.getString("NIF");
				String nombre= rs.getString("nombre");
				String apellidos= rs.getString("apellidos");
				String telefono= rs.getString("telefono");
				String email= rs.getString("email");

				
				cliente= new Cliente(id_cliente, NIF, nombre, apellidos, telefono, email);
				lista.add(cliente);
				
				}
			
		} catch (SQLException ex) {
			// TODO: handle exception
			System.out.println("Error al consultar clientes ");
			
		}
		return lista;
		
		
		}

}
