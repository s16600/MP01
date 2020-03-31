import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable {
	
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
	
	public static void writeExtent(ObjectOutputStream stream) throws IOException {
		stream.writeObject(extent);
	}
	
	public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		extent = (ArrayList<Employee>) stream.readObject();
	}
	
	public String toString() {
		return name + " " + surname + ", " + position; 
	}
}
