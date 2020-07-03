package interfaces;

public interface ISettings {
	int getNumeroDeJogadores();
	int getTamanhoDoTabuleiro();
	int getNumeroDeGemas();
	boolean getGanhaQuemTemMais();
	boolean getGanhaQuemPegouMais();
	public int getWindowWidth();	
	public int getWindowHeight();
	void setNumeroDeJogadores(int n);
	void setTamanhoDoTabuleiro(int n);
	void setNumeroDeGemas(int n);
	void setGanhaQuemTemMais(boolean thisCondition);
	void setGanhaQuemPegouMais(boolean thisCondition);	
	public void setWindowWidth(int newWidth);
	public void setWindowHeight(int newHeight);
}