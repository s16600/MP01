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
	public enum Ocena {Odpowiada, Odpowiada_w_przebadanych_parametrach, Nie_odpowiada};
	Date dataOceny;
	Employee wykonalOcene;
	public enum Status {Zwolniona, Odrzucona}; 
	Date dataZwolnienia;
	Employee wykonalZwolnienie;
	
	public String toString() {
		return nrProby + ", " + nrSerii + ". Wykonał ocenę: " + wykonalOcene; 
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
		this.dataOceny = dataOceny;
		this.wykonalOcene = wykonalOcene;
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
