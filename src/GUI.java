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
import minorObjects.MenuButton;
import minorObjects.MenuLabel;

public class GUI extends JFrame implements IGUI, ActionListener {
	private String LastAction;
	private static final long serialVersionUID = 0;

	@Override
	public void imprimirMenuInicial() {
		LastAction = "open";
		String IMG_PATH = "img/menuInicial/";
		MenuLabel labelLogo = new MenuLabel(IMG_PATH + "logo.png");
		JPanel panelLogo = new JPanel();
		panelLogo.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		panelLogo.add(labelLogo);
		
		MenuButton buttonStart = new MenuButton(IMG_PATH + "start.png");
		buttonStart.setActionCommand("start");
		buttonStart.addActionListener(this);
		MenuButton buttonSettings = new MenuButton(IMG_PATH + "settings.png");
		buttonSettings.setActionCommand("settings");
		buttonSettings.addActionListener(this);
		MenuButton buttonExit = new MenuButton(IMG_PATH + "exit.png");
		buttonExit.setActionCommand("exit");
		buttonExit.addActionListener(this);
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		panelButtons.setLayout(new GridLayout(3, 0));
		panelButtons.add(buttonStart);
		panelButtons.add(buttonSettings);
		panelButtons.add(buttonExit);
		
		this.setLayout(new BorderLayout());
		this.add(panelLogo, BorderLayout.PAGE_START);
		this.add(panelButtons, BorderLayout.CENTER);
		
		setTitle("Minefield - Main Menu");
		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void imprimirSettings(ISettings settings) {
		System.out.println("Debug Message: imprimirSettings");

	}

	@Override
	public void imprimirGame(IGame game) {
		System.out.println("Debug Message: imprimirGame");

	}

	@Override
	public void imprimirVencedor(IPlayer winner) {
		System.out.println("Debug Message: imprimirVencedor");
		
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