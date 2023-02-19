package org.academyTop.Report.Generator;

import org.academyTop.Report.Employee;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TopHighlyPaidEmployees {

    private final List<Employee> employees;

    public TopHighlyPaidEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void createsReportHighlyPaidEmployees() {

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                double salary1 = Double.parseDouble(e1.getSalary());
                double salary2 = Double.parseDouble(e2.getSalary());
                return Double.compare(salary2, salary1);
            }
        });

        // Название файла и путь для сохранения отчета
        String fileName = "." + File.separator + "Report"+File.separator+"Top_highly_paid_employees.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("\n\n\nТОП самых высокооплачиваемых сотрудников:\n");
            for (int i = 0; i < 10 && i < employees.size(); i++) {
                Employee employee = employees.get(i);
                String line = String.format("%d. %s: %s рублей\n", i + 1, employee.getFullName(), employee.getSalary());
                writer.write(line);
                System.out.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\t\t\nОтчёт успешно сохранён в файл  Report\n\n\n");
    }

    public void getCreatesReportHighlyPaidEmployees() {
        createsReportHighlyPaidEmployees();
    }
}
