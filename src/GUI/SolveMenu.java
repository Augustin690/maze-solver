package GUI;

import javax.swing.JMenu;

public class SolveMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final SolveItem solveItem;
	
	public SolveMenu(MazeApp mazeApp) {
		
		super("Solve");
		
		add(solveItem = new SolveItem(mazeApp));
	}

}
