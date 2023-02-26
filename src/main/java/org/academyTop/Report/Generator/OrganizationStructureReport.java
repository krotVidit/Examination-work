package org.academyTop.Report.Generator;

import org.academyTop.Report.Employee;
import org.academyTop.Report.EmployeeParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizationStructureReport {
    private final List<Employee> employees;

    private OrganizationStructureReport(List<Employee> employees) {
        this.employees = employees;
    }

    public OrganizationStructureReport(ArrayList<ArrayList<String>> data) {
        EmployeeParser parser = new EmployeeParser();
        employees = parser.getParseData(data);
    }

    private String createOrganizationStructureReport() {
        StringBuilder reportBuilder = new StringBuilder();
        Map<String, Department> departmentsMap = new HashMap<>();

        for (Employee employee : employees) {
            String departmentName = employee.getDepartmentName();
            Department department = departmentsMap.get(departmentName);

            if (department == null) {
                department = new Department(departmentName);
                departmentsMap.put(departmentName, department);
            }

            if (employee.getPosition().equals("Начальник")) {
                department.setManager(employee);
            } else {
                department.addEmployee(employee);
            }
        }

        for (Department department : departmentsMap.values()) {
            reportBuilder.append("========================================================================================\n");
            reportBuilder.append("            Отдел: ").append(department.getName()).append("\n");
            if (department.getManager() != null) {
                reportBuilder.append("\tНачальник: ").append(department.getManager().getFullName())
                        .append(" (пол ").append(department.getManager().getGender())
                        .append(", дата рождения ").append(department.getManager().getBirthDate()).append(")\n");
            }

            List<Employee> employees = department.getEmployees();

            if (!employees.isEmpty()) {
                reportBuilder.append("\t\nПодчиненные:\n");
                for (Employee employee : employees) {
                    reportBuilder.append("\t\t").append(employee.getFullName())
                            .append(" (пол ").append(employee.getGender())
                            .append(", дата рождения ").append(employee.getBirthDate()).append(")\n");
                }
            } else {
                reportBuilder.append("\tОтсутствуют подчиненные.\n");
            }
        }

        return reportBuilder.toString();
    }

    private void generatesHierarchyReport() {
        String report = createOrganizationStructureReport();
        System.out.println(report);
        savesReportToFile(report);
    }
    public void getGeneratesHierarchyReport(){
        generatesHierarchyReport();
    }

    private void savesReportToFile(String report) {
        String fileName = "." + File.separator + "Report" + File.separator + "Organization_structure_report.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(report);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\t\nОтчёт успешно сохранён в файл Report\n\n\n");
    }

    private static class Department {
        private final String name;
        private Employee manager;
        private final List<Employee> employees;

        private Department(String name) {
            this.name = name;
            employees = new ArrayList<>();
        }

        private String getName() {
            return name;
        }

        private Employee getManager() {
            return manager;
        }

        private void setManager(Employee manager) {
            this.manager = manager;
        }

        private List<Employee> getEmployees() {
            return employees;
        }

        private void addEmployee(Employee employee) {
            employees.add(employee);
        }
    }
}

