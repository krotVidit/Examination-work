package org.academyTop.Report;

import org.academyTop.DataBase;

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
        // Сортируем сотрудников по длительности работы в организации
        employees.sort(Comparator.comparing(Employee::getStartDate));

        // Создаем список из ТОП-10 самых преданных сотрудников
        List<Employee> topTenEmployees = new ArrayList<>();
        for (int i = 0; i < Math.min(10, employees.size()); i++) {
            topTenEmployees.add(employees.get(i));
        }

        // Сортируем список ТОП-10 сотрудников по убыванию длительности работы в организации
        topTenEmployees.sort(Comparator.comparing(Employee::getStartDate).reversed());

        // Формируем отчет и сохраняем в файл
        try (FileWriter writer = new FileWriter("top_ten_employee_report.txt")) {
            writer.write("ТОП-10 самых преданных сотрудников по количеству лет работы в организации:\n");
            for (int i = 0; i < topTenEmployees.size(); i++) {
                Employee employee = topTenEmployees.get(i);
                String line = String.format("%d. %s - %d лет работы\n", i + 1, employee.getFullName(), employee.getDurationOfWork());
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            DataBase database = new DataBase();
            RoleAssigner roleAssigner = new RoleAssigner();
            EmployeeParser employeeParser = new EmployeeParser();

            List<Employee> employees = employeeParser.parseData(roleAssigner.getData());
            List<Employee> sortedEmployees = new ArrayList<>(employees);
            sortedEmployees.sort((e1, e2) -> e2.getDurationOfWork() - e1.getDurationOfWork());

            TopTenEmployeeReport reportGenerator = new TopTenEmployeeReport(sortedEmployees);
            reportGenerator.generateReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
