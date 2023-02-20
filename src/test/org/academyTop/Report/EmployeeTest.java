package org.academyTop.Report;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    public void testCalculatesDurationOfWork() {
        Employee employee = new Employee("IT", "Software Developer", "Ivanov", "Ivan", "Ivanovich", "Male", "10.02.1985", "123456", "01.01.2010", "USD", "5000", "yearly", "100000");

        LocalDate startDate = LocalDate.parse("01.01.2010", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate now = LocalDate.now();
        int expectedYears = now.getYear() - startDate.getYear();
        int actualYears = employee.getCalculatesDurationOfWork();

        assertEquals(expectedYears, actualYears);
    }

    @Test
    public void testFullName() {
        Employee employee = new Employee("IT", "Software Developer", "Ivanov", "Ivan", "Ivanovich", "Male", "10.02.1985", "123456", "01.01.2010", "USD", "5000", "yearly", "100000");
        String expectedFullName = "Ivanov Ivan Ivanovich";
        String actualFullName = employee.getFullName();
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    public void testGettersAndSetters() {
        Employee employee = new Employee("IT", "Software Developer", "Ivanov", "Ivan", "Ivanovich", "Male", "10.02.1985", "123456", "01.01.2010", "USD", "5000", "yearly", "100000");

        employee.setDepartmentName("HR");
        employee.setPosition("HR Manager");
        employee.setLastName("Petrov");
        employee.setFirstName("Petr");
        employee.setMiddleName("Petrovich");
        employee.setGender("Male");
        employee.setBirthDate("12.01.1980");
        employee.setEmployeeId("654321");
        employee.setStartDate("01.01.2008");
        employee.setCurrency("EUR");
        employee.setBonus("1000");
        employee.setBonusType("monthly");
        employee.setSalary("80000");

        assertEquals("HR", employee.getDepartmentName());
        assertEquals("HR Manager", employee.getPosition());
        assertEquals("Petrov", employee.getLastName());
        assertEquals("Petr", employee.getFirstName());
        assertEquals("Petrovich", employee.getMiddleName());
        assertEquals("Male", employee.getGender());
        assertEquals("12.01.1980", employee.getBirthDate());
        assertEquals("654321", employee.getEmployeeId());
        assertEquals("01.01.2008", employee.getStartDate());
        assertEquals("EUR", employee.getCurrency());
        assertEquals("1000", employee.getBonus());
        assertEquals("monthly", employee.getBonusType());
        assertEquals("80000", employee.getSalary());
    }
}
