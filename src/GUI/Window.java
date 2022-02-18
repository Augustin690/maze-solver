package GUI;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import model.WindowModel;

public class Window extends JFrame implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2815577872584840591L;
	
	private final MenuBar menuBar;
	private final WindowsPanel windowPanel;
	/*private final JPanel panel;*/

	public Window() {
		super("Drawing space");
		
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
	
	private WindowModel windowModel = new WindowModel();
	
	public final WindowModel getModel() {
		
		return windowModel;
	}
	
	public final void setModel(WindowModel windowModel) {
		
		this.windowModel = windowModel;
	}

	@Override
	public void update(Observable observable, Object parameter) {
		// TODO Auto-generated method stub
		notifyForUpdate();
	}
	
	public void notifyForUpdate() {
		
		windowPanel.notifyForUpdate();
	}

}
