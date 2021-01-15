package models;

public class Juego {
	private int Id_Juego;
	private String Nombre;
	private Horario oHorario;
	private Tematica oTematica;
	private Tarifa oTarifa;

	public Juego(int id_Juego, String nombre, Horario oHorario, Tematica oTematica, Tarifa oTarifa) {
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

	

	public int getId_Juego() {
		return Id_Juego;
	}

	public boolean setId_Juego(int id_Juego) {
		boolean bExito = false;
		if (id_Juego <= 999) {
			bExito = true;
			Id_Juego = id_Juego;
		}
		return bExito;
	}

	public String getNombre() {
		return Nombre;
	}

	public boolean setNombre(String nombre) {
		boolean bExito = false;
		if (nombre.length() == 30) {
			bExito = true;
			Nombre = nombre;
		}
		return bExito;
	}

	public Horario getoHorario() {
		return oHorario;
	}

	public void setoHorario(Horario oHorario) {
		this.oHorario = oHorario;
	}

	public Tematica getoTematica() {
		return oTematica;
	}

	public void setoTematica(Tematica oTematica) {
		this.oTematica = oTematica;
	}

	public Tarifa getoTarifa() {
		return oTarifa;
	}

	public void setoTarifa(Tarifa oTarifa) {
		this.oTarifa = oTarifa;
	}

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
