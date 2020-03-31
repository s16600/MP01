import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		//System.out.println(new Date());
		
		//Employee e1 = new Employee("Jan", "Kowalski", "Laborant");
		//Employee e2 = new Employee("Piotr", "Nowak", "Analityk");
		
		File extentFile = new File("Plik1.obj");
/*		
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(extentFile)));
		Employee.writeExtent(out);
		out.close();		
*/		
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(extentFile)));
		Employee.readExtent(in);
		in.close();
		
		Employee.showExtent();		
		
		System.out.println("Koniec programu");
	}

}
