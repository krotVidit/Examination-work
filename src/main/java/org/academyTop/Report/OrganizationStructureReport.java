package org.academyTop.Report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizationStructureReport {
    private final List<Employee> employees;

    public OrganizationStructureReport(List<Employee> employees) {
        this.employees = employees;
    }

    public OrganizationStructureReport(ArrayList<ArrayList<String>> data) {
        employees = new ArrayList<>();

        // Пропускаем первую строку в файле
        data.remove(0);

        for (ArrayList<String> row : data) {
            String departmentName = row.get(0);
            String position = row.get(1);
            String lastName = row.get(2);
            String firstName = row.get(3);
            String middleName = row.get(4);
            String gender = row.get(5);
            String birthDate = row.get(6);
            String employeeId = row.get(7);
            String startDate = row.get(8);
            String currency = row.get(9);
            String bonus = row.get(10);
            String bonusType = row.get(11);
            String salary = row.get(12);

            Employee employee = new Employee(departmentName, position, lastName, firstName, middleName, gender, birthDate, employeeId, startDate, currency, bonus, bonusType, salary);
            employees.add(employee);
        }
    }


        public void generateReport() {
        Map<String, Department> departmentsMap = new HashMap<>();

        for (Employee employee : employees) {
            String departmentName = employee.departmentName();
            Department department = departmentsMap.get(departmentName);

            if (department == null) {
                department = new Department(departmentName);
                departmentsMap.put(departmentName, department);
            }

            if (employee.position().equals("Начальник")) {
                department.setManager(employee);
            } else {
                department.addEmployee(employee);
            }
        }

        for (Department department : departmentsMap.values()) {
            if (!department.getEmployees().isEmpty() || department.getManager() != null) {
                System.out.println("\n\t\t                   Отдел " + department.getName() + ":");
            }
            if (department.getManager() != null) {
                System.out.println("  Начальник :  " + department.getManager().getFullName() + " (пол " + department.getManager().gender() + ", дата рождения " + department.getManager().birthDate() + ")");
            }
            List<Employee> employees = department.getEmployees();

            if (!employees.isEmpty()) {
                System.out.println("  Подчиненные:  ");
                for (Employee employee : employees) {
                    System.out.println("    " + employee.getFullName() + " (пол " + employee.gender() + ", дата рождения " + employee.birthDate() + ")");
                }
            }
        }
    }

    private static class Department {
        private final String name;
        private Employee manager;
        private final List<Employee> employees;

        public Department(String name) {
            this.name = name;
            employees = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public Employee getManager() {
            return manager;
        }

        public void setManager(Employee manager) {
            this.manager = manager;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void addEmployee(Employee employee) {
            employees.add(employee);
        }
    }

    private record Employee(String departmentName, String position, String lastName, String firstName,
                            String middleName, String gender, String birthDate, String employeeId, String startDate,
                            String currency, String bonus, String bonusType, String salary) {

        public String getFullName() {
                return lastName + " " + firstName + " " + middleName;
            }
        }


        public static void main(String[] args) {
            try {
                RoleAssigner roleAssigner = new RoleAssigner();
                roleAssigner.assignRoles();
                ArrayList<ArrayList<String>> dataWithRoles = roleAssigner.getData();

                OrganizationStructureReport report = new OrganizationStructureReport(dataWithRoles);
                report.generateReport();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
