package org.academyTop.Menu;

import org.academyTop.DataBase.DataBase;
import org.academyTop.DataBase.DataTable;
import org.academyTop.Report.*;
import org.academyTop.Report.Generator.OrganizationStructureReport;
import org.academyTop.Report.Generator.ReportGenerator;
import org.academyTop.Report.Generator.TopSalaryReportGenerator;
import org.academyTop.Report.Generator.TopTenEmployeeReport;

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
        int numberMenu = scanner.nextInt();
        switch (numberMenu){
            case 2:
                new Menu().getPrintMenuReport();
                selectsMenuReport();
                break;
            case 3 :
                new DataTable().setVisible(true);
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
        Menu menu = new Menu();
        menu.getPrintMenuReport();
        selectsMenuReport();

    }
}
