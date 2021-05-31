package CH18;

import java.net.*;

public class HostToInternetAddress {

	public static void main(String[] args) {
		String hostName = "www.naver.com";

		try {
			InetAddress iAddr = InetAddress.getByName(hostName);
			System.out.println("IP addr : " + iAddr.getHostAddress());
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}
