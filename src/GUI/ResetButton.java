package GUI;

import javax.swing.JButton;

import model.Ctrl;

import java.awt.event.*;

public class ResetButton extends JButton implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final MazeApp mazeApp;
	
	
	public ResetButton(MazeApp mazeApp) {
		
		super("Reset");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Ctrl.setResetActive(true);
		Ctrl.setModified(false);
		System.out.println("yess");
		mazeApp.getModel().resetMaze();
		System.out.println("yess2");
		Ctrl.setResetActive(false);
		Ctrl.setWallsSelection(false);
	}

	public MazeApp getMazeApp() {
		return mazeApp;
	}


}
