package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1: load the file in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				
		//step2: create workbook for the file loaded
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3: create sheet
		Sheet sh = wb.createSheet("Trail");
		
		//step4: create row
		Row rw = sh.createRow(4);
		
		//step5: create cell
		Cell ce = rw.createCell(3);
		
		//step6: set the value into cell
		ce.setCellValue("Anvitha");
		
		//step7: open the file in java write format
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step8:call the write method
		wb.write(fos);
		System.out.println("data added");
		
		//step9: close the workbook
		wb.close();
		System.out.println("workbook closed");
				
				
	}

}
