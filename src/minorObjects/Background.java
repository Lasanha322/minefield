package minorObjects;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Background extends JLabel {
	private static final long serialVersionUID = 1L;

	public Background(String imgPath, Dimension resolution) {
		super();
		ImageIcon imgIcon = new ImageIcon(imgPath);
		imgIcon = new ImageIcon(imgIcon.getImage().getScaledInstance(resolution.width, resolution.height, Image.SCALE_SMOOTH));
		setIcon(imgIcon);
		setBorder(BorderFactory.createEmptyBorder());
	}
}