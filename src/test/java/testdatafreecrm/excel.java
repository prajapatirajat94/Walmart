package testdatafreecrm;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel {
	public static Workbook book;
	public static Sheet sheet ;
	public static Object[][] readdata(String sname){
		FileInputStream file = null;
		
		try {
		file = new FileInputStream("C:\\Users\\praja\\eclipse-workspace\\FreeCRM\\src\\test\\java\\testdatafreecrm\\Details.xlsx");
		}
		catch(IOException g) {
			g.printStackTrace();
		}
		try{book = WorkbookFactory.create(file);
		}
		catch(IOException h) {
			h.printStackTrace();		
		}
		sheet =book.getSheet(sname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i =0;i<sheet.getLastRowNum();i++) {
			for(int j =0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}			
		}
		return data;
		
	}

}
