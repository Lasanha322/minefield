package minorObjects;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import interfaces.IGame;

public class SkillButton extends IconButton {
	private int skillCost;
	private IGame game;
	private static final long serialVersionUID = 1L;

	public SkillButton(int skillCost, String imgPath, IGame game) {
		super(null);
		this.skillCost = skillCost;
		this.game = game;

		addActionListener(game);
		setActionCommand("skill" + Integer.toString(skillCost));
		setIcon(new ImageIcon(imgPath + "_usable.png"));
		setEnabled(false);
		setDisabledIcon(new ImageIcon(imgPath + "_unusable.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (game.getPlayers()[game.proximoTurno()].getGemasAtual() >= skillCost) {
				setEnabled(true);
		} else {
				setEnabled(false);
		}	
	}
}