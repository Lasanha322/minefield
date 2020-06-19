import interfaces.ISettings;

public class Settings implements ISettings {
	int NumeroDeJogadores;
	int TamanhoDoTabuleiro;
	int NumeroDeGemas;
	boolean GanhaQuemTemMais;
	boolean GanhaQuemPegouMais;
	
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
