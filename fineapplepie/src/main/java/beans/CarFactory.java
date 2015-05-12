package beans;

public class CarFactory {
	static int count;
	
	public static Car createInstance() {
		System.out.println("createInstance()");
		count++;
		return new Car(count);
	}
}
