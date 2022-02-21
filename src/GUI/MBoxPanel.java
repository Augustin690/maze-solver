package GUI;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

import model.WindowModel;

import java.awt.* ;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MBoxPanel extends JPanel implements MouseListener {
	
	private final MazeApp mazeApp;
	private String label;
	
	public MBoxPanel(MazeApp mazeApp) {
		
		super();
		setBackground(Color.RED);
		
		this.mazeApp = mazeApp;
		addMouseListener(this);
		
	}
	
	/*public final void paint(Graphics g) {
		
		super.paint(g);
		
		int w = getWidth();
		int h = getHeight();
		
		g.setColor(mazeApp.getModel().getCurrentColor());
		g.fillRect(4,4,w-8,h-8);
		
		g.setColor(Color.BLACK);
		g.drawRect(4,4,w-8,h-8);
	}*/
	public void MouseEntered(MouseEvent e) {
		
		setBackground(Color.GREEN);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		WindowModel model = mazeApp.getModel();
		Color newColor = JColorChooser.showDialog(mazeApp, "change MBox color", model.getCurrentColor());
		
		if(newColor != null) {
			setBackground(newColor);
			model.update();
		}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void notifyForUpdate() {
		// TODO Auto-generated method stub
		repaint();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
