import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.IGUI;
import interfaces.IGame;
import interfaces.IPlayer;
import interfaces.ISettings;

public class GUI extends JFrame implements IGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void imprimirMenuInicial() {
		JPanel mainPanel = new JPanel();
		JButton buttonPlay = new JButton();
		JButton buttonSettings = new JButton();
		JButton buttonExit = new JButton();
		
		this.setLayout(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);
		
		setTitle("Minefield - Main Menu");
		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
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