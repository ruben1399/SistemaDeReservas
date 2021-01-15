package controladores;

import java.util.List;

import models.Horario;
import models.iHorario;

public interface iHorarioController {

	public int add(iHorario oHorario);

	public int update(iHorario oHorario);

	public int remove(iHorario oHorario);

	public int existeHorario(iHorario oHorario);

	public List<Horario> searchPorId_Horario(iHorario oHorario);

}