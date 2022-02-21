package GUI;

import javax.swing.*;

public class MenuBar extends JMenuBar {
	
	private FileMenu file;
	private SolveItem solve;
	
	public MenuBar(MazeApp mazeApp) {
		
		super();
				
		add(file = new FileMenu(mazeApp));
		add(solve = new SolveItem(mazeApp));
			
	}

}
