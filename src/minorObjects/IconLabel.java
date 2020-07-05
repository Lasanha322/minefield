package minorObjects;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class IconLabel extends JLabel{
	private static final long serialVersionUID = 1L;

	public IconLabel(String imgPath) {
		super();
		setIcon(new ImageIcon(imgPath + ".png"));
		setBorder(BorderFactory.createEmptyBorder());
	}
}