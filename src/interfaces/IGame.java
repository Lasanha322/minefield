package interfaces;
import java.awt.event.ActionListener;

public interface IGame extends ActionListener {
	public void esperarJogada();
	public void verificarJogada();
	public void verificarFinal();
	public int proximoTurno();
	public boolean acabou();
	public int getTurno();
	public ISettings getSettings();
	public IBoard getBoard();	
	public IPlayer[] getPlayers();
	public IPlayer getVencedor();
}