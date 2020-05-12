package MyCodeInterview.MyCodeInterview;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InterviewExercise {

	
  @Test
  public void CodeExercise() throws InterruptedException {
	  
	  
	  	System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		WebDriverManager.chromedriver().setup();
	  
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
//		Open google.com (done)
		driver.get("https://www.google.com/");

		//Check the title equals "Google" (done)
		String sExpGooglTitle = driver.getTitle();
		String sActGooglTitle = "Google";
		Assert.assertEquals(sExpGooglTitle,sActGooglTitle);
		
		//Check the google logo
		boolean bImage = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		Assert.assertTrue(bImage);
		
		//Check there are two options present: "Google Search" and "I'm Feeling Lucky"
		boolean bGoogleSearch =  driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).isDisplayed();
		Assert.assertTrue(bGoogleSearch);
		boolean bFeelingLucky =  driver.findElement(By.xpath("(//input[@name='btnI'])[2]")).isDisplayed();
		Assert.assertTrue(bFeelingLucky);
		
		//Enter text "PayPal" and click "I'm Feeling Lucky"
		WebElement wGoogleEnterTxt = driver.findElement(By.xpath("//*[@type='text']"));
		wGoogleEnterTxt.sendKeys("PayPal");
		WebElement wFeelingLuck = driver.findElement(By.xpath("(//input[@name='btnI'])[2]"));
		wFeelingLuck.click();
		
//		Check the url is now "https://www.paypal.com/"
		String sExpPayPalURL = "https://www.paypal.com/us/home";
		String sActPayPalURL = driver.getCurrentUrl();
		Assert.assertEquals(sActPayPalURL,sExpPayPalURL);

// 		click on Sitemap		
		WebElement wSiteMapLink = driver.findElement(By.ByPartialLinkText.linkText("Sitemap"));
		wSiteMapLink.click();

		//Check the url is now "https://www.paypal.com/us/webapps/mpp/full-sitemap"
		String sExpSiteMapURL = "https://www.paypal.com/us/webapps/mpp/full-sitemap";
		String sActSiteMapURL = driver.getCurrentUrl();
		Assert.assertEquals(sActSiteMapURL,sExpSiteMapURL);
		
		//Store all of the links on this page into a list and then print them all to system.out
		List <WebElement> lLinks = driver.findElements(By.xpath("//ul/li/a"));
				
		for (int i = 0; i < lLinks.size(); i++) {
			System.out.println(lLinks.get(i).getAttribute("href"));

		}

	
		driver.close();
	}
  
		
  }

