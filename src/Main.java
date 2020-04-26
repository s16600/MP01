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

//As. zwykla, np. Measurement - Employee
//As. z atrybutem
//As. kwalifikowana
//Kompozycja, np. Result - Measurement lub Measurement - Sample

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Podaj, co chcesz zrobić: \n"
				+ " - Utworzyć ekstensję i zapisać w pliku, wpisz - 1\n"
				+ " - Odczytać ekstensję z pliku, wpisz - 2\n"
				+ " - Utworzyć asocjacje, wpisz - 3\n"
				+ " - Zakończyć program, wpisz inną liczbę\n");
		
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
				
				System.out.println("Lista pracowników:");
				Employee.showExtent(Employee.class);
				System.out.println("Suma wynagrodzeń: " + Employee.sumSalary() +"\n");
				System.out.println("Lista prób:");
				Sample.showExtent(Sample.class);
				break; 
			case 2:
				extentFile = new File("Plik1.obj");
				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(extentFile)));
				Employee.readExtent(in);
				in.close();
				
				System.out.println("Lista pracowników:");
				Employee.showExtent(Employee.class);
				System.out.println("Suma wynagrodzeń: " + Employee.sumSalary() +"\n");
				System.out.println("Lista prób:");
				Sample.showExtent(Sample.class);
				break;
			case 3:
				utworzAsocjacje();
				break;
		}

		System.out.println("\n*** Koniec programu ***");
	}


	public static void utworzAsocjacje() throws Exception {
		Employee e1 = new Employee("Jan", "Kowalski", "Laborant", 100);
		Employee e2 = new Employee("Piotr", "Nowak", "Analityk", 150);
		Employee e3 = new Employee("Tomasz", "Nicpoń", "Kierownik", 200);
		
		Measurement m1 = new MeasurementNumerical(e1, new Date(), 5.51D);
		Measurement m2 = new MeasurementNumerical(e1, new Date(), 5.00D);
		Measurement m3 = new Measurement(e1, new Date());
		
		Result r1 = new ResultAssay(1,new Date(), e2, "komentarz do zawartości");
		Result r2 = new Result(2,new Date(), e2);
		Result r3 = new Result(3,new Date(), e2, "komentarz");
		Result r4 = new Result(1,new Date(), e2);
		Result r5 = new Result(2,new Date(), e2);
		
		r1.addLink("employee","result",e1);
		r2.addLink("employee","result",e2);
		r3.addLink("employee","result",e2);
		r4.addLink("employee","result",e2);
		r5.addLink("employee","result",e2);
		
		r1.addLink("measurement","result",m1);
		r1.addLink("measurement","result",m2);
		
		System.out.println("R1: " + r1.toString());
		
		System.out.println("M1: " + m1.toString());
		
		//for (MyExtensionPlus r : r1.getLinks("measurement")) System.out.println(r);
		
		//r2.addLink("employee","result",e3);
		
		//r1.showLinks("employee",System.out);
		
		
		//System.out.println(e1.getLinks("result"));
		
		//for(MyExtensionPlus r : r1.getLinks("employee")) System.out.println(r);
		//for(MyExtensionPlus r : r2.getLinks("employee")) System.out.println(r);
		
		//System.out.println("Lista pracowników:");
		//Employee.showExtent(Employee.class);
		
		//System.out.println(r1.getLinkedObject("employee",e3));
	}
	
	public static void utworzEkstensje() throws Exception {
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
		Result r1 = new ResultAssay(1,new Date(), e2, "komentarz do zawarości");
		Result r2 = new Result(2,new Date(), e2);
		Result r3 = new Result(3,new Date(), e2, "komentarz");
		Result r4 = new Result(1,new Date(), e2);
		Result r5 = new Result(2,new Date(), e2);
		
		r1.addMeasurement(m1);
		r1.addMeasurement(m2);
		r3.addMeasurement(m3);
		r5.addMeasurement(m10);
		
		//System.out.println(m3);
		
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
