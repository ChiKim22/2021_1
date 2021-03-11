package CH11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Float;

public class QuadraticFunction extends JPanel implements ActionListener{
	
	private JTextField aField, bField, cField;
	private double aCE = 1.0, bCE = -5.0, cCE = 6.0; // cofficient of x(2), x, and a constant
	
	public QuadraticFunction() {
		
		aField = new JTextField("1.0", 10);
		bField = new JTextField("-5.0", 10);
		cField = new JTextField("6.0", 10);
		
		this.add(aField);
		this.add(bField);
		this.add(cField);
		
		JButton drawBtn = new JButton("Draw");
		this.add(drawBtn);
		drawBtn.addActionListener(this);
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawLine(100, 200, 500, 200);
		g2d.drawLine(300, 0, 300, 400);
		
		g2d.setColor(Color.RED);
		System.out.println("!aCE :" + aCE + "!bCE :" + bCE + "!cCE" + cCE);
		for(int i = -20; i < 20; i++) {
			int x = i;
			int y = (int) (aCE * x * x -bCE * x + cCE);
			Shape s = new Ellipse2D.Float(300 + x-2, 200 - y + 2, 4, 4);
			g2d.fill(s);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		aCE = Double.parseDouble(aField.getText());
		bCE = Double.parseDouble(bField.getText());
		cCE = Double.parseDouble(cField.getText());
		
		System.out.println("!aCE :" + aCE + "!bCE :" + bCE + "!cCE" + cCE);
		repaint();
		
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame();
		
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new QuadraticFunction());
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
		
	}
}
