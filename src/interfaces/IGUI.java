package interfaces;

public interface IGUI {
	void imprimirStart();
	void imprimirGame(IGame game);
	void imprimirSettings();
	void imprimirWinner(IPlayer Winner);
	String getLastAction();
	ISettings getSettings();
}