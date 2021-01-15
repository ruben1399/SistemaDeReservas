package models;

public interface iTematica {

	public int getId_Temat();

	public String getNombre();

	public boolean setNombre(String nombre);

	public String getDescripcion();

	public boolean setDescripcion(String descripcion);

	public boolean validaTematica();

	public String toString();

}