package GUI;

import javax.swing.JButton;

import model.Ctrl;

import java.awt.event.*;

public class EndButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private final MazeApp mazeApp;
	
	public EndButton(MazeApp mazeApp) {
		
		super("Select finish");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Ctrl.setEndSelection(true);	
		Ctrl.setModified(true);
	}

	public MazeApp getMazeApp() {
		return mazeApp;
	}

	public void notifyForUpdate(MBoxPanel mboxPanel) {
		// TODO Auto-generated method stub
		
	}

}
