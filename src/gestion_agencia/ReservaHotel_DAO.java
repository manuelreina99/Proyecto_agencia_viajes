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



public class ReservaHotel_DAO {
	
	
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
	
	
	
	public ReservaHotel_DAO() {
		conexion=conectar();
	}
	
	
public void create(ReservaHotel reservaHotel) {
		
		
		
		String sql= "INSERT INTO pedidos VALUES (?,?,?,?,?,?,?); ";
		
		try {
			PreparedStatement sentencia= conexion.prepareStatement(sql);
			
			sentencia.setInt(1, reservaHotel.getId_reserva_hotel());
			sentencia.setInt(2, reservaHotel.getId_cliente());
			sentencia.setInt(3, reservaHotel.getId_hotel());
			sentencia.setInt(4, reservaHotel.getId_sucursal());
			sentencia.setDate(5, java.sql.Date.valueOf(reservaHotel.getFecha_entrada()));
			sentencia.setDate(6, java.sql.Date.valueOf(reservaHotel.getFecha_salida()));
			sentencia.setDate(7, java.sql.Date.valueOf(reservaHotel.getFecha_reserva()));
			
			int filasAfectadas= sentencia.executeUpdate();
			System.out.println("filas afectadas"+ filasAfectadas);
			
		} catch (SQLException ex) {
			// TODO: handle exception
			System.out.println("Error al insertar");
		}
		
}

public List<ReservaHotel> array() {
	
	List<ReservaHotel> lista= new ArrayList<>();
	ReservaHotel reservaHotel=null;
	String sql= "SELECT * FROM reservahotel";
	try {
		PreparedStatement sentencia= conexion.prepareStatement(sql);
		ResultSet rs= sentencia.executeQuery();
		
		while(rs.next()) {
			
			
			int id_reserva_hotel= rs.getInt("id_reserva_hotel");
			int id_cliente= rs.getInt("id_cliente");
			int id_hotel= rs.getInt("id_hotel");
			int id_sucursal= rs.getInt("id_sucursal");
			
			LocalDate fecha_entrada= rs.getDate("fecha_entrada").toLocalDate();
			LocalDate fecha_salida= rs.getDate("fecha_salida").toLocalDate();
			LocalDate fecha_reserva= rs.getDate("fecha_reserva").toLocalDate();
			

			
			reservaHotel= new ReservaHotel(id_reserva_hotel, id_cliente, id_hotel, id_sucursal, fecha_entrada, fecha_salida, fecha_reserva);
			lista.add(reservaHotel);
			
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

public void eliminar_pedido() {
	
	System.out.println("introduzca el numero del pedido");
	String numpedido = scanner.next();
	
	
	String sql= "DELETE FROM pedidos WHERE numpedido =? ";
	
	try {
		PreparedStatement sentencia= conexion.prepareStatement(sql);
		
		sentencia.setString(1, numpedido);
		
		int filasAfectadas= sentencia.executeUpdate();
		System.out.println("filas afectadas:"+ filasAfectadas);
		
	} catch (SQLException ex) {
		// TODO: handle exception
		System.out.println("Error al insertar");
	}
	
}

}
