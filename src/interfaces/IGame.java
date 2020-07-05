package interfaces;
import java.awt.event.ActionListener;

public interface IGame extends ActionListener {
	public boolean acabou();
	public int proximoTurno();
	public int getTurno();
	public ISettings getSettings();
	public IBoard getBoard();	
	public IPlayer[] getPlayers();
	public IPlayer getVencedor();
}