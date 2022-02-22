package GUI;

import javax.swing.JLabel ;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

import Dijkstra.VertexInterface;
import Maze.MBox;
import Maze.Maze;
import model.WindowModel;

import java.awt.* ;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

public class MBoxPanel extends JPanel implements MouseListener {
	
	private final MazeApp mazeApp;
	private String labelMPanel;
	private MBox mbox;
	private static boolean imported;
	
	/*private JLabel image = new JLabel(new ImageIcon("data/BrickWall.jpg"));
	ImageIcon imageIcon = new ImageIcon("data/BrickWall.jpg");
	int width = imageIcon.getIconWidth() / 2;
	int height = imageIcon.getIconHeight() / 2;
	Image scaled = scaleImage(imageIcon.getImage(), width, height);
	
	private Image scaleImage(Image image, int w, int h) {

	    Image scaled = image.getScaledInstance(w+4, h+12, Image.SCALE_REPLICATE);

	    return scaled;
	}
	
	ImageIcon scaledIcon = new ImageIcon(scaled);

	JLabel newLabel = new JLabel(scaledIcon);*/
	
	public MBoxPanel(MazeApp mazeApp) {
		
		super();
		setBackground(Color.RED);
		
		this.mazeApp = mazeApp;
		addMouseListener(this);
		/*add(newLabel);	*/
		
	}
	
	@SuppressWarnings("deprecation")
	/*public void paint(Graphics g) {
		
		super.paint(g);
		
		int w = getWidth();
		int h = getHeight();
		System.out.println("yes1");
		boolean v = true;
		
		while(mazeApp.getModel().isModified()) {
			System.out.println("yes");
			g.setColor(mazeApp.getModel().getCurrentColor());
			g.fillRect(4,4,w-8,h-8);
			
			g.setColor(Color.BLACK);
			g.drawRect(4,4,w-8,h-8);
			/*v = false;*/
			/*if(!v) {
				break;
			}*/
		//}
		
	//}
	
	public void MouseEntered(MouseEvent e) {
		
		setBackground(Color.GREEN);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		/*MBoxPanel mPanel = (MBoxPanel) e.getSource();
		WindowModel model = mazeApp.getModel();
		Color newColor = JColorChooser.showDialog(mazeApp, "change MBox color", model.getCurrentColor());
		
		if(newColor != null) {
			/*setBackground(newColor);
			model.update();*/
			/*model.setCurrentColor(newColor,mPanel);
			System.out.println("hi lets goooooooooooooooooooo");
		}*/
	}
	
	public void refresh() {
		WindowModel model = mazeApp.getModel();
		
		
		if(imported) {
			
                 if(labelMPanel == "A") {
				
		         setBackground(Color.BLACK);
		         }
                 
                 if(labelMPanel == "D") {
				
				setBackground(Color.BLUE);
				}
                 
                 if(labelMPanel == "W") {
				
				setBackground(Color.GREEN);
				}
                 
                 if(labelMPanel == "E") {
				
				setBackground(Color.WHITE);
				}
           }
		}
	
	
	public void notifyForUpdate() {
		// TODO Auto-generated method stub
		refresh();
	}

	public String getLabelMPanel() {
		return labelMPanel;
	}

	public void setLabelMPanel(String labelMPanel) {
		this.labelMPanel = labelMPanel;
	}
	
	public static boolean isImported() {
		
		return imported;
	}
	
	public static void setImported(boolean imported) {
		
		MBoxPanel.imported = imported;
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


}
