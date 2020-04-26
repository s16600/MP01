import java.util.Date;

public class TestedAccording extends MyExtensionPlus {
	Date decisionDate;
	Employee decidedBy;
	
	public TestedAccording(Date decisionDate, Employee decidedBy, Sample sample, Specification specification) {
		this.decisionDate = decisionDate;
		this.decidedBy = decidedBy;
		this.addLink("testedaccording","sample",sample);
		this.addLink("testedaccording","specification",specification);
	}
	
	public String toString() {
		String text = null;
		return text;
		
		
	}

}
