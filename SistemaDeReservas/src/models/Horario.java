package models;

public class Horario implements iHorario {
	private int Id_Horario;
	private String Hora;

	public Horario(int id_Horario, String hora) {
		setId_Horario(id_Horario);
		setHora(hora);
	}
	
	public Horario(int id_Horario) {
		Id_Horario = id_Horario;
	}

	@Override
	public int getId_Horario() {
		return Id_Horario;
	}

	private boolean setId_Horario(int id_Horario) {
		boolean bExito = false;
		if (id_Horario < 999) {
			bExito = true;
			Id_Horario = id_Horario;
		}
		return bExito;
	}

	@Override
	public String getHora() {
		return Hora;
	}

	@Override
	public boolean setHora(String hora) {
		boolean bExito = false;
		if (hora.length() == 5) {
			bExito = true;
			Hora = hora;
		}
		return bExito;
		
	}
	
	
	@Override
	public boolean validaHorario() {
		boolean bExito = false;
		if (this.Id_Horario < 0 && this.Hora != null ) {
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String toString() {
		String sResultado = "";
		sResultado += "ID: " + Id_Horario + "\n";
		sResultado += "Hora: " + Hora + "\n";
		return sResultado;
	}
}
