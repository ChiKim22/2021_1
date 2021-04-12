package CH15;

import java.util.*;
import java.util.stream.IntStream;

public class CollectionTest {
	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		setTest();
		lotto();

	}
	class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

	public static void lotto() {
//		Set<Integer> lootoNums = new HashSet<>();

//		MyComparator comp = new MyComparator();

		Set<Integer> lootoNums = new TreeSet<>();

		// lootoNums 의 원소 수가 6 이 될때까지
		// 1 ~ 45 까지의 무작위 값을 생성해 lottoNums에 넣자.

		while(lootoNums.size() < 6) {
			int num = (int) (Math.random()*45)+1;
			if(lootoNums.add(num)) {
//				System.out.print(num + " ");
			}
//			lootoNums.add((int) (Math.random() * 45)+1);
		}

		System.out.println(lootoNums);

		Iterator<Integer> iter = lootoNums.iterator();
		while(iter.hasNext()) {
//			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}

	public static void setTest() {
		Set<String> set = new HashSet<>();
		String[] strArr = {"A", "B", "C", "D", "B"}; // 중복 제거후 출력

		for(String s : strArr) {
			if(set.add(s) == false) {
				System.out.println(s + " 이미 같은 값이 존재.");
			}
			set.add(s);
		}
		System.out.println(set);
	}

	public static void test3() {
		ArrayList<String> list = new ArrayList();
		list.add("MILK");
		list.add("BREAD");
		list.add("BUTTER");
		System.out.println(list);

		list.add(1, "APPLE");
		System.out.println("APPLE 을 1번 인덱스에 추가한 후 : " + list);
		list.add(2, "GREAP");
		System.out.println("GREAP 을 2번 인덱스에 추가한 후 : " + list);
		list.remove(3);
		System.out.println("3번 인덱스를 삭제한 후 : " + list);

		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());

		}
		iter = list.iterator();
//		iter.next(); // Err
		System.out.println("End...");

	}

	public static void test2() {
//		List<Integer> list = new ArrayList(); // 13ms , 6ms
		List<Integer> list = new LinkedList(); // 1ms , 4070ms
//		for (int i = 0; i < 100000; i++) {
//			list.add(i + 1);
//		}

		IntStream.rangeClosed(1, 100000).forEach(i -> list.add(i)); // 위의 반복문과 같은 내용임.

		long start = System.currentTimeMillis();

//		for (int i = 0; i < 1000; i++) {
//			list.add(30, 1000);
//		}

		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}

		long end = System.currentTimeMillis();

		System.out.println((end - start) + "ms Elapsed...");
	}


public static void test1() {
	/*
	 * list : 순서가 있고 중복이 허용되는 자료구조
	 */

	List<Integer> list1 = new ArrayList<>();
	List<String> list2 = new LinkedList<>();
	List<Double> list3 = new Vector<>();
	List<Integer> list4 = new Stack<>();

	for (int i = 0; i < 10; i++) {
		list1.add(i+1);
		list2.add(String.valueOf(i+1));
		list3.add((i+1) * 1.0);
		list4.add(10-i);


}
	System.out.println(list1);
	System.out.println(list2);
	System.out.println(list3);
	System.out.println(list4);

	for (int i = 0; i < list1.size(); i++) {
		System.out.print(list1.get(i) + " ");
	}

	for (String s : list2) {
		System.out.print(s + " ");

}
	Iterator<Double> iter = list3.iterator();
	while (iter.hasNext()) {
	Double d = iter.next();
	System.out.print(d + " ");
	}
  }
}
