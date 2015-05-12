package beans;

public class MyBean2 {
	String name;
	
	public MyBean2(String name) {
		this.name = name;
	}
	
	public void printTest() {
		System.out.println("Hello, " + name);
	}
}
