package org.academyTop.DataBase;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DataTable extends JFrame {
    private JTable table;
    private ArrayList<ArrayList<String>> data;

    private DataBase dataBase;

    private final JButton saveButton;

    public DataTable() throws IOException {
        super("DataBase");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        System.out.println("\n\nDatabase started\n\n");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        setSize(width, height);

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

        saveButton = new JButton("Saves");
        saveButton.addActionListener(e -> saveData());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);

        container.add(buttonPanel, BorderLayout.NORTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }

    private void saveData() {
        try {
            HSSFWorkbook workbook = dataBase.getPatchFileExelDataBase();
            String fileName = "DataBase.xls";

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            ArrayList<ArrayList<String>> tableData = new ArrayList<>();

            ArrayList<String> headerRow = new ArrayList<>();
            for (int j = 0; j < model.getColumnCount(); j++) {
                headerRow.add(model.getColumnName(j));
            }
            tableData.add(headerRow);

            for (int i = 0; i < model.getRowCount(); i++) {
                ArrayList<String> row = new ArrayList<>();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    row.add(model.getValueAt(i, j).toString());
                }
                tableData.add(row);
            }

            for (int i = 0; i < tableData.size(); i++) {
                ArrayList<String> rowData = tableData.get(i);
                for (int j = 0; j < rowData.size(); j++) {
                    Cell cell = workbook.getSheetAt(0).getRow(i).getCell(j);
                    cell.setCellValue(rowData.get(j));
                }
            }

            FileOutputStream out = new FileOutputStream(fileName);
            workbook.write(out);
            out.close();

            dataBase.getPatchFileExelDataBase().close();
            JOptionPane.showMessageDialog(this, "Changes saved");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public ArrayList<ArrayList<String>> getData() {
        return data;
    }
}