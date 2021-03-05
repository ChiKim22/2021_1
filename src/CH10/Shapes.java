package CH10;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Shapes extends JPanel{
	
	ArrayList<Shape> shapeArr = new ArrayList<Shape>();
	
	public Shapes() {
//		new Rectangle2D.Float();
//		Shape rect = new Rectangle2D.Float(10, 10, 70, 80); 
		
		shapeArr.add(new Rectangle2D.Float(10, 10, 70, 80)); // 사각형.
		
		shapeArr.add(new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20)); //둥근 사각형, 끝에 20, 20 은 곡률 조정.
		
		shapeArr.add(new Ellipse2D.Float(210, 10, 80, 80)); //원.
		
		shapeArr.add(new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN)); // 원의 오.
		
		shapeArr.add(new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD)); // 반원.
		
		shapeArr.add(new Arc2D.Float(510, 10, 80, 80, 45, 45, Arc2D.PIE)); // 부채꼴.
		
	}
	@Override
	public void	paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //선 부드럽게
		
		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(3));
		
		for(Shape s : shapeArr) {
			g2.draw(s);
		}
		
	}
}
