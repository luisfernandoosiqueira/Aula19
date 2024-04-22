
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

        System.out.print("Informe o nome do Departamento: ");
        String departmentName = ler.nextLine();
        System.out.println("Dados do Contrato: ");
        System.out.print("Nome: ");
        String workerName = ler.nextLine();
        System.out.print("Nível: ");
        String workerLevel = ler.nextLine();
        System.out.print("Salário base: ");
        double baseSalary = ler.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.println("Quantos contratos deseja cadastrar? ");
        int n = ler.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("Dados do  #" + i + " contrato:");
            System.out.print("Data (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(ler.next());
            System.out.println("Valor por hora: ");
            double valuePerHour = ler.nextDouble();
            System.out.println("Duração (horas): ");
            int hours = ler.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.println("Informe o mês e o ano que deseja calcular (MM/YYYY): ");
        String monthAndYear = ler.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Nome: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartment().getName());
        System.out.println("Renda de " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        ler.close();

    }

}
