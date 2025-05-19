package gestion_agencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;






public class Gestion_agencia {
	
	static	Scanner scanner= new Scanner(System.in);
	static ReservaHotel_DAO reservaHotel_DAO= new ReservaHotel_DAO();
	static ReservaVuelo_DAO reservaVuelo_DAO= new ReservaVuelo_DAO();
	static Vuelo_DAO vuelo_DAO= new Vuelo_DAO();
	static Cliente_DAO cliente_DAO= new Cliente_DAO();
	static Hotel_DAO hotel_DAO= new Hotel_DAO();
	
	static	List<ReservaHotel> reservasHoteles= reservaHotel_DAO.array();
	static	List<ReservaVuelo> reservasVuelos= reservaVuelo_DAO.array();
	static List<Vuelo> lista_vuelos= vuelo_DAO.array();
	static List<Cliente> lista_clientes= cliente_DAO.array();
	static List<Hotel> lista_hoteles= hotel_DAO.array();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Bienvenido al sistema de gestión, introduzca id y contraseña");
		identificacion_cliente();
		
		int opcion;
		do {
			System.out.println("1 reservar vuelo");
			System.out.println("2 reservar hotel");
			System.out.println("3 modificar reserva hotel");
			System.out.println("4 eliminar reserva vuelo");
			System.out.println("5 eliminar reserva hotel");
			System.out.println("6 buscar reservas por id cliente(hoteles y vuelos)");
			System.out.println("7 listar reservas ordenadas por fecha de realización ");
			System.out.println("8 buscar vuelos por fecha");
			System.out.println("9 buscar vuelos disponibles");
			System.out.println("10 buscar vuelos por destino");
			System.out.println("11 buscar hoteles por destino ordenados por estrellas");
			System.out.println("12 Salir del programa");
			opcion= scanner.nextInt();
			
			switch (opcion) {
			case 1: {
				
				ReservaVuelo rs= reserva_vuelo();
				reservaVuelo_DAO.create(rs);
				break;
				
				
			}case 2:{
				ReservaHotel rs= reserva_hotel();
				reservaHotel_DAO.create(rs);
				break;
			}case 3:{
				reservaHotel_DAO.modificar();
				break;
			}case 4:{
				reservaVuelo_DAO.eliminar_reserva();
				break;
			}case 5:{
				reservaHotel_DAO.eliminar_reserva();
				break;
			}case 6:{
				buscar_reservas();
				break;
			}case 7:{
				buscar_reservas_ordenadas();
				break;
			}case 8:{
				buscar_vuelos_fecha();
				break;
			}case 9:{
				buscar_vuelos_disponibles();
				break;
			}case 10:{
				buscar_vuelos_destino();
				break;
			}case 11:{
				buscar_hoteles_por_destino();
				break;
			}
			default:
				throw new IllegalArgumentException("valor no valido: " + opcion);
			}
		} while (opcion!=12);
		System.out.println("ha salido del programa");
	}
	
	public static ReservaVuelo reserva_vuelo() {
		System.out.println("introduzca id de la reserva:");
		int id_reserva_vuelo= scanner.nextInt();
		System.out.println("introduzca id cliente");
		int id_cliente= scanner.nextInt();
		System.out.println("introduzca id vuelo");
		int id_vuelo= scanner.nextInt();
		System.out.println("introduzca el id de la sucursal");
		int id_sucursal= scanner.nextInt();
		System.out.println("introduzca clase turista o primera");
		String clase= scanner.next();
		System.out.println("introduzca fecha reserva");
		String fecha= scanner.next();
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyy");
		LocalDate fecha_final= LocalDate.parse(fecha, formatter);
		
		ReservaVuelo rs= new ReservaVuelo(id_reserva_vuelo, id_cliente, id_vuelo, id_sucursal, clase, fecha_final);
		return rs;
	}
	
	public static ReservaHotel reserva_hotel() {
		System.out.println("introduzca id de la reserva");
		int id_reserva_hotel= scanner.nextInt();
		System.out.println("introduzca el id de cliente");
		int id_cliente=scanner.nextInt();
		System.out.println("introduzca id del hotel");
		int id_hotel= scanner.nextInt();
		System.out.println("introduzca el id de la sucursal");
		int id_sucursal=scanner.nextInt();
		
		System.out.println("introduzca fecha de entrada");
		String fecha= scanner.next();
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyy");
		LocalDate fecha_final= LocalDate.parse(fecha, formatter);
		
		System.out.println("introduzca fecha de salida");
		String fecha1= scanner.next();
		DateTimeFormatter formatter1= DateTimeFormatter.ofPattern("dd/MM/yyy");
		LocalDate fecha_final1= LocalDate.parse(fecha, formatter);
		
		ReservaHotel rs= new ReservaHotel(id_reserva_hotel, id_cliente, id_hotel, id_sucursal, fecha_final, fecha_final1);
		
		return rs;
		
	}
	
	public static void buscar_reservas() {
		
		
		System.out.println("introduzca su id de cliente");
		int id_cliente= scanner.nextInt();
		
		List<ReservaVuelo> lista_vuelos= reservasVuelos.stream()
				.filter(v->v.getId_cliente()==id_cliente)
				.collect(Collectors.toList());
		
		List<ReservaHotel> lista_hoteles= reservasHoteles.stream()
				.filter(v->v.getId_cliente()==id_cliente)
				.collect(Collectors.toList());
		
		System.out.println("Estas son sus reservas de vuelos:");
		lista_vuelos.forEach(System.out::println);
		
		System.out.println("Estas son sus reservas de hoteles:");
		lista_hoteles.forEach(System.out::println);
		
		
		
		
	}
	
	public static void buscar_reservas_ordenadas() {
		
		System.out.println("introduzca su id de cliente");
		int id_cliente= scanner.nextInt();
		
		List<ReservaVuelo> lista_vuelos= reservasVuelos.stream()
				.filter(v->v.getId_cliente()==id_cliente)
				.sorted(Comparator.comparing(ReservaVuelo::getFecha_reserva))
				.collect(Collectors.toList());
				
		
		List<ReservaHotel> lista_hoteles= reservasHoteles.stream()
				.filter(v->v.getId_cliente()==id_cliente)
				.sorted(Comparator.comparing(ReservaHotel::getFecha_reserva))
				.collect(Collectors.toList());
		
		System.out.println("Estas son sus reservas de vuelos ordenadas por fecha de reserva:");
		lista_vuelos.forEach(System.out::println);
		
		System.out.println("Estas son sus reservas de hoteles ordenadas por fecha de reserva:");
		lista_hoteles.forEach(System.out::println);
	}
	
	public static void buscar_vuelos_disponibles() {
		
		lista_vuelos.stream()
		.filter(v-> v.getNumero_plazas_totales()>0)
		.forEach(System.out::println);
		
		
		
	}
	
	public static void buscar_vuelos_destino() {
		
		System.out.println("Esta es la lista de destinos disponibles:"+ " \n");
		 lista_vuelos.stream()
			.forEach(v -> System.out.println(v.getDestino() ));
		
		System.out.println("\n Introduzca destino:");
		String destino= scanner.next();
		
		lista_vuelos.stream()
		.filter(v-> v.getDestino().equalsIgnoreCase(destino))
		.forEach(System.out::println);
		
	}
	
	public static void buscar_vuelos_fecha() {
		
		
		
		System.out.println("\n Introduzca la fecha:");
		String fecha= scanner.next();
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyy");
		LocalDate fecha_final= LocalDate.parse(fecha, formatter);
		
		lista_vuelos.stream()
		.filter(v-> v.getFecha_salida()==fecha_final)
		.forEach(System.out::println);
		
	}
	
	public static void buscar_hoteles_por_destino() {
		
		System.out.println("Esta es la lista de destinos disponibles:"+ " \n");
		 lista_hoteles.stream()
			.forEach(v -> System.out.println(v.getCiudad() ));
		
		System.out.println("\n Introduzca destino:");
		String destino= scanner.next();
		
		lista_hoteles.stream()
		.filter(v-> v.getCiudad().equalsIgnoreCase(destino))
		.sorted(Comparator.comparing(Hotel::getNumero_estrellas))
		.forEach(System.out::println);
		
	}
	
	public static void identificacion_cliente() {
		
		System.out.println("introduzca id cliente: ");
		int id_cliente= scanner.nextInt();
		System.out.println("introduzca contraseña: ");
		String nif=scanner.next();
		
		for(int i=0; i<lista_clientes.size();i++) {
			if (lista_clientes.get(i).getId_cliente()== id_cliente && lista_clientes.get(i).getNIF().equalsIgnoreCase(nif)) {
				
				System.out.println("verificacion completada");
				break;
			}else {
				throw new IllegalArgumentException("usuario o contraseña incorrecto");
			}
		}
		
	}

}
