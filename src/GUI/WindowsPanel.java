package GUI;

import javax.swing.*;
import java.awt.*;

public final class WindowsPanel extends JPanel {
	
	private final DrawingPanel drawingPanel;
	/*private final ButtonsPanel buttonsPanel;*/
	
	public WindowsPanel(MazeApp mazeApp) {
		
		super();
		
		setLayout(new BorderLayout());
		
		add(drawingPanel = new DrawingPanel(mazeApp));
		
		/*add(buttonsPanel = new ButtonsPanel(window), BorderLayout.SOUTH);*/
	}
	
	public void notifyForUpdate() {
		
		drawingPanel.notifyForUpdate();
		/*buttonsPanel.notifyForUpdate();*/
	}
	
	public DrawingPanel getDrawingPanel() {
		
		return drawingPanel;
	}

}
