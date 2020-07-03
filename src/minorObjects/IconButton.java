package minorObjects;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconButton extends JButton {
	private static final long serialVersionUID = 1L;

	public IconButton(String imgPath) {	
		super();
		ImageIcon img = new ImageIcon(imgPath);
		System.out.println(img.getIconWidth() + " and " + img.getIconHeight());
		Dimension size = new Dimension(img.getIconWidth(), img.getIconHeight());
		this.setIcon(img);
		this.setPreferredSize(size);
	}
}