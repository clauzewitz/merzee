package beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class Car5 {
	@Autowired(required=true)
	Engine engine;
	
	
	//@Required
	//@Autowired  //스프링 애노테이션
	//@Qualifier("engine2")   //스프링 애노테이션
	//@Resource(name="engine1") //자바 표준(JSR-250) 애노테이션
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	
	
	
	public void run() {
		engine.start();
	}
}







