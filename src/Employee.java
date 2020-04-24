import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Employee extends MyExtensionPlus {
	
	//private static List<Employee> extent = new ArrayList<>();
	
	String name;
	String surname;
	String position;
	Integer salary;
	//BigDecimal salary;

	public Employee(String name, String surname, String position, Integer salary){
		this.name=name;
		this.surname=surname;
		this.position=position;
		this.salary = salary;
		
		//addEmployee(this);
		//add(this);
	}
	
	public Employee(String name, String surname, String position){
		this(name, surname, position, 0);
	}
	
	
	
	public String toString() {
		return name + " " + surname + ", " + position; 
	}	
	
	public static Integer sumSalary() {
		Integer res = 0;
		List<Employee> employees = null; 

		// DOKOŃCZYĆ i koniec programu
		for (Object emp : Employee.getExtent(Employee.class)) {
			res += ((Employee) emp).salary;
			//res = res.add( ((Employee) emp).salary );
			//System.out.println(emp.toString());
		}
		
		return res;
	}
	
	//Przeciążenie, Employee sumSalary
	public static Integer sumSalary(String position) {
		Integer res = 0;
		List<Employee> employees = null; 

		// DOKOŃCZYĆ i koniec programu
		for (Object emp : Employee.getExtent(Employee.class)) {
			if ( ((Employee) emp).position.equals(position) ) res += ((Employee) emp).salary;
			//res = res.add( ((Employee) emp).salary );
			//System.out.println(emp.toString());
		}
		
		return res;
	}

	
/*
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
*/	


}
