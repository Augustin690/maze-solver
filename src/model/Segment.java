package model;

import java.awt.*;
import java.awt.geom.*;

public final class Segment extends Line2D.Float {
	
	private Color color;
	
	public Segment(float x1, float y1, float x2, float y2, Color color) {
		
		super(x1,y1,x2,y2);
		this.color = color;
	}
	
	private final static float[] dash = { 4.0f };
	
	private final static BasicStroke usualStroke;
	private final static BasicStroke largerStroke;
	private final static BasicStroke dashStroke;
	
	static {
		
		usualStroke = new BasicStroke();
		largerStroke = new BasicStroke(3.0f, BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
		dashStroke = new BasicStroke(1.0f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10.0f,dash,0.0f);
	}
	
	public final void paintDashed(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(color);
		
		g2d.setStroke(dashStroke); //set to dashed rendering
		g2d.draw(this);            //draw the segment
		g2d.setStroke(usualStroke); //restore to normal settings
		
	}
	
	public final void paintLarger(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(color);
		
		g2d.setStroke(largerStroke); //set to larger rendering
		g2d.draw(this);            //draw the segment
		g2d.setStroke(usualStroke); //restore to normal settings
		
		
	}
	
	public final void paintNormal(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(color);
		
		g2d.draw(this);
	}

}
