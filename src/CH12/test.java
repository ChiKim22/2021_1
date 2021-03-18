package CH12;

public class test {

	public static void main(String[] args) {
		String s = "동해물과 백두산이 마르고 닳도록...";
//		for(int i = 0; i < s.length(); i++) {
//			System.out.println(s.charAt(i));
//		}
		
		s.lastIndexOf("백두산");
		int idx = s.indexOf("백두산");
//		System.out.println(idx);

		String subs = s.substring(idx, idx + "백두산".length());
		System.out.println(subs);
		
		subs = s.substring(idx, s.indexOf("마르고"));
		System.out.println("["+subs+"]");
	}
}
