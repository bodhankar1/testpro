package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
 

public class Utility 
{
	public static String getDataFromExcel(String sheet,int row,int col) throws EncryptedDocumentException, IOException
	{
		String data="";
		
		String path="C:\\Users\\Lenovo\\Desktop\\AUTOMATION.xlsx";
		FileInputStream file=new FileInputStream(path);
     
          Cell cell= WorkbookFactory.create(file).getSheet(sheet ).getRow(row).getCell(col);
              
      
          try
          {
        	  data= cell.getStringCellValue();
          }
          
          catch(IllegalStateException e) 
          {
        	  double value=cell.getNumericCellValue();
              data = Double.toString(value);
        	   
          }
		return data;
		
	}
	
	public static void Screenshot(WebDriver driver,int testID) throws IOException 
	{

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		   LocalDateTime now = LocalDateTime.now();
		 File src=   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File pop=new File("C:\\Users\\Lenovo\\Desktop\\Screenshot\\Test-" + testID+ dtf.format(now) +".jpg");
					FileHandler.copy(src, pop)	;
		
	}

}
