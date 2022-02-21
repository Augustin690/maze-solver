package GUI;

import javax.swing.JMenuItem;

public class ExportItem extends JMenuItem{
	
	private final MazeApp mazeApp;
	
	public ExportItem(MazeApp mazeApp) {
		
		super("Export");
		this.mazeApp = mazeApp;
	}

}
