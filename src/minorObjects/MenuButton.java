package minorObjects;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MenuButton extends JButton {
	private static final long serialVersionUID = 1L;

	public MenuButton(String imgPath) {
		super(new ImageIcon(imgPath));		
	}
}