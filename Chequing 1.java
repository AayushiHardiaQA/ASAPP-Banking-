package Unicore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Chequing {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		Actions keys = new Actions(driver);
		
		
		String Loan_Amount = "10000";
		String Payment_Frequency = "Monthly";
		String Term = "";
		String ApplicantEmail = "asapp123@mailinator.com";
		String ApplicantPassword = "Tester@123";
		String ApplicantFirstName = "Cory";
		String ApplicantLastName = "Varin";
		String MemberProfilePasscode = "Tester@123";
		String Applicant_Address = "188 Rue Rachelle, les Cedres, QC, Canada";
		String BirthdayMonth = "October";
		String BirthDay = "11";
		String BirthdayYear = "1970";
		String SIN = "441 372 117";
		String Gender = "M";
		String Maritials_Status = "Married";
		String Applicant_PhoneNumber = "4502000545";
		String PhoneNumber_Type = "Home";
		
		
		String ParentTab = driver.getWindowHandle();
		
	    driver.get("https://asapp-17.test.asappbanking.com/");
	    driver.manage().window().maximize();
	    
	    Thread.sleep(1500);
	    try {
			   driver.findElement(By.xpath("//label[@for='testAgreement']")).click();
			   driver.findElement(By.xpath("//button[@id='continueBtn']")).click();
		 }
			   
		catch(Exception e) {
		    	
		 }
		   
	    driver.findElement(By.xpath("//div[text()='Chequing']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@class='accordion_box_pop accordion_box slideInUp1 animated product-container z-2 ']//div[@class='row form-inline justify-content-end']/button[1]")).click();
	    
	    Thread.sleep(2000);
	    
//	    Member Card
	    driver.findElement(By.xpath("//div[@data-product-id='355']//ul/li[1]/label")).click();
	    
//	    Overdraft
	    driver.findElement(By.xpath("//div[@data-product-id='355']//ul/li[3]/label")).click();
	   
	    
//	    Account Used for
		driver.findElement(By.xpath("//div[@data-product-id='355']//div[@class='account-used-list-container onchange-visibillity-trigger']//label[1]")).click();
		
		driver.findElement(By.xpath("//div[@data-product-id='355']//div[@class='row form-inline negative-margin']//button[text()='select']")).click();
		driver.findElement(By.xpath("//button[@class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent auto-validate-visible-fields submit-products']")).click();
		driver.findElement(By.name("action")).click();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("Email")).sendKeys(ApplicantEmail);
		driver.findElement(By.id("PreferredBranchId")).sendKeys(Keys.ARROW_DOWN);
		keys.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.id("toggle-password")).sendKeys(ApplicantPassword);
		String ApplicationID= driver.findElement(By.xpath("//div[@class='numb_m']")).getText();
		System.out.println(ApplicationID);
		
		driver.findElement(By.id("btn-setup-submit")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ex-center-content']/label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect existing-member-no existing-member-select mdl-js-ripple-effect--ignore-events is-upgraded']//span[@class='mdl-radio__ripple-container mdl-js-ripple-effect mdl-ripple--center']")).click();
		driver.findElement(By.xpath("//div[@class='personalInfoTab']//div[@class='row pt-3 justify-content-around identityMethods']//label")).click();
		driver.findElement(By.xpath("//div[@class='right right-to-next']//button[@id='buttonIdentityToggle']")).click();
		
		Thread.sleep(1000);
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
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect own-type-no-rent mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='Own']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("MailingAddress_AddressLookup")).sendKeys(Applicant_Address);
		Thread.sleep(3000);
		keys.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(3000);
		keys.sendKeys(Keys.ARROW_DOWN).build().perform();
		keys.sendKeys(Keys.ENTER).build().perform();

		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect different-address-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='No']")).click();
		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect two-years-address-yes mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='Yes']")).click();
		driver.findElement(By.id("nextBtn")).click();
		
		Thread.sleep(2500);
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
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//label//span[text()='Employed']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label//span[text()='Full Time']")).click();
		
       try {
			
			driver.findElement(By.id("EmploymentInformation_EmployerAddressLookup")).sendKeys("959 ABBEY RD");
			Thread.sleep(3000);
			keys.sendKeys(Keys.SPACE).build().perform();
			Thread.sleep(2000);
			keys.sendKeys(Keys.ARROW_DOWN).build().perform();
			keys.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			
			driver.findElement(By.id("EmploymentInformation_EmployerPhoneNumber")).sendKeys("1222301834");
			
		}
		
		catch(Exception e){
				
			System.out.println("Employer Address and Phone number is turned off");
		}
		
		
		driver.findElement(By.xpath("//input[@class='autocomplete-text mdl-textfield__input ']")).sendKeys("Information Systems Analysts and Consultants");
		keys.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(1000);
		keys.sendKeys(Keys.ARROW_DOWN).build().perform();
		keys.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1500);
		
		try {

			driver.findElement(By.id("EmploymentInformation_JobTitle")).sendKeys("Manager");
		}
		catch(Exception e) {
			
		}
		driver.findElement(By.id("EmploymentInformation_EmployerName")).sendKeys("Employee One");
	
		try {
			driver.findElement(By.id("EmploymentInformation_HireDate_Month")).sendKeys("June");
			driver.findElement(By.id("EmploymentInformation_HireDate_Year")).sendKeys("2018");
		}
		catch(Exception e) {
			
		}
		Thread.sleep(1000);
		
		driver.findElement(By.id("EmploymentInformation_AnnualIncome")).sendKeys("80000");
		
		try{
			
			driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect has-monthly-payment-obligations-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();
			driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect has-owe-personal-income-taxes-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();
			driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect is-payroll-deposited-into-account-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();
			
		}
        
		catch(Exception e){
			
		}
		driver.findElement(By.xpath("//button[@id='nextBtn']")).click();
		
		
		
//     KIN Information
	    try {
			
			driver.findElement(By.id("EmploymentInformation_KinFirstName")).sendKeys("JAMES");
			driver.findElement(By.id("EmploymentInformation_KinLastName")).sendKeys("Luther");
			driver.findElement(By.id("EmploymentInformation_KinPhone")).sendKeys("0128387411");
		}
		catch(Exception e){
			
		}
		Thread.sleep(1500);
		
		try {
			driver.findElement(By.id("EmploymentInformation_KinAddressLookup")).sendKeys("5135 10E AVE MONTREAL QC H1Y2G5");
			Thread.sleep(3000);
			keys.sendKeys(Keys.SPACE).build().perform();
			Thread.sleep(2000);
			keys.sendKeys(Keys.ARROW_DOWN).build().perform();
			keys.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1500);
			
			driver.findElement(By.id("EmploymentInformation_NextOfKinRelationship")).sendKeys(Keys.ARROW_DOWN);
		}
		catch(Exception e){
			
		}
		
		try {
			
			driver.findElement(By.id("nextBtn")).click();
		}
		catch(Exception e){
			
		}
		
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//input[@id='AML']")).sendKeys("Personal banking only");
		driver.findElement(By.id("HowYouHeard")).sendKeys("Online advertising");
		keys.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@id='yesGroup']//label[1]")).click();
		driver.findElement(By.xpath("//div[@id='taxUS']//label[2]")).click();
		driver.findElement(By.xpath("//div[@id='taxNonUSCA']//label[2]")).click();
		
		
		driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='I consent to allow FI Name to access my Credit Report.']")).click();
		driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='I consent to the SIN for Administrative Purposes Content']")).click();
		driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='I consent to the account agreement terms and conditions.']")).click();
		driver.findElement(By.xpath("//span[text()='Prompt']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("action")).click();
		
		
//      Statement Verification
		if (driver.findElement(By.xpath("//div[@class='col-md-9']//h2[text()='Bank Statement']")).isDisplayed()) {
			driver.findElement(By.xpath("//div[@class='col-md-9']//h2[text()='Bank Statement']")).click();
			driver.findElement(By.xpath("//div[@class='manual-verification']//input[@data-document-type='BankStatement']")).sendKeys("C:\\Users\\lucif\\Pictures\\Ofiice\\sample.pdf");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='auto-btn']//button[text()='next']")).click();
		}
		else {
			driver.findElement(By.xpath("//div[@class='manual-verification-methods']//div[@dual-statement-number='1']")).click();
	        Thread.sleep(1200);
			driver.findElement(By.xpath("//div[@class='dual-statement dual-statement-1']//div")).click();
			driver.findElement(By.xpath("//div[@class='dual-statement dual-statement-1']//input[@data-document-type='BankStatement']")).sendKeys("C:\\Users\\lucif\\Pictures\\Ofiice\\sample.pdf");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//div[@class='manual-verification-methods']//div[@dual-statement-number='2']")).click();
	        Thread.sleep(1200);
			driver.findElement(By.xpath("//div[@class='dual-statement dual-statement-2']//div")).click();
			driver.findElement(By.xpath("//div[@class='dual-statement dual-statement-2']//input[@data-document-type='CreditCardStatement']")).sendKeys("C:\\Users\\lucif\\Pictures\\Ofiice\\sample.pdf");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='auto-btn']//button[text()='next']")).click();
			
			
		}
		
//		driver.findElement(By.xpath("//div[@class='manual-verification-dual']//div[@class='logout-information']//label")).click();
//		Thread.sleep(1200);
//		driver.findElement(By.xpath("//div[@class='auto-btn']//button[text()='next']")).click();
		
		driver.findElement(By.xpath("//div[@class='col-12 ex-no-mar radio-group-container rb-tx-center']//div[2]//label[1]")).click();
		driver.findElement(By.xpath("//button[text()='NO, NEXT']")).click();
		
		Thread.sleep(2000);
//		Overdraft Agreement
		driver.findElement(By.xpath("//button[@value='Next']")).click();
		
//		Member Share  
		driver.findElement(By.xpath("//input[@id='DepositAmount_0']")).sendKeys("1000");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='action']")).click();
		
		
		Thread.sleep(1200);
		driver.findElement(By.xpath("//div[@class='account-funding-container animated slideInUp3']//h3[text()='CHEQUE IN-MAIL']")).click();
		driver.findElement(By.xpath("//button[@name='action']")).click();
		
		Thread.sleep(1200);
//		Docusign
		driver.findElement(By.xpath("//button[text()='Sign now ']")).click();
		driver.findElement(By.id("action-bar-btn-continue")).click();
		

	}

}
