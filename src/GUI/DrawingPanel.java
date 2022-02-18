package GUI;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
	
	private final Window window;
	
	public DrawingPanel(Window window) {
		
		super();
		
		this.window = window;
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(256,256));
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		window.getModel().paintSegments(g);
	}
	
	public void notifyForUpdate() {
		
		repaint();
	}

}
