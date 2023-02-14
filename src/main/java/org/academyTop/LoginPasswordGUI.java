package org.academyTop;

import org.academyTop.Menu.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;


public class LoginPasswordGUI extends JFrame {
    MainMenu mainMenu = new MainMenu();


    private final JTextField loginField = new JTextField(20);
    private final JPasswordField passwordField = new JPasswordField(20);
    private final JButton loginButton = new JButton("Войти");
    private final HashMap<String, Integer> hashLoginPassword = new HashMap<>();

    public LoginPasswordGUI() throws IOException {
        setTitle("Авторизация");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 10);
        loginPanel.add(new JLabel("Логин:"), c);

        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(10, 0, 0, 10);
        loginPanel.add(loginField, c);

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        loginPanel.add(new JLabel("Пароль:"), c);

        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(10, 0, 10, 10);
        loginPanel.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 10, 10);
        loginPanel.add(loginButton, c);

        add(loginPanel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String login = loginField.getText();
                    int password = Integer.parseInt(new String(passwordField.getPassword()));

                    DataBase dataBase = new DataBase();
                    int startRow = 1;
                    int endRow = 10;
                    for (int i = startRow; i < endRow; i++) {
                        String loginExcel = String.valueOf(dataBase.getPatchFileExel().getSheetAt(1).getRow(i).getCell(3));
                        int passwordExcel = (int) dataBase.getPatchFileExel().getSheetAt(1).getRow(i).getCell(4).getNumericCellValue();

                        hashLoginPassword.put(loginExcel, passwordExcel);
                    }
                    dataBase.getPatchFileExel().close();

                    Integer keyHash = hashLoginPassword.get(login);
                    if (keyHash == null) {
                        JOptionPane.showMessageDialog(LoginPasswordGUI.this, "Логин не найден, попробуйте еще раз.", "Ошибка входа", JOptionPane.ERROR_MESSAGE);
                    } else if (password == keyHash) {
                        JOptionPane.showMessageDialog(LoginPasswordGUI.this, "Вы успешно вошли в систему.", "Успешный вход", JOptionPane.INFORMATION_MESSAGE);
                        if (login.equals("Mimirov") || login.equals("Mironov") || login.equals("Yaric")) {
                            mainMenu.getPrintMenuAdmin();

                        } else {
                            mainMenu.getPrintMenuEmployee();

                        }
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(LoginPasswordGUI.this, "Пароль неверен, попробуйте еще раз.", "Ошибка входа", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(LoginPasswordGUI.this, "Ошибка чтения данных.", "Ошибка входа", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
    }
}


