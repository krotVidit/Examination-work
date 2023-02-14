package org.academyTop;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        MainMenu menu =new MainMenu();
//        LoginPassword loginPassword = new LoginPassword();
//
//        menu.getPrintsNameProgram();
//        loginPassword.getPutLoginPasswordInHashMap();
//        loginPassword.getCheckLoginPassword();

        LoginPasswordGUI loginPasswordGUI = new LoginPasswordGUI();
        loginPasswordGUI.setVisible(true);
    }
}
