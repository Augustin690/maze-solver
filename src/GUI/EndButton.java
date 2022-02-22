package GUI;

import javax.swing.JButton;
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
		
	}







	public MazeApp getMazeApp() {
		return mazeApp;
	}

}
