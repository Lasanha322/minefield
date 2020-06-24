import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.IGUI;
import interfaces.IGame;
import interfaces.IPlayer;
import interfaces.ISettings;
import minorObjects.IconButton;
import minorObjects.IconLabel;

public class GUI extends JFrame implements IGUI, ActionListener {
	private String LastAction;
	private static final long serialVersionUID = 0;

	@Override
	public void imprimirMenuInicial() {
		LastAction = "open";
		String IMG_PATH = "img/menuInicial/";
		IconLabel labelLogo = new IconLabel(IMG_PATH + "logo.png");
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelLogo.add(labelLogo);
		
		IconButton buttonStart = new IconButton(IMG_PATH + "start.png");
		buttonStart.setActionCommand("start");
		buttonStart.addActionListener(this);
		IconButton buttonSettings = new IconButton(IMG_PATH + "settings.png");
		buttonSettings.setActionCommand("settings");
		buttonSettings.addActionListener(this);
		IconButton buttonExit = new IconButton(IMG_PATH + "exit.png");
		buttonExit.setActionCommand("exit");
		buttonExit.addActionListener(this);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelButtons.setLayout(new GridLayout(3, 0));
		panelButtons.add(buttonStart);
		panelButtons.add(buttonSettings);
		panelButtons.add(buttonExit);
		
		this.setLayout(new BorderLayout());
		this.add(panelLogo, BorderLayout.PAGE_START);
		this.add(panelButtons, BorderLayout.CENTER);
		
		setTitle("Minefield - Main Menu");
		setSize(1296, 735);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void imprimirSettings(ISettings settings) {
		String IMG_PATH = "img/settings/";
		setTitle("Minefield - Settings");		
		getContentPane().removeAll();
		repaint();
	}

	@Override
	public void imprimirGame(IGame game) {
		String IMG_PATH = "img/game/";
		int size = game.getSettings().getTamanhoDoTabuleiro();	
		int players = game.getSettings().getNumeroDeJogadores();
		setTitle("Minefield - Game");		
		getContentPane().removeAll();
		repaint();
		
		IconButton[] cellButton = new IconButton[size*size];
		for(int i = 0; i < size*size; i++)
			cellButton[i] = new IconButton(IMG_PATH + "cell.png");
		JPanel panelCells = new JPanel();
		panelCells.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelCells.setLayout(new GridLayout(size, size));
		for(int i = 0; i < size*size; i++)
			panelCells.add(cellButton[i]);
		
		IconLabel[] playerLabel = new IconLabel[players];
		for(int i = 0; i < players; i++)
			playerLabel[i] = new IconLabel(IMG_PATH + "player.png");		
		JPanel panelPlayers = new JPanel();
		panelPlayers.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelPlayers.setLayout(new GridLayout(0, players));
		for(int i = 0; i < players; i++)
			panelPlayers.add(playerLabel[i]);
		
		this.setLayout(new BorderLayout());
		this.add(panelPlayers, BorderLayout.PAGE_START);
		this.add(panelCells, BorderLayout.CENTER);
		revalidate();
	}

	@Override
	public void imprimirVencedor(IPlayer winner) {
		System.out.println("Debug Message: imprimirVencedor");
		String IMG_PATH = "img/winner/";
		
	}

	@Override
	public String getLastAction() {
		return LastAction;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		synchronized (this) {
			LastAction = e.getActionCommand();
			notify();
		}
	}
}