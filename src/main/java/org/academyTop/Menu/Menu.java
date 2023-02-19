package org.academyTop.Menu;

import java.io.IOException;

public class Menu {
    SelectMenu selectMenu = new SelectMenu();

    public Menu() throws IOException {
    }

    private void printsNameProgram(){
            System.out.print("""

                ********************************
                ** Employee accounting system **
                ********************************

                """);
        }
        public void getPrintsNameProgram(){
            printsNameProgram();
        }

        private void printMenuAdmin() throws IOException {
            System.out.println("""

                Select Action
                _____________""");
            System.out.println("1.DataBase\n2.Create a report\n3.Exit Program");
            selectMenu.getSelectsMenuItemsAdmin();

        }
        public void getPrintMenuAdmin() throws IOException {
            printMenuAdmin();
        }

    // TODO: 19.02.2023 Меню для начальника и работника одинаковые - нужно будет исправить  
    private void printMenuEmployee() throws IOException {
        System.out.println("""

                    Select Action
                    _____________""");
        System.out.println("1.DataBase\n2.Create a report\n3.Exit Program");
        selectMenu.getSelectsMenuItemsAdmin();

    }

    public void getPrintMenuEmployee() throws IOException {
        printMenuEmployee();
    }

    private void printMenuReport() {
        System.out.println("""

                Select Action
                _____________""");
        System.out.println("1.Organization structure\n2.Average salary by organization and department\n3.The highest paid\n4.Most dedicated employees\n5.Main Menu\n6.Exit Program ");
    }
    public void getPrintMenuReport(){
        printMenuReport();
    }

}
