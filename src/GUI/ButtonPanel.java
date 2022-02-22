package GUI;

import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private WallButton wallButton;
	
	public ButtonPanel(MazeApp mazeApp) {
		
		super();
		
		add(wallButton = new WallButton(mazeApp));
		
		
	}
	
}
