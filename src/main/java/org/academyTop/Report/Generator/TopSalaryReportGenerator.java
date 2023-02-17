package org.academyTop.Report.Generator;

import org.academyTop.Report.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TopSalaryReportGenerator {

    private final List<Employee> employees;

    public TopSalaryReportGenerator(List<Employee> employees) {
        this.employees = employees;
    }

    public void generateReport() {
        // Сортируем список сотрудников по убыванию зарплаты
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                double salary1 = Double.parseDouble(e1.getSalary());
                double salary2 = Double.parseDouble(e2.getSalary());
                return Double.compare(salary2, salary1);
            }
        });

        // Выводим информацию о ТОП-10 самых дорогих сотрудниках
        System.out.println("ТОП-10 самых дорогих сотрудников:");
        for (int i = 0; i < 10 && i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.printf("%d. %s: %s рублей\n", i + 1, employee.getFullName(), employee.getSalary());
        }
    }

}

