
public class Specification {
	private String number;
	private String name;
	
	public Specification(String number, String name){
		this.number = number;
		this.name = name;
	}
	
	public String toString(){
		return this.number + " " + this.name;
	}
	
}
