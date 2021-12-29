package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataExcel {

	public static void main(String[] args) throws IOException {


		FileOutputStream file = new FileOutputStream("D://TestData1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Data");
		
		for(int i=0; i<=4;i++)
		{
			XSSFRow createrow = sheet.createRow(i);
			for(int j=0; j<=6;j++)
			{
				createrow.createCell(j).setCellValue("xyz");
			}
		}
		wb.write(file);
		file.close();
		System.out.println("writing completed");

	}

}
