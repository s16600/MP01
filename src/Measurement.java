import java.util.Date;

public /*abstract*/ class Measurement extends MyExtension {
	Employee masurementDoneBy;
	Date masurmentDate; 
	
	public String toString() {
		return "Measurement: " + masurmentDate.toLocaleString() + ", by: " + masurementDoneBy; 
	}
	
	Measurement(Employee masurementDoneBy, Date masurmentDate) {
		this.masurementDoneBy = masurementDoneBy;
		this.masurmentDate = masurmentDate;
	}
}
