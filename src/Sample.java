import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public /*abstract*/ class Sample extends MyExtensionPlus {
	
	String nrProby;
	String nrSerii;
	String nazwaProby;
	Date dataPoboru;
	Date dataProdukcji;
	Date dataWaznosci;
	//List<Result> results;
	Ocena ocena;
	Date dataOceny;
	//Employee wykonalOcene;
	Status status;
	Date dataZwolnienia;
	//Employee wykonalZwolnienie;
	
	public enum Ocena {Brak, Odpowiada, Odpowiada_w_przebadanych_parametrach, Nie_odpowiada};
	public enum Status {Brak, Zwolniona, Odrzucona}; 
	
	public String toString() {
		String text = null;
		
		try {
			text = "Sample: " + nrProby + ", " + nrSerii + ", evaluated by: " + this.getLinks("evaluatedBy")[0] +"\n";
			for (MyExtensionPlus r : this.getLinks("result")) text += " - " + r.toString() +"\n";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		for (Result result : results) {
			text += " - " + result.toString() +"\n";
		}
		*/
		
		return text;
	}	
	
	public Sample() {
		//this.results = new ArrayList<>();
	}
	
	public Sample(String nrProby, String nrSerii, String nazwaProby, Date dataPoboru, Date dataProdukcji, Date dataWaznosci, Date dataOceny, 
			Employee wykonalOcene, Date dataZwolnienia, Employee wykonalZwolnienie) {
		this.nrProby = nrProby;
		this.nrSerii = nrSerii;
		this.nazwaProby = nazwaProby;
		this.dataPoboru = dataPoboru;
		this.dataPoboru = dataPoboru;
		this.dataProdukcji = dataProdukcji;
		this.dataWaznosci = dataWaznosci;
		//this.results = new ArrayList<>();
		this.ocena = Sample.Ocena.Brak;
		this.dataOceny = dataOceny;
		//this.wykonalOcene = wykonalOcene;
		this.addLink("evaluatedBy", "sample", wykonalOcene);
		this.status = Sample.Status.Brak;
		this.dataZwolnienia = dataZwolnienia;
		//this.wykonalZwolnienie = wykonalZwolnienie;
		this.addLink("releasedBy", "sample", wykonalZwolnienie);
	}
	
	public void addResult(Result result) throws Exception {
		//this.results.add(result);
		this.addPart("result","sample",result);
	}
	
	/*
	public void removeResult(Result result) {
		this.results.remove(result);
	}
	*/

}
