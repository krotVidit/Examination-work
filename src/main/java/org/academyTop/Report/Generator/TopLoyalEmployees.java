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

    private void createReportLoyalEmployees() {
        StringBuilder reportContent = new StringBuilder();
        reportContent.append("\n\n\nОтчет по всем сотрудникам:\n");
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            String line = String.format("%d. %s - %d лет работы\n", i + 1, employee.getFullName(), employee.getCalculatesDurationOfWork());
            reportContent.append(line);
            System.out.print(line);
        }
        System.out.println("\t\t\nОтчёт успешно сохранён в файл в Report\n\n\n");
        saveReportToFile(reportContent.toString(), "Top_loyal_employees.txt");
    }

    private void saveReportToFile(String reportContent, String fileName) {
        try (FileWriter writer = new FileWriter("." + File.separator + "Report" + File.separator + fileName)) {
            writer.write(reportContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sortsEmployeesByDurationOfWork() {
        employees.sort(Comparator.comparing(Employee::getCalculatesDurationOfWork).reversed());
    }

    public void getSortsEmployeesByDurationOfWork() {
        sortsEmployeesByDurationOfWork();
    }

    public void getCreateReportLoyalEmployees() {
        sortsEmployeesByDurationOfWork();
        createReportLoyalEmployees();
    }
}