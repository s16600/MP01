
public class Parameter extends MyExtensionPlus {
	private String name;
	private String requirements;
	private String unit;
	
	public Parameter(String name, String requirements, String unit){
		this.name = name;
		this.requirements = requirements;
		this.unit = unit;
	}
	
	public String toString(){
		return this.name + ", " + this.requirements + " " + this.unit;
	}
}
