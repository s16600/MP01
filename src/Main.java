import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		System.out.println("Podaj, co chcesz zrobić: \n"
				+ "Utworzyć ekstensję i zapisać w pliku, wpisz - 1\n"
				+ "Odczytać ekstensję z pliku, wpisz - 2\n"
				+ "Zakończyć program, wpisz inną liczbę\n");
		
		int polecenie;
		Scanner konsola = new Scanner(System.in);
		polecenie = Integer.parseInt(konsola.next());
		
		File extentFile;
		
		switch (polecenie) {
			case 1:			
				utworzEkstensje();
				extentFile = new File("Plik1.obj");
				ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(extentFile)));
				Employee.writeExtent(out);
				out.close();
				break;
				
			case 2:
				extentFile = new File("Plik1.obj");
				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(extentFile)));
				Employee.readExtent(in);
				in.close();
				break;
		}
		
		//Employee.showExtent();
		Sample.showExtent();
		
		System.out.println("\n*** Koniec programu ***");
	}

	
	public static void utworzEkstensje() {
		Employee e1 = new Employee("Jan", "Kowalski", "Laborant");
		Employee e2 = new Employee("Piotr", "Nowak", "Analityk");
		Employee e3 = new Employee("Tomasz", "Nicpoń", "Kierownik");
		
		//Sample(String nrProby, String nrSerii, String nazwaProby, Date dataPoboru, Date dataProdukcji, Date dataWaznosci, Date dataOceny, 
		//		Employee wykonalOcene, Date dataZwolnienia, Employee wykonalZwolnienie)
		
		Sample s1 = new Sample("ZS/2009/001", "A2005/123A", "Witamina D3", new Date(), new Date(), new Date(), new Date(), e2, new Date(), e3);
		//s1.addResult(new Result());
		
		s1.addResult(new Result());
		new Result();
		
	}
}
