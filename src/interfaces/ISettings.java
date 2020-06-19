package interfaces;

public interface ISettings {
	int getNumeroDeJogadores();
	int getTamanhoDoTabuleiro();
	int getNumeroDeGemas();
	boolean getGanhaQuemTemMais();
	boolean getGanhaQuemPegouMais();
	void setNumeroDeJogadores(int n);
	void setTamanhoDoTabuleiro(int n);
	void setNumeroDeGemas(int n);
	void setGanhaQuemTemMais(boolean thisCondition);
	void setGanhaQuemPegouMais(boolean thisCondition);
}