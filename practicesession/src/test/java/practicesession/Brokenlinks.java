package practicesession;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Brokenlinks {

	public static void main(String[] args) throws IOException {
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\logesh.g\\Downloads\\geckodriver-v0.35.0-win-aarch64\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> atags = driver.findElements(By.tagName("a"));
		for (WebElement atag : atags) {
			String hrefvalue = atag.getAttribute("href");
		
			if(hrefvalue == null || hrefvalue.isEmpty()) {
				System.out.println("All Values empty");
				continue;
		}
			try {
				URL linkurl= new URL(hrefvalue);
				URLConnection con=linkurl.openConnection();
				con.connect();
				if(((HttpURLConnection) con).getResponseCode()>=400) {
					System.out.println("BROKEN LINKS IS"+"=======>"+con);
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();

	}

}
