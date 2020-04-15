import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public /*abstract*/ class Sample extends MyExtension {
	
	String nrProby;
	String nrSerii;
	String nazwaProby;
	Date dataPoboru;
	Date dataProdukcji;
	Date dataWaznosci;
	List<Result> results;
	Ocena ocena;
	Date dataOceny;
	Employee wykonalOcene;
	Status status;
	Date dataZwolnienia;
	Employee wykonalZwolnienie;
	
	public enum Ocena {Brak, Odpowiada, Odpowiada_w_przebadanych_parametrach, Nie_odpowiada};
	public enum Status {Brak, Zwolniona, Odrzucona}; 
	
	public String toString() {
		String text = "Sample: " + nrProby + ", " + nrSerii + ", evaluated by: " + wykonalOcene +"\n";
		
		for (Result result : results) {
			text += " - " + result.toString() +"\n";
		}
		
		return text;
	}	
	
	public Sample() {
		this.results = new ArrayList<>();
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
		this.results = new ArrayList<>();
		this.ocena = Sample.Ocena.Brak;
		this.dataOceny = dataOceny;
		this.wykonalOcene = wykonalOcene;
		this.status = Sample.Status.Brak;
		this.dataZwolnienia = dataZwolnienia;
		this.wykonalZwolnienie = wykonalZwolnienie;
	}
	
	public void addResult(Result result) {
		this.results.add(result);
	}
	
	public void removeResult(Result result) {
		this.results.remove(result);
	}

}
