package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("D://TestData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		int cellcount = sheet.getRow(0).getLastCellNum();
		
		for(int row=0; row<rowcount; row++) {
			
			XSSFRow currentrow = sheet.getRow(row);
			
			for(int col=0; col<cellcount; col++)
			{
				String data = currentrow.getCell(col).toString();
				
				System.out.print("   "+data);
			}
			System.out.println();
		}
		
		

	}

}
