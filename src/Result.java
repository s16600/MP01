import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public /*abstract*/ class Result extends MyExtensionPlus {
	Integer resultNumber;
	//List<Measurement> measurements;
	Checked checked;
	Date checkDate;
	//Employee checkedBy; 
	String comments;
	
	public enum Checked {Yes, No};
	
	public String toString() {
		String text = null;
		
		try {
			text = "Result: " + resultNumber + ", checked by: " + this.getLinks("employee")[0] + ((comments!=null)? " ("+comments +")":"") + "\n";
			for (MyExtensionPlus r : this.getLinks("measurement")) {text += "   -- " + r +"\n";}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		/*
		for(Measurement measurement : measurements) {
			text += "   -- " + measurement +"\n";
		}
		*/
		
		return text;
	}
	
	public Result(Sample sample, Integer resultNumber, Date checkDate, Employee checkedBy, String comments) {
		this.resultNumber = resultNumber;
		//this.measurements = new ArrayList<>();
		this.checked = Result.Checked.Yes;
		this.checkDate = checkDate;
		//this.checkedBy = checkedBy;
		this.addLink("employee","result", checkedBy);
		this.addLink("sample","result", sample);
		this.comments = comments;
	}
	
	public Result(Sample sample, Integer resultNumber, Date checkDate, Employee checkedBy) {
		this(sample, resultNumber, checkDate, checkedBy, null);
	}
	
	public void addMeasurement(Measurement measurement) throws Exception {
		//this.measurements.add(measurement);
		this.addPart("measurement","result",measurement);
		//this.addLink("measurement","result",measurement);
	}
	
	/*
	public void removeMeasurement(Measurement measurement) {
		//this.measurements.remove(measurement);
		
	}
	*/

}
