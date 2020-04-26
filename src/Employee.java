import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Employee extends MyExtensionPlus {
	String name;
	String surname;
	String position;
	Integer salary;

	public Employee(String name, String surname, String position, Integer salary){
		this.name=name;
		this.surname=surname;
		this.position=position;
		this.salary = salary;
	}
	
	public Employee(String name, String surname, String position){
		this(name, surname, position, 0);
	}
	
	public String toString() {
		return name + " " + surname + ", " + position; 
	}	
	
	public static Integer sumSalary() {
		Integer res = 0;
		for (Object emp : Employee.getExtent(Employee.class)) {
			res += ((Employee) emp).salary;
		}
		return res;
	}
	
	public static Integer sumSalary(String position) {
		Integer res = 0;
		for (Object emp : Employee.getExtent(Employee.class)) {
			if ( ((Employee) emp).position.equals(position) ) res += ((Employee) emp).salary;
		}
		return res;
	}

}
