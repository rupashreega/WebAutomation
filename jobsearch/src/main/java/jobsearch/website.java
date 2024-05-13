package jobsearch;

import org.openqa.selenium.chrome.ChromeDriver;
import jobsearch.PageObjects.*;
import org.openqa.selenium.manager.SeleniumManager;

public class website {
	
	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		seleniumPracticeForm candidate1 = new seleniumPracticeForm(driver);
		candidate1.fillForm("Rupashree","Shankar","Female",4,"2024-05-12", "Manual Tester", "UFT");
//		driver.close();
	
    }
}
