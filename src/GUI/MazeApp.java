package GUI;

import java.lang.reflect.Parameter;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import Maze.MBox;
import model.WindowModel;

public class MazeApp extends JFrame implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2815577872584840591L;
	
	private final MenuBar menuBar;
	private final WindowsPanel windowPanel;
	private WindowModel windowModel = new WindowModel();
	/*private final JPanel panel;*/

	@SuppressWarnings("deprecation")
	public MazeApp() {
		super("Maze solving program");
		
		windowModel.addObserver(this);
		//menu bar
		menuBar = new MenuBar(this);
		setJMenuBar(menuBar);
		
		//content creation
		windowPanel = new WindowsPanel(this);
		setContentPane(windowPanel);
		
		
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

	@SuppressWarnings("deprecation")
	@Override
	public void update(Observable observable, Object parameter) {
		// TODO Auto-generated method stub
		notifyForUpdate();
	}
	
	public void notifyForUpdate() {
		
		windowPanel.notifyForUpdate();
	}
	
     public void notifyForUpdate(MBox mbox) {
		
		windowPanel.notifyForUpdate(mbox);
	}
	
	public WindowsPanel getPanel() {
		
		return windowPanel;
	}

}
