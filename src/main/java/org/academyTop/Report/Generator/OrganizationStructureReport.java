package org.academyTop.Report.Generator;

import org.academyTop.Report.Employee;
import org.academyTop.Report.EmployeeParser;

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
        employees = parser.parseData(data);
    }

    private void generateReport() {
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
            System.out.println("                                 Отдел: " + department.getName());
            if (department.getManager() != null) {
                System.out.println("\tНачальник: " + department.getManager().getFullName() +
                        " (пол " + department.getManager().getGender() + ", дата рождения " + department.getManager().getBirthDate() + ")");
            }
            List<Employee> employees = department.getEmployees();

            if (!employees.isEmpty()) {
                System.out.println("\tПодчиненные:");
                for (Employee employee : employees) {
                    System.out.println("\t\t" + employee.getFullName() +
                            " (пол " + employee.getGender() + ", дата рождения " + employee.getBirthDate() + ")");
                }
            } else {
                System.out.println("\tОтсутствуют подчиненные.");
            }
        }
    }


    public void getGeneralReport(){
        generateReport();
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

