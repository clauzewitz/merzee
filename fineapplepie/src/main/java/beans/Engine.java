package beans;

import org.springframework.stereotype.Component;

//@Component
public class Engine {
	String model = "V8";
	
	public Engine() {}
	
	public Engine(String model) {
		this.model = model;
	}
	
	public void start() {
		System.out.println("엔진가동..." + model);
		
	}

}
