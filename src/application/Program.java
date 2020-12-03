package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// Entrada de dados ==
		System.out.print("Entre com o nome do Departamento: ");
		String departmentName = sc.nextLine();
		System.out.println();
		System.out.println("Entre com os dados do Trabalhador:");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		System.out.print("Nível: ");
		String workerLevel = sc.nextLine();
		System.out.print("Salário base: $");
		Double workerBaseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(departmentName));
		
		System.out.print("Quantos Contratos? ");
		int numContratos = sc.nextInt();
		
		for(int i=1; i<=numContratos; i++) {
			System.out.println("Entre com os dados do " + i + "º Contrato:");
			System.out.print("Data (DD/MM/AAAA): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por Hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duração (Horas): ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Entre com o mês e ano para calcular o pagamento (MM/AAAA): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println();
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.println("Pagamento para " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		
		
		sc.close();
	}
}
