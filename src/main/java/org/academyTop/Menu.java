package org.academyTop;

import java.io.IOException;

public class Menu {
    SelectMenu selectMenu = new SelectMenu();
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
            System.out.println("1.search by employees\n2.Create a report\n3.News blog\n4.Hire a new employee");
            selectMenu.getSelectMenuItemsAdmin();

        }
        public void getPrintMenuAdmin() throws IOException {
            printMenuAdmin();
        }
        private void printMenuEmployee(){
            System.out.println("""

                Select Action
                _____________""");
            System.out.println("1.search by employees\n2.Create a report\n3.News blog\n");
        }
        public void getPrintMenuEmployee(){
            printMenuEmployee();
        }
}
