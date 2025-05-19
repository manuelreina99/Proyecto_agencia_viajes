package gestion_agencia;

import java.time.LocalDate;

public class ReservaVuelo {
	
	private int id_reserva_vuelo;
	private int id_cliente;
	private int id_vuelo;
	private int id_sucursal;
	private String clase;
	private LocalDate fecha_reserva;
	
	
	/**
	 * @return the clase
	 */
	public String getClase() {
		return clase;
	}
	/**
	 * @param clase the clase to set
	 */
	public void setClase(String clase) {
		this.clase = clase;
	}
	/**
	 * @return the id_reserva_vuelo
	 */
	public int getId_reserva_vuelo() {
		return id_reserva_vuelo;
	}
	/**
	 * @param id_reserva_vuelo the id_reserva_vuelo to set
	 */
	public void setId_reserva_vuelo(int id_reserva_vuelo) {
		this.id_reserva_vuelo = id_reserva_vuelo;
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
	
	public ReservaVuelo(int id_reserva_vuelo, int id_cliente, int id_vuelo, int id_sucursal, String clase,
			LocalDate fecha_reserva) {
		super();
		this.id_reserva_vuelo = id_reserva_vuelo;
		this.id_cliente = id_cliente;
		this.id_vuelo = id_vuelo;
		this.id_sucursal = id_sucursal;
		this.clase = clase;
		this.fecha_reserva = fecha_reserva;
	}
	@Override
	public String toString() {
		return "ReservaVuelo [id_reserva_vuelo=" + id_reserva_vuelo + ", id_cliente=" + id_cliente + ", id_vuelo="
				+ id_vuelo + ", id_sucursal=" + id_sucursal + ", fecha_reserva=" + fecha_reserva + "]";
	}
	
	
	

}
