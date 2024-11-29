package datadriventest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadrivetest {

    public static void main(String[] args) {
        // Construct the path to the Excel file
        String filePath = System.getProperty("user.dir") + "\\sitemap-1.xlsx";
        
        try (FileInputStream file = new FileInputStream(filePath); 
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            
            // Attempt to access the sheet named "Sheet1"
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            if (sheet == null) {
                throw new NullPointerException("Sheet 'Sheet1' not found in the workbook.");
            }
            
            // Get the last row number
            int s = sheet.getLastRowNum();
            List<String> list=new ArrayList<String>();
            System.out.println("Last row number: " + s);
            for(int rm=3;rm<=s;rm++) {
            	XSSFRow rowval=sheet.getRow(rm);
            	XSSFCell cellval=rowval.getCell(0);
            	System.out.println(cellval.toString());
            	String url= cellval.toString();
            	list.add(url);
            	
            }
            for (int i=0;i<list.size();i++) {
            	String k=list.get(i);
            	URL linkurl= new URL(k);
				URLConnection con=linkurl.openConnection();
				con.connect();
				int code=((HttpURLConnection) con).getResponseCode();
				System.out.println("The status is of url is "+linkurl +"=======>"+code);
				
            }
            
            
        } catch (FileNotFoundException e) {
            System.out.println("The specified file was not found: " + filePath);
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("A NullPointerException occurred. Possible causes:");
            System.out.println("- The file path might be incorrect or the file does not exist.");
            System.out.println("- The sheet named 'Sheet1' might not exist in the workbook.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
