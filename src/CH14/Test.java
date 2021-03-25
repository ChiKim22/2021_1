package CH14;

import java.io.IOException;

public class Test {

	public static void main (String[] args) {

		//System.out.println(readString());
		//Exception in thread "main" java.lang.Error:
		//Unresolved compilation problem:
		//Unhandled exception type IOException

		try {
			System.out.println(readString());
		}catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private static String readString() throws IOException {
		byte[] buf = new byte[100];
		System.out.println("문자열 입력.");
		System.in.read(buf);
		return new String(buf);
	}

}
