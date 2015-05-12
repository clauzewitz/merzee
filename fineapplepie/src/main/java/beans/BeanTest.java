package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("beans/beans.xml");
		
		
		Car5 car = (Car5) ctx.getBean("car5");
		car.run();
		
		
		//MyBean4 bean = (MyBean4)ctx.getBean("bean4");
		
		
		/*
		MyBean1 bean1 = (MyBean1)ctx.getBean("mybean1");
		bean1.printTest();
		
		MyBean2 bean2 = (MyBean2)ctx.getBean("mybean2");
		bean2.printTest();
		
		MyBean3 bean3 = (MyBean3)ctx.getBean("mybean3");
		bean3.printTest();
		*/
		/*
		Car car = (Car) ctx.getBean("car");
		car.run();
		
		car = (Car) ctx.getBean("car");
		car.run();
		*/
		
		/*
		Car car = (Car) ctx.getBean("car2");
		car.run();
		
		car = (Car) ctx.getBean("car2");
		car.run();
		*/
		/*
		Car car = (Car) ctx.getBean("car3");
		car.run();
		
		car = (Car) ctx.getBean("car3");
		car.run();
		*/
	}

}








