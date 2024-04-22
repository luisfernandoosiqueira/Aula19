
package exercicoTrabalhador.application;

import exercicoTrabalhador.entities.Department;
import exercicoTrabalhador.entities.HourContract;
import exercicoTrabalhador.entities.Worker;
import exercicoTrabalhador.entities.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department name: ");
        String departmentName = ler.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = ler.nextLine();
        System.out.print("Level: ");
        String workerLevel = ler.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = ler.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.println("How many contracts to this worker? ");
        int n = ler.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(ler.next());
            System.out.println("Value per hour: ");
            double valuePerHour = ler.nextDouble();
            System.out.println("Duration (hours): ");
            int hours = ler.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = ler.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        ler.close();

    }

}
