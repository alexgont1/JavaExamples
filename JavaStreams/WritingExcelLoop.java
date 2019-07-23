import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcelLoop {

	public static void main(String[] args) throws IOException {
	
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet0 = workbook.createSheet("firstSheet");
		
		/*Row row0 = sheet0.createRow(0);
		Cell cellA = row0.createCell(0);
		Cell cellB = row0.createCell(1);
		
		cellA.setCellValue("1st cell");
		cellB.setCellValue("2nd cell");*/
		
		for(int rows=0; rows<10; rows++) {
			
			Row row = sheet0.createRow(rows);
			for(int cols=0; cols<10; cols++) {
				
				Cell cell = row.createCell(cols);
				cell.setCellValue((int)(Math.random()*100));
				
			}
		}
		
		//connect stream
		File f = new File("S:\\eclipse\\workspace\\Files\\myExcel.xlsx");
		FileOutputStream fo = new FileOutputStream(f);
		
		workbook.write(fo);
		
		//close stream
		fo.close();
		workbook.close();
		
		System.out.println("Excel file created");

	}

}
