package sliders;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Slides {

	public static void main(String[] args) throws Exception  {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Slider.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File source=ts.getScreenshotAs(OutputType.FILE);
//		File targetFile = new File("C:\\Users\\logesh.g\\eclipse-workspace\\practicesession\\screenshot\\fullpage.png");
//		source.renameTo(targetFile);
		
		WebElement t=driver.findElement(By.xpath("(//div[@class='row'])[2]/parent::div"));
		File sourcefile=t.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("C:\\Users\\logesh.g\\eclipse-workspace\\practicesession\\screenshot\\section.png");
		sourcefile.renameTo(targetFile);
		driver.quit();

	}

}
