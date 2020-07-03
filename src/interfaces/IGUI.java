package interfaces;

public interface IGUI {
	void imprimirStart();
	void imprimirGame();
	void imprimirSettings();
	void imprimirVencedor(IPlayer Winner);
	String getLastAction();
}