package parameterization;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import excelRW.ExcelRW;

public class TestNGParameterizationExcel {
	
	@Test(dataProvider="getData")
	public void doLogin (String username, String password, String is_correct) {

			System.out.println("NAME: "+username+"; PASSWORD: "+password+"; CORRECT? "+is_correct);
		}

	
	@DataProvider
	public String[][] getData() throws IOException {		
		//open file for reading
		ExcelRW reader = new ExcelRW("s:/1.xlsx");		
		//I need Array without 1st row where I have column names:
		int rows = reader.getRowCount("Sheet1")-1;
		int cols = reader.getColsCount("Sheet1");
		//create Array with dimensions  rows*cols
		String[][] data = new String[rows][cols];
		//fill data from excel file
		//But count from 1 to rows and from 0 to cols-1
		for(int i=1;i<=rows;i++) {
			for(int j=0;j<cols;j++) {
				data[i-1][j] = reader.getCellData("Sheet1", i, j);
			}
		}	
		return data;		
	}
	
}