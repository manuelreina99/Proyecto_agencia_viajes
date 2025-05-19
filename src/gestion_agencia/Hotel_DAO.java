package gestion_agencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel_DAO {

	
	
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
	
	
	
	public Hotel_DAO() {
		conexion=conectar();
	}
	
	public List<Hotel> array() {
		
		List<Hotel> lista= new ArrayList<>();
		Hotel hotel=null;

		String sql= "SELECT * FROM hotel";
		try {
			PreparedStatement sentencia= conexion.prepareStatement(sql);
			ResultSet rs= sentencia.executeQuery();
			
			while(rs.next()) {
				
				
				int id_hotel= rs.getInt("id_hotel");
				String nombre= rs.getString("nombre");
				String direccion= rs.getString("direccion");
				String ciudad= rs.getString("ciudad");
				String provincia= rs.getString("provincia");
				String telefono= rs.getString("telefono");
				int numero_estrellas= rs.getInt("numero_estrellas");

				hotel = new Hotel(id_hotel, nombre, direccion, ciudad, provincia, telefono, numero_estrellas);
				lista.add(hotel);
				
				}
			
		} catch (SQLException ex) {
			// TODO: handle exception
			System.out.println("Error al consultar hoteles ");
			
		}
		return lista;
		
		
		}
}
