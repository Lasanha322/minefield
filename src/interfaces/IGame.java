package interfaces;

public interface IGame {
	void esperarJogada();
	void verificarJogada();
	void verificarFinal();
	ISettings getSettings();
}