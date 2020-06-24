package minorObjects;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconButton extends JButton {
	private static final long serialVersionUID = 1L;

	public IconButton(String imgPath) {
		super(new ImageIcon(imgPath));		
	}
}