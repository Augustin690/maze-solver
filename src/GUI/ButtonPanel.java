package GUI;

import java.awt.Component;

import javax.swing.JPanel;

import Maze.MBox;

public class ButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private WallButton wallButton;
	private StartButton startButton;
	private EndButton endButton;
	private ResetButton resetButton;
	
	
	public ButtonPanel(MazeApp mazeApp) {
		
		super();
		
		add(setWallButton(new WallButton(mazeApp)));
		add(setStartButton(new StartButton(mazeApp)));
		add(setEndButton(new EndButton(mazeApp)));
		add(setResetButton(new ResetButton(mazeApp)));
	}

	public WallButton getWallButton() {
		return wallButton;
	}

	public WallButton setWallButton(WallButton wallButton) {
		this.wallButton = wallButton;
		return wallButton;
	}

	public StartButton getStartButton() {
		return startButton;
	}

	public StartButton setStartButton(StartButton startButton) {
		this.startButton = startButton;
		return startButton;
	}

	public EndButton getEndButton() {
		return endButton;
	}

	public EndButton setEndButton(EndButton endButton) {
		this.endButton = endButton;
		return endButton;
	}

	public void notifyForUpdate(MBoxPanel mboxPanel) {
		// TODO Auto-generated method stub
		/*wallButton.notifyForUpdate(mboxPanel);
		startButton.notifyForUpdate(mboxPanel);
		endButton.notifyForUpdate(mboxPanel);*/
		
	}

	public ResetButton getResetButton() {
		return resetButton;
	}

	public ResetButton setResetButton(ResetButton resetButton) {
		this.resetButton = resetButton;
		return resetButton;
	}


	
	
	
	
	
}
