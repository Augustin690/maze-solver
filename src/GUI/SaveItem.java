package GUI;

import javax.swing.*;
import java.awt.event.*;

public class SaveItem extends JMenuItem implements ActionListener {
	
  private final MazeApp mazeApp;
	
	public SaveItem(MazeApp mazeApp) {
		
		super("Save");
		this.mazeApp = mazeApp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
