package org.academyTop.Report;

import org.academyTop.DataBase.DataBase;

import java.io.IOException;
import java.util.ArrayList;

public class Roles {
    private ArrayList<ArrayList<String>> data;

    public Roles() throws IOException {
        DataBase database = new DataBase();
        this.data = database.getPutDataBaseExelInArrayList();
    }

    private void assignsRole() {
        for (ArrayList<String> row : data) {
            String position = row.get(1);

            if (position.contains("Начальник")) {
                row.set(1, "Начальник");
            } else {
                row.set(1, "Сотрудник");
            }
        }
    }
    public void getAssignsRole(){
        assignsRole();
    }

    public ArrayList<ArrayList<String>> getData() {
        return data;
    }
}
