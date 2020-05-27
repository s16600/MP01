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

//As. zwykla, np. Measurement - Employee (jedenn E może wykonać wiele M)
//As. z atrybutem np. Specification - TestedAccording - Sample (klasy są połączone przez TestedAccording)
//As. kwalifikowana np. Specyfication - Parameter, z kwalifikatorem tekstowym ze skrótem nazwy parametru
//Kompozycja, np.  Result - Measurement

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

		Sample s1 = new Sample("ZS/2009/001", "A2005/123A", "Witamina D3", new Date(), new Date(), new Date(), new Date(), e2, new Date(), e3);
		Sample s2 = new Sample("ZS/2009/002", "A2005/124A", "Witamina B1", new Date(), new Date(), new Date(), new Date(), e3, new Date(), e3);
		
		Result r1 = new ResultAssay(s1, 1,new Date(), e2, "komentarz do zawartości");
		Result r2 = new Result(s1, 2,new Date(), e2);
		Result r3 = new Result(s1, 3,new Date(), e2, "komentarz");
		Result r4 = new Result(s2, 1,new Date(), e2);
		Result r5 = new Result(s2, 2,new Date(), e2);
		
		Measurement m1 = new MeasurementNumerical(r1, e1, new Date(), 5.51D);
		Measurement m2 = new MeasurementNumerical(r1, e1, new Date(), 5.00D);
		Measurement m3 = new Measurement(r2, e1, new Date());
		
		r1.addLink("employee","result",e1);
		r2.addLink("employee","result",e2);
		r3.addLink("employee","result",e2);
		r4.addLink("employee","result",e2);
		r5.addLink("employee","result",e2);
		
		r1.addLink("measurement","result",m1);
		r1.addLink("measurement","result",m2);
		
		System.out.println("R1: " + r1.toString());
		System.out.println("M1: " + m1.toString());
	}
	
	public static void utworzEkstensje() throws Exception {
		Employee e1 = new Employee("Jan", "Kowalski", "Laborant", 100);
		Employee e2 = new Employee("Piotr", "Nowak", "Analityk", 150);
		Employee e3 = new Employee("Tomasz", "Nicpoń", "Kierownik", 200);
		
		Sample s1 = new Sample("ZS/2009/001", "A2005/123A", "Witamina D3", new Date(), new Date(), new Date(), new Date(), e2, new Date(), e3);
		Sample s2 = new Sample("ZS/2009/002", "A2005/124A", "Witamina B1", new Date(), new Date(), new Date(), new Date(), e3, new Date(), e3);
		
		Result r1 = new ResultAssay(s1, 1,new Date(), e2, "komentarz do zawarości");
		Result r2 = new Result(s1, 2,new Date(), e2);
		Result r3 = new Result(s1, 3,new Date(), e2, "komentarz");
		Result r4 = new Result(s2, 1,new Date(), e2);
		Result r5 = new Result(s2, 2,new Date(), e2);
		
		Measurement m1 = new MeasurementNumerical(r1, e1, new Date(), 5.51D);
		Measurement m2 = new MeasurementNumerical(r1, e1, new Date(), 5.00D);
		Measurement m3 = new Measurement(r3, e1, new Date());
		//Measurement m4 = new Measurement(e1, new Date());
		//Measurement m5 = new Measurement(e1, new Date());
		//Measurement m6 = new Measurement(e2, new Date());
		//Measurement m7 = new Measurement(e2, new Date());
		//Measurement m8 = new Measurement(e2, new Date());
		//Measurement m9 = new Measurement(e2, new Date());
		Measurement m10 = new Measurement(r5, e2, new Date());
		
		//public Result(Integer resultNumber, Date checkDate, Employee checkedBy, String comments)

		/*
		r1.addMeasurement(m1);
		r1.addMeasurement(m2);
		r3.addMeasurement(m3);
		r5.addMeasurement(m10);
		*/
		
		//System.out.println(m3);
		
		//Sample(String nrProby, String nrSerii, String nazwaProby, Date dataPoboru, Date dataProdukcji, Date dataWaznosci, Date dataOceny, 
		//		Employee wykonalOcene, Date dataZwolnienia, Employee wykonalZwolnienie)
		
		/*
		s1.addResult(r1);
		s1.addResult(r2);
		s1.addResult(r3);
		s2.addResult(r4);
		s2.addResult(r5);
		*/
		
		Specification sp1 = new Specification("SPK001", "Witamina D3", "PL", "B");
		Specification sp2 = new Specification("SPK002", "Witamina B1", "DE", "A");
		
		//public TestedAccording(Date decisionDate, Employee decidedBy, Sample sample, Specification specification)
		TestedAccording ta1 = new TestedAccording(new Date(), e1, s1, sp1);
		TestedAccording ta2 = new TestedAccording(new Date(), e2, s2, sp2);
		
		Parameter p1 = new Parameter("Zawartość witaminy D3", "380 - 420", "j.m.");
		Parameter p2 = new Parameter("Czas rozpadu", "NMT 15", "min.");
		Parameter p3 = new Parameter("Zawartość witaminy B1", "0,9 - 1,1", "mg");
		Parameter p4 = new Parameter("Czas rozpadu", "NMT 15", "min.");
		
		sp1.addParameter(p1, "zawartość");
		sp1.addParameter(p2, "rozpad");
		sp2.addParameter(p3, "zawartość");
		sp2.addParameter(p4, "rozpad");
		
		System.out.println("Tested according:");
		System.out.println(ta1);
		System.out.println(ta2 + "\n");
		
		System.out.println(sp1.getLinkedObject("parameter", "zawartość") + "\n");
	}
	
}
