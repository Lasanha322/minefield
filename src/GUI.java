import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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
import minorObjects.GameButton;
import minorObjects.IconButton;
import minorObjects.PlayerLabel;
import minorObjects.SkillButton;

public class GUI extends JFrame implements IGUI {
	private String LastAction;
	private ISettings Settings;
	private Dimension Resolution;
	private static final long serialVersionUID = 0;
	
	public GUI() {
		Settings = new Settings();
		Resolution = new Dimension(Settings.getWindowWidth(), Settings.getWindowHeight());
		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		getContentPane().setPreferredSize(Resolution);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void imprimirStart() {
		String IMG_PATH = "img/start/";	
		setTitle("Minefield - Main Menu");		
		getContentPane().removeAll();
		add(Box.createHorizontalGlue());
		
		IconButton buttonStart = new IconButton(IMG_PATH + "start");
		buttonStart.setActionCommand("game");
		buttonStart.addActionListener(this);
		IconButton buttonSettings = new IconButton(IMG_PATH + "settings");
		buttonSettings.setActionCommand("settings");
		buttonSettings.addActionListener(this);
		IconButton buttonExit = new IconButton(IMG_PATH + "exit");
		buttonExit.setActionCommand("exit");
		buttonExit.addActionListener(this);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
		panelButtons.add(buttonStart);
		panelButtons.add(buttonSettings);
		panelButtons.add(buttonExit);

		Background logo = new Background(IMG_PATH + "background", Resolution);
		logo.setSize(new Dimension(Settings.getWindowWidth(), Settings.getWindowHeight()));
		logo.setLayout(new BoxLayout(logo, BoxLayout.Y_AXIS));
		logo.add(Box.createVerticalGlue());
		logo.add(panelButtons);
		panelButtons.setAlignmentX(CENTER_ALIGNMENT);
		logo.add(Box.createRigidArea(new Dimension(0, Settings.getWindowHeight()/10)));
		
		add(logo);
		add(Box.createHorizontalGlue());
		pack();
		repaint();
	}

	@Override
	public void imprimirGame(IGame Game) {
		String IMG_PATH = "img/game/";
		setTitle("Minefield - Game");		
		getContentPane().removeAll();
		add(Box.createHorizontalGlue());
		
		//Imprime o estado inicial do jogo
		int size = Game.getSettings().getTamanhoDoTabuleiro();	
		int players = Game.getSettings().getNumeroDeJogadores();
		
		PlayerLabel[] playerLabel = new PlayerLabel[players];
		for (int i = 0; i < players; i++)
			playerLabel[i] = new PlayerLabel(Game.getPlayers()[i], Game);
		
		JPanel panelPlayers = new JPanel();
		panelPlayers.setBorder(BorderFactory.createEmptyBorder());
		panelPlayers.setLayout(new BoxLayout(panelPlayers, BoxLayout.Y_AXIS));
		for (int i = 0; i < players; i++)
			panelPlayers.add(playerLabel[i]);
		
		SkillButton[] skillButton = new SkillButton[5];
		for (int i = 0; i < 5; i++)
			skillButton[i] = new SkillButton(i+1, IMG_PATH, Game);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				skillButton[i].addActionListener(skillButton[j]);
			for (int j = 0; j < players; j++)
				skillButton[i].addActionListener(playerLabel[j]);
		}
		JPanel panelSkills = new JPanel();
		panelSkills.setBorder(BorderFactory.createEmptyBorder());
		panelSkills.setLayout(new BoxLayout(panelSkills, BoxLayout.Y_AXIS));
		for (int i = 0; i < 5; i++)
			panelSkills.add(skillButton[i]);

		GameButton[] gameButton = new GameButton[size*size];
		for (int i = 0; i < size*size; i++) {
			gameButton[i] = new GameButton(IMG_PATH, Game.getBoard().getCell(i));
			gameButton[i].setActionCommand(Integer.toString(i));
			gameButton[i].addActionListener(gameButton[i]);
			gameButton[i].addActionListener(skillButton[0]);
			gameButton[i].addActionListener(skillButton[1]);
			gameButton[i].addActionListener(skillButton[2]);
			gameButton[i].addActionListener(skillButton[3]);
			gameButton[i].addActionListener(skillButton[4]);

			for(int j = 0; j < players; j++)
				gameButton[i].addActionListener(playerLabel[j]);
			
			gameButton[i].addActionListener(Game);				
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < size*size; j++) {
				skillButton[i].addActionListener(gameButton[j]);
			}
			skillButton[i].addActionListener(Game);
		}
		
		JPanel panelCells = new JPanel();
		panelCells.setLayout(new GridLayout(size, size));
		for (int i = 0; i < size*size; i++)
			panelCells.add(gameButton[i]);
		
		JPanel panelBoard = new JPanel();
		panelBoard.setBorder(BorderFactory.createEmptyBorder());
		panelBoard.setLayout(new BoxLayout(panelBoard, BoxLayout.Y_AXIS));
		panelBoard.setBackground(new Color(0, 0, 0, 0));
		panelBoard.add(Box.createVerticalGlue());
		panelBoard.add(panelCells);
		panelBoard.add(Box.createVerticalGlue());

		Background background = new Background(IMG_PATH + "background", Resolution);
		background.setSize(new Dimension(Settings.getWindowWidth(), Settings.getWindowHeight()));
		background.setLayout(new BoxLayout(background, BoxLayout.X_AXIS));
		background.add(Box.createHorizontalGlue());
		background.add(panelPlayers);
		background.add(Box.createHorizontalGlue());
		background.add(panelBoard);
		background.add(Box.createHorizontalGlue());
		background.add(panelSkills);
		background.add(Box.createHorizontalGlue());
		
		add(background);
		add(Box.createHorizontalGlue());
		pack();
		repaint();
	}
	
	@Override
	public void imprimirSettings() {
		String IMG_PATH = "img/settings/";
		setTitle("Minefield - Settings");		
		getContentPane().removeAll();
		add(Box.createHorizontalGlue());
		
		Background background = new Background(IMG_PATH + "background", Resolution);
		background.setSize(new Dimension(Settings.getWindowWidth(), Settings.getWindowHeight()));
		background.setLayout(new BoxLayout(background, BoxLayout.X_AXIS));
		
		add(background);
		add(Box.createHorizontalGlue());
		pack();
		repaint();
	}

	@Override
	public void imprimirWinner(IPlayer Winner) {
		String IMG_PATH = "img/winner/";
		setTitle("Minefield - Game Over");		
		getContentPane().removeAll();
		add(Box.createHorizontalGlue());
		
		Background Background = new Background(IMG_PATH + "background", Resolution);
		Background.setSize(new Dimension(Settings.getWindowWidth(), Settings.getWindowHeight()));
		Background.setLayout(new BoxLayout(Background, BoxLayout.X_AXIS));
		
		add(Background);
		add(Box.createHorizontalGlue());
		pack();
		repaint();
		System.out.println("Vencedor: Jogador " + Winner.getID());
	}

	@Override
	public String getLastAction() {
		return LastAction;
	}
	
	@Override
	public ISettings getSettings() {
		return Settings;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		synchronized (this) {
			LastAction = e.getActionCommand();
			notify();
		}
	}
}