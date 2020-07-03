package interfaces;

public interface IGame {
	public void esperarJogada();
	public void verificarJogada();
	public void verificarFinal();
	public ISettings getSettings();
	public IBoard getBoard();	
	public IPlayer[] getPlayers();
}