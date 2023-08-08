package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {
	public static void main(String[] args) throws Throwable, IOException {
		//step1: load the file in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step: create workbook for the file loaded
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3: navigate to the requited sheet
		Sheet sh = wb.getSheet("Organizations");
		
		//step4: navigate to the required row
		Row rw = sh.getRow(0);
		
		//step5: navigate to the required cell
		Cell ce = rw.getCell(0);
		
		//step6: capture the value inside cell
		String value = ce.getStringCellValue();
		System.out.println(value);
	}

}
