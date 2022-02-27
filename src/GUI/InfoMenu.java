package GUI;

import javax.swing.*;

public class InfoMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GeneralInfoItem generalInfoItem;
	
	public InfoMenu (MazeApp mazeApp) {
		
		super("Program info");
		
		add(generalInfoItem = new GeneralInfoItem(mazeApp));
	}

}
