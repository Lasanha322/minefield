import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.IGUI;
import interfaces.IGame;
import interfaces.IPlayer;
import interfaces.ISettings;

public class GUI extends JFrame implements IGUI {

	@Override
	public void imprimirMenuInicial() {
		JPanel mainPanel = new JPanel();
	}

	@Override
	public void imprimirSettings(ISettings settings) {
		// TODO Auto-generated method stub

	}

	@Override
	public void imprimirGame(IGame game) {
		// TODO Auto-generated method stub

	}

	@Override
	public void imprimirVencedor(IPlayer winner) {
		// TODO Auto-generated method stub
		
	}

}
