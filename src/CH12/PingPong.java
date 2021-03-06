package CH12;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PingPong extends JPanel implements KeyListener{

	protected Ball ball;
	protected Racquet racquet1, racquet2;
	private Score score;

	public PingPong() {
		ball = new Ball(this, Color.WHITE);
		this.setBackground(Color.BLACK);
		racquet1 = new Racquet(this, 0, 150, Color.BLUE);
		racquet2 = new Racquet(this, 590, 150, Color.YELLOW);
		score = new Score();
		this.setFocusable(true);
		this.addKeyListener(this);

	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.drawLine(295, 0, 295, 400);
		Graphics2D g2d = (Graphics2D) g;
		ball.draw(g2d);
		racquet1.draw(g2d);
		racquet2.draw(g2d);
		score.draw(g2d);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		racquet1.keyPressed(e);
		racquet2.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		racquet1.keyRealeased(e);
		racquet2.keyRealeased(e);
	}

	void move() {
		ball.move();
		racquet1.move();
		racquet2.move2();
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("PingPong Game");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(frame);

		PingPong pingPong = new PingPong();

		frame.add(pingPong);
		frame.setVisible(true);
		while(true){
			pingPong.move();
			pingPong.repaint();
			try {
				Thread.sleep(7);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
	class Ball {
		private static final int RADIUS = 20;
		private int x = 0, y = 0, xSpeed = 1, ySpeed = 1;
		private PingPong pingPong;
		private Color color;
		int player1 = 0, player2 = 0;

		public Ball(PingPong pingPong, Color color) {
			// TODO Auto-generated constructor stub
			this.pingPong = pingPong;
			this.color = color;
		}

		void move() {
			if(x + xSpeed < 0) {
				xSpeed = 1;
				score.getScore(player1, ++player2);
			}

			if(x + xSpeed > pingPong.getWidth() - 2 * RADIUS) {
				xSpeed = -1;
				score.getScore(++player1, player2);
			}

			if(y + ySpeed < 0) {
				ySpeed = 1;
			}

			if(y + ySpeed > pingPong.getHeight() - 2 * RADIUS) {
				ySpeed = -1;
			}

			if(collision()) {
				xSpeed = -xSpeed;
			}

			x += xSpeed;
			y += ySpeed;
		}
		private boolean collision() {
			return pingPong.racquet1.getBounds().intersects(getBounds())
					|| pingPong.racquet2.getBounds().intersects(getBounds());
		}
		private Rectangle getBounds() {
			// TODO Auto-generated method stub
			return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
		}

		public void draw(Graphics2D g) {
			g.setColor(color);
			g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
		}

	}

	class Racquet{
		int getySpeed() {
			return ySpeed;
		}

		void setySpeed(int ySpeed) {
			this.ySpeed = ySpeed;
		}

		private static final int WIDTH = 10, HEIGHT = 80;
		private int x = 0, y = 0, ySpeed = 0, ySpeed2 = 0;
		private PingPong pingPong;
		private Color color;

		public Racquet(PingPong pingPong, int x, int y, Color color) {
			// TODO Auto-generated constructor stub
			this.pingPong = pingPong;
			this.x = x;
			this.y = y;
			this.color = color;
		}
		public void move() {
			if(y + ySpeed2 > 0 && y + ySpeed2 < pingPong.getHeight() - HEIGHT) {
				y += ySpeed2;
			}
		}
		public void move2() {
			if(y + ySpeed > 0 && y + ySpeed < pingPong.getHeight() - HEIGHT) {
				y += ySpeed;
			}
		}

		public void draw(Graphics2D g) {
			g.setColor(color);
			g.fillRect(x, y, WIDTH, HEIGHT);
		}
		public void keyRealeased(KeyEvent e) {
			ySpeed = 0;
			ySpeed2 = 0;
		}

		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) { // ????????? ???
				ySpeed = -3;
			}else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				ySpeed = 3;
			}else if (e.getKeyCode() == KeyEvent.VK_W) { // ?????? ???
				ySpeed2 = -3;
			}else if (e.getKeyCode() == KeyEvent.VK_S) {
				ySpeed2 = 3;
			}

		}

		public Rectangle getBounds() {
			return new Rectangle(x, y, WIDTH, HEIGHT);
		}
	}

	class Score{
		protected int player1 = 0, player2 = 0;

		public void getScore(int player1, int player2) {
			this.player1 = player1;
			this.player2 = player2;
		}

		public void draw(Graphics g) {
			g.setColor(Color.WHITE);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
			g.drawString(String.valueOf(player1), 250, 50);
			g.drawString(String.valueOf(player2), 300, 50);

		}
	}



}

