package test.base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelread {

	public static String ExcelData(int r, int c) throws IOException, EncryptedDocumentException, InvalidFormatException {
		FileInputStream in=new FileInputStream("Excel/InputData.xlsx");
		Workbook wb=WorkbookFactory.create(in);
		String s=wb.getSheet("sheet1").getRow(r).getCell(c).getStringCellValue();
		return s;
		
		

	}

}
