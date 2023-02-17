package org.academyTop.Report;

import org.academyTop.DataBase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGenerator {
    private List<Employee> employees;

    public ReportGenerator(List<Employee> employees) {
        this.employees = employees;
    }

    public Map<String, Double> getAverageSalaryByDepartment() {
        Map<String, Double> departmentSalaryMap = new HashMap<>();
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName));
        for (Map.Entry<String, List<Employee>> entry : employeesByDepartment.entrySet()) {
            List<Employee> departmentEmployees = entry.getValue();
            double totalSalary = 0;
            for (Employee employee : departmentEmployees) {
                totalSalary += Double.parseDouble(employee.getSalary().replaceAll("[^\\d.]", ""));
            }
            double averageSalary = totalSalary / departmentEmployees.size();
            departmentSalaryMap.put(entry.getKey(), averageSalary);
        }
        return departmentSalaryMap;
    }

    public double getAverageSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += Double.parseDouble(employee.getSalary().replaceAll("[^\\d.]", ""));
        }
        return totalSalary / employees.size();
    }

    public void generateReport() {
        Map<String, Double> averageSalaryByDepartment = getAverageSalaryByDepartment();
        double averageSalary = getAverageSalary();

        System.out.println("Средняя зарплата по организации: " + averageSalary);
        for (Map.Entry<String, Double> entry : averageSalaryByDepartment.entrySet()) {
            String department = entry.getKey();
            double departmentAverageSalary = entry.getValue();
            System.out.println("Средняя зарплата по отделу " + department + ": " + departmentAverageSalary);
        }
    }

    public void saveReportToFile(String fileName) throws IOException {
        Map<String, Double> averageSalaryByDepartment = getAverageSalaryByDepartment();
        double averageSalary = getAverageSalary();

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("Средняя зарплата по организации: " + averageSalary + "\n");
        for (Map.Entry<String, Double> entry : averageSalaryByDepartment.entrySet()) {
            String department = entry.getKey();
            double departmentAverageSalary = entry.getValue();
            fileWriter.write("Средняя зарплата по отделу " + department + ": " + departmentAverageSalary + "\n");
        }
        fileWriter.close();
        System.out.println("Отчёт успешно сохранён в файл " + fileName);
    }

    public static void main(String[] args) throws IOException {
        DataBase database = new DataBase();
        RoleAssigner roleAssigner = new RoleAssigner();
        EmployeeParser employeeParser = new EmployeeParser();
        List<Employee> employees = employeeParser.parseData(roleAssigner.getData());

        ReportGenerator reportGenerator = new ReportGenerator(employees);
        reportGenerator.generateReport();
        reportGenerator.saveReportToFile("report.txt");
    }
}

