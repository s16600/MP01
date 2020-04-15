import java.util.ArrayList;
import java.util.Date;

public class ResultAssay extends Result {
	private static int accuracy=2; 

	public ResultAssay(Integer resultNumber, Date checkDate, Employee checkedBy, String comments) {
		super(resultNumber, checkDate, checkedBy, comments);
	}
	
	public String toString() {
		String text = "No " + resultNumber + ", ASSAY: " + roundAvoid(getValue(),accuracy) + ", checked by: " + checkedBy + "\n";
		
		for(Measurement measurement : measurements) {
			text += "   -- " + measurement +"\n";
		}
		
		return text;
	}
	
	public Double getValue() {
		Double result = 0D;
		int counter = 0;
		
		for (Measurement measurement : measurements) {
			result += ((MeasurementNumerical) measurement).getValue();
			counter++;
		}
		
		if (counter>0) {
			return result/counter;
		}
		return null;
	}
	
	private void setAccuracy(Integer integer) {
		accuracy = integer;
	}
	
	public static double roundAvoid(double value, int places) {
	    double scale = Math.pow(10, places);
	    return Math.round(value * scale) / scale;
	}
}
