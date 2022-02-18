package GUI;

import javax.swing.*;

import model.Segment;

public final class EraseSegment extends JButton {
	
	private final Window window;
	
	public EraseSegment(Window window) {
		
		super("Erase Segment");
		this.window = window;
	}
	
	public void notifyForUpdate() {
		
		Segment selected = window.getModel().getSelectedSegment();
		setEnabled(selected != null);
	}

}
