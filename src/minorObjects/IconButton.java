package minorObjects;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconButton extends JButton {
	private static final long serialVersionUID = 1L;

	public IconButton(String imgPath) {	
		super();
		ImageIcon imgIcon = new ImageIcon(imgPath);
		setIcon(imgIcon);
		setBorder(BorderFactory.createRaisedBevelBorder());
	}
}