package GUI;

import javax.swing.JButton;

import Maze.MBox;

import java.awt.event.*;

public class WallButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final MazeApp mazeApp;
	private static boolean wallsSelection = false;
	
	public WallButton(MazeApp mazeApp) {
		
		super("Create walls");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setWallsSelection(true);
		System.out.println(isWallsSelection());
	}

	public MazeApp getMazeApp() {
		return mazeApp;
	}

	public static boolean isWallsSelection() {
		return wallsSelection;
	}

	public static void setWallsSelection(boolean wallsSelection) {
		WallButton.wallsSelection = wallsSelection;
	}

	public void notifyForUpdate(MBoxPanel mboxPanel) {
		// TODO Auto-generated method stub
		
	}
	

}
