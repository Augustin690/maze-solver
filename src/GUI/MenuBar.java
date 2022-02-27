package GUI;

import javax.swing.*;

public class MenuBar extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final FileMenu fileMenu;
	private final  SolveMenu solveMenu;
	private final InfoMenu infoMenu;
	
	public MenuBar(MazeApp mazeApp) {
		
		super();
				
		add(fileMenu = new FileMenu(mazeApp));
		add(solveMenu = new SolveMenu(mazeApp));
		add(infoMenu = new InfoMenu(mazeApp));
	}

}
