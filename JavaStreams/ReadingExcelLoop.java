import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//Due to different formats in Excel files we need to switch
//	for (Row row:sheet0)
//	{
//	for(Cell cell:row)
//	{
//	switch(cell.getCellType())
//	{
//	case Cell.CELL_TYPE_STRING:
//	System.out.print(cell.getStringCellValue()+"\t");
//	break;
//  case Cell.CELL_TYPE_BLANK:
//	System.out.print("It's a blank value");
//	break;
//	case Cell.CELL_TYPE_NUMERIC:
//	System.out.print(cell.getNumericCellValue()+"\t");
//	break;
//	}//end switch
//	}//end inner 'for'
//	}//end outer 'for'

public class ReadingExcelLoop {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		File f = new File("S:\\eclipse\\workspace\\Files\\myExcel.xlsx");
		FileInputStream fi = new FileInputStream(f);
		
		Workbook workbook = WorkbookFactory.create(fi);
		
		org.apache.poi.ss.usermodel.Sheet sheet0 = workbook.getSheetAt(0);
		
		/*Row row0 = sheet0.getRow(0);
		Cell cellA = row0.getCell(0);
		
		System.out.println(cellA);*/
		
		for(Row row : sheet0) {
			
			for(Cell cell: row) {
				
				switch(cell.getCellType()) 
				{
				case STRING:
					System.out.print(cell.getStringCellValue()+"\t");
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue()+"\t");
					break;
				case BLANK:
					System.out.print("Blank cell"+"\t");
					break;
				default:
					break;
				}
				
			}
			System.out.println();
			
		}
		
		
		fi.close();

	}

}
