import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public abstract class MyExtension implements Serializable {
	private static Map<Class, List<MyExtension>> allExtents = new Hashtable<>();
	
	public MyExtension() {
		List<MyExtension> extent = null;
		Class theClass = this.getClass();
		
		if (allExtents.containsKey(theClass)) {
			extent = allExtents.get(theClass);
		}
		else {
			extent = new ArrayList();
			allExtents.put(theClass, extent);
		}
		extent.add(this); 
	}
	
	public static void writeExtent(ObjectOutputStream stream) throws IOException {
		stream.writeObject(allExtents);
	}
	
	
	public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		allExtents = (Hashtable) stream.readObject();
	}
	
	
	public String toString() {
		return "Uzupełnić metodę toString"; 
	}
	
	public static void showExtent(Class theClass) {
		List<MyExtension> extent = null;
		if (allExtents.containsKey(theClass)) {
			extent = allExtents.get(theClass);
			for (Object obj : extent) {
				System.out.println(obj);
			}
		}
		else {
			System.out.println("Brak klasy: "+theClass.toString());
		}
	}
	
	public static <T> List<T> getExtent(Class theClass) {
		List<MyExtension> extent = null;
		if (allExtents.containsKey(theClass)) {
			extent = allExtents.get(theClass);
		}
		else {
			System.out.println("Brak klasy: "+theClass.toString());
		}
		return (List<T>) extent;
	}
	
}
