package org.academyTop.Report.Generator;

import org.academyTop.Report.Employee;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class TopHighlyPaidEmployees {

    private final List<Employee> employees;

    public TopHighlyPaidEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void sortEmployeesBySalary() {
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                double salary1 = Double.parseDouble(e1.getSalary());
                double salary2 = Double.parseDouble(e2.getSalary());
                return Double.compare(salary2, salary1);
            }
        });
    }

    private String createsReportHighlyPaidEmployees() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("\n\n\nТОП самых высокооплачиваемых сотрудников:\n");
        for (int i = 0; i < 10 && i < employees.size(); i++) {
            Employee employee = employees.get(i);
            String line = String.format("%d. %s: %s рублей\n", i + 1, employee.getFullName(), employee.getSalary());
            reportBuilder.append(line);
            System.out.print(line);
        }
        return reportBuilder.toString();
    }
    public String getCreatesReportHighlyPaidEmployees(){
        return createsReportHighlyPaidEmployees();
    }

    private String savesReportToFile(String report) {
        String fileName = "." + File.separator + "Report" + File.separator + "Top_highly_paid_employees.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(report);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\t\t\nОтчёт успешно сохранён в файл  Report\n\n\n");
        return report;
    }
    public String getSavesReportToFile(){
        String report = createsReportHighlyPaidEmployees();
        return savesReportToFile(report);
    }

}
