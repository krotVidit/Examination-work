package org.academyTop.Report;

import java.util.ArrayList;
import java.util.List;

public class EmployeeParser {

    public List<Employee> parseData(ArrayList<ArrayList<String>> data) {
        List<Employee> employees = new ArrayList<>();

        boolean firstRowSkipped = false;
        for (ArrayList<String> row : data) {
            if (!firstRowSkipped) {
                firstRowSkipped = true;
                continue;
            }

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

        return employees;
    }
}
