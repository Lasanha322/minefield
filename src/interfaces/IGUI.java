package interfaces;

import java.awt.event.ActionListener;

public interface IGUI extends ActionListener {
	public void imprimirStart();
	public void imprimirGame(IGame game);
	public void imprimirSettings();
	public void imprimirWinner(IPlayer Winner);
	public String getLastAction();
	public ISettings getSettings();
}