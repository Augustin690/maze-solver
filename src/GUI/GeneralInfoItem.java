package GUI;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.*;

public class GeneralInfoItem extends JMenuItem implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MazeApp mazeApp;
	
	public GeneralInfoItem(MazeApp mazeApp) {
		
		super("General info");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(mazeApp,"Here is some general info about this maze solving program you are about to use:\n"
				+ "You can either import an already-made Maze in the form of a .txt file on your computer,\n"
				+ " and edit it if you want or create it from nothing thanks to three buttons \n"
				+ " that allow you to create a start, a finish, and walls");
		JOptionPane.showMessageDialog(mazeApp, "To do so, you have a 'File' Menu at the top left corner of the menu bar that allows you \n "
				+ "to import a Maze and then display it, save it to a new .txt file and also quit the program \n"
				+ "you will find more info in this very 'Info' Menu with sections dedicated to each important \n"
				+ "feature of this program. Enjoy! ");
	}

}
