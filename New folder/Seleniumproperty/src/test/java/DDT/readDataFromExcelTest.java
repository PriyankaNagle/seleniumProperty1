package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readDataFromExcelTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1 :get the excel path location and java object of the physical excelfile
		FileInputStream fis =new FileInputStream("C:\\Users\\PRIYANKA\\Downloads\\Book (1).xlsx");
		
		//stp2 : open workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		
		//stp3 : get the contron of the sheet
		Sheet sh = wb.getSheet("Sheet1");
		//stp4 : get the control of the first row.
		Row rw = sh.getRow(1);
		//stp5: get the control of 2nd cell and read tghe string data.
		Cell cel = rw.getCell(2);
		String data = cel.getStringCellValue();
		System.out.println(data);
		
		//stp6 : close the workbook.
		wb.close();
		
	}

}
