package gestion_agencia;

import java.time.LocalDate;

public class ReservaHotel {
	
	private int id_reserva_hotel;
	private int id_cliente;
	private int id_hotel;
	private int id_sucursal;
	private LocalDate fecha_entrada;
	private LocalDate fecha_salida;
	private LocalDate fecha_reserva;
	
	
	public ReservaHotel(int id_reserva_hotel, int id_cliente, int id_hotel, int id_sucursal, LocalDate fecha_entrada,
			LocalDate fecha_salida, LocalDate fecha_reserva) {
		super();
		this.id_reserva_hotel = id_reserva_hotel;
		this.id_cliente = id_cliente;
		this.id_hotel = id_hotel;
		this.id_sucursal = id_sucursal;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.fecha_reserva = fecha_reserva;
	}


	/**
	 * @return the id_reserva_hotel
	 */
	public int getId_reserva_hotel() {
		return id_reserva_hotel;
	}


	/**
	 * @param id_reserva_hotel the id_reserva_hotel to set
	 */
	public void setId_reserva_hotel(int id_reserva_hotel) {
		this.id_reserva_hotel = id_reserva_hotel;
	}


	/**
	 * @return the id_cliente
	 */
	public int getId_cliente() {
		return id_cliente;
	}


	/**
	 * @param id_cliente the id_cliente to set
	 */
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}


	/**
	 * @return the id_hotel
	 */
	public int getId_hotel() {
		return id_hotel;
	}


	/**
	 * @param id_hotel the id_hotel to set
	 */
	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}


	/**
	 * @return the id_sucursal
	 */
	public int getId_sucursal() {
		return id_sucursal;
	}


	/**
	 * @param id_sucursal the id_sucursal to set
	 */
	public void setId_sucursal(int id_sucursal) {
		this.id_sucursal = id_sucursal;
	}


	/**
	 * @return the fecha_entrada
	 */
	public LocalDate getFecha_entrada() {
		return fecha_entrada;
	}


	/**
	 * @param fecha_entrada the fecha_entrada to set
	 */
	public void setFecha_entrada(LocalDate fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
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
	 * @return the fecha_reserva
	 */
	public LocalDate getFecha_reserva() {
		return fecha_reserva;
	}


	/**
	 * @param fecha_reserva the fecha_reserva to set
	 */
	public void setFecha_reserva(LocalDate fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}


	@Override
	public String toString() {
		return "ReservaHotel [id_reserva_hotel=" + id_reserva_hotel + ", id_cliente=" + id_cliente + ", id_hotel="
				+ id_hotel + ", id_sucursal=" + id_sucursal + ", fecha_entrada=" + fecha_entrada + ", fecha_salida="
				+ fecha_salida + ", fecha_reserva=" + fecha_reserva + "]";
	}
	
	
}
