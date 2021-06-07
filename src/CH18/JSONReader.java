package CH18;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.google.gson.Gson;

public class JSONReader {


	public static void main(String[] args) throws Exception{

		//Connect
		// 결과를 입력string 로 받아서 문자열로 저장.
		// 저장된 문자열로부터 자바 객체 생성

		// 자바 객체를 이용해서 여러가지 처리 가능
		// DB 에 저장이나 여러가지 가능.

		//URL Connction
		String site = "https://jsonplaceholder.typicode.com/posts";
		URL url = new URL(site);

		URLConnection conn = url.openConnection();

		InputStream stream = conn.getInputStream();

		InputStreamReader isReader = new InputStreamReader(stream, "UTF-8"); // Reader 는 문자열 읽을 때 사용.

		BufferedReader bufReader = new BufferedReader(isReader);

		String line = null;

		String jsonString = "";

		while((line = bufReader.readLine()) != null) {
//			System.out.println(line);
			jsonString += line;
		}

		Gson gson = new Gson();

//		String json = "[{'userId': 1, 'id':1, 'title':'test', 'body':'test body'}],"
//				+ " {'userId': 2, 'id':2, 'title':'test2', 'body':'test body2'}";
		Post[] posts = gson.fromJson(jsonString, Post[].class);

		/*
		 * Post post = new Post();
		 * post.setUserId(1);
		 * post.setId(1);
		 * post.setTitle("title");
		 * post.setBody("test body");
		 * return post;
		 */

//		System.out.println(post[0].getUserId());
//		System.out.println(post[0].getId());
//		System.out.println(post[0].getTitle());
//		System.out.println(post[0].getBody());


		for(Post post : posts) {
			System.out.println(post.getUserId());
			System.out.println(post.getId());
			System.out.println(post.getTitle());
			System.out.println(post.getBody());
			System.out.println("###########################");
		}

		insertIntoDB(posts);



	}

	private static void insertIntoDB(Post[] posts) throws Exception{
		/*
		 * 1. Class.forName(...) JDBC 드라이버 적재
		 * 2. Connction conn = DriverManager.getConnction(...); DB 서버 연결
		 * 3. String sql = "insert into posts (userId, id, title, body) values(?, ?, ?, ?)";
		 * PreparedStatements pstmt = conn.prepareStatement(sql);
		 *
		 * 4. pstmt.setInt(1, post.getUserID());
		 * 	  pstmt.setInt(2, post.getId());
		 * 	  pstmt.setString(3, post.getTitle());
		 * 	  pstmt.setString(4, post.getBody()); ?자리에 들어갈 값을 정한다.
		 *
		 * 5. pstmt.excuteUpdate(); 서버에 실행요청
		 * 6. conn.close();
		 */

		// DB
		String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
		String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String USER = "system";
		String PWD = "oracle";

		Class.forName(JDBC_DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PWD);
		String sql = "insert into posts (userId, id, title, body) values(?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		for(Post post: posts) {
			pstmt.setInt(1, post.getUserId());
			pstmt.setInt(2, post.getId());
			pstmt.setString(3, post.getTitle());
			pstmt.setString(4, post.getBody());
			pstmt.executeUpdate();
		}
		conn.close();

	}

}
class Post {

	private int userId;
	private int id;
	private String title;
	private String body;

	int getUserId() {
		return userId;
	}

	void setUserId(int userId) {
		this.userId = userId;
	}

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	String getTitle() {
		return title;
	}

	void setTitle(String title) {
		this.title = title;
	}

	String getBody() {
		return body;
	}

	void setBody(String body) {
		this.body = body;
	}
}
