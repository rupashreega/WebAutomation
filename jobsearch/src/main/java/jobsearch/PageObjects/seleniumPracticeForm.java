package jobsearch.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class seleniumPracticeForm extends Exception {
	
	WebDriver driver;
	
	public seleniumPracticeForm(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

//	WebElement firstname = driver.findElement(By.name("firstname"));
//			//input[@name="firstname"]
	
	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@value='Female']")
	WebElement genderFemale;
	
	@FindBy(xpath = "//input[@value='Male']")
	WebElement genderMale;

	@FindBy(xpath = "//div/input[@name =\"exp\"]")
	List<WebElement> yrsOfExp;
	
	@FindBy(id="datepicker")
	WebElement datepicker;
	
	@FindBy(xpath="//div/input[@name=\"profession\"]")
	List<WebElement> professions;
	
	@FindBy(xpath="//div/input[@name=\"tool\"]")
	List<WebElement> automationTools;
	 
	@FindBy(xpath="//*[@name=\"tool\"]")
	List<WebElement> automationtools;
	
	public void fillForm(String first_name,String last_name,String gender, 
			Integer yrsofexp, String date, String profession, String tool)
	{
		firstName.sendKeys(first_name);	
		lastName.sendKeys(last_name);
		
		try
		{
			
			if(gender == "Male")
				genderMale.click();
			else if(gender == "Female")
				genderFemale.click();
			else
				throw new Exception("Gender value invalid");
		}
		catch(Exception e)
		{
			System.out.println("Gender value is not appropriate");
		}
		
		yrsOfExp.get(yrsofexp-1).click();
		datepicker.sendKeys(date);
		
		try
		{
			System.out.println(professions.size());
			for(WebElement e : professions)
			{
				System.out.println(e.getText());
			}
			if(profession.equalsIgnoreCase("Manual Tester"))
			{
				System.out.println("I came here");
				professions.get(1).click();
			}
				
			else if(profession.equalsIgnoreCase("Automation Tester"))
				professions.get(2).click();
			else
				throw new Exception("Profession value invalid");
		}
		catch(Exception e)
		{
			System.out.println("Profession value is not appropriate");
		}
		
		try {
			if(tool.equalsIgnoreCase("UFT"))
			{
				System.out.println("I came here");
				automationtools.get(0).click();
			}
			else if(tool.equalsIgnoreCase("Protractor"))
				automationtools.get(1).click();
			else if(tool.equalsIgnoreCase("Selenium Webdriver"))
				automationtools.get(2).click();
			else
				throw new Exception("Tool value unavailable");
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
