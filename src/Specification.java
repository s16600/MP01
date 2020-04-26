
public class Specification extends MyExtensionPlus {
	private String number;
	private String name;
	private String country;
	private String version;
	
	public Specification(String number, String name, String country, String version){
		this.number = number;
		this.name = name;
		this.country = country;
		this.version = version;
	}
	
	public String toString(){
		return this.number + "; " + this.name + "; " + this.country + "; " + this.version;
	}
	
	public void addParameter(Parameter parameter, String qualifier) {
		this.addLink("parameter", "specification", /*(MyExtensionPlus)*/ parameter, qualifier);
	}
	
}
