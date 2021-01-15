package controladores;

import java.util.List;

import models.Reserva;
import models.iReserva;

public interface iReservaController {

	public int add(iReserva oReserva);

	public int update(iReserva oReserva);

	public int remove(iReserva oReserva);

	public int existeReserva(iReserva oReserva);

	public List<Reserva> searchPorId_Reserva(iReserva oReserva);

}