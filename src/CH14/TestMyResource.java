package CH14;

public class TestMyResource {
	public static void main(String[] args) {
//		test1();
		test2();
	}

	public static void test1() {
		try (MyResource r = new MyResource()){
		System.out.println(r.getValue());
		System.out.println("Working!!!");
		}catch(Exception e){
		System.out.println(e.getMessage());
		}
//		without autocloseable
//		}finally {
//		r.close();
//		}

	}

	public static void test2() {
		try (MyResource r = new MyResource()){
		System.out.println(r.getValue());
		System.out.println("Working!!!");
		}catch(Exception e){
		System.out.println(e.getMessage());
		}

	}
}