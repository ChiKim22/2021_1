package CH15;

public class Student {

	void setContent(Student content) {
		this.content = content;
	}
	int getSid() {
		return sid;
	}
	void setSid(int sid) {
		this.sid = sid;
	}
	private Student content;
	private String name, dept;
	private int grade, sid;


	public Student(String name, int sid) {
		this.name = name;
		this.sid = sid;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student getContent() {
		return content;


	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getDept() {
		return dept;
	}
	void setDept(String dept) {
		this.dept = dept;
	}
	int getGrade() {
		return grade;
	}
	void setGrade(int grade) {
		this.grade = grade;
	}


}
