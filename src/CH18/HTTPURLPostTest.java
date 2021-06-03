package CH18;

import java.io.*;
import java.net.*;

public class HTTPURLPostTest {

	public static void main(String[] args) throws Exception {
		String site = "http://localhost:8888/todos";
		URL url = new URL(site);

		HttpURLConnection conn = (HttpURLConnection)url.openConnection(); // 강제 형변환

		conn.setDoInput(true); // 읽기 가능
		conn.setDoOutput(true); // 쓰기 가능

		conn.setRequestMethod("POST");
		conn.setRequestProperty("content-type", "application/x-www-form-urlencoded" );

		OutputStream ostream = conn.getOutputStream();
		OutputStreamWriter oWriter = new OutputStreamWriter(ostream, "UTF-8"); //유니코드

		PrintWriter writer = new PrintWriter(oWriter); // network stream 을 가지고 있음.
													   // System.out.println 은 console stream.

		String data = "id=JHK&pw=1111";

		writer.println(data);
		writer.flush(); // buffer 에 유지하고 있으면 보내준다.

		//읽기
		InputStream istream = conn.getInputStream();
		InputStreamReader iReader = new InputStreamReader(istream, "UTF-8");

		BufferedReader reader = new BufferedReader(iReader);
		String line;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println();
	}

}
