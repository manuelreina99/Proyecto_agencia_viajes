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

public class ReservaVuelo_DAO {
	
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
	
	
	
	public ReservaVuelo_DAO() {
		conexion=conectar();
	}
	
	
public void create(ReservaVuelo reservaVuelo) {
		
		
		
		String sql= "INSERT INTO reservavuelo VALUES (?,?,?,?,?,?); ";
		
		try {
			PreparedStatement sentencia= conexion.prepareStatement(sql);
			
			sentencia.setInt(1, reservaVuelo.getId_reserva_vuelo());
			sentencia.setInt(2, reservaVuelo.getId_cliente());
			sentencia.setInt(3, reservaVuelo.getId_vuelo());
			sentencia.setInt(4, reservaVuelo.getId_sucursal());
			sentencia.setString(5, reservaVuelo.getClase());
			sentencia.setDate(6, java.sql.Date.valueOf(reservaVuelo.getFecha_reserva()));
			
			
			int filasAfectadas= sentencia.executeUpdate();
			System.out.println("filas afectadas"+ filasAfectadas);
			
		} catch (SQLException ex) {
			// TODO: handle exception
			System.out.println("Error al insertar");
		}
		
}

public List<ReservaVuelo> array() {
	
	List<ReservaVuelo> lista= new ArrayList<>();
	ReservaVuelo reservaVuelo=null;
	String sql= "SELECT * FROM reservaVuelo";
	try {
		PreparedStatement sentencia= conexion.prepareStatement(sql);
		ResultSet rs= sentencia.executeQuery();
		
		while(rs.next()) {
			
			
			int id_reserva_vuelo= rs.getInt("id_reserva_vuelo");
			int id_cliente= rs.getInt("id_cliente");
			int id_vuelo= rs.getInt("id_vuelo");
			int id_sucursal= rs.getInt("id_sucursal");
			String clase= rs.getString("clase");
			
			
			

			
			reservaVuelo= new ReservaVuelo(id_reserva_vuelo, id_cliente, id_vuelo, id_sucursal, clase);
			lista.add(reservaVuelo);
			
			}
		
	} catch (SQLException ex) {
		// TODO: handle exception
		System.out.println("Error al consultar reservas ");
		
	}
	return lista;
	
	
	}

public void modificar() {
	
	System.out.println("introduzca numero de reserva");
	int numpedido= scanner.nextInt();
	
	
	
	System.out.println("introduzca id resp");
	int resp= scanner.nextInt();
	
	
		
		
		String sql=  "UPDATE pedidos SET   resp=?  WHERE numpedido = ?";
		try {
			PreparedStatement sentencia= conexion.prepareStatement(sql);
			
			sentencia.setInt(2, numpedido);
			
			sentencia.setInt(1, resp);
			
			
			
			int filasAfectadas= sentencia.executeUpdate();
			
			if (filasAfectadas>0) {
				System.out.println("se ha modificado");
			}else {
				System.out.println("no se ha modificado nada");
			}
						
			
		} catch (SQLException ex) {
			// TODO: handle exception
			System.out.println("Error al consultar un pedido");
			
		}
		
	}

public void eliminar_reserva() {
	
	System.out.println("introduzca el id de reserva");
	int id = scanner.nextInt();
	
	
	String sql= "DELETE FROM reservavuelo WHERE id_reserva_vuelo =? ";
	
	try {
		PreparedStatement sentencia= conexion.prepareStatement(sql);
		
		sentencia.setInt(1, id);
		
		int filasAfectadas= sentencia.executeUpdate();
		System.out.println("filas afectadas:"+ filasAfectadas);
		
	} catch (SQLException ex) {
		// TODO: handle exception
		System.out.println("Error al insertar");
	}
	
}
	
}
