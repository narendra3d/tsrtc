package darling;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tsrtc 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","E:\\automation\\chromedriver.exe");
		ChromeDriver nk=new ChromeDriver();
		nk.get("https://online.tsrtcpass.in");
		nk.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		WebDriverWait w=new WebDriverWait(nk,15);
		nk.manage().window().maximize();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='hyderabadAdd']/i")));
		nk.findElement(By.xpath("//*[@id='hyderabadAdd']/i")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='btn applyBtns'])[5]")));
		nk.findElement(By.xpath("(//*[@class='btn applyBtns'])[5]")).click();
		ArrayList<String> x=new ArrayList<String>(nk.getWindowHandles());
		nk.switchTo().window((String) x.get(1));
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("userProperties(empname)")));
		nk.findElement(By.name("userProperties(empname)")).sendKeys("Narendra kumar");
		nk.findElement(By.name("userProperties(empfgname)")).sendKeys("Yanadi rao");
		nk.findElement(By.name("userProperties(dob)")).sendKeys("03/08/1994");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='radio'])[2]")));
		nk.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		nk.findElement(By.name("userProperties(aadharno)")).sendKeys("587587227248");
		nk.findElement(By.name("userProperties(studentmobileno)")).sendKeys("7097002540");
		nk.findElement(By.name("userProperties(email)")).sendKeys("nari501401@gmail.com");
		nk.findElement(By.name("userProperties(studentphoto)")).click();
		//java robot
		Thread.sleep(5000);
		StringSelection n=new StringSelection("C:\\Users\\user1\\Downloads\\img089");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(n,null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//selenium
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("userProperties(address)")));
		nk.findElement(By.name("userProperties(address)")).sendKeys("PLOT NO 105 BALAJI NAGAR ROAD NO 8\nMEDCHAL MEDCHAL DIST \n501401");
		Thread.sleep(3000);
	/*	try
		{
			nk.switchTo().alert().dismiss();
		}
		catch(Exception ex)
		{
					
		}*/
		//dropdown
		WebElement e=nk.findElement(By.name("userProperties(addrdistid)"));
		Select s=new Select(e);
		Actions a=new Actions(nk);
		a.keyDown(Keys.CONTROL).click(s.getOptions().get(9)).keyUp(Keys.CONTROL).build().perform();
		}
	}
