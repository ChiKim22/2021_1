package CH18;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class HttpURLTest {

	public static void main(String[] args) throws Exception{
		URL url = new URL("https://www.google.com/search?q=java");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();

		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent", "Mozilla/5.0");

		int responseCode = conn.getResponseCode();
		System.out.println("Response Code : " + responseCode);

		InputStream stream = conn.getInputStream();

		// InputStream 객체를 통해 네트워크 너머의 프로세스가 보내주는 데이터를 받는다.

		//위를 좀더 편리하게.
		InputStreamReader isReader = new InputStreamReader(stream, "UTF-8");
		// 한 라인씩 편리하게 읽음.
		BufferedReader reader = new BufferedReader(isReader);
		String line;
		while((line = reader.readLine()) != null){ // null이 리턴될때 까지 작동.
			System.out.println(line);
		}

	}

}
