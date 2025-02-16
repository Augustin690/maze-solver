package GUI;

import javax.swing.JButton;

import model.Ctrl;

import java.awt.event.*;

public class WallButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final MazeApp mazeApp;
	
	public WallButton(MazeApp mazeApp) {
		
		super("Create walls");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Ctrl.setWallsSelection(true);
		Ctrl.setModified(true);
		System.out.println(Ctrl.isWallsSelection());
	}

	public MazeApp getMazeApp() {
		return mazeApp;
	}

	public void notifyForUpdate(MBoxPanel mboxPanel) {
		// TODO Auto-generated method stub
		
	}
	

}
