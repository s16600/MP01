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

//Ekstensja i trwałość MyExtension
//A. złożony Employee
//A. opcjonalny, Result comments
//A. powtarzalny, Result <measurements> 
//A. klasowy, ResultAssay accuracy
//A. pochodny,ResultAssay.getValue(); 
//Met. klasowa Employee.sumSalary();
//Przeciążenie, Employee sumSalary
//Przesłonięcie toString() ResultAssay

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
		
		System.out.println("Lista pracowników:");
		Employee.showExtent(Employee.class);
		System.out.println("Suma wynagrodzeń: " + Employee.sumSalary() +"\n");
		System.out.println("Lista prób:");
		Sample.showExtent(Sample.class);
		
		//Result.showExtent(Result.class);
		//Measurement.showExtent(Measurement.class);
		
		System.out.println("\n*** Koniec programu ***");
	}

	
	public static void utworzEkstensje() {
		Employee e1 = new Employee("Jan", "Kowalski", "Laborant", 100);
		Employee e2 = new Employee("Piotr", "Nowak", "Analityk", 150);
		Employee e3 = new Employee("Tomasz", "Nicpoń", "Kierownik", 200);
		
		Measurement m1 = new MeasurementNumerical(e1, new Date(), 5.51D);
		Measurement m2 = new MeasurementNumerical(e1, new Date(), 5.00D);
		Measurement m3 = new Measurement(e1, new Date());
		Measurement m4 = new Measurement(e1, new Date());
		Measurement m5 = new Measurement(e1, new Date());
		Measurement m6 = new Measurement(e2, new Date());
		Measurement m7 = new Measurement(e2, new Date());
		Measurement m8 = new Measurement(e2, new Date());
		Measurement m9 = new Measurement(e2, new Date());
		Measurement m10 = new Measurement(e2, new Date());
		
		//public Result(Integer resultNumber, Date checkDate, Employee checkedBy, String comments)
		Result r1 = new ResultAssay(1,new Date(), e2, "komentarz");
		Result r2 = new Result(2,new Date(), e2);
		Result r3 = new Result(3,new Date(), e2, "komentarz");
		Result r4 = new Result(1,new Date(), e2, "");
		Result r5 = new Result(2,new Date(), e2, "");
		
		r1.addMeasurement(m1);
		r1.addMeasurement(m2);
		r3.addMeasurement(m3);
		r5.addMeasurement(m10);
		
		
		//Sample(String nrProby, String nrSerii, String nazwaProby, Date dataPoboru, Date dataProdukcji, Date dataWaznosci, Date dataOceny, 
		//		Employee wykonalOcene, Date dataZwolnienia, Employee wykonalZwolnienie)
		
		Sample s1 = new Sample("ZS/2009/001", "A2005/123A", "Witamina D3", new Date(), new Date(), new Date(), new Date(), e2, new Date(), e3);
		Sample s2 = new Sample("ZS/2009/002", "A2005/124A", "Witamina B1", new Date(), new Date(), new Date(), new Date(), e3, new Date(), e3);
		
		s1.addResult(r1);
		s1.addResult(r2);
		s1.addResult(r3);
		s2.addResult(r4);
		s2.addResult(r5);
		
	}
}
