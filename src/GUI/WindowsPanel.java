package GUI;

import javax.swing.*;

import Maze.MBox;

import java.awt.*;

public final class WindowsPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final DrawingPanel drawingPanel;
	private final ButtonPanel buttonsPanel;
	
	public WindowsPanel(MazeApp mazeApp) {
		
		super();
		
		setLayout(new BorderLayout());
		
		add(drawingPanel = new DrawingPanel(mazeApp));
		
		add(buttonsPanel = new ButtonPanel(mazeApp), BorderLayout.SOUTH);
	}
	
	public void notifyForUpdate() {
		
		System.out.println("notifyforupdate()windowspanel");
		drawingPanel.notifyForUpdate();
		/*buttonsPanel.notifyForUpdate();*/
	}
	
	public void notifyForUpdate(MBoxPanel mboxPanel) {
		
		System.out.println("notifyforupdate(mboxpanel)windowspanel");
		drawingPanel.notifyForUpdate(mboxPanel);
		/*buttonsPanel.notifyForUpdate(mboxPanel);*/
	}
	
	public DrawingPanel getDrawingPanel() {
		
		return drawingPanel;
	}

	public ButtonPanel getButtonsPanel() {
		return buttonsPanel;
	}

}
