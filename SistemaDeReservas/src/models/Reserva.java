package models;

public class Reserva {
	private int Id_Reserva;
	private String Horas;
	private Cliente oCliente;
	private Juego oJuego;

	public Reserva(int id_Reserva, String horas, Cliente oCliente, Juego oJuego) {
		setId_Reserva(id_Reserva);
		setHoras(horas);
		setoCliente(oCliente);
		setoJuego(oJuego);

	}
	
	public Reserva(int id_Reserva) {
		setId_Reserva(id_Reserva);

	}
	public Reserva(int id_Reserva, String horas) {
		setId_Reserva(id_Reserva);
		setHoras(horas);

	}
	public boolean validaReserva() {
		boolean bExito = false;
		if (this.Id_Reserva < 0 && this.Horas != null && oCliente.getDNI() != null && this.oJuego.getId_Juego() < 0) {
			bExito = true;
		}
		return bExito;
	}

	public int getId_Reserva() {
		return Id_Reserva;
	}

	private boolean setId_Reserva(int id_Reserva) {
		boolean bExito = false;
		if (id_Reserva < 999) {
			bExito = true;
			Id_Reserva = id_Reserva;
		}
		return bExito;
	}

	public String getHoras() {
		return Horas;
	}

	public boolean setHoras(String horas) {
		boolean bExito = false;
		if (horas.length() == 5) {
			bExito = true;
			Horas = horas;
		}
		return bExito;

	}

	public Cliente getoCliente() {
		return oCliente;
	}

	public void setoCliente(Cliente oCliente) {
		this.oCliente = oCliente;
	}

	public Juego getoJuego() {
		return oJuego;
	}

	public void setoJuego(Juego oJuego) {
		this.oJuego = oJuego;
	}

	@Override
	public String toString() {
		String sResultado = "";
		sResultado += "ID: " + Id_Reserva + "\n";
		sResultado += "Horas: " + Horas + "\n";
		sResultado += "Cliente: " + oCliente + "\n";
		sResultado += "Juego: " + oJuego + "\n";

		return sResultado;
	}
}
