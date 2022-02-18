package GUI;

import javax.swing.*;
import java.awt.*;

public final class WindowsPanel extends JPanel {
	
	private final DrawingPanel drawingPanel;
	private final ButtonsPanel buttonsPanel;
	
	public WindowsPanel(Window window) {
		
		super();
		
		setLayout(new BorderLayout());
		
		add(drawingPanel = new DrawingPanel(window), BorderLayout.CENTER);
		
		add(buttonsPanel = new ButtonsPanel(window), BorderLayout.SOUTH);
	}
	
	public void notifyForUpdate() {
		
		drawingPanel.notifyForUpdate();
		buttonsPanel.notifyForUpdate();
	}

}
