
public class Specification extends MyExtensionPlus {
	private String number;
	private String name;
	private String country;
	private String version;
	
	public Specification(String number, String name){
		this.number = number;
		this.name = name;
	}
	
	public String toString(){
		return this.number + "; " + this.name + "; " + this.country + "; " + this.version;
	}
	
}
