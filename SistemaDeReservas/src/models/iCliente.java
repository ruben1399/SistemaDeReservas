package models;

public interface iCliente {

	public String getDNI();

	public String getNombre();

	public boolean setNombre(String nombre);

	public String getApellidos();

	public boolean setApellidos(String apellidos);

	public int getTelefono();

	public boolean setTelefono(int telefono);

	public String getEmail();

	public boolean setEmail(String email);

	public int hashCode();

	public boolean equals(Object obj);

	public boolean validaCliente();

	public String toString();

}