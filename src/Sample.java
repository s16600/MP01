import java.util.Date;

public abstract class Sample extends MyExtension {
	
	String nrProby;
	String nrSerii;
	Date dataPoboru;
	Date dataProdukcji;
	Date dataWaznosci;
	public enum Ocena {Odpowiada, Odpowiada_w_przebadanych_parametrach, Nie_odpowiada};
	Date dataOceny;
	Employee wykonalOcene;
	public enum Status {Zwolniona, Odrzucona}; 
	Date dataZwolnienia;
	Employee wykonalZwolnienie;
	
	public String toString() {
		return nrProby + ", " + nrSerii + ", " + wykonalOcene; 
	}	

}
