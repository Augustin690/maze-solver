package GUI;

import javax.swing.*;

public class QuitItem extends JMenuItem{
	
	private final Window window;
	
	public QuitItem(Window window) {
		
		super("Quit");
		this.window = window;
	}

}
