package GUI;

import javax.swing.JButton;

import Maze.MBox;

import java.awt.event.*;

public class StartButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private final MazeApp mazeApp;
    private static boolean startSelection = false;
	
	public StartButton(MazeApp mazeApp) {
		
		super("Select start");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setStartSelection(true);
	}




	public MazeApp getMazeApp() {
		return mazeApp;
	}




	public static boolean isStartSelection() {
		return startSelection;
	}




	public static void setStartSelection(boolean startSelection) {
		StartButton.startSelection = startSelection;
	}




	public void notifyForUpdate(MBoxPanel mboxPanel) {
		// TODO Auto-generated method stub
		
	}

}
