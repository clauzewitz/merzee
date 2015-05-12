package beans;

public class CarFactory2 {
	int count;
	
	public Car createCar() {
		System.out.println("createCar()");
		count++;
		return new Car(count);
	}
}
