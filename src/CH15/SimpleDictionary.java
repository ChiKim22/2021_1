package CH15;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class SimpleDictionary extends JPanel implements ActionListener{
	/*
	 * 단어 입력받는 JTextField
	 * 검색버튼
	 * 추가버튼
	 * 단어장 구현을 위한 Map 객체
	 */

	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("Search");
	private JButton addBtn = new JButton("Add");

	//Map 객체로 단어장 구현
	// <Key, Value> 쌍으로 저장. key는 한글, value는 대응되는 영어단어.
	Map<String, String> dict = new HashMap<>();
	private static final String DIC_FILE_NAME = "dict.props";

	public SimpleDictionary() {
		//Panel 의 기본 레이아웃 : FlowLayout
		this.add(inputField);
		this.add(searchBtn);
		this.add(addBtn);

		//SearchBtn, AddBtn 에 클릭이벤트를 처리해주는 리스너 지정.
		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);

		this.setSize(new Dimension(600, 50));

		//파일에 key = value 형태로 저장된 엔트리들을 읽어서, dict를 구성.
		buildDictionaryFromFile();
	}

	private void buildDictionaryFromFile() {
		// Properities 도 일종의 Map 이며,
		// Key, Value 쌍의 타입이 각각 String, String로 고정된 일종의 Map이다.
		Properties props = new Properties();
//		props.put("사과", "Apple");
//		System.out.println(props.get("사과"));

		// 파일에서 이릭어서 props 객체의 <key, value> 쌍을 구성할 수 있다.
//		FileReader fReader = null;
		try (FileReader fReader = new FileReader(DIC_FILE_NAME)){
			props.load(fReader);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Set<Object> set = props.keySet();
		for(Object obj : set) {
			dict.put((String)obj, (String)props.get(obj));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = inputField.getText();
		if(key.trim().length() == 0) return;// 공백만 입력된 경우는 무시

		if(e.getSource() == searchBtn) {
			/*
			 * 입력된 단어를 추출
			 * 그 단어를 키 값으로 가지는 대응되는 맵 엔트리가 있는지 검사
			 * dict.get("단어");
			 * 그 단어에 대응되는 값이 있으면, JOptionPane.showMessageDialog() 메서드를 호출.
			 * 대응되는 값을 보여줌. 없으면 (null)이면 JOptionPane.showMessageDialog() 메서드 호출.
			 * "단어를 찾을 수 없습니다." 출력
			 * inputField를 빈문자열로 설정.
			 */

			System.out.println("[" + key + "]");
			String value = dict.get(key);

			if(value != null) { // 대응되는 단어가 있는 경우.
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
			}else { // 대응되는 단어가 없는 경우.
				JOptionPane.showMessageDialog(this, "단어를 찾을 수 없음.", key, JOptionPane.ERROR_MESSAGE);
			}



		}else if(e.getSource() == addBtn) {
			/*
			 * 입력된 단어를 추출
			 * String value = JOptionPane.showMessafeDialog();
			 * 메서드를 호출해서 추가할 영어 단어를 입력받음.
			 * dict.put (입력필드에 입력된 단어, inputDialog에 입력된 단어);
			 */
			String value = JOptionPane.showInputDialog(this,
				"입력한 "+ key + " 에 대응되는 영어단어를 입력하세요.");
			if(value.trim().length() == 0) return;
			dict.put(key, value);
			addWordToFile(key, value);
			JOptionPane.showMessageDialog(this, value + " 영어단어가 추가되었습니다.",
					key, JOptionPane.INFORMATION_MESSAGE);
		}
//		inputField.setText("");

	}

	private void addWordToFile(String key, String value) {

		try(FileWriter fWriter =
				new FileWriter(DIC_FILE_NAME, true)){
			fWriter.write(key+"="+value+"\n"); // 덮어씀.
		}catch(Exception e) {
			System.out.println(e.getMessage());
			}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		SimpleDictionary dictPanel = new SimpleDictionary();
		frame.add(dictPanel);

		frame.setTitle("Simple Dictionary");
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(dictPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
