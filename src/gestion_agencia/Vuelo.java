package gestion_agencia;

import java.time.LocalDate;

public class Vuelo {
	
	private int id_vuelo;
	private LocalDate fecha_salida;
	private LocalDate fecha_llegada;
	private String origen;
	private String destino; 
	private int numero_plazas_totales;
	
	
	public Vuelo(int id_vuelo, LocalDate fecha_salida, LocalDate fecha_llegada, String origen, String destino,
			int numero_plazas_totales) {
		super();
		this.id_vuelo = id_vuelo;
		this.fecha_salida = fecha_salida;
		this.fecha_llegada = fecha_llegada;
		this.origen = origen;
		this.destino = destino;
		this.numero_plazas_totales = numero_plazas_totales;
	}


	/**
	 * @return the id_vuelo
	 */
	public int getId_vuelo() {
		return id_vuelo;
	}


	/**
	 * @param id_vuelo the id_vuelo to set
	 */
	public void setId_vuelo(int id_vuelo) {
		this.id_vuelo = id_vuelo;
	}


	/**
	 * @return the fecha_salida
	 */
	public LocalDate getFecha_salida() {
		return fecha_salida;
	}


	/**
	 * @param fecha_salida the fecha_salida to set
	 */
	public void setFecha_salida(LocalDate fecha_salida) {
		this.fecha_salida = fecha_salida;
	}


	/**
	 * @return the fecha_llegada
	 */
	public LocalDate getFecha_llegada() {
		return fecha_llegada;
	}


	/**
	 * @param fecha_llegada the fecha_llegada to set
	 */
	public void setFecha_llegada(LocalDate fecha_llegada) {
		this.fecha_llegada = fecha_llegada;
	}


	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}


	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}


	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}


	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}


	/**
	 * @return the numero_plazas_totales
	 */
	public int getNumero_plazas_totales() {
		return numero_plazas_totales;
	}


	/**
	 * @param numero_plazas_totales the numero_plazas_totales to set
	 */
	public void setNumero_plazas_totales(int numero_plazas_totales) {
		this.numero_plazas_totales = numero_plazas_totales;
	}


	@Override
	public String toString() {
		return "Vuelo [id_vuelo=" + id_vuelo + ", fecha_salida=" + fecha_salida + ", fecha_llegada=" + fecha_llegada
				+ ", origen=" + origen + ", destino=" + destino + ", numero_plazas_totales=" + numero_plazas_totales
				+ "]";
	}
	
	
	
	
	
}
