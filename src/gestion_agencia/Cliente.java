package gestion_agencia;

public class Cliente {
	
	private int id_cliente;
	private String NIF;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	
	
	public Cliente(int id_cliente, String nIF, String nombre, String apellidos, String telefono, String email) {
		super();
		this.id_cliente = id_cliente;
		NIF = nIF;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
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
	 * @return the nIF
	 */
	public String getNIF() {
		return NIF;
	}


	/**
	 * @param nIF the nIF to set
	 */
	public void setNIF(String nIF) {
		NIF = nIF;
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
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}


	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
