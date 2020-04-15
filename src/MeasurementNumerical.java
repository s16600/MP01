import java.util.Date;

public class MeasurementNumerical extends Measurement {
	private Double value;
	
	public MeasurementNumerical(Employee masurementDoneBy, Date masurmentDate, Double value){
		super(masurementDoneBy, masurmentDate);
		this.value = value;
	}
	
	public String toString() {
		return "Measurement: " + value + ", by: " + masurementDoneBy; 
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	public Double getValue() {
		return this.value;
	}

}
