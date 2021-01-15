package controladores;

import java.util.List;

import models.Tematica;
import models.iTematica;

public interface iTematicaController {

	public int add(iTematica oTematica);

	public int update(iTematica oTematica);

	public int remove(iTematica oTematica);

	public int existeTematica(iTematica oTematica);

	public List<Tematica> searchPorId_Temat(iTematica oTematica);

}