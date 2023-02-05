package org.academyTop;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DateBase {
    ArrayList<String> dataBaseArrayList = new ArrayList<>();


    private HSSFWorkbook patchFileExel() throws IOException {
        String separator = File.separator;
        FileInputStream fileExel = new FileInputStream("." + separator + "src" + separator + "main" + separator + "resources" + separator + "company.xls");
        return new HSSFWorkbook(fileExel);
    }

    public HSSFWorkbook getPatchFileExel() throws IOException {
        return patchFileExel();
    }


    private ArrayList<String> putDataBaseExelInArrayList() throws IOException {
        int startCell = 0;
        int endCell = 13;
        int startRow = 0;
        int endRow = 10;
        String dataBaseExel = null;

        for (int i = startCell; i < endCell; i++) {
            for (int x = startRow; x < endRow; x++) {
                dataBaseExel = ChecksCellForFormat(patchFileExel().getSheetAt(0).getRow(x).getCell(i));
                dataBaseArrayList.add(dataBaseExel);
            }
        }
        System.out.print(dataBaseArrayList);
        patchFileExel().close();
        return dataBaseArrayList;
    }



    public void getPutDataBaseExelInArrayList() throws IOException {
        putDataBaseExelInArrayList();

    }


    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    private static String ChecksCellForFormat(Cell cell) {
        String result = null;
        switch (cell.getCellType()) {
            case STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result = simpleDateFormat.format(cell.getDateCellValue());
                } else {
                    result = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                result = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                result = String.valueOf(cell.getNumericCellValue());
                break;
            default:
                System.out.println();
        }
        return result;

    }


}



