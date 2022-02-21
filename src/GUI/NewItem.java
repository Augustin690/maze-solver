package GUI;

import javax.swing.JMenuItem;

import model.WindowModel;

import java.awt.event.*;
import java.awt.Color;

public class NewItem extends JMenuItem implements ActionListener {
	
	private final MazeApp mazeApp;
	
	public NewItem(MazeApp mazeApp) {
		
		super("New");
		this.mazeApp = mazeApp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		WindowModel model = mazeApp.getModel();
		
		if (model.hasChanged()) {
			
			setBackground(Color.GREEN);
		}
	}
	

}
