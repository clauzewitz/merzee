package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyBean4 {
	static int count;
	int no;
	
	public MyBean4() {
		System.out.println("MyBean4()...");
		count++;
		no = count;
	}
	
	//@PostConstruct
	public void init() {
		System.out.println("MyBean4.init()..." + no);
	}
	
	//@PreDestroy
	public void destroy() {
		System.out.println("MyBean4.destroy()..." + no);
	}
}







