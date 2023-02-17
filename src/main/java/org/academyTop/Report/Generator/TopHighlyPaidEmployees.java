package org.academyTop.Report.Generator;

import org.academyTop.Report.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TopHighlyPaidEmployees {

    private final List<Employee> employees;

    public TopHighlyPaidEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void createsReportHighlyPaidEmployees() {

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                double salary1 = Double.parseDouble(e1.getSalary());
                double salary2 = Double.parseDouble(e2.getSalary());
                return Double.compare(salary2, salary1);
            }
        });


        System.out.println("ТОП самых высокооплачиваемых сотрудников:");
        for (int i = 0; i < 10 && i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.printf("%d. %s: %s рублей\n", i + 1, employee.getFullName(), employee.getSalary());
        }
    }
    public void getCreatesReportHighlyPaidEmployees(){
        createsReportHighlyPaidEmployees();
    }

}

