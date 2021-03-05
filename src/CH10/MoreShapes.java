package CH10;

import javax.swing.*;
import java.awt.*;


public class MoreShapes extends JFrame{
	
	public MoreShapes() {
		setSize(600, 130);
		setTitle("Shapes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Shapes shapes = new Shapes();
		add(shapes);
		
		setVisible(true);
	}
	
	public static void main(String args[]) {
		JFrame frame = new MoreShapes();
	}
}
