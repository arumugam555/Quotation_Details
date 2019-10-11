package eliteportal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Quotation_Response {

	
	WebDriver driver;
	  @BeforeTest
	  public void beforeTest() {
		  
		  //ChromeOptions chromeOptions= new ChromeOptions();
		  //chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		  System.setProperty("webdriver.chrome.driver", "E:\\Maven\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://www.kobster.website/elite-auth");
		  driver.manage().window().maximize();
		  
	  }
	  
	  @Test(priority = 0)
	  public void loginpage() throws InterruptedException, AWTException {
		
		  WebElement uname=driver.findElement(By.xpath("//*[@id=\"login_email\"]"));
		  uname.sendKeys("vijayashanthi38@gmail.com");
		  
		  WebElement Password=driver.findElement(By.xpath("//*[@id=\"login_passwd\"]"));
		  Password.sendKeys("kobster123");
		  
		  WebElement log_button=driver.findElement(By.xpath("//*[@id=\"SubmitDashLogin\"]"));
		  log_button.click();
		  
		  Thread.sleep(2000);
		  
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/header/div[2]/ul/li[5]/div/a")).click();
		  
		  WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/table/thead/tr/th[7]/input"));
		  searchbox.sendKeys("Glass Board Marker");
		  
		  //new Actions(driver).moveToElement(searchbox).click().perform();
		  
		  Thread.sleep(2000);
		  
		  searchbox.sendKeys(Keys.ENTER);
		  
		  Thread.sleep(2000);
		     JavascriptExecutor jse = (JavascriptExecutor)driver;
		     for (int second = 0;; second++) {
		     if(second >=20){
		         break;
		     }
		 jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 Thread.sleep(2000);
		 }

		   Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_PAGE_UP);
		  robot.keyRelease(KeyEvent.VK_PAGE_UP);
		 Thread.sleep(2000);      
		  
		  //WebElement productname=driver.findElement(By.xpath("//*[@id=\"237_id\"]/td[3]"));
		  
		  List<WebElement> name = driver.findElements(By.className("name"));

		  for (WebElement result:name) {
		       
			  System.out.println(result.getText());
			     Assert.assertTrue(result.getText().indexOf("Glass Board Marker")!=-1? true: false);

		  }
		  
	  }
	 // @Test(priority = 1)
	  public void Search_result_failure() throws InterruptedException, AWTException {
          
		  Thread.sleep(2000);
		   
		  Robot robot1 = new Robot();
		  robot1.keyPress(KeyEvent.VK_PAGE_UP);
		  robot1.keyRelease(KeyEvent.VK_PAGE_UP);
		  
		  Thread.sleep(2000);
		  
		  WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/table/thead/tr/th[7]/input"));
		  
		  searchbox.clear();
		  
		  searchbox.sendKeys("wertyui");
		  
		  searchbox.sendKeys(Keys.ENTER);
		  
		  String noresult="No Quotations Found!";
		  Thread.sleep(3000);
		  WebElement result_no=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/table/tbody/tr/td/div"));
		  Thread.sleep(2000);
		  String nores_text=result_no.getText();
		  System.out.println(nores_text);
		  
		  if(nores_text.contains(noresult)) {
			  
			  System.out.println("Success");
		  }else {
			  System.out.println("Not Success");
		  }
		
	  }
	  @Test(priority = 1)
	  public void search_res_date() throws InterruptedException, AWTException, ParseException {
		  
		  
		  Thread.sleep(2000);
		  
		  WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/table/thead/tr/th[7]/input"));
		  
		  searchbox.clear();
		  
		  driver.navigate().refresh();
		  
		  Thread.sleep(2000);
		   
		  Robot robot1 = new Robot();
		  robot1.keyPress(KeyEvent.VK_PAGE_UP);
		  robot1.keyRelease(KeyEvent.VK_PAGE_UP);
		  
		  Thread.sleep(2000);
		  
          DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		  
		  //get current date time with Date()
		  Date date = new Date();
		  
		  // Now format the date
		  String cdate1= dateFormat.format(date);
		  
		  Date cdate2=dateFormat.parse(cdate1);
		  
		  // Print the Date
		  System.out.println(cdate2);
		  
		  Thread.sleep(2000);
		   
		  Robot robot2 = new Robot();
		  robot2.keyPress(KeyEvent.VK_PAGE_UP);
		  robot2.keyRelease(KeyEvent.VK_PAGE_UP);
		  
		  Thread.sleep(2000);
		  
		  
		  Thread.sleep(2000);
		     JavascriptExecutor jse = (JavascriptExecutor)driver;
		     for (int second = 0;; second++) {
		     if(second >=20){
		         break;
		     }
		 jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 Thread.sleep(2000);
		 }

		   Robot robot = new Robot();
		   robot.keyPress(KeyEvent.VK_PAGE_UP);
		  robot.keyRelease(KeyEvent.VK_PAGE_UP);
		  Thread.sleep(2000);      
		  
		   String beforexpath="/html/body/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div/table/tbody/tr[";
		   String afterxpath ="]/td[1]";
		   Thread.sleep(2000);
		 
		  List<WebElement> deadline_date = driver.findElements(By.className("deadline"));
		  int i=0;
		  
		  for (WebElement result:deadline_date) {
			  
			  String date_dead=result.getText();
			  
			  i=i+1;			  
			  SimpleDateFormat dateFormat1 = new SimpleDateFormat("d, MMM yyyy"); 
			  Date varDate1=dateFormat1.parse(date_dead); 
			  dateFormat1=new SimpleDateFormat("dd-MM-yyyy"); 
			  String Final_admitDT=dateFormat1.format(varDate1);
			  
			  Date varDate2=dateFormat1.parse(Final_admitDT); 
			  
			  System.out.println(varDate2);
		  
		        if (varDate2.before(cdate2)) { 
		        		 
		        	WebElement ref_num=driver.findElement(By.xpath(beforexpath+i+afterxpath));
		        	System.out.println("Ref Num of No and Recevied Quotations="+ref_num.getText()); 
		        		 
		        }
		        
		        if (varDate2.after(cdate2)) { 					  
			            
		        	      WebElement ref_num1=driver.findElement(By.xpath(beforexpath+i+afterxpath));
						  System.out.println("Ref Num of Awating Quotation="+ref_num1.getText());
			      } 
		        
		        if (varDate2.equals(cdate2)) { 					  
		            
	        	      WebElement ref_num2=driver.findElement(By.xpath(beforexpath+i+afterxpath));
					  System.out.println("Ref Num of Awating Quotation="+ref_num2.getText());
		      } 			  
		  }		  		  
	  }
	
}
