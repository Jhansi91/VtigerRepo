package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author jhans
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from excel sheet based on sheet name, row no and cell no given by the caller
	 * @param sheetName
	 * @param row
	 * @param celno
	 * @return value
	 * @throws Throwable
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName,int row,int celno) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream(IConstants.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(row).getCell(celno).getStringCellValue();
		wb.close();
		return value;
	}
	
	/**
	 * This method will write data into the excel sheet
	 * @param sheetName
	 * @param rowno
	 * @param cellno
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName,int rowno,int cellno,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstants.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.createSheet(sheetName);
		Row rw = sh.createRow(rowno);
		Cell cl = rw.createCell(cellno);
		cl.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(IConstants.excelFilePath);
		wb.write(fos);
		wb.close();
	}

}
