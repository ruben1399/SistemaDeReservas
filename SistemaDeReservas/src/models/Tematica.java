package models;

public class Tematica implements iTematica {
	private int Id_Temat;
	private String Nombre;
	private String Descripcion;

	public Tematica(int id_Temat, String nombre, String descripcion) {
		setId_Temat(id_Temat);
		setNombre(nombre);
		setDescripcion(descripcion);
	}

	public Tematica(int id_Temat, String nombre) {
		setId_Temat(id_Temat);
		setNombre(nombre);
	}

	public Tematica(int id_Temat) {
		setId_Temat(id_Temat);
	}

	@Override
	public int getId_Temat() {
		return Id_Temat;
	}

	private boolean setId_Temat(int id_Temat) {
		boolean bExito = false;
		if (id_Temat < 999) {
			bExito = true;
			Id_Temat = id_Temat;
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
		if (Nombre.length() <= 30 && Nombre.length() >= 0) {
			bExito = true;
			Nombre = nombre;
		}
		return bExito;
	}

	@Override
	public String getDescripcion() {
		return Descripcion;
	}

	@Override
	public boolean setDescripcion(String descripcion) {
		boolean bExito = false;
		if (Descripcion.length() <= 250 && Descripcion.length() >= 0) {
			bExito = true;
			Descripcion = descripcion;
		}
		return bExito;
	}

	@Override
	public boolean validaTematica() {
		boolean bExito = false;
		if (this.Id_Temat < 0 && this.Nombre != null ) {
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String toString() {
		String sResultado = "";
		sResultado += "ID: " + Id_Temat + "\n";
		sResultado += "Nombre: " + Nombre + "\n";
		sResultado += "Descripcion: " + Descripcion + "\n";
		return sResultado;
	}

}
