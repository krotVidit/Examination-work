package org.academyTop.Report.Generator;

import org.junit.Test;
import org.junit.Before;
import org.academyTop.Report.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class AverageSalaryTest {

    private List<Employee> employees;

    @Before
    public void setup() {
        employees = new ArrayList<>();
        employees.add(new Employee("IT", "Developer", "Ivanov", "Ivan", "Ivanovich", "Male", "10.02.1985", "123456", "01.01.2010", "USD", "5000", "yearly", "100000"));
        employees.add(new Employee("IT", "Developer", "Petrov", "Petr", "Petrovich", "Male", "12.05.1990", "234567", "01.06.2015", "EUR", "2000", "quarterly", "80000"));
        employees.add(new Employee("Marketing", "Marketing Manager", "Sidorova", "Olga", "Petrovna", "Female", "25.11.1980", "345678", "01.03.2008", "RUB", "3000", "yearly", "120000"));
        employees.add(new Employee("Sales", "Sales Manager", "Kuznetsov", "Dmitry", "Viktorovich", "Male", "03.09.1975", "456789", "01.09.2002", "USD", "4000", "monthly", "150000"));
    }

    @Test
    public void testCalculatesAverageSalaryByDepartment() {
        AverageSalary averageSalary = new AverageSalary(employees);
        Map<String, Double> result = averageSalary.getCalculatesAverageSalaryByDepartment();
        assertEquals(3, result.size());
        assertEquals(90000.0, result.get("IT"), 0.01);
        assertEquals(120000.0, result.get("Marketing"), 0.01);
        assertEquals(150000.0, result.get("Sales"), 0.01);
    }

    @Test
    public void testCalculatesAverageSalaryOrganization() {
        AverageSalary averageSalary = new AverageSalary(employees);
        double result = averageSalary.getCalculatesAverageSalaryOrganization();
        assertEquals(112500.0, result, 0.01);
    }
}

