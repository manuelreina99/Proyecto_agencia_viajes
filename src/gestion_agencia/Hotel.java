package gestion_agencia;

public class Hotel {

	private int id_hotel;
	private String nombre;
	private String direccion;
	private String ciudad;
	private String provincia;
	private String telefono;
	private int numero_estrellas;
	
	
	public Hotel(int id_hotel, String nombre, String direccion, String ciudad, String provincia, String telefono,
			int numero_estrellas) {
		super();
		this.id_hotel = id_hotel;
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.numero_estrellas = numero_estrellas;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}


	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}


	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}


	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}


	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * @return the numero_estrellas
	 */
	public int getNumero_estrellas() {
		return numero_estrellas;
	}


	/**
	 * @param numero_estrellas the numero_estrellas to set
	 */
	public void setNumero_estrellas(int numero_estrellas) {
		this.numero_estrellas = numero_estrellas;
	}


	@Override
	public String toString() {
		return "Hotel [id_hotel=" + id_hotel + ", nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad
				+ ", provincia=" + provincia + ", telefono=" + telefono + ", numero_estrellas=" + numero_estrellas
				+ "]";
	}
	
	
	
}
