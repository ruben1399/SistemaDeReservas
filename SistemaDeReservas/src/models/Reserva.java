package models;

public class Reserva implements iReserva {
	private int Id_Reserva;
	private String Horas;
	private iCliente oCliente;
	private iJuego oJuego;

	public Reserva(int id_Reserva, String horas, iCliente oCliente, iJuego oJuego) {
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
	@Override
	public boolean validaReserva() {
		boolean bExito = false;
		if (this.Id_Reserva < 0 && this.Horas != null && oCliente.getDNI() != null && this.oJuego.getId_Juego() < 0) {
			bExito = true;
		}
		return bExito;
	}

	@Override
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

	@Override
	public String getHoras() {
		return Horas;
	}

	@Override
	public boolean setHoras(String horas) {
		boolean bExito = false;
		if (horas.length() == 5) {
			bExito = true;
			Horas = horas;
		}
		return bExito;

	}

	@Override
	public iCliente getoCliente() {
		return oCliente;
	}

	@Override
	public void setoCliente(iCliente oCliente) {
		this.oCliente = oCliente;
	}

	@Override
	public iJuego getoJuego() {
		return oJuego;
	}

	@Override
	public void setoJuego(iJuego oJuego) {
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
