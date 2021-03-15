package CH12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextConverter extends JFrame implements ActionListener {

	private JButton convertBtn, cancelBtn;
	private JTextArea textIn, textOut;

	public TextConverter() {
		this.setTitle("텍스트 변환");

		textIn = new JTextArea(10, 14);
		textOut = new JTextArea(10, 14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);

		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);

		convertBtn = new JButton("변환");
		cancelBtn = new JButton("취소");
		convertBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		JPanel btnPanel = new JPanel();
		btnPanel.add(convertBtn);
		btnPanel.add(cancelBtn);

		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(textAreaPanel, BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		this.add(mainPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);



	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		/*
		 * 변환 버튼이 클릭되었다면
		 * 좌측 텍스트에리어의 텍스트를 읽어서
		 * 영어호 변환하고 그 변환된 결과를 우측 텍스트에리어에 append
		 *
		 * 취소 버튼이 클릭되면
		 * 우측을 빈 문자열로 지정.
		 */

		if(e.getSource() == convertBtn) {
			String str = textIn.getText();
			String result = toEnglish(str);
			textOut.setText(result);
		}else {
			textOut.setText(" ");
		}


		}
		private String toEnglish(String korean) {

			// Korean 문자열을 영어로 변환해서 반환.

			/*
			 * 텍스트 => Text
			 * Text => english
			 */

			String result = null;
			result = korean.replace("텍스트", "Text");
			result = result.replace("영어", "English");
			return result;
		}

		public static void main(String args[]) {
			new TextConverter();
		}

}
