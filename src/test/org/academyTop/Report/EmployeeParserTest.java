package org.academyTop.Report;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeParserTest {

    @Test
    public void testParseData() {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        ArrayList<String> row1 = new ArrayList<>();
        row1.add("IT");
        row1.add("Software Developer");
        row1.add("Ivanov");
        row1.add("Ivan");
        row1.add("Ivanovich");
        row1.add("Male");
        row1.add("10.02.1985");
        row1.add("123456");
        row1.add("01.01.2010");
        row1.add("USD");
        row1.add("5000");
        row1.add("yearly");
        row1.add("100000");
        data.add(row1);

        ArrayList<String> row2 = new ArrayList<>();
        row2.add("HR");
        row2.add("HR Manager");
        row2.add("Petrov");
        row2.add("Petr");
        row2.add("Petrovich");
        row2.add("Male");
        row2.add("12.01.1980");
        row2.add("654321");
        row2.add("01.01.2008");
        row2.add("EUR");
        row2.add("1000");
        row2.add("monthly");
        row2.add("80000");
        data.add(row2);

        EmployeeParser parser = new EmployeeParser();
        List<Employee> employees = parser.getParseData(data);

        assertEquals(1, employees.size());

        Employee employee1 = employees.get(0);
        assertEquals("HR", employee1.getDepartmentName());
        assertEquals("HR Manager", employee1.getPosition());
        assertEquals("Petrov", employee1.getLastName());
        assertEquals("Petr", employee1.getFirstName());
        assertEquals("Petrovich", employee1.getMiddleName());
        assertEquals("Male", employee1.getGender());
        assertEquals("12.01.1980", employee1.getBirthDate());
        assertEquals("654321", employee1.getEmployeeId());
        assertEquals("01.01.2008", employee1.getStartDate());
        assertEquals("EUR", employee1.getCurrency());
        assertEquals("1000", employee1.getBonus());
        assertEquals("monthly", employee1.getBonusType());
        assertEquals("80000", employee1.getSalary());
    }
}

