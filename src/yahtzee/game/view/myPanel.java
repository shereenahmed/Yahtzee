package yahtzee.game.view;

import javax.swing.*;
import java.awt.*;

public class myPanel extends JPanel {

	private int width, height;

	public myPanel(int w, int h) {
		width = w;
		height = h;
	}

	/*
	 * this is a nice constructor to do a common task- setting the layout
	 * immediately after creating the new panel.
	 */
	public myPanel(int w, int h, int a, int b) {
		width = w;
		height = h;
		this.setLayout(new GridLayout(a, b));
	}

	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
}
