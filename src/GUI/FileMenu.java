package GUI;

import javax.swing.*;

public class FileMenu extends JMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final QuitItem quit;
	private final SaveItem save;
	private final ImportItem importItem;
	private final NewItem newItem;
	
	public FileMenu(MazeApp mazeApp) {
		
		super("File");
		
		
		add(quit = new QuitItem(mazeApp));
		add(save = new SaveItem(mazeApp));
		add(importItem = new ImportItem(mazeApp));
		add(newItem = new NewItem(mazeApp));

	}

}
