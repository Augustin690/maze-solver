package GUI;

import java.awt.*;
import javax.swing.*;

public final class ButtonsPanel extends JPanel{
	
	private final ColorIndicator colorIndicator;
	private final ColorChooser colorChooser;
	private final EraseSegment eraseSegment;
	
	public ButtonsPanel(Window window) {
		
		super();
		
		setLayout(new GridLayout(1,3));
		
		add(colorIndicator = new ColorIndicator(window));
		add(colorChooser = new ColorChooser(window));
		add(eraseSegment = new EraseSegment(window));
	}
	
	public void notifyForUpdate() {
		
		colorIndicator.notifyForUpdate();
		eraseSegment.notifyForUpdate();
	}

}
