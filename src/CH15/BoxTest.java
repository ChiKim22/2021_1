package CH15;

public class BoxTest {

	public static void main(String[] args) {

//		Box box = new Box();
//		box.setContent("동해물과 백두산이");
//		String cont = box.getContent();
//		System.out.println(cont);


//		Box2 box2 = new Box2();
//		box2.setContent(100);
//		Integer cont2 = box2.getContent();
//		System.out.println(cont2);

//		Box3 box3 = new Box3();
//		box3.setContent(new Student());
//		Student std = new Student();
//		std.setName("홍길동");
//		std.setDept("컴정");
//		std.setGrade(2);
//		System.out.println(std.getName() + ":" + std.getGrade());


		Box4 box4 = new Box4();
//		box4.setContent(new Student());
//		box4.setContent(100);
		box4.setContent("마르고 닳도록");
		process(box4);
	}

	public static void process(Box4 box4) {
		Object obj = box4.getContent();

		if(obj instanceof Student) {
		Student std = (Student) obj;
		String s = std.getName();
		int n = std.getGrade();

		// DB 테이블에 저장.
		}else if(obj instanceof String) {
			//문자열
		}else if(obj instanceof Integer) {
			//정수 처리
		}
	}
}
