package org.academyTop.Report;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String departmentName;
    private String position;
    private String lastName;
    private String firstName;
    private String middleName;
    private String gender;
    private String birthDate;
    private String employeeId;
    private String startDate;
    private String currency;
    private String bonus;
    private String bonusType;
    private String salary;

    public Employee(String departmentName, String position, String lastName, String firstName, String middleName, String gender, String birthDate, String employeeId, String startDate, String currency, String bonus, String bonusType, String salary) {
        this.departmentName = departmentName;
        this.position = position;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.currency = currency;
        this.bonus = bonus;
        this.bonusType = bonusType;
        this.salary = salary;
    }

    public String fullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    public String getFullName() {
        return fullName();
    }

    private int calculatesDurationOfWork() {
        LocalDate startDate = LocalDate.parse(this.startDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate now = LocalDate.now();
        Period period = Period.between(startDate, now);
        return period.getYears();
    }

    public int getCalculatesDurationOfWork() {
        return calculatesDurationOfWork();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getBonusType() {
        return bonusType;
    }

    public void setBonusType(String bonusType) {
        this.bonusType = bonusType;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
