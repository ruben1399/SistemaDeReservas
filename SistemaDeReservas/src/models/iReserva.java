package models;

public interface iReserva {

	public boolean validaReserva();

	public int getId_Reserva();

	public String getHoras();

	public boolean setHoras(String horas);

	public iCliente getoCliente();

	public void setoCliente(iCliente oCliente);

	public iJuego getoJuego();

	public void setoJuego(iJuego oJuego);

	public String toString();

}