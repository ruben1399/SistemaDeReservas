package models;

public class Tarifa {
	private int Id_Tarifa;
	private int Precio;

	public Tarifa(int id_Tarifa, int precio) {
		Id_Tarifa = id_Tarifa;
		Precio = precio;
	}
	
	public Tarifa(int id_Tarifa) {
		setId_Tarifa(id_Tarifa);
	}

	public int getId_Tarifa() {
		return Id_Tarifa;
	}

	private boolean setId_Tarifa(int id_Tarifa) {
		boolean bExito = false;
		if (id_Tarifa < 999) {
			bExito = true;
			Id_Tarifa = id_Tarifa;
		}
		return bExito;
	}

	public int getPrecio() {
		return Precio;
	}
	public boolean validaTarifa() {
		boolean bExito = false;
		if (this.Id_Tarifa < 0 && this.Precio < 0 ) {
			bExito = true;
		}
		return bExito;
	}
	public boolean setPrecio(int precio) {
		boolean bExito = false;
		if (precio > 0 && precio < 120) {
			bExito = true;
			Precio = precio;
			;
		}
		return bExito;

	}

	@Override
	public String toString() {
		String sResultado = "";
		sResultado += "ID: " + Id_Tarifa + "\n";
		sResultado += "Precio: " + Precio + "\n";
		return sResultado;
	}

}
