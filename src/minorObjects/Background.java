package minorObjects;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class Background extends IconLabel {
	private static final long serialVersionUID = 1L;

	public Background(String imgPath, Dimension resolution) {
		super(null);
		
		ImageIcon imgIcon = new ImageIcon(imgPath + ".png");
		imgIcon = new ImageIcon(imgIcon.getImage().getScaledInstance(resolution.width, resolution.height, Image.SCALE_SMOOTH));
		setIcon(imgIcon);
		setBorder(BorderFactory.createEmptyBorder());
	}
}