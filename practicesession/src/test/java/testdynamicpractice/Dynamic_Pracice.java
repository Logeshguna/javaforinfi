package testdynamicpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Pracice {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().window().maximize();
		int i=1;
		List<WebElement>t=driver.findElements(By.xpath("//ul[@id='pagination']/li/a"));
		
		List<WebElement>tr=driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr/td[1]"));
		while(i<=t.size()) {
			WebElement p=driver.findElement(By.xpath("//ul[@id='pagination']/li["+i+"]/a[1]"));
			p.click();
//			System.out.println(p);
			i++;
			for(int trd=1;trd<tr.size();trd++) {
				WebElement str=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+trd+"]/td[1]"));
				String td1 = str.getText();
				System.out.println(td1);
				
				WebElement str2=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+trd+"]/td[2]"));
				String td2 = str2.getText();
				System.out.println(td2);
				
				
			}
			
			
		}
		System.out.println(t.size());
		driver.quit();
	}

}
