package CH12;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ComboBox extends JFrame implements ActionListener{
	
	private JLabel label;
	private JComboBox animalList;
	
	public ComboBox() {
		this.setTitle("ComboBoxDemo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 400);
		
		String[] animals = {"Dog", "Cat", "Lion"};
		animalList = new JComboBox(animals);
		animalList.setSelectedIndex(0);
		animalList.addActionListener(this);
		
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		changePicture(animals[animalList.getSelectedIndex()]);
		
		this.add(animalList, BorderLayout.NORTH);
		this.add(label, BorderLayout.CENTER);
		this.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = (String) animalList.getSelectedItem();
		changePicture(name);
		
	}
	
	private void changePicture(String name) {
		// TODO Auto-generated method stub
		
		ImageIcon icon = new ImageIcon(name + ".jpg");
		label.setIcon(icon);
		label.setText(null);
		
	}

	public static void main(String args[]) {
		new ComboBox();
	}
	

}
