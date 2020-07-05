package minorObjects;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import interfaces.IGame;

public class SkillButton extends IconButton {
	private boolean lastSelected;
	private int turnoAtual;
	private int skillCost;
	private String imgPath;
	private IGame Game;
	private static final long serialVersionUID = 1L;

	public SkillButton(int skillCost, String imgPath, IGame Game) {
		super(null);
		this.skillCost = skillCost;
		this.imgPath = imgPath;
		this.Game = Game;
		
		lastSelected = false;
		turnoAtual = Game.getTurno();

		setActionCommand("skill" + Integer.toString(skillCost));
		setIcon(new ImageIcon(imgPath + "skill" + Integer.toString(skillCost-1) + "_usable.png"));
		setDisabledIcon(new ImageIcon(imgPath + "skill" + Integer.toString(skillCost-1) + "_unusable.png"));
		setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		if (e.getSource().getClass().equals(this.getClass())) {
			if (e.getSource().equals(this)) {
				if (lastSelected) {
					setIcon(new ImageIcon(imgPath + "skill" + Integer.toString(skillCost-1) + "_usable.png"));
				} else {
					if (skillCost < 5)
						setIcon(new ImageIcon(imgPath + "skill" + Integer.toString(skillCost-1) + "_selected.png"));
					else
						setEnabled(false);
				}
				lastSelected = !lastSelected;
			} else {
				if (isEnabled()) {
					setEnabled(false);
				} else {
					if (Game.getPlayers()[Game.getTurno()].getGemasAtual() >= skillCost)
						setEnabled(true);
					else
						setEnabled(false);
				}
			}
		} else {
			if (lastSelected) {
				setIcon(new ImageIcon(imgPath + "skill" + Integer.toString(skillCost-1) + "_usable.png"));
				if (Game.getTurno() == turnoAtual) {
					setEnabled(false);
				} else {
					if (Game.getPlayers()[Game.getTurno()].getGemasAtual() >= skillCost)
						setEnabled(true);
					else
						setEnabled(false);					
				}
			} else {
				if (Game.getTurno() == turnoAtual) {
					setEnabled(false);					
				} else {
					if (Game.getPlayers()[Game.getTurno()].getGemasAtual() >= skillCost)
						setEnabled(true);
					else
						setEnabled(false);					
				}
			}
			lastSelected = false;			
		}
		turnoAtual = Game.getTurno();
	}
}