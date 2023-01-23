package clases;

public class Persona2 {
	private String id;
	private String usuario;
	private String password;
	private String tipo;
	
	public Persona2(String id, String usuario, String password, String tipo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}