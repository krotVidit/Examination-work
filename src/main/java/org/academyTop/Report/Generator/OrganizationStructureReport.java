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

    private void generatesHierarchyReport() {
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
            System.out.println("========================================================================================");
            System.out.println("            Отдел: " + department.getName());
            if (department.getManager() != null) {
                System.out.println("\tНачальник: " + department.getManager().getFullName() +
                        " (пол " + department.getManager().getGender() + ", дата рождения " + department.getManager().getBirthDate() + ")");
            }
            List<Employee> employees = department.getEmployees();

            if (!employees.isEmpty()) {
                System.out.println("\t\nПодчиненные:");
                for (Employee employee : employees) {
                    System.out.println("\t\t" + employee.getFullName() +
                            " (пол " + employee.getGender() + ", дата рождения " + employee.getBirthDate() + ")");
                }
            } else {
                System.out.println("\tОтсутствуют подчиненные.");
            }
        }

        savesReportToFile();
    }

    public void getGeneratesHierarchyReport() {
        generatesHierarchyReport();
    }

    private void savesReportToFile() {
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

        String fileName = "." + File.separator + "Report" + File.separator + "Organization_structure_report.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            for (Department department : departmentsMap.values()) {
                writer.write("\n\n\n========================================================================================\n");
                writer.write( "\t\t\tОтдел: " + department.getName()+"\n");
                if (department.getManager() != null) {
                    writer.write("\tНачальник: " + department.getManager().getFullName() +
                            " (пол " + department.getManager().getGender() + ", дата рождения " + department.getManager().getBirthDate() + ")\n");
                }
                List<Employee> employees = department.getEmployees();

                if (!employees.isEmpty()) {
                    writer.write("\nПодчиненные:\n");
                    for (Employee employee : employees) {
                        writer.write("\t\t" + employee.getFullName() +
                                " (пол " + employee.getGender() + ", дата рождения " + employee.getBirthDate() + ")\n");
                    }
                } else {
                    writer.write("\tОтсутствуют подчиненные.\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\t\nОтчёт успешно сохранён в файл Report\n\n\n");
    }

    public void getSavesReportToFile() {
        savesReportToFile();
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

