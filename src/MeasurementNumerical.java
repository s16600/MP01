import java.util.Date;

public class MeasurementNumerical extends Measurement {
	private Double value;
	
	public MeasurementNumerical(Employee masurementDoneBy, Date masurmentDate, Double value){
		super(masurementDoneBy, masurmentDate);
		this.value = value;
	}
	
	public String toString() {
		try {
			return "Measurement: " + value + ", by: " + this.getLinks("employee")[0];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	public Double getValue() {
		return this.value;
	}

}
