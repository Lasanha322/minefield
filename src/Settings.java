import interfaces.ISettings;

public class Settings implements ISettings {
	private int NumeroDeJogadores;
	private int TamanhoDoTabuleiro;
	private int NumeroDeGemas;
	private boolean GanhaQuemTemMais;
	private boolean GanhaQuemPegouMais;
	
	Settings() {
		NumeroDeJogadores = 1;
		TamanhoDoTabuleiro = 10;
		NumeroDeGemas = 25;
		GanhaQuemTemMais = true;
		GanhaQuemPegouMais = false;
	}
	
	public int getNumeroDeJogadores() {
		return NumeroDeJogadores ;
	}

	public int getTamanhoDoTabuleiro() {
		return TamanhoDoTabuleiro;
	}

	public int getNumeroDeGemas() {
		return NumeroDeGemas;
	}

	public boolean getGanhaQuemTemMais() {
		return GanhaQuemTemMais;
	}

	public boolean getGanhaQuemPegouMais() {
		return GanhaQuemPegouMais;
	}

	public void setNumeroDeJogadores(int n) {
		NumeroDeJogadores=n;
	}

	public void setTamanhoDoTabuleiro(int n) {
		TamanhoDoTabuleiro=n;
	}

	public void setNumeroDeGemas(int n) {
		NumeroDeGemas=n;
	}

	public void setGanhaQuemTemMais(boolean thisCondition) {
		GanhaQuemTemMais=thisCondition;

	}

	public void setGanhaQuemPegouMais(boolean thisCondition) {
		GanhaQuemPegouMais=thisCondition;
	}
}