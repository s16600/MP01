import java.util.Date;

public /*abstract*/ class Measurement extends MyExtensionPlus {
	//Employee masurementDoneBy;
	Date masurmentDate; 
	
	public String toString() {
		//return "Measurement: " + masurmentDate.toLocaleString() + ", by: " + masurementDoneBy; 
		try {
			return "Measurement: " + masurmentDate.toLocaleString() + ", by: " + this.getLinks("employee")[0];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(r1.getLinkedObject("employee",e3));
		return null;
	}
	
	Measurement(Employee masurementDoneBy, Date masurmentDate) {
		//this.masurementDoneBy = masurementDoneBy;
		this.addLink("employee","measurement", masurementDoneBy);
		this.masurmentDate = masurmentDate;
	}
}
