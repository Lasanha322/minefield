package interfaces;

public interface IGUI {
	void imprimirMenuInicial();
	void imprimirSettings(ISettings Settings);
	void imprimirGame(IGame Game);
	void imprimirVencedor(IPlayer Winner);
}