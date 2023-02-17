package org.academyTop.Menu;

import org.academyTop.DataBase;
import org.academyTop.DataTable;
import org.academyTop.Report.*;

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
    ReportGenerator reportGenerator = new ReportGenerator(employees);
    List<ArrayList<String>> data = dataBase.getPutDataBaseExelInArrayList();
    List<Employee> employees1 = employeeParser.parseData((ArrayList<ArrayList<String>>) data);


    public SelectMenu() throws IOException {
    }

    private void selectsMenuItemsAdmin() throws IOException {
        DataTable dataTable = new DataTable();
        Menu menu = new Menu();
        int numberMenu = scanner.nextInt();
        switch (numberMenu){
            case 2:
                menu.getPrintMenuReport();
                selectsMenuReport();
                break;
            case 3 :
                dataTable.setVisible(true);
                break;

        }
        menu.getPrintMenuAdmin();
        selectsMenuItemsAdmin();
    }
    public  void getSelectMenuItemsAdmin() throws IOException {
        selectsMenuItemsAdmin();
    }
    private void selectsMenuReport() throws IOException {
        Menu menu = new Menu();

        int numberSelect = scanner.nextInt();
        switch (numberSelect){
            case 1:
                roleAssigner.assignRoles();
                ArrayList<ArrayList<String>> dataWithRoles = roleAssigner.getData();
                OrganizationStructureReport report = new OrganizationStructureReport(dataWithRoles);
                report.getGeneralReport();
                break;
            case 2:
                reportGenerator.generateReport();
                reportGenerator.saveReportToFile("report.txt");
                break;
            case 3:
                TopSalaryReportGenerator reportGenerator1 = new TopSalaryReportGenerator(employees);
                reportGenerator1.generateReport();
                break;
            case 4:
                EmployeeParser employeeParser = new EmployeeParser();

                List<Employee> employees = employeeParser.parseData(roleAssigner.getData());

                TopTenEmployeeReport reportGenerator = new TopTenEmployeeReport(employees);
                reportGenerator.generateReport();
                break;
        }
        menu.getPrintMenuReport();
        selectsMenuReport();

    }
}
