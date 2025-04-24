package gestion_agencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestion_agencia {
	
	static	List<ReservaHotel> reservasHoteles= new ArrayList();
	static	List<ReservaVuelo> reservasVuelos= new ArrayList();
	static	Scanner scanner= new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion;
		do {
			System.out.println("1 reservar vuelo");
			System.out.println("2 reservar hotel");
			System.out.println("3 modificar reserva vuelo");
			System.out.println("4 modificar reserva hotel");
			System.out.println("5 eliminar reserva vuelo");
			System.out.println("6 eliminar reserva hotel");
			System.out.println("7 listar reservas ordenadas por fecha de realización ");
			System.out.println("10 buscar reservas por id cliente(hoteles y vuelos)");
			System.out.println("9 buscar vuelos por fecha");
			System.out.println("11 buscar vuelos disponibles");
			System.out.println("12 buscar vuelos por destino");
			opcion= scanner.nextInt();
		} while (opcion!=8);
		
	}

}
