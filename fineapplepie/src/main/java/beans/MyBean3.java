package beans;

public class MyBean3 {
	String name;
	int age;
	
	public MyBean3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void printTest() {
		System.out.println(
				"Hello, " + name + "(" + age + ")");
	}
}
