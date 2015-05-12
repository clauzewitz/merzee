package beans;

import org.springframework.beans.factory.FactoryBean;

public class CarFactory3 implements FactoryBean<Car> {
	int count;
	
	@Override
	public Car getObject() throws Exception {
		count++;
		return new Car(count);
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
		//return Class.forName("beans.Car");
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}



