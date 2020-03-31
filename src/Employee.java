import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private static List<Employee> extent = new ArrayList<>();
	
	String name;
	String surname;
	String position;
	
	public Employee(String name, String surname, String position){
		this.name=name;
		this.surname=surname;
		this.position=position;
		
		addEmployee(this);
	}
	
	private static void addEmployee(Employee employee) {
		extent.add(employee);
	}
	
	private static void removeEmployee(Employee employee) {
		extent.remove(employee);
	}
	
	public static void showExtent() {
	
		System.out.println("Extent of the class: " + Employee.class.getName());
		for (Employee employee : extent) {
			System.out.println(employee);
		}
	
	}
	
	public String toString() {
		return name + " " + surname + ", " + position; 
	}
}
