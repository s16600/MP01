import java.util.Date;

public class TestedAccording extends MyExtensionPlus {
	Date decisionDate;
	Employee decidedBy;
	
	public TestedAccording(Date decisionDate, Employee decidedBy, Sample sample, Specification specification) {
		this.decisionDate = decisionDate;
		this.decidedBy = decidedBy;
		this.addLink("sample","testedaccording",sample);
		this.addLink("specification","testedaccording",specification);
	}
	
	public String toString() {
		String text = null;
		
		text = decidedBy +", "+ decisionDate;
		try {
			text += ". Sample: " + ((Sample) this.getLinks("sample")[0]).nazwaProby;
			text += ", Tested for: " + this.getLinks("specification")[0];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return text;
	}

}
