package models;

public class Cliente {
	private String DNI;
	private String Nombre;
	private String Apellidos;
	private int Telefono;
	private String email;

	public Cliente(String dNI, String nombre, String apellidos, int telefono, String email) {
		setDNI(dNI);
		setNombre(nombre);
		setApellidos(apellidos);
		setTelefono(telefono);
		setEmail(email);
	}

	public Cliente(String dNI, String nombre, String apellidos, int telefono) {
		setDNI(dNI);
		setNombre(nombre);
		setApellidos(apellidos);
		setTelefono(telefono);
	}

	public Cliente(String dNI) {
		setDNI(dNI);
	}

	public String getDNI() {
		return DNI;
	}

	private boolean setDNI(String dNI) {
		boolean bExito = false;
		if (dNI.length() == 9) {
			bExito = true;
			DNI = dNI;
		}
		return bExito;
	}

	public String getNombre() {
		return Nombre;
	}

	public boolean setNombre(String nombre) {
		boolean bExito = false;
		if (nombre.length() <= 30 && nombre.length() > 0) {
			bExito = true;
			Nombre = nombre;
		}
		return bExito;

	}

	public String getApellidos() {
		return Apellidos;
	}

	public boolean setApellidos(String apellidos) {
		boolean bExito = false;
		if (apellidos.length() <= 30 && apellidos.length() > 0) {
			bExito = true;
			Apellidos = apellidos;
		}
		return bExito;

	}

	public int getTelefono() {
		return Telefono;
	}

	public boolean setTelefono(int telefono) {
		boolean bExito = false;
		if (telefono == 9) {
			bExito = true;
			Telefono = telefono;
		}
		return bExito;

	}

	public String getEmail() {
		return email;
	}

	public boolean setEmail(String email) {
		boolean bExito = false;
		if (email.length() <= 40 && email.length() >= 10) {
			bExito = true;
			this.email = email;
		}
		return bExito;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Cliente other = (Cliente) obj;
		if (validaCliente() && other.validaCliente() && this.DNI.equals(other.DNI)) {
			bExito = true;
		}
		return bExito;
	}

	public boolean validaCliente() {
		boolean bExito = false;
		if (this.DNI != null && this.Nombre != null && this.Apellidos != null && this.email != null) {
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String toString() {
		String sResultado = "";
		sResultado += "DNI: " + DNI + "\n";
		sResultado += "Nombre: " + Nombre + "\n";
		sResultado += "Apellidos: " + Apellidos + "\n";
		sResultado += "Telefono: " + Telefono + "\n";
		sResultado += "email: " + email + "\n";
		return sResultado;
	}
}
