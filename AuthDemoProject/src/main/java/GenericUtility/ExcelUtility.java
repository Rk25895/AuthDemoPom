package GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
		public String getDataFromExcel(String sheetname , int rownum , int celnum) throws Throwable {
			FileInputStream fis = new FileInputStream(".xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetname);
			Row row = sh.getRow(rownum);
			String data = row.getCell(celnum).getStringCellValue();
			wb.close();
		    return data;
			
		}
		public int getRowCount(String sheetname) throws Throwable {
			FileInputStream fis = new FileInputStream(".xlsx");
			Workbook wb  = WorkbookFactory.create(fis);
			 Sheet sh = wb.getSheet(sheetname);
			 wb.close();
			 return sh.getLastRowNum();
			}

		public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
			FileInputStream fis  = new FileInputStream(".xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cel = row.createCell(celNum);
			cel.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(".xlsx");
			wb.write(fos);
			wb.close();
			
		}
}
