package org.academyTop.Report.Generator;

import org.academyTop.Report.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TopTenEmployeeReport {

    private List<Employee> employees;

    public TopTenEmployeeReport(List<Employee> employees) {
        this.employees = employees;
    }

    public void generateReport() {
        employees.sort(Comparator.comparing(Employee::getDurationOfWork).reversed());


        List<Employee> topTenEmployees = new ArrayList<>();
        for (int i = 0; i < Math.min(10, employees.size()); i++) {
            topTenEmployees.add(employees.get(i));
        }

        // Формируем отчет и сохраняем в файл
        try (FileWriter writer = new FileWriter("top_ten_employee_report.txt")) {
            writer.write("ТОП самых преданных сотрудников по количеству лет работы в организации:\n");
            for (int i = 0; i < topTenEmployees.size(); i++) {
                Employee employee = topTenEmployees.get(i);
                String line = String.format("%d. %s - %d лет работы\n", i + 1, employee.getFullName(), employee.getDurationOfWork());
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
