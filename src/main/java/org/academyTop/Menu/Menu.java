package org.academyTop.Menu;

import org.academyTop.DataBase.DataBase;
import org.academyTop.DataBase.DataTable;
import org.academyTop.Report.Employee;
import org.academyTop.Report.EmployeeParser;
import org.academyTop.Report.Generator.AverageSalary;
import org.academyTop.Report.Generator.OrganizationStructureReport;
import org.academyTop.Report.Generator.TopHighlyPaidEmployees;
import org.academyTop.Report.Generator.TopLoyalEmployees;
import org.academyTop.Report.Roles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Roles role = new Roles();
    EmployeeParser employeeParser = new EmployeeParser();
    DataBase dataBase = new DataBase();
    List<Employee> employees = employeeParser.getParseData(role.getData());
    AverageSalary reportGeneratorAverageSalary = new AverageSalary(employees);
    List<ArrayList<String>> data = dataBase.getPutDataBaseExelInArrayList();

    public Menu() throws IOException {
    }


    private void printsNameProgram() {
        System.out.print("""

                ********************************
                ** Employee accounting system **
                ********************************

                """);
    }

    public void getPrintsNameProgram() {
        printsNameProgram();
    }

    private void printsInteractiveMenuAdmin() throws IOException {
        System.out.println("""

                Select Action
                _____________""");
        System.out.println("1.DataBase\n2.Create a report\n3.Exit Program");
        try {
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    new DataTable().setVisible(true);
                    printsInteractiveMenuAdmin();
                    break;
                case 2:
                    printsInteractiveMenuReport();
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid value entered\n");
                    printsInteractiveMenuAdmin();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid value entered\n");
            printsInteractiveMenuAdmin();
        }
    }

    public void getPrintsInteractiveMenuAdmin() throws IOException {
        printsInteractiveMenuAdmin();
    }

    private void printsInteractiveMenuReport() throws IOException {
        System.out.println("""

                Select Action
                _____________""");
        System.out.println("1.Organization structure\n2.Average salary by organization and department\n3.The highest paid\n4.Most dedicated employees\n5.Main Menu\n6.Exit Program ");
    try{
        int select = Integer.parseInt(scanner.nextLine());
        switch (select){
            case 1:
                role.getAssignsRole();
                ArrayList<ArrayList<String>> dataWithRoles = role.getData();
                OrganizationStructureReport reportStructureOrganization = new OrganizationStructureReport(dataWithRoles);
                reportStructureOrganization.getGeneratesHierarchyReport();

                break;
            case 2:
                reportGeneratorAverageSalary.getGenerateReportAverageSalary();
                reportGeneratorAverageSalary.getSavesReportToFile();
                break;
            case 3:
                TopHighlyPaidEmployees topHighlyPaidEmployees = new TopHighlyPaidEmployees(employees);
                topHighlyPaidEmployees.getSavesReportToFile();
                break;
            case 4:
                TopLoyalEmployees topLoyalEmployees = new TopLoyalEmployees(employees);
                topLoyalEmployees.getCreateReportLoyalEmployees();
                break;
            case 5:
                printsInteractiveMenuAdmin();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid value entered\n");
                printsInteractiveMenuReport();
                break;
        }
        printsInteractiveMenuReport();
    }
    catch (NumberFormatException e){
        System.out.println("\nInvalid value entered\n");
        printsInteractiveMenuReport();
    }
    }
    public void getPrintsInteractiveMenuReport() throws IOException {
        printsInteractiveMenuReport();
    }
}

