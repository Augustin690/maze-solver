package GUI;

import javax.swing.*;

public class MenuBar extends JMenuBar {
	
	private Menu menu;
	
	
	public MenuBar(Window window) {
		
		super();
		
		
		add(menu = new Menu(window));
	}

}
