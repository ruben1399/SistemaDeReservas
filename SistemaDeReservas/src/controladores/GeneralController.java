package controladores;

import controladores.ConexionDB;

public class GeneralController {
	private ClienteController cctrl;
	private TarifaController tfctrl;
	private HorarioController hrctrl;
	private TematicaController tmctrl;
	private ReservaController rsctrl;
private JuegoController jctrl;
	public GeneralController(String sDatabase) {
		cctrl = new ClienteController();
		tfctrl = new TarifaController();
		hrctrl = new HorarioController();
		tmctrl = new TematicaController();
		jctrl = new JuegoController();
		rsctrl= new ReservaController();
		new ConexionDB(sDatabase);
	}

	public ReservaController getRsctrl() {
		return rsctrl;
	}

	public JuegoController getJctrl() {
		return jctrl;
	}

	public TematicaController getTmctrl() {
		return tmctrl;
	}



	public HorarioController getHrctrl() {
		return hrctrl;
	}

	public ClienteController getCctrl() {
		return cctrl;
	}

	public TarifaController getTfctrl() {
		return tfctrl;
	}

}