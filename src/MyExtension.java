import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class MyExtension implements Serializable {
	
	private static List<MyExtension> extent = new ArrayList<>();

	
	public MyExtension(){
		add(this);
	}
	
	
	protected static void add(MyExtension myextension) {
		extent.add(myextension);
	}
	
	
	protected static void remove(MyExtension myextension) {
		extent.remove(myextension); 
	}
	
	
	public static void writeExtent(ObjectOutputStream stream) throws IOException {
		stream.writeObject(extent);
	}
	
	
	public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		extent = (ArrayList<MyExtension>) stream.readObject();
	}
	
	
	public String toString() {
		return "Uzupełnić metodę toString"; 
	}
	
	
	public static void showExtent() {
		System.out.println("Extent of the class: " + MyExtension.class.getName());
		for (MyExtension myextension : extent) {
			System.out.println(myextension);
		}	
	}
	
}
