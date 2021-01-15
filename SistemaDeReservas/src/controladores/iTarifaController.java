package controladores;

import java.util.List;

import models.Tarifa;
import models.iTarifa;

public interface iTarifaController {

	public int add(iTarifa oTarifa);

	public int update(iTarifa oTarifa);

	public int remove(iTarifa oTarifa);

	public int existeTarifa(iTarifa oTarifa);

	public List<Tarifa> searchPorId_Tarifa(iTarifa oTarifa);

}