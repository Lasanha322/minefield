import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.IGUI;
import interfaces.IGame;
import interfaces.IPlayer;
import interfaces.ISettings;
import minorObjects.Background;
import minorObjects.IconButton;
import minorObjects.IconLabel;

public class GUI extends JFrame implements IGUI, ActionListener {
	private String LastAction;
	private ISettings settings;
	private Dimension resolution;
	private static final long serialVersionUID = 0;
	
	public GUI() {
		settings = new Settings();
		resolution = new Dimension(settings.getWindowWidth(), settings.getWindowHeight());
		setPreferredSize(resolution);
	}

	@Override
	public void imprimirStart() {
		String IMG_PATH = "img/menuInicial/";
		Background logo = new Background(IMG_PATH + "logo.png", resolution);
		logo.setSize(new Dimension(settings.getWindowWidth(), settings.getWindowHeight()));
		
		IconButton buttonStart = new IconButton(IMG_PATH + "start.png");
		buttonStart.setActionCommand("game");
		buttonStart.addActionListener(this);
		IconButton buttonSettings = new IconButton(IMG_PATH + "settings.png");
		buttonSettings.setActionCommand("settings");
		buttonSettings.addActionListener(this);
		IconButton buttonExit = new IconButton(IMG_PATH + "exit.png");
		buttonExit.setActionCommand("exit");
		buttonExit.addActionListener(this);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
		panelButtons.add(buttonStart);
		panelButtons.add(buttonSettings);
		panelButtons.add(buttonExit);
		
		logo.setLayout(new BoxLayout(logo, BoxLayout.Y_AXIS));
		logo.add(Box.createVerticalGlue());
		logo.add(panelButtons);
		panelButtons.setAlignmentX(CENTER_ALIGNMENT);
		logo.add(Box.createRigidArea(new Dimension(0, settings.getWindowHeight()/10)));
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(logo);
		logo.setAlignmentX(CENTER_ALIGNMENT);
		
		setTitle("Minefield - Main Menu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	@Override
	public void imprimirGame() {
		IGame game = new Game(settings);
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
		panelCells.setBorder(BorderFactory.createEmptyBorder());
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
	
		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		add(panelPlayers);
		add(panelCells);
		revalidate();
		pack();
	}
	
	@Override
	public void imprimirSettings() {
		String IMG_PATH = "img/settings/";
		setTitle("Minefield - Settings");		
		getContentPane().removeAll();
		repaint();
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