import java.io.Serializable;

//klasa do testów, docelowo do usunięcia

public class Test implements Serializable {
	String nazwaTestu;
	
	Test() {
		this.nazwaTestu="Czas utworzenia: "+System.currentTimeMillis();
	}
	
	public String toString() {
		return this.nazwaTestu;
	}
}
