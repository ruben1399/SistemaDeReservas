package models;

public interface iTarifa {

	public int getId_Tarifa();

	public int getPrecio();

	public boolean validaTarifa();

	public boolean setPrecio(int precio);

	public String toString();

}