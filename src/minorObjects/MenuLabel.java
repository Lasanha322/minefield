package minorObjects;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MenuLabel extends JLabel {
	private static final long serialVersionUID = 1L;

	public MenuLabel(String imgPath) {
		super(new ImageIcon(imgPath));		
	}
}