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

public class Vuelo_DAO {

	
	
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
	
	
	
	public Vuelo_DAO() {
		conexion=conectar();
	}
	
	public List<Vuelo> array() {
		
		List<Vuelo> lista= new ArrayList<>();
		Vuelo vuelo=null;
		String sql= "SELECT * FROM vuelo";
		try {
			PreparedStatement sentencia= conexion.prepareStatement(sql);
			ResultSet rs= sentencia.executeQuery();
			
			while(rs.next()) {
				
				
				int id_vuelo= rs.getInt("id_vuelo");
				LocalDate fecha_salida= rs.getDate("fecha_salida").toLocalDate();
				LocalDate fecha_llegada= rs.getDate("fecha_llegada").toLocalDate();
				String origen= rs.getString("origen");
				String destino= rs.getString("destino");
				int numero_plazas_totales= rs.getInt("numero_plazas_totales");

				
				vuelo= new Vuelo(id_vuelo, fecha_salida, fecha_llegada, origen, destino, numero_plazas_totales);
				lista.add(vuelo);
				
				}
			
		} catch (SQLException ex) {
			// TODO: handle exception
			System.out.println("Error al consultar vuelos ");
			
		}
		return lista;
		
		
		}
}
