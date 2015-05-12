package beans;

public class Car {
	int no;
	public Car(int no) {
		this.no = no;
	}

	public void run() {
		System.out.println(no + "번 자동차 달린다");
	}
}
