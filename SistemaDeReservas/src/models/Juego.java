package models;

public class Juego implements iJuego {
	private int Id_Juego;
	private String Nombre;
	private iHorario oHorario;
	private iTematica oTematica;
	private iTarifa oTarifa;

	public Juego(int id_Juego, String nombre, iHorario oHorario, iTematica oTematica, iTarifa oTarifa) {
		setId_Juego(id_Juego);
		setNombre(nombre);
		setoHorario(oHorario);
		setoTematica(oTematica);
		setoTarifa(oTarifa);
	}

	public Juego(int id_Juego, String nombre) {
		setId_Juego(id_Juego);
		setNombre(nombre);
	}

	public Juego(int id_Juego) {
		setId_Juego(id_Juego);
	}

	

	@Override
	public int getId_Juego() {
		return Id_Juego;
	}

	@Override
	public boolean setId_Juego(int id_Juego) {
		boolean bExito = false;
		if (id_Juego <= 999) {
			bExito = true;
			Id_Juego = id_Juego;
		}
		return bExito;
	}

	@Override
	public String getNombre() {
		return Nombre;
	}

	@Override
	public boolean setNombre(String nombre) {
		boolean bExito = false;
		if (nombre.length() == 30) {
			bExito = true;
			Nombre = nombre;
		}
		return bExito;
	}

	@Override
	public iHorario getoHorario() {
		return oHorario;
	}

	@Override
	public void setoHorario(iHorario oHorario) {
		this.oHorario = oHorario;
	}

	@Override
	public iTematica getoTematica() {
		return oTematica;
	}

	@Override
	public void setoTematica(iTematica oTematica) {
		this.oTematica = oTematica;
	}

	@Override
	public iTarifa getoTarifa() {
		return oTarifa;
	}

	@Override
	public void setoTarifa(iTarifa oTarifa) {
		this.oTarifa = oTarifa;
	}

	@Override
	public boolean validaJuego() {
		boolean bExito = false;
		if (this.Id_Juego < 0 && this.Nombre != null && oHorario != null && this.oTarifa != null
				&& this.oTematica != null) {
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String toString() {
		String sResultado = "";
		sResultado += "ID: " + Id_Juego + "\n";
		sResultado += "Nombre: " + Nombre + "\n";
		sResultado += "Horario: " + oHorario.getId_Horario() + "\n";
		sResultado += "Tematica: " + oTematica.getId_Temat() + "\n";
		sResultado += "Tarifa: " + oTarifa.getId_Tarifa() + "\n";

		return sResultado;
	}

}
