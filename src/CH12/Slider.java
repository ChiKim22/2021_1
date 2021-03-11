package CH12;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class Slider extends JFrame implements ChangeListener{

	private final int INTI_VALUE = 15;
	private JSlider slider;
	private JButton button;
	
	public Slider() {
		JPanel panel;
		
		this.setTitle("SliderDemo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		JLabel label = new JLabel("슬라이더를 움직여 보세요.", SwingConstants.CENTER);
		panel.add(label);
		
		slider = new JSlider(0, 30, INTI_VALUE);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTrack(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(this);
		panel.add(slider);
		
		button = new JButton(" ");
		ImageIcon icon = new ImageIcon("Dog.jpg");
		button.setIcon(icon);
		button.setSize(INTI_VALUE * 10, INTI_VALUE * 10);
		panel.add(button);
		
		this.add(panel);
		this.setResizable(false);
		this.setLocationRelativeTo(panel);
		this.setSize(350, 500);
		this.setVisible(true);
		
		
	}
		
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider source = (JSlider) e.getSource();
		if(!source.getValueIsAdjusting()) { // 슬라이딩을 멈추면 이미지 사이즈 조정.
			int value = source.getValue();
			button.setSize(value * 10, value * 10);
		}
	}
	
	public static void main(String args[]) {
		new Slider();
	}
}
