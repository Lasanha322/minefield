package minorObjects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;

	public IconButton(String imgPath) {	
		super();
		setBorder(BorderFactory.createRaisedBevelBorder());
		setIcon(new ImageIcon(imgPath + "_usable.png"));
		setDisabledIcon(new ImageIcon(imgPath + "_unusable.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this)) {
			setEnabled(false);
		}
	}
}