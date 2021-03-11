package CH11;

import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.awt.*;
import javax.swing.*;

public class BazierCurve extends JFrame implements MouseListener, MouseMotionListener{
	
	
	private int[] xs = {50, 150, 400, 450};
	private int[] ys = {200, 50, 300, 200};
	
	private int dragIdx = -1;
	
	private MyPanel drawPanel;
	
	class MyPanel extends JPanel{
		
		@Override
		public void paintComponent(Graphics g) {
			
			
			g.setColor(Color.blue);
			g.fillRect(xs[0], ys[0], 16, 16);
			g.fillRect(xs[2], ys[2], 16, 16);
			
			g.setColor(Color.red);
			g.fillRect(xs[1], ys[1], 16, 16);
			g.fillRect(xs[3], ys[3], 16, 16);
			
			
			// 점 4개를 이용하여, 배지어 곡선 그리기.
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.white);
			GeneralPath path = new GeneralPath();
			path.moveTo(xs[0], ys[0]);
			path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
			g2d.draw(path);
		}
	}
	
	public BazierCurve() {
		
		setSize(600, 400);
		setTitle("Bazier Curve");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(drawPanel);
		setBackground(Color.gray);
		
		drawPanel = new MyPanel();
		drawPanel.addMouseListener(this);
		drawPanel.addMouseMotionListener(this);
		add(drawPanel, BorderLayout.CENTER);
		
		setVisible(true);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		dragIdx = -1;
		for(int i = 0; i < 4; i++) {
			Rectangle r = new Rectangle(xs[i] - 4, ys[i] - 4, 20, 20);
			if(r.contains(e.getX(), e.getY())){
				dragIdx = i;
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		dragIdx = -1;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(dragIdx != -1) {
			xs[dragIdx] = e.getX();
			ys[dragIdx] = e.getY();
		}
		repaint();
		
	}
 
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[]) {
		new BazierCurve();
	}

}
