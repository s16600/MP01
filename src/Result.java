import java.util.Date;
import java.util.List;

public /*abstract*/ class Result extends MyExtension {
	Integer resultNumber;
	List<Measurement> measurements;
	public enum Checked {Tak, Nie};
	Date checkDate;
	Employee checkedBy; 
	String comments;
	
	
}
