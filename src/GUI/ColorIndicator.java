package GUI;

import javax.swing.*;
import java.awt.*;

public final class ColorIndicator extends JPanel {
	
	private final Window window;
	
	public ColorIndicator(Window window) {
		
		super();
		this.window = window;
	}
	
	@Override
	protected final void paintComponent(Graphics g){
		
		super.paintComponent(g);  //paints the background
		
		int w = getWidth();             //widget dimensions
		int h = getHeight();
		
		g.setColor(window.getModel().getCurrentColor());
		g.fillRect(4,4,w-8,h-8);
		
		g.setColor(Color.BLACK);
		g.drawRect(4,4,w-8,h-8);
		
	
		
	}
	
	public void notifyForUpdate() {
		
		repaint();
	}

}
