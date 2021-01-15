package models;

public interface iJuego {

	public int getId_Juego();

	public boolean setId_Juego(int id_Juego);

	public String getNombre();

	public boolean setNombre(String nombre);

	public iHorario getoHorario();

	public void setoHorario(iHorario oHorario);

	public iTematica getoTematica();

	public void setoTematica(iTematica oTematica);

	public iTarifa getoTarifa();

	public void setoTarifa(iTarifa oTarifa);

	public boolean validaJuego();

	public String toString();

}