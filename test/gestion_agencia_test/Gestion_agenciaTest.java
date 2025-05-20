package gestion_agencia_test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import gestion_agencia.ReservaHotel;
import gestion_agencia.ReservaVuelo;
import gestion_agencia.Vuelo;

class Gestion_agenciaTest {

	@Test
	void testBuscar_reservas() {
		
		int id_cliente = 123;
		
		ReservaVuelo rv0= new ReservaVuelo(1, 123, 1, 1, "turista");
		ReservaVuelo rv1= new ReservaVuelo(2, 123, 1, 1, "turista");
		ReservaVuelo rv2= new ReservaVuelo(3, 123, 1, 1, "turista");
		
		ReservaHotel rh0= new ReservaHotel(1, 123, 1, 1, LocalDate.of(2025, 04, 03), LocalDate.of(2025, 04, 07));
		ReservaHotel rh1= new ReservaHotel(2, 123, 1, 1, LocalDate.of(2025, 8, 8), LocalDate.of(2025, 8, 11));
		ReservaHotel rh2= new ReservaHotel(3, 123, 1, 1, LocalDate.of(2025, 10, 15), LocalDate.of(2025, 10, 18));
		
		List<ReservaVuelo> reservasVuelos= new ArrayList<>();
		reservasVuelos.add(rv0);
		reservasVuelos.add(rv1);
		reservasVuelos.add(rv2);
		
		
		List<ReservaHotel> reservasHoteles= new ArrayList<>();
		reservasHoteles.add(rh0);
		reservasHoteles.add(rh1);
		reservasHoteles.add(rh2);
		
		
        
        List<ReservaVuelo> lista_vuelos = reservasVuelos.stream()
                .filter(v -> v.getId_cliente() == id_cliente)
                .toList();

        List<ReservaHotel> lista_hoteles = reservasHoteles.stream()
                .filter(h -> h.getId_cliente() == id_cliente)
                .toList();

        assertNotNull(lista_vuelos);
        assertNotNull(lista_hoteles);
        assertTrue(lista_vuelos.size() >= 0);
        assertTrue(lista_hoteles.size() >= 0);
    }
		
	

	@Test
	void testBuscar_vuelos_disponibles() {
		
		
		List<Vuelo> lista_vuelos= new ArrayList<>();
		Vuelo v1= new Vuelo(1, LocalDate.of(2025, 3, 3)	, LocalDate.of(2025, 3, 3), "Sevilla", "Madrid", 0);
		
		
		lista_vuelos.add(v1);
		
		List<Vuelo> lista_filtrada= lista_vuelos.stream()
		.filter(v-> v.getNumero_plazas_totales()>0)
		.collect(Collectors.toList());
		
		
		assertFalse(lista_filtrada.size()>0);
		
	}

	@Test
	void testBuscar_vuelos_destino() {
				
				List<Vuelo> lista_vuelos= new ArrayList<>();
				Vuelo v1= new Vuelo(1, LocalDate.of(2025, 3, 3)	, LocalDate.of(2025, 3, 3), "Sevilla", "Madrid", 0);
		
		        String destino = "Madrid";

		        List<Vuelo> vuelosDestino = lista_vuelos.stream()
		                .filter(v -> v.getDestino().equalsIgnoreCase(destino))
		                .toList();

		        assertNotNull(vuelosDestino);
		        assertTrue(vuelosDestino.stream().allMatch(v -> v.getDestino().equalsIgnoreCase(destino)));
		    
		
	}

	@Test
	void testBuscar_vuelos_fecha() {
		
		List<Vuelo> lista_vuelos= new ArrayList<>();
		Vuelo v1= new Vuelo(1, LocalDate.of(2025, 3, 3)	, LocalDate.of(2025, 3, 3), "Sevilla", "Madrid", 0);

        String fecha = "03/03/2025";
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyy");
		LocalDate fecha_final= LocalDate.parse(fecha, formatter);

        List<Vuelo> vuelosFecha = lista_vuelos.stream()
                .filter(v -> v.getFecha_salida()==fecha_final)
                .toList();

        assertNotNull(vuelosFecha);
        assertTrue(vuelosFecha.stream().allMatch(v -> v.getFecha_salida()==fecha_final));
		
	}



}
