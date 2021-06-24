package CH19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;


public class TableViewer extends JFrame implements ActionListener{

	private JTextField idField, titleField, publisherField, yearField, priceField, authoField;
	private JButton preBtn, nextBtn, insertBtn, finishBtn;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private Connection conn = null;

	public TableViewer() {
		/*
		 * 1. 드라이버 적재
		 * 2. DB 연결
		 * 3. PreparedStatement 객체 생성
		 * 4. SQL문 실행.
		 */

		super("Database Viewer");

		//		conn = null;
		try {
			conn = makeConnection();
		}catch(Exception e) {
			System.out.println("Connection Failed...");
			System.out.println(e.getMessage());
			return;
		}

		try {
			String sql = "SELECT * FROM books ORDER BY book_id";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // 변경을 하면 반영을 해서 바로 반영.
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			System.out.println("SQL 문의 실행에 실패함...");
			System.out.println(e.getMessage());
			System.out.println("Shutting Down...");
			return;
		}


		// GridLayout로 설정.
		this.setLayout(new GridLayout(0, 2));

		this.add(new JLabel("ID", JLabel.CENTER));
		idField = new JTextField();
		this.add(idField);

		this.add(new JLabel("Title", JLabel.CENTER));
		titleField = new JTextField();
		this.add(titleField);

		this.add(new JLabel("Publisher", JLabel.CENTER));
		publisherField = new JTextField();
		this.add(publisherField);

		this.add(new JLabel("Year", JLabel.CENTER));
		yearField = new JTextField();
		this.add(yearField);

		this.add(new JLabel("Price", JLabel.CENTER));
		priceField = new JTextField();
		this.add(priceField);

		preBtn = new JButton("Previoues");
		preBtn.addActionListener(this);
		this.add(preBtn);

		nextBtn = new JButton("Next");
		nextBtn.addActionListener(this);
		this.add(nextBtn);

		insertBtn = new JButton("Insert");
		insertBtn.addActionListener(this);
		this.add(insertBtn);

		finishBtn = new JButton("Finish");
		finishBtn.addActionListener(this);
		this.add(finishBtn);

		//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // x 버튼 비활성화.
		this.setLocationRelativeTo(this);

		this.setSize(350, 200);
		this.setResizable(false);

		this.setVisible(true);

	}

	public void currentBookInfo() throws Exception{

		String bookId = rs.getString("book_id");
		idField.setText(String.valueOf(bookId));

		String title = rs.getString("title");
		titleField.setText(title);

		String publisher = rs.getString("publisher");
		publisherField.setText(publisher);

		Date date = rs.getDate("year");
		yearField.setText(String.valueOf(date));

		int price = rs.getInt("price");
		priceField.setText(String.valueOf(price));

	}

	public static Connection makeConnection() throws Exception {

		String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String USER = "oop";
		String PWD = "oop";

		//		Connection conn = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Success");

		Connection conn = DriverManager.getConnection(URL, USER, PWD);
		System.out.println("Datebase Success");

		//		String sql = "SELECT * FROM books ORDER BY book_id desc";
		//문법검사, 정당성검사, exute검사

		return conn;

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == nextBtn) {
				rs.next();

				currentBookInfo();

			}else if(e.getSource() == preBtn) {
				rs.previous();

				currentBookInfo();

			}else if (e.getSource() == insertBtn) {

				String id = idField.getText();
				String title = titleField.getText();
				String publisher = publisherField.getText();
				String year = yearField.getText();
				String price = priceField.getText();

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date(sdf.parse(year).getTime());

				String sql = "INSERT INTO books(book_id, title, publisher, year, price) values(?, ?, ?, ?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, id);
				pstmt.setString(2, title);
				pstmt.setString(3, publisher);
				pstmt.setDate(4, date);
				pstmt.setInt(5, Integer.parseInt(price));

				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(this, "책 등록 성공!!", "Success", JOptionPane.INFORMATION_MESSAGE);

			}else if (e.getSource() == finishBtn){
				System.out.println("프로그램을 종료합니다.");
				rs.close();
				conn.close();
				this.dispose();
				System.exit(0); // 프로세스 종료.
			}



		}catch(Exception err) {
			err.printStackTrace();
		}

	}
	public static void main(String[] args) {
		new TableViewer();
	}
}
