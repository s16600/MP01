import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public /*abstract*/ class Result extends MyExtension {
	Integer resultNumber;
	List<Measurement> measurements;
	Checked checked;
	Date checkDate;
	Employee checkedBy; 
	String comments;
	
	public enum Checked {Yes, No};
	
	public String toString() {
		String text = "Result: " + resultNumber + ", checked by: " + checkedBy + "\n"/*+ ", klasa:" + this.getClass()*/;
		
		for(Measurement measurement : measurements) {
			text += "   -- " + measurement +"\n";
		}
		
		return text;
	}
	
	public Result(Integer resultNumber, Date checkDate, Employee checkedBy, String comments) {
		this.resultNumber = resultNumber;
		this.measurements = new ArrayList<>();
		this.checked = Result.Checked.Yes;
		this.checkDate = checkDate;
		this.checkedBy = checkedBy;
		this.comments = comments;
	}
	
	public Result(Integer resultNumber, Date checkDate, Employee checkedBy) {
		this(resultNumber, checkDate, checkedBy, null);
	}

	public void addMeasurement(Measurement measurement) {
		this.measurements.add(measurement);
	}
	
	public void removeMeasurement(Measurement measurement) {
		this.measurements.remove(measurement);
	}

}
