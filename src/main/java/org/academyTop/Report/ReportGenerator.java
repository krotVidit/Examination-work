package org.academyTop.Report;

import org.academyTop.DataBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGenerator {
    private ArrayList<ArrayList<String>> data;

    public ReportGenerator() throws IOException {
        DataBase database = new DataBase();
        this.data = database.getPutDataBaseExelInArrayList();
    }

    public void getReport() {
        List<Employee> employees = new EmployeeParser().parseData(data);
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName));

        System.out.println("Средняя зарплата по организации: " + getAverageSalary(employees));

        for (Map.Entry<String, List<Employee>> entry : employeesByDepartment.entrySet()) {
            String department = entry.getKey();
            List<Employee> departmentEmployees = entry.getValue();
            System.out.println("Средняя зарплата по отделу " + department + ": " + getAverageSalary(departmentEmployees));
        }
    }

    private double getAverageSalary(List<Employee> employees) {
        double totalSalary = employees.stream()
                .mapToDouble(employee -> Double.parseDouble(employee.getSalary().replaceAll("[^\\d.]+", "")))
                .sum();
        return totalSalary / employees.size();
    }

    public static void main(String[] args) {
        try {
            ReportGenerator reportGenerator = new ReportGenerator();
            reportGenerator.getReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



