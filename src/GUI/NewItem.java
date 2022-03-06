package GUI;

import javax.swing.JMenuItem;
import java.awt.event.*;

public class NewItem extends JMenuItem implements ActionListener {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final MazeApp mazeApp;
	
	public NewItem(MazeApp mazeApp) {
		
		super("New");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new MazeApp();
	}

}
