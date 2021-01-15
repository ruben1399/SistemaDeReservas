package controladores;

import java.util.List;

import models.Juego;
import models.iJuego;

public interface iJuegoController {

	public int add(iJuego oJuego);

	public int update(iJuego oJuego);

	public int remove(iJuego oJuego);

	public int existeJuego(iJuego oJuego);

	public List<Juego> searchPorId_Juego(iJuego oJuego);

}