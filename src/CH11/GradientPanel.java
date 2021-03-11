package CH11;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GradientPanel extends Shapes{
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		GradientPaint gp = new GradientPaint(0, 10, Color.green, 0, 70, Color.yellow);
		for(Shape s : shapeArr) {
			g2.setPaint(gp);
			g2.fill(s);
		}
	}
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		
		
		frame.setSize(600, 130);
		frame.setTitle("Java 2D Shapes");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.add(new GradientPanel());
		frame.setVisible(true);
		
	}
	
}
