package org.academyTop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class DataTable extends JFrame {
    private JTable table;
    private ArrayList<ArrayList<String>> data;
    private DataBase dataBase;

    public DataTable() throws IOException {
        super("Data from excel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        dataBase = new DataBase();
        data = dataBase.getPutDataBaseExelInArrayList();

        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(new JScrollPane(table), BorderLayout.CENTER);

        ArrayList<String> columnHeaders = data.get(0);
        model.setColumnIdentifiers(columnHeaders.toArray());

        for (int i = 1; i < data.size(); i++) {
            ArrayList<String> row = data.get(i);
            model.addRow(row.toArray());
        }
    }

    public ArrayList<ArrayList<String>> getData() {
        return data;
    }

    public JTable getTable() {
        return table;
    }

    public DataBase getDataBase() {
        return dataBase;
    }
}