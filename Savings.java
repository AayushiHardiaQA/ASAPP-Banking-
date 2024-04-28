package Unicore;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Savings {

	public static void main(String[] args) throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-gpu");
		ChromeDriver driver = new ChromeDriver(options);
		Actions keys = new Actions(driver);
		
		String Loan_Amount = "10000";
		String Payment_Frequency = "Monthly";
		String Term = "";
		String ApplicantEmail = "tester123@mailinator.com";
		String ApplicantPassword = "Tester@123";
		String ApplicantFirstName = "RICHARD";
		String ApplicantLastName = "TESTPAL";
		String MemberProfilePasscode = "ASAPPtester@123";
		String Applicant_Address = "14 RICHARD ST LES CEDRES QC	J7T1J6";
		String BirthdayMonth = "August";
		String BirthDay = "08";
		String BirthdayYear = "1975";
		String SIN = "719 029 506";
		String Gender = "M";
		String Maritials_Status = "Married";
		String Applicant_PhoneNumber = "4502000607";
		String PhoneNumber_Type = "Home";
		String Collect_Employer_number_and_Address = "Y";
		
		
		
		String ParentTab = driver.getWindowHandle();
		
	    driver.get("https://asapp-17.test.asappbanking.com/");
	    driver.manage().window().maximize();
	    
		Thread.sleep(1500);
//		   if (driver.findElement(By.xpath("//div[@class='col-12 col-md-10 col-lg-5 bg-white p-4 border-5 primary-border']")).isDisplayed()) {
//			   
//			   driver.findElement(By.xpath("//label[@for='testAgreement']")).click();
//			   driver.findElement(By.xpath("//button[@id='continueBtn']")).click();
//			   
//		   }
//		    
//		   else {
//			   
//		   }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.findElement(By.xpath("//div[text()='Savings']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@class='accordion_box_pop accordion_box slideInUp delay-0s animated product-container z-1 ']/div[2]/div[3]/div/div[2]/div/button[1]")).click();
	    
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@class='accordion_box_pop accordion_box slideInUp delay-0s animated product-container z-1 ']//ul[@class='list-unstyled']//li[1]//label//span[text()='MEMBER CARD ']")).click();
//		driver.findElement(By.xpath("//div[@class='accordion_box_pop accordion_box slideInUp delay-0s animated product-container z-1 ']//div[@class='account-used-list-container onchange-visibillity-trigger']//label//span[text()='Investment']")).click();
		driver.findElement(By.xpath("//div[@class='accordion_box_pop accordion_box slideInUp delay-0s animated product-container z-1 ']//div[2]//div[2]/div[2]//div[3]/div[@class='row form-inline negative-margin']//button")).click();
		driver.findElement(By.xpath("//button[@class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent auto-validate-visible-fields submit-products']")).click();
		driver.findElement(By.name("action")).click();
		
		driver.findElement(By.id("Email")).sendKeys(ApplicantEmail);
		driver.findElement(By.id("PreferredBranchId")).sendKeys(Keys.ARROW_DOWN);
		keys.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.id("toggle-password")).sendKeys(ApplicantPassword);
		String ApplicationID= driver.findElement(By.xpath("//div[@class='numb_m']")).getText();
		System.out.println(ApplicationID);
		
		driver.findElement(By.id("btn-setup-submit")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ex-center-content']/label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect existing-member-no existing-member-select mdl-js-ripple-effect--ignore-events is-upgraded']//span[@class='mdl-radio__ripple-container mdl-js-ripple-effect mdl-ripple--center']")).click();
		driver.findElement(By.xpath("//*[@id='personalInformationForm']/div[1]/div/div[2]/div[4]/div/div/div/div[5]/div[3]/p/label/span[4]")).click();
		driver.findElement(By.xpath("//div[@class='right right-to-next']//button[@id='buttonIdentityToggle']")).click();
		
		Thread.sleep(500);
		driver.findElement(By.id("MemberProfile_FirstName")).sendKeys(ApplicantFirstName);
		driver.findElement(By.id("MemberProfile_LastName")).sendKeys(ApplicantLastName);
		driver.findElement(By.id("MemberProfile_Password")).sendKeys(MemberProfilePasscode);
		driver.findElement(By.id("nextBtn")).click();
		
		
		Thread.sleep(1500);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='PersonalInfo_BirthdayMonth']")).sendKeys(BirthdayMonth);
		driver.findElement(By.xpath("//input[@id='PersonalInfo_BirthdayDay']")).sendKeys(BirthDay);
		driver.findElement(By.xpath("//input[@id='PersonalInfo_BirthdayYear']")).sendKeys(BirthdayYear);
		Thread.sleep(1500);
		
		
//		Get SIN
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.navigate().to("https://www.fakenamegenerator.com/social-insurance-number.php");
		String Get_Random_sin =driver.findElement(By.xpath("//div[@class='content']//p[2]")).getText();
		System.out.println(Get_Random_sin);
		
		String[] Random_sin = Get_Random_sin.split(":");
//	    System.out.println(Random_sin.length);
	    
	    System.out.println(Random_sin[1].trim());
	    
	    driver.switchTo().window(ParentTab);
		driver.findElement(By.id("PersonalInfo_SIN")).sendKeys(Random_sin[1]);
//		driver.findElement(By.id("PersonalInfo_InternationalSIN")).sendKeys(Random_sin[1].replaceAll("\\s", ""));
		
//		Gender
		if (Gender== "M") {
			driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()= 'Male']")).click();
		}
		else {
			driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()= 'Female']")).click();
		}
		
//		Maritials Status
		
		if (Maritials_Status == "Married") {
			driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()= 'Married']")).click();
		}
		else {
			driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()= 'Single']")).click();
			
		}
		
		driver.findElement(By.id("PersonalInfo_SitizenshipCountry")).sendKeys("Canada");
		driver.findElement(By.id("PersonalInfo_ResidenceCountry")).sendKeys("Canada");
		
		driver.findElement(By.id("nextBtn")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Own']")).click();
		
		WebElement Address = driver.findElement(By.id("MailingAddress_AddressLookup"));
		
		Address.sendKeys(Applicant_Address);
		Thread.sleep(1000);
		Address.sendKeys(Keys.SPACE);
		Thread.sleep(1000);
		Address.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		Address.sendKeys(Keys.ENTER);

	    Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect different-address-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='No']")).click();
		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect two-years-address-yes mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='Yes']")).click();
		driver.findElement(By.id("nextBtn")).click();
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='ContactInformation_PhoneNumber']")).sendKeys(Applicant_PhoneNumber);
		
		if (PhoneNumber_Type == "Home") {
			driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='Home']")).click();
		}
		else {
			driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='Mobile']")).click();
		}
		
//		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect alternative-phone-number-no alternative-phone-number mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='No']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("nextBtn")).click();
		
		Thread.sleep(1500);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='mb-5 wrapper ex-no-pad animated slideInUp1 z-5 animation-fill-mode-none']//span[text()='Employed']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='mb-5 wrapper ex-no-pad animated slideInUp1 z-5 animation-fill-mode-none']//span[text()='Full Time']")).click();
		
		if(driver.findElement(By.xpath("//div[@id='employer-address-section']")).isDisplayed()) {
			driver.findElement(By.xpath("//input[@id='EmploymentInformation_EmployerAddressLookup']")).sendKeys("109 ALBERT ST NE AIRDRIE AB T4B0R5");
			Thread.sleep(1000);
			keys.sendKeys(Keys.ARROW_DOWN).build().perform();
			keys.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			driver.findElement(By.id("EmploymentInformation_EmployerPhoneNumber")).sendKeys("1236781933");
		}
		else {
			
		}
		driver.findElement(By.xpath("//input[@class='autocomplete-text mdl-textfield__input ']")).sendKeys("Information Systems Analysts and Consultants");
		Thread.sleep(2000);
		keys.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(2000);
		keys.sendKeys(Keys.ARROW_DOWN).build().perform();
		keys.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.id("EmploymentInformation_JobTitle")).sendKeys("Manager");
		driver.findElement(By.id("EmploymentInformation_EmployerName")).sendKeys("Employee One");
        
		
		
//		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect has-monthly-payment-obligations-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();
//		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect has-owe-personal-income-taxes-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();
//		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect is-payroll-deposited-into-account-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();
		driver.findElement(By.xpath("//button[@id='nextBtn']")).click();
		
		Thread.sleep(1500);
		driver.findElement(By.id("EmploymentInformation_KinFirstName")).sendKeys("JAMES");
		driver.findElement(By.id("EmploymentInformation_KinLastName")).sendKeys("Luther");
		driver.findElement(By.id("EmploymentInformation_KinPhone")).sendKeys("0128387411");
		driver.findElement(By.id("EmploymentInformation_KinAddressLookup")).sendKeys("5135 10E AVE MONTREAL QC H1Y2G5");
		Thread.sleep(3000);
		keys.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(2000);
		keys.sendKeys(Keys.ARROW_DOWN).build().perform();
		keys.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1500);
		driver.findElement(By.id("nextBtn")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='AML']")).sendKeys("Personal banking only");
//		keys.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.id("HowYouHeard")).sendKeys("Online advertising");
//		keys.sendKeys(Keys.ENTER).build().perform();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(20000);
//		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect above_all_yes mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();
//		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect us-resident-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();
//		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect otherResidentForTaxPurposes-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();
//		
		driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='I consent to allow FI Name to access my Credit Report.']")).click();
		driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='I consent to the SIN for Administrative Purposes Content']")).click();
		driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[contains(text(),'Prompt')]")).click();
		driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='I consent to the account agreement terms and conditions.']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.name("action")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("action")).click();
		
//      Statement Verification
		if (driver.findElement(By.xpath("//div[@class='col-md-9']//h2[text()='Bank Statement']")).isDisplayed()) {
			driver.findElement(By.xpath("//div[@class='col-md-9']//h2[text()='Bank Statement']")).click();
			driver.findElement(By.xpath("//div[@class='manual-verification']//input[@data-document-type='BankStatement']")).sendKeys("C:\\Users\\lucif\\Downloads\\Test.pdf");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='auto-btn']//button[text()='next']")).click();
		}
		else {
			driver.findElement(By.xpath("//div[@class='manual-verification-methods']//div[@dual-statement-number='1']")).click();
	        Thread.sleep(1200);
			driver.findElement(By.xpath("//div[@class='dual-statement dual-statement-1']//div")).click();
			driver.findElement(By.xpath("//div[@class='dual-statement dual-statement-1']//input[@data-document-type='BankStatement']")).sendKeys("C:\\Users\\lucif\\Downloads\\Test.pdf");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//div[@class='manual-verification-methods']//div[@dual-statement-number='2']")).click();
	        Thread.sleep(1200);
			driver.findElement(By.xpath("//div[@class='dual-statement dual-statement-2']//div")).click();
			driver.findElement(By.xpath("//div[@class='dual-statement dual-statement-2']//input[@data-document-type='CreditCardStatement']")).sendKeys("C:\\Users\\lucif\\Downloads\\Test.pdf");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='auto-btn']//button[text()='next']")).click();
			
			
		}
		
		
		driver.findElement(By.xpath("//div[@class='col-12 ex-no-mar radio-group-container rb-tx-center']//div[2]//label[1]")).click();
		driver.findElement(By.xpath("//button[text()='NO, NEXT']")).click();
		
		driver.findElement(By.xpath("//input[@id='DepositAmount_0']")).sendKeys("1000");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='action']")).click();
		
		Thread.sleep(1200);
		driver.findElement(By.xpath("//div[@class='account-funding-container animated slideInUp3']//div[3]//div//div//h3[text()='CHEQUE IN-MAIL']")).click();
		driver.findElement(By.xpath("//button[@name='action']")).click();
		
		Thread.sleep(1200);
//		Docusign
		driver.findElement(By.xpath("//button[text()='Sign now ']")).click();
		driver.findElement(By.id("action-bar-btn-continue")).click();

	}

}
