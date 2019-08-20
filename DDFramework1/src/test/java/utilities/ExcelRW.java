package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
	public String path;
	public FileInputStream file = null;
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	public FileOutputStream fos = null;

	// constructor for path setting
	public ExcelRW(String path) throws IOException {

		this.path = path;
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
	}

	// Reusable method for reading data from Excel
	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum);
		if(row==null) return "";
		cell = row.getCell(colNum);
		if(cell==null) return "";
		Object dataOb = new Object(); 
		if(cell.getCellType().toString()=="STRING"){
			dataOb = cell.getStringCellValue();
		}else {
			dataOb = cell.getRawValue();
		}
		return dataOb.toString();
	}
	
	public int getRowCount(String sheetName) throws IOException {		
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		return sheet.getLastRowNum()+1;		
	}
	
	public int getColsCount(String sheetName) throws IOException {		
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		return sheet.getRow(0).getLastCellNum();
	}

	// Reusable method for writing data to the Excel
	public void setCellData(String sheetName, String data, int rowNum, int colNum) throws IOException {

		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum);

		if (row == null) {
			row = sheet.createRow(rowNum);
		}

		cell = row.getCell(colNum);
		if (cell == null) {
			cell = row.createCell(colNum);
		}

		cell.setCellValue(data);
		fos = new FileOutputStream(path);
		workbook.write(fos);
		fos.close();
	}

	// Usage example
/*	
	  public static void main(String[] args) throws IOException{ 
		  ExcelRW xl = new ExcelRW("s:/1.xlsx");
		  System.out.println(xl.getCellData("Sheet1", 0, 0));
		  System.out.println(xl.getCellData("Sheet1", 1, 1));
		  System.out.println(xl.getRowCount("Sheet1"));
		  System.out.println(xl.getColsCount("Sheet1"));
		  //xl.setCellData("Sheet2", "value", 11, 11); 
		  }
*/
}
