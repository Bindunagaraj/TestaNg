package SalesForce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLsheetReading {
	public String readData(String requiredDAta) throws IOException
	{
		String path = "C:\\Users\\14704\\Downloads\\SalesForceXlSheet.xlsx";
		FileInputStream fi = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(fi);
		XSSFSheet sheet = book.getSheet("Data");
		XSSFRow row = null;
		LinkedHashMap<String, String> excelDataMap = new LinkedHashMap<String, String>();
		String key = null;
		String value = null;
		String data = null;
		String str=requiredDAta.toLowerCase();
		
	

		for (int rowIndex = 0; rowIndex <=sheet.getLastRowNum(); rowIndex++) {
			row = sheet.getRow(rowIndex);
			for (int i = 0; i < row.getLastCellNum(); i++) {
			data = row.getCell(i).toString();
			if (i == 0) 
			key = data;
		    else
			value = data;
			}
            excelDataMap.put(key, value);
     }
		
		if(excelDataMap.containsKey(str))
		return excelDataMap.get(str);
		else {
			System.out.println("Enter valid dataName u want");
		return null;}
		
	}


}
