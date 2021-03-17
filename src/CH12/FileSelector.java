package CH12;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileSelector extends JFrame implements ActionListener{

	private JButton openBtn, saveBtn;
	private JFileChooser fileSelector;

	public FileSelector() {
		this.setTitle("파일 선택기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(fileSelector);
		this.setSize(250, 200);
		fileSelector = new JFileChooser();

		JLabel label = new JLabel("파일 선택기 컴포넌트 테스트입니다.");
		openBtn = new JButton("파일 열기");
		openBtn.addActionListener(this);

		saveBtn = new JButton("파일 저장");
		saveBtn.addActionListener(this);

		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(openBtn);
		panel.add(saveBtn);

		this.add(panel);

		this.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == openBtn) {
			int returnVal = fileSelector.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileSelector.getSelectedFile();
				System.out.println("open file : " + file.getAbsolutePath());
			}else {
				System.out.println("Not Selected...");
			}
		}else if(e.getSource() == saveBtn) {
			int returnVal = fileSelector.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileSelector.getSelectedFile();
				System.out.println("save to " + file.getAbsolutePath());
			}else {
				System.out.println("Not Canceled...");
			}

		}

	}
	public static void main(String args[]) {
		new FileSelector();
	}
}
