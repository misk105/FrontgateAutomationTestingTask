package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtils {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static String filePath;

    public static void openFile(String path, String sheetName) throws Exception {
        filePath = path;
        workbook = new XSSFWorkbook(new FileInputStream(path));
        sheet    = workbook.getSheet(sheetName);
    }

    public static int getRowCount() {
    	return sheet.getPhysicalNumberOfRows() - 1; 
    }

    public static String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) return "";
        
        Cell cell = row.getCell(colNum);
        if (cell == null || cell.getCellType() == CellType.BLANK) {
            return "";
        }

        if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((long) cell.getNumericCellValue());
        }

        return cell.getStringCellValue().trim();
    }
    
    public static void write(String value, int row, int col) throws Exception {
        XSSFRow r = sheet.getRow(row);
        XSSFCell c = r.getCell(col);
        if (c == null) c = r.createCell(col);
        c.setCellValue(value);
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);
        out.close();
    }
}