package minorObjects;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import interfaces.IGame;
import interfaces.IPlayer;

public class PlayerLabel extends IconLabel implements ActionListener {
	private Font Font;
	private IPlayer Player;
	private IGame Game;
	private static final long serialVersionUID = 1L;

	public PlayerLabel(IPlayer Player, IGame Game) {
		super(null);
		this.Player = Player;
		this.Game = Game;
		this.Font = new Font(null, java.awt.Font.BOLD, 24);
		setFont(Font);
		setText("Gems: " + Player.getGemasAtual() + " / " + Player.getGemasTotal());
		if (Game.proximoTurno() == Player.getID())
			setBorder(BorderFactory.createTitledBorder(null, " > Player " + Integer.toString(Player.getID()), 0, 0, Font));
		else
			setBorder(BorderFactory.createTitledBorder(null, "Player " + Integer.toString(Player.getID()), 0, 0, Font));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setText("Gems: " + Player.getGemasAtual() + " / " + Player.getGemasTotal());
		if (Game.getTurno()+1 == Player.getID())
			setBorder(BorderFactory.createTitledBorder(null, " > Player " + Integer.toString(Player.getID()), 0, 0, Font));
		else
			setBorder(BorderFactory.createTitledBorder(null, "Player " + Integer.toString(Player.getID()), 0, 0, Font));	
	}
}