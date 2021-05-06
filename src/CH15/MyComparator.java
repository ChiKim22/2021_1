package CH15;

import java.util.Comparator;

public class MyComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// o1 이 크면 양수 반환, 같으면 0, 작으면 음수 반환

		// 문자열 값의 비교는 Comparable 인터페이스를 구현하고 있는 String 클래스의
		// Compare 메소드를 호출하면 된다.


//		return o1.compareTo(o2); // 오름차순
		return o1.compareTo(o2) * (-1); // 내림차순
	}

}
