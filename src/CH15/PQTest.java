package CH15;

import java.util.PriorityQueue;
import java.util.Queue;

public class PQTest {

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		Queue<String> q = new PriorityQueue<>();

		q.offer("PineApple"); // q.add 도 가능
		q.offer("Banana");
		q.offer("Carrot");
		q.offer("Chrry");
		q.offer("Orange");

		//엿보기, 인출은 아니다
		System.out.println(q.peek()); //q.element 도 가능 => Banana
		System.out.println(q.peek()); //Banana
		System.out.println(q.peek() + "\n"); //Banana


		while(q.size() > 0) { //빼면 사이즈가 준다
			System.out.println(q.poll()); // q.remove 도 가능 => 순서대로 출력됨
		}
	}

}
