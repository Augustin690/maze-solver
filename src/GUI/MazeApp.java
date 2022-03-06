package GUI;

import java.lang.reflect.Parameter;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import Maze.MBox;
import Maze.Maze;
import model.Ctrl;
import model.WindowModel;

/**
 * 
 * @author Augustin
 * vamos a la playa
 */
@SuppressWarnings("deprecation")
public class MazeApp extends JFrame implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2815577872584840591L;
	
	private final MenuBar menuBar;
	private final WindowsPanel windowPanel;
	private WindowModel windowModel = new WindowModel();

	public MazeApp() {
		super("Maze solving program");
		
		
		ImageIcon img = new ImageIcon("data/BrickWall.jpg");
		setIconImage(img.getImage());
		
		windowModel.addObserver(this);
		//menu bar
		menuBar = new MenuBar(this);
		setJMenuBar(menuBar);
		
		String inputWidth = JOptionPane.showInputDialog("enter number of columns");
		int w = Integer.parseInt(inputWidth);
		windowModel.setWidth(w);
		
		String inputDepth = JOptionPane.showInputDialog("enter number of rows");
		int d = Integer.parseInt(inputDepth);
		windowModel.setDepth(d);
		
		WindowModel.getMazeModel().setMaze(new MBox[w][d]);
		
		//content creation
		windowPanel = new WindowsPanel(this);
		setContentPane(windowPanel);
		JOptionPane.showMessageDialog(this, "if you are using that program for the first time do not hesitate \n "
				+ "to go to the info Menu to learn on how to use this program");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();
		setVisible(true);
	}
	
	
	public final WindowModel getModel() {
		
		return windowModel;
	}
	
	public final void setModel(WindowModel windowModel) {
		
		this.windowModel = windowModel;
	}

	@Override
	public void update(Observable observable, Object parameter) {
		// TODO Auto-generated method stub
		if(Ctrl.isImported() || Ctrl.isSolved()) {
			if(/*WallButton.isWallsSelection() !Ctrl.isModified()*/ parameter == null) {
				System.out.println("MazeApp.notifyForUpdate()")	;
				notifyForUpdate();
			}

			else {
				System.out.println("MazeApp.notifyForUpdate(param)");
				notifyForUpdate((MBoxPanel) parameter);
			}			
		}
		
		else {
			System.out.println("MazeApp.notifyForUpdate(param)");
			notifyForUpdate((MBoxPanel) parameter);
		}	
	}
	
	public void notifyForUpdate() {
		
		windowPanel.notifyForUpdate();
	}
	
     public void notifyForUpdate(MBoxPanel mboxPanel) {
		
		windowPanel.notifyForUpdate(mboxPanel);
	}
	
	public WindowsPanel getPanel() {
		
		return windowPanel;
	}

}
