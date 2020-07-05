package interfaces;

public interface ISettings {
	public boolean getGanhaQuemTemMais();
	public boolean getGanhaQuemPegouMais();
	public int getNumeroDeJogadores();
	public int getTamanhoDoTabuleiro();
	public int getNumeroDeGemas();
	public int getWindowWidth();	
	public int getWindowHeight();
	public void setGanhaQuemTemMais(boolean thisCondition);
	public void setGanhaQuemPegouMais(boolean thisCondition);
	public void setNumeroDeJogadores(int n);
	public void setTamanhoDoTabuleiro(int n);
	public void setNumeroDeGemas(int n);	
	public void setWindowWidth(int newWidth);
	public void setWindowHeight(int newHeight);
}