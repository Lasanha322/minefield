package minorObjects;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class IconLabel extends JLabel {
	private static final long serialVersionUID = 1L;

	public IconLabel(String imgPath) {
		super(new ImageIcon(imgPath));		
	}
}