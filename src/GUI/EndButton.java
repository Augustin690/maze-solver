package GUI;

import javax.swing.JButton;

import Maze.MBox;

import java.awt.event.*;

public class EndButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private final MazeApp mazeApp;
    private static boolean endSelection = false;
	
	public EndButton(MazeApp mazeApp) {
		
		super("Select finish");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setEndSelection(true);	
	}

	public MazeApp getMazeApp() {
		return mazeApp;
	}

	public static boolean isEndSelection() {
		return endSelection;
	}

	public static void setEndSelection(boolean endSelection) {
		EndButton.endSelection = endSelection;
	}







	public void notifyForUpdate(MBoxPanel mboxPanel) {
		// TODO Auto-generated method stub
		
	}

}
