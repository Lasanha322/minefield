import java.awt.Color;
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
		getContentPane().setPreferredSize(resolution);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void imprimirStart() {
		String IMG_PATH = "img/start/";	
		setTitle("Minefield - Main Menu");		
		getContentPane().removeAll();
		
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

		Background logo = new Background(IMG_PATH + "background.png", resolution);
		logo.setSize(new Dimension(settings.getWindowWidth(), settings.getWindowHeight()));
		logo.setLayout(new BoxLayout(logo, BoxLayout.Y_AXIS));
		logo.add(Box.createVerticalGlue());
		logo.add(panelButtons);
		panelButtons.setAlignmentX(CENTER_ALIGNMENT);
		logo.add(Box.createRigidArea(new Dimension(0, settings.getWindowHeight()/10)));
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(logo);
		pack();
		repaint();
	}

	@Override
	public void imprimirGame() {
		String IMG_PATH = "img/game/";
		setTitle("Minefield - Game");		
		getContentPane().removeAll();

		IGame game = new Game(settings);
		int size = game.getSettings().getTamanhoDoTabuleiro();	
		int players = game.getSettings().getNumeroDeJogadores();
		
		IconLabel[] playerLabel = new IconLabel[players];
		for(int i = 0; i < players; i++)
			playerLabel[i] = new IconLabel(IMG_PATH + "player.png");
		
		JPanel panelPlayers = new JPanel();
		panelPlayers.setBorder(BorderFactory.createEmptyBorder());
		panelPlayers.setLayout(new BoxLayout(panelPlayers, BoxLayout.Y_AXIS));
		for(int i = 0; i < players; i++)
			panelPlayers.add(playerLabel[i]);	
		
		IconButton[] cellButton = new IconButton[size*size];
		for(int i = 0; i < size*size; i++) {
			cellButton[i] = new IconButton(IMG_PATH + "cell_hidden.png");
		}
		
		JPanel panelCells = new JPanel();
		panelCells.setLayout(new GridLayout(size, size));
		for(int i = 0; i < size*size; i++)
			panelCells.add(cellButton[i]);
		
		JPanel panelBoard = new JPanel();
		panelBoard.setBorder(BorderFactory.createEmptyBorder());
		panelBoard.setLayout(new BoxLayout(panelBoard, BoxLayout.Y_AXIS));
		panelBoard.setBackground(new Color(0, 0, 0, 0));
		panelBoard.add(Box.createVerticalGlue());
		panelBoard.add(panelCells);
		panelBoard.add(Box.createVerticalGlue());

		IconButton[] skillButton = new IconButton[5];
		skillButton[0] = new IconButton(IMG_PATH + "skill0_unusable.png");
		skillButton[1] = new IconButton(IMG_PATH + "skill1_unusable.png");
		skillButton[2] = new IconButton(IMG_PATH + "skill2_unusable.png");
		skillButton[3] = new IconButton(IMG_PATH + "skill3_unusable.png");
		skillButton[4] = new IconButton(IMG_PATH + "skill4_unusable.png");
		
		JPanel panelSkills = new JPanel();
		panelSkills.setBorder(BorderFactory.createEmptyBorder());
		panelSkills.setLayout(new BoxLayout(panelSkills, BoxLayout.Y_AXIS));
		for(int i = 0; i < 5; i++)
			panelSkills.add(skillButton[i]);

		Background background = new Background(IMG_PATH + "background.png", resolution);
		background.setSize(new Dimension(settings.getWindowWidth(), settings.getWindowHeight()));
		background.setLayout(new BoxLayout(background, BoxLayout.X_AXIS));
		background.add(Box.createHorizontalGlue());
		background.add(panelPlayers);
		background.add(Box.createHorizontalGlue());
		background.add(panelBoard);
		background.add(Box.createHorizontalGlue());
		background.add(panelSkills);
		background.add(Box.createHorizontalGlue());
		
		add(background);
		pack();
		repaint();
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