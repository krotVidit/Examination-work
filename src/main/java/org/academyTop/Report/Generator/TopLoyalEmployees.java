package org.academyTop.Report.Generator;

import org.academyTop.Report.Employee;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class TopLoyalEmployees {

    private List<Employee> employees;

    public TopLoyalEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void createReportLoyalEmployees() {
        employees.sort(Comparator.comparing(Employee::getDurationOfWork).reversed());

        try (FileWriter writer = new FileWriter("." + File.separator + "Report" + File.separator + "Top_loyal_employees.txt")) {
            writer.write("Отчет по всем сотрудникам:\n");
            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                String line = String.format("%d. %s - %d лет работы\n", i + 1, employee.getFullName(), employee.getDurationOfWork());
                writer.write(line);
                System.out.print(line); // Добавляем эту строку для вывода на консоль
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\tОтчёт успешно сохранён в файл в Report");
    }
}
