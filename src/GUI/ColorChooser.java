package GUI;

import javax.swing.*;

public final class ColorChooser extends JButton {
	
	private final Window window;
	
	public ColorChooser(Window window) {
		
		super("Choose color");
		this.window = window;
	}
	

}
