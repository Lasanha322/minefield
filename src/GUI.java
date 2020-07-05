import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import minorObjects.PlayerLabel;
import minorObjects.SkillButton;

public class GUI extends JFrame implements IGUI, ActionListener {
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
	public void imprimirGame(IGame game) {
		String IMG_PATH = "img/game/";
		setTitle("Minefield - Game");		
		getContentPane().removeAll();
		add(Box.createHorizontalGlue());
		
		//Imprime o estado inicial do jogo
		int size = game.getSettings().getTamanhoDoTabuleiro();	
		int players = game.getSettings().getNumeroDeJogadores();
		
		PlayerLabel[] playerLabel = new PlayerLabel[players];
		for(int i = 0; i < players; i++) {
			playerLabel[i] = new PlayerLabel(game.getPlayers()[i], game);
		}
		
		JPanel panelPlayers = new JPanel();
		panelPlayers.setBorder(BorderFactory.createEmptyBorder());
		panelPlayers.setLayout(new BoxLayout(panelPlayers, BoxLayout.Y_AXIS));
		for(int i = 0; i < players; i++)
			panelPlayers.add(playerLabel[i]);
		
		SkillButton[] skillButton = new SkillButton[5];
		for(int i = 0; i < 5; i++) {
			skillButton[i] = new SkillButton(i+1, IMG_PATH + "skill" + Integer.toString(i), game);
			skillButton[i].addActionListener(game);
			skillButton[i].setActionCommand("skill");
		}
		
		JPanel panelSkills = new JPanel();
		panelSkills.setBorder(BorderFactory.createEmptyBorder());
		panelSkills.setLayout(new BoxLayout(panelSkills, BoxLayout.Y_AXIS));
		for(int i = 0; i < 5; i++)
			panelSkills.add(skillButton[i]);

		IconButton[] cellButton = new IconButton[size*size];
		for(int i = 0; i < size*size; i++) {
			cellButton[i] = new IconButton(IMG_PATH + "cell");
			cellButton[i].setActionCommand(Integer.toString(i));
			cellButton[i].addActionListener(cellButton[i]);	
			
			for(int j = 0; j < players; j++)
				cellButton[i].addActionListener(playerLabel[j]);
			cellButton[i].addActionListener(game);	
			cellButton[i].addActionListener(skillButton[0]);
			cellButton[i].addActionListener(skillButton[1]);
			cellButton[i].addActionListener(skillButton[2]);
			cellButton[i].addActionListener(skillButton[3]);
			cellButton[i].addActionListener(skillButton[4]);	
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
		pack();
		repaint();
	}

	@Override
	public void imprimirVencedor(IPlayer winner) {
		String IMG_PATH = "img/vencedor/";
		setTitle("Minefield - Game");		
		getContentPane().removeAll();
		add(Box.createHorizontalGlue());
		System.out.println("Vencedor: Jogador " + winner.getID());
		
		add(Box.createHorizontalGlue());
		pack();
		repaint();
	}

	@Override
	public String getLastAction() {
		return LastAction;
	}
	
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