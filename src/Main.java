import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(new Date());
		
		Employee e1 = new Employee("Jan", "Kowalski", "Laborant");
		Employee e2 = new Employee("Piotr", "Nowak", "Analityk");
		
		Employee.showExtent();
		
		System.out.println("Koniec programu");
	}

}
