package gestion_agencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



public class Gestion_agencia {
	
	static	Scanner scanner= new Scanner(System.in);
	static ReservaHotel_DAO reservaHotel_DAO= new ReservaHotel_DAO();
	static ReservaVuelo_DAO reservaVuelo_DAO= new ReservaVuelo_DAO();
	static Vuelo_DAO vuelo_DAO= new Vuelo_DAO();
	static Cliente_DAO cliente_DAO= new Cliente_DAO();
	
	static	List<ReservaHotel> reservasHoteles= reservaHotel_DAO.array();
	static	List<ReservaVuelo> reservasVuelos= reservaVuelo_DAO.array();
	static List<Vuelo> lista_vuelos= vuelo_DAO.array();
	static List<Cliente> lista_clientes= cliente_DAO.array();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Bienvenido al sistema de gestión, introduzca id y contraseña");
		identificacion_cliente();
		
		int opcion;
		do {
			System.out.println("1 reservar vuelo");
			System.out.println("2 reservar hotel");
			System.out.println("3 modificar reserva vuelo");
			System.out.println("4 modificar reserva hotel");
			System.out.println("5 eliminar reserva vuelo");
			System.out.println("6 eliminar reserva hotel");
			System.out.println("7 listar reservas ordenadas por fecha de realización ");
			System.out.println("8 buscar reservas por id cliente(hoteles y vuelos)");
			System.out.println("9 buscar vuelos por fecha");
			System.out.println("11 buscar vuelos disponibles");
			System.out.println("12 buscar vuelos por destino");
			opcion= scanner.nextInt();
			
			switch (opcion) {
			case 1: {
					
				break;
			}case 11:{
				
				buscar_vuelos_disponibles();
				
				break;
				
			}case 12:{
				
				buscar_vuelos_destino();
				
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
		} while (opcion!=8);
		
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
