package CH12;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Capture extends JFrame implements ActionListener{
	private JButton captureBtn, saveBtn;
	private JPanel imgPanel, btnPanel;

	BufferedImage img = null;
	Dimension d;

	public Capture() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(d = new Dimension(500, 500));


		imgPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, d.width, d.height, this);
			}
		};
			imgPanel.setOpaque(false);
			imgPanel.prepareImage(img, imgPanel);
			this.getContentPane().add(imgPanel);



		btnPanel = new JPanel();
		captureBtn = new JButton("Capture");
		captureBtn.addActionListener(this);
		saveBtn = new JButton("Save");
		saveBtn.addActionListener(this);

		btnPanel.add(captureBtn);
		btnPanel.add(saveBtn);


		this.add(btnPanel, BorderLayout.SOUTH);
		this.add(imgPanel);
		this.setVisible(true);


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == captureBtn) {
		Robot robot;
		try {
			robot = new Robot();
		    img = robot.createScreenCapture(new Rectangle(500,500));
			img.flush();
			imgPanel.repaint();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}


		}else if(e.getSource() == saveBtn) {
			try {
				ImageIO.write(img, "jpg", new File("Captured.jpg"));
				System.out.println("Save Successed");
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("Save Failed");
			}
		}

	}
	public static void main(String[] args) {
		JFrame frame = new Capture();
	}
}
