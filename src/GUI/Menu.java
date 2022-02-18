package GUI;

import javax.swing.*;

public class Menu extends JMenu {
	
	private final QuitItem quit;
	
	
	public Menu(Window window) {
		
		super("File");
		
		
		add(quit = new QuitItem(window));
	}

}
