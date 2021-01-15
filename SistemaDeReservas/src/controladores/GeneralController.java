package controladores;

import controladores.ConexionDB;

public class GeneralController implements iGeneralController {
	private iClienteController cctrl;
	private iTarifaController tfctrl;
	private iHorarioController hrctrl;
	private iTematicaController tmctrl;
	private iReservaController rsctrl;
	private iJuegoController jctrl;

	public GeneralController(String sDatabase) {
		cctrl = new ClienteController();
		tfctrl = new TarifaController();
		hrctrl = new HorarioController();
		tmctrl = new TematicaController();
		jctrl = new JuegoController();
		rsctrl = new ReservaController();
		new ConexionDB(sDatabase);
	}

	@Override
	public iReservaController getRsctrl() {
		return rsctrl;
	}

	@Override
	public iJuegoController getJctrl() {
		return jctrl;
	}

	@Override
	public iTematicaController getTmctrl() {
		return tmctrl;
	}

	@Override
	public iHorarioController getHrctrl() {
		return hrctrl;
	}

	@Override
	public iClienteController getCctrl() {
		return cctrl;
	}

	@Override
	public iTarifaController getTfctrl() {
		return tfctrl;
	}

}