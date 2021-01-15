package controladores;

import java.util.List;

import models.Cliente;
import models.iCliente;

public interface iClienteController {

	public int add(iCliente oCliente);

	public int update(iCliente oCliente);

	public int remove(iCliente oCliente);

	public int existeCliente(iCliente oCliente);

	List<Cliente> searchAddressesPorDNI(iCliente oCliente);

}