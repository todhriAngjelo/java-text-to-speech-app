package parser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class XlsDocumentReader implements DocumentReader {

    public String parse(String filepath) {
        File file = new File(filepath);

        // Create a FileInputStream object
        // for getting the information of the file
        FileInputStream fip = null;
        try {
            fip = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "PARSING_FAILURE";
        } catch (Exception e) {
            e.printStackTrace();
            return "PARSING_FAILURE";
        }

        XSSFWorkbook workbook = null;
        // Getting the workbook instance for XLSX file
        try {
            workbook = new XSSFWorkbook(fip);
        } catch (IOException e) {
            e.printStackTrace();
            return "PARSING_FAILURE";
        } catch (Exception e) {
            e.printStackTrace();
            return "PARSING_FAILURE";
        }

        // our application will process only the first sheet of the document
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();

        String content = "";
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                // we cant read numeric values as strings
                if (!cell.getCellTypeEnum().equals(CellType.STRING))
                    cell.setCellType(CellType.STRING);

                content = content.concat(cell.getStringCellValue() + "\t");
            }
            content = content.concat("\n");
        }

        return content;
    }

    public boolean saveFile(String filepath, String content) {
        File file = new File(filepath);

        // Create a FileInputStream object
        // for getting the information of the file
        FileInputStream fip = null;
        try {
            fip = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        XSSFWorkbook workbook = new XSSFWorkbook();

        // our application will process only the first sheet of the document
        Sheet firstSheet = workbook.createSheet("FirstSheet"); // fixme i alter the original here, also alters formats of document

        String[] rows = content.split("\n");
        int rowNum = 0;
        for (String row : rows) {
            int cellNum = 0;
            String[] cells = row.split("\t");
            firstSheet.createRow(rowNum);
            for (String cell : cells) {
                firstSheet.getRow(rowNum).createCell(cellNum, CellType.STRING).setCellValue(cell);
                cellNum++;
            }
            rowNum++;
        }

        try {
            FileOutputStream out = new FileOutputStream(filepath);
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}