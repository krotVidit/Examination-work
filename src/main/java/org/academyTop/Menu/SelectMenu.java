package org.academyTop.Menu;

import org.academyTop.DataBase.DataBase;
import org.academyTop.DataBase.DataTable;
import org.academyTop.Report.Employee;
import org.academyTop.Report.EmployeeParser;
import org.academyTop.Report.Generator.AverageSalary;
import org.academyTop.Report.Generator.OrganizationStructureReport;
import org.academyTop.Report.Generator.TopHighlyPaidEmployees;
import org.academyTop.Report.Generator.TopLoyalEmployees;
import org.academyTop.Report.RoleAssigner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectMenu {
    Scanner scanner = new Scanner(System.in);
    RoleAssigner roleAssigner = new RoleAssigner();
    EmployeeParser employeeParser = new EmployeeParser();
    DataBase dataBase = new DataBase();
    List<Employee> employees = employeeParser.parseData(roleAssigner.getData());
    AverageSalary reportGenerator = new AverageSalary(employees);
    List<ArrayList<String>> data = dataBase.getPutDataBaseExelInArrayList();
    List<Employee> employees1 = employeeParser.parseData((ArrayList<ArrayList<String>>) data);


    public SelectMenu() throws IOException {
    }

    private void selectsMenuItemsAdmin() throws IOException {
        int numberMenu = scanner.nextInt();
        switch (numberMenu){
            case 2:
                new Menu().getPrintMenuReport();
                selectsMenuReport();
                new Menu().getPrintMenuAdmin();
                selectsMenuItemsAdmin();
                break;
            case 3 :
                new DataTable().setVisible(true);
                new Menu().getPrintMenuAdmin();
                selectsMenuItemsAdmin();
                break;
            case 4:
                break;

        }
        new Menu().getPrintMenuAdmin();
        selectsMenuItemsAdmin();
    }
    public  void getSelectMenuItemsAdmin() throws IOException {
        selectsMenuItemsAdmin();
    }
    private void selectsMenuReport() throws IOException {

        int numberSelect = scanner.nextInt();
        switch (numberSelect){
            case 1:
                roleAssigner.getAssignRoles();
                ArrayList<ArrayList<String>> dataWithRoles = roleAssigner.getData();
                OrganizationStructureReport report = new OrganizationStructureReport(dataWithRoles);
                report.getGeneralReport();
                break;
            case 2:
                reportGenerator.getGenerateReport();
                reportGenerator.getSaveReportToFile();
                break;
            case 3:
                TopHighlyPaidEmployees reportGenerator1 = new TopHighlyPaidEmployees(employees);
                reportGenerator1.getCreatesReportHighlyPaidEmployees();
                break;
            case 4:
                EmployeeParser employeeParser = new EmployeeParser();

                List<Employee> employees = employeeParser.parseData(roleAssigner.getData());

                TopLoyalEmployees reportGenerator = new TopLoyalEmployees(employees);
                reportGenerator.createReportLoyalEmployees();
                break;
        }
        Menu menu = new Menu();
        menu.getPrintMenuReport();
        selectsMenuReport();

    }
}
