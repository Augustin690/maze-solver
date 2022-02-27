package GUI;

import javax.swing.JButton;

import Maze.MBox;
import model.Ctrl;

import java.awt.event.*;

public class StartButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private final MazeApp mazeApp;
	
	public StartButton(MazeApp mazeApp) {
		
		super("Select start");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Ctrl.setStartSelection(true);
		Ctrl.setModified(true);
	}

	public MazeApp getMazeApp() {
		return mazeApp;
	}

	public void notifyForUpdate(MBoxPanel mboxPanel) {
		// TODO Auto-generated method stub
		
	}

}
