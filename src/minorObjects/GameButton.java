package minorObjects;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import interfaces.ICell;

public class GameButton extends IconButton {
	private String imgPath;
	private ICell Cell;
	private static final long serialVersionUID = 1L;

	public GameButton(String imgPath, ICell Cell) {
		super(null);
		this.imgPath = imgPath;
		this.Cell = Cell;
		setIcon(new ImageIcon(imgPath + "cell" + "_usable.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String conteudo = Cell.getConteudo().getClass().getName();

		switch(conteudo) {
		case "Gema":
			setDisabledIcon(new ImageIcon(imgPath + "gem" + "_unusable.png"));
			break;
		case "Bomba":
			setDisabledIcon(new ImageIcon(imgPath + "bomb" + "_unusable.png"));
			break;
		case "BombaInvisivel":
			setDisabledIcon(new ImageIcon(imgPath + "bomb" + "_unusable.png"));
			break;
		default:
			setDisabledIcon(new ImageIcon(imgPath + "cell" + "_unusable.png"));
			break;
		}		
		
		if (Cell.examinada()) {
			switch(conteudo) {
			case "Gema":
				setIcon(new ImageIcon(imgPath + "gem" + "_usable.png"));
				break;
			case "Bomba":
				setIcon(new ImageIcon(imgPath + "bomb" + "_usable.png"));
				break;
			default:
				setIcon(new ImageIcon(imgPath + "cell" + "_usable.png"));
				break;
			}
		}

		if (Cell.revelada())
			setEnabled(false);
	}
}