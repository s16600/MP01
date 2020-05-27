import java.util.ArrayList;
import java.util.Date;

public class ResultAssay extends Result {
	private static int accuracy=2; 

	public ResultAssay(Sample sample, Integer resultNumber, Date checkDate, Employee checkedBy, String comments) {
		super(sample, resultNumber, checkDate, checkedBy, comments);
	}
	
	public String toString() {
		String text = null;;
		try {
			text = "Result: " + resultNumber + ", ASSAY: " + roundAvoid(getValue(),accuracy)
				+ ", checked by: " + this.getLinks("employee")[0] + ((comments!=null)? " ("+comments +")":"") + "\n";
			for (MyExtensionPlus r : this.getLinks("measurement")) {text += "   -- " + r +"\n";}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		//String text = "No " + resultNumber + ", ASSAY: " + roundAvoid(getValue(),accuracy) 
		//			+ ", checked by: " + /*checkedBy +*/ ((comments!=null)? " ("+comments +")":"") + "\n";
		
		/*
		for(Measurement measurement : measurements) {
			text += "   -- " + measurement +"\n";
		}
		*/
		
		return text;
	}
	
	public Double getValue() throws Exception {
		Double result = 0D;
		int counter = 0;
		
		for (MyExtensionPlus r : this.getLinks("measurement")) {
			result += ((MeasurementNumerical) r).getValue();
			counter++;
		}
		
		/*
		for (Measurement measurement : measurements) {
			result += ((MeasurementNumerical) measurement).getValue();
			counter++;
		}
		*/
		
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
