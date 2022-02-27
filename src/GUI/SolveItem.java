package GUI;

import javax.swing.JMenuItem;

import model.Ctrl;

import java.awt.event.*;

public class SolveItem extends JMenuItem implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final MazeApp mazeApp;
	
	public SolveItem(MazeApp mazeApp) {
		
		super("solve");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Ctrl.setSolved(true);
		Ctrl.setWallsSelection(false);
		System.out.println("solvingItem");
		Ctrl.setResetPath(true);
		System.out.println("model.resetPath()" + Ctrl.isResetPath()	);
		mazeApp.getModel().resetPath();
		Ctrl.setResetPath(false);
		System.out.println("model.solveMaze()");
		/*System.exit(0);*/
		mazeApp.getModel().solveMaze();
		Ctrl.setSolved(false);
		Ctrl.setWallsSelection(false);
	}

}
