package org.academyTop.Report.Generator;

import org.academyTop.Report.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageSalary {
    private List<Employee> employees;

    public AverageSalary(List<Employee> employees) {
        this.employees = employees;
    }

    private Map<String, Double> averageSalaryByDepartment() {
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
    public Map<String, Double> getAverageSalaryByDepartment(){
        return averageSalaryByDepartment();
    }

    private double averageSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += Double.parseDouble(employee.getSalary().replaceAll("[^\\d.]", ""));
        }
        return totalSalary / employees.size();
    }

    public double getAverageSalary(){
        return averageSalary();
    }

    private void generateReport() {
        Map<String, Double> averageSalaryByDepartment = getAverageSalaryByDepartment();
        double averageSalary = getAverageSalary();

        System.out.println("Средняя зарплата по организации: " + averageSalary);
        for (Map.Entry<String, Double> entry : averageSalaryByDepartment.entrySet()) {
            String department = entry.getKey();
            double departmentAverageSalary = entry.getValue();
            System.out.println("Средняя зарплата по отделу " + department + ": " + departmentAverageSalary);
        }
    }
    public void getGenerateReport(){
        generateReport();
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
        System.out.println("\tОтчёт успешно сохранён в файл " + fileName);
    }
}

