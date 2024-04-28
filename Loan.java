package Unicore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loan {

	public static void main(String[] args) throws InterruptedException {
		System.getProperty("webdrive.chrome.driver","C:\\Selenium Webdriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		Actions keys = new Actions(driver);
		
		String Loan_Amount = "150000";
		String Payment_Frequency = "Monthly";
		String Term = "3";
		String ApplicantEmail = "tester123@mailinator.com";
		String ApplicantPassword = "Tester@123";
		String ApplicantFirstName = "JELLO";
		String ApplicantLastName = "PUDDING";
		String MemberProfilePasscode = "Tester@123";
		String Applicant_Address = "270 RUE OLIER CHICOUTIMI QC";
	    String BirthdayMonth = "January";
		String BirthDay = "18";
		String BirthdayYear = "1983";
		String SIN = "719 029 506";
		String Gender = "F";
		String Maritials_Status = "Married";
		String Applicant_PhoneNumber = "(418)690-3918";
		String PhoneNumber_Type = "Home";
		String Collect_Employer_number_and_Address = "Y";
		
		String ParentTab = driver.getWindowHandle();
		driver.get("https://asapp-17.test.asappbanking.com");
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
		
		driver.findElement(By.xpath("//div[text()='Lending']")).click();
		
		Thread.sleep(1200);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@class='accordion_box_pop accordion_box slideInUp1 animated product-container z-11 ']//div[@class='row form-inline justify-content-end']//button[1]")).click();
		driver.findElement(By.xpath("//div[@data-product-id='478']//input[@class='requested-amount mdl-textfield__input ']")).sendKeys(Loan_Amount);
		driver.findElement(By.xpath("//div[@data-product-id='478']//div[@class='account-used-list-container onchange-visibillity-trigger']//label//span[text()='For car purchase or other expenses']")).click();

		driver.findElement(By.xpath("//div[@data-product-id='478']//label//span[text()='3y']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-product-id='478']//div[@class='d-flex flex-wrap justify-content-start amortization-selector ']//input[@class='mdl-textfield__input']")).sendKeys("10");
		keys.sendKeys(Keys.ENTER).build().perform();
		
		driver.findElement(By.xpath("//div[@data-product-id='478']//div[@class='d-flex flex-wrap justify-content-start payment-frequency']//input[@class='mdl-textfield__input']")).sendKeys("Semi-monthly");
		keys.sendKeys(Keys.ENTER).build().perform();
		
//		 For Guarantor
		 String Guarantor = driver.findElement(By.xpath("//div[@data-product-id='478']//div[@class='extraQuestions']//h6")).getText();
		
		 if (Guarantor.contains("Will this application require a guarantor?")|| Guarantor.contains("co-signer")|| Guarantor.contains("to consolidate any existing debt")) {
		 	
		 	driver.findElement(By.xpath("//div[@data-product-id='478']//div[@class='extraQuestions']//label//span[text()='No']")).click();
		 }
		
//		 For Existing
		 String Existing = driver.findElement(By.xpath("//div[@data-product-id='478']//div[@class='existing-member-lending-container onchange-visibillity-trigger']//h6")).getText();
		
		 if (Existing.contains("Do you have an existing account")) {
		 	
		 	driver.findElement(By.xpath("//div[@data-product-id='478']//div[@class='existing-member-lending-container onchange-visibillity-trigger']//label[2]")).click();
		 }
		 
		driver.findElement(By.xpath("//div[@data-product-id='478']//div[@class='extraQuestions']//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect no mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='No']")).click();
		 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-product-id='478']//div[@class='row form-inline negative-margin']//button[text()='select']")).click();
		driver.findElement(By.xpath("//button[@class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent auto-validate-visible-fields submit-products']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("action")).click();
		
		
		driver.findElement(By.id("Email")).sendKeys(ApplicantEmail);
		driver.findElement(By.id("PreferredBranchId")).sendKeys(Keys.ARROW_DOWN);
		keys.sendKeys(Keys.ENTER).build().perform();

		driver.findElement(By.id("toggle-password")).sendKeys(ApplicantPassword);
		
		String ApplicationID= driver.findElement(By.xpath("//div[@class='numb_m']")).getText();
		System.out.println(ApplicationID);
		
		driver.findElement(By.id("btn-setup-submit")).click();
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//div[@class='ex-center-content']/label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect existing-member-no existing-member-select mdl-js-ripple-effect--ignore-events is-upgraded']//span[@class='mdl-radio__ripple-container mdl-js-ripple-effect mdl-ripple--center']")).click();
		
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@class='personalInfoTab']//div[@class='row pt-3 justify-content-around identityMethods']//label")).click();
		driver.findElement(By.xpath("//div[@class='right right-to-next']//button[@id='buttonIdentityToggle']")).click();
		
		
		Thread.sleep(500);
		driver.findElement(By.id("MemberProfile_FirstName")).sendKeys(ApplicantFirstName);
		driver.findElement(By.id("MemberProfile_LastName")).sendKeys(ApplicantLastName);
		driver.findElement(By.id("MemberProfile_Password")).sendKeys(MemberProfilePasscode);
		driver.findElement(By.id("nextBtn")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='PersonalInfo_BirthdayMonth']")).sendKeys(BirthdayMonth);
		driver.findElement(By.xpath("//input[@id='PersonalInfo_BirthdayDay']")).sendKeys(BirthDay);
		driver.findElement(By.xpath("//input[@id='PersonalInfo_BirthdayYear']")).sendKeys(BirthdayYear);
		Thread.sleep(500);
		
//		Get Random SIN
		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.fakenamegenerator.com/social-insurance-number.php");
//		String Get_Random_sin= driver.findElement(By.xpath("//div[@class='content']//p[2]")).getText();
//		String[] Random_sin =Get_Random_sin.split(":");
//		
//		driver.switchTo().window(parentWindow);
//		driver.findElement(By.id("PersonalInfo_SIN")).sendKeys(Random_sin[1].trim());
//		driver.findElement(By.id("PersonalInfo_InternationalSIN")).sendKeys(Random_sin[1].trim().replaceAll("\\s",""));
		
		
		driver.get("https://www.myfakeinfo.com/nationalidno/get-canada-sin.php");
		String Random_sin= driver.findElement(By.xpath("//div[@class='alert alert-info']//h1")).getText();
		driver.switchTo().window(ParentTab);
		driver.findElement(By.id("PersonalInfo_SIN")).sendKeys(Random_sin);
		
		Thread.sleep(1000);
		
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect own-type-no-rent mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='Own']")).click();
		
		
		driver.findElement(By.id("MailingAddress_AddressLookup")).sendKeys(Applicant_Address);
		Thread.sleep(1000);
		keys.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(1000);
		keys.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		keys.sendKeys(Keys.ENTER).build().perform();
 
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect different-address-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='No']")).click();
		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect two-years-address-yes mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='Yes']")).click();
		driver.findElement(By.id("nextBtn")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("ContactInformation_PhoneNumber")).sendKeys(Applicant_PhoneNumber);
		
		if (PhoneNumber_Type == "Home") {
			driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='Home']")).click();
		}
		else {
			driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='Mobile']")).click();
		}
	
		Thread.sleep(1000);
		driver.findElement(By.id("nextBtn")).click();
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label//span[text()='Employed']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label//span[text()='Full Time']")).click();
		
		
		if(driver.findElement(By.xpath("//div[@id='employer-address-section']")).isDisplayed()) {
			driver.findElement(By.xpath("//input[@id='EmploymentInformation_EmployerAddressLookup']")).sendKeys("109 ALBERT ST NE AIRDRIE AB T4B0R5");
			Thread.sleep(1000);
			keys.sendKeys(Keys.SPACE).build().perform();
			Thread.sleep(2000);
			keys.sendKeys(Keys.ARROW_DOWN).build().perform();
			keys.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			driver.findElement(By.id("EmploymentInformation_EmployerPhoneNumber")).sendKeys("(123)678-1933");
		}
		else {
			
		}
		
		driver.findElement(By.xpath("//input[@class='autocomplete-text mdl-textfield__input ']")).sendKeys("Information Systems Analysts and Consultants");
		Thread.sleep(1000);
		keys.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(2000);
		keys.sendKeys(Keys.ARROW_DOWN).build().perform();
		keys.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		
		driver.findElement(By.id("EmploymentInformation_EmployerName")).sendKeys("Employee One");
        driver.findElement(By.id("EmploymentInformation_JobTitle")).sendKeys("Tester");
		Thread.sleep(1000);
		driver.findElement(By.id("EmploymentInformation_HireDate_Month")).sendKeys("June");
		driver.findElement(By.id("EmploymentInformation_HireDate_Year")).sendKeys("2018");
		
		driver.findElement(By.id("EmploymentInformation_AnnualIncome")).sendKeys("300000");
		
		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect has-monthly-payment-obligations-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();
		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect has-owe-personal-income-taxes-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();
		driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect is-payroll-deposited-into-account-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();
		
		driver.findElement(By.xpath("//button[@id='nextBtn']")).click();
		
//		KIN information
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1200);
        driver.findElement(By.id("EmploymentInformation_KinFirstName")).sendKeys("JAMES");
		driver.findElement(By.id("EmploymentInformation_KinLastName")).sendKeys("KING");
		driver.findElement(By.id("EmploymentInformation_KinPhone")).sendKeys("0128987431");
		driver.findElement(By.id("EmploymentInformation_KinAddressLookup")).sendKeys("515 10E AVE MONTREAL QC H1Y2G5");
		Thread.sleep(1000);
		keys.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(2000);
		keys.sendKeys(Keys.ARROW_DOWN).build().perform();
		keys.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='EmploymentInformation_NextOfKinRelationship']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("nextBtn")).click();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Declaration
		Thread.sleep(1000);
		driver.findElement(By.id("AML")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("HowYouHeard")).sendKeys("Online advertising");
		keys.sendKeys(Keys.ENTER).build().perform();
		
		
		Thread.sleep(1500);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[@id='yesGroup']//label[1]")).click();
//		driver.findElement(By.xpath("//div[@id='taxUS']//label[2]")).click();	
		driver.findElement(By.xpath("//div[@id='taxNonUSCA']//label[2]")).click();
		
//		Consents
		driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[contains(text(), 'SIN')]")).click();
		driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[contains(text(), 'consent')]")).click();
		driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[contains(text(), 'Prompt')]")).click();
		driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[contains(text(), 'I consent to the account agreement terms and conditions')]")).click();
		
		
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
//		driver.findElement(By.xpath("//button[text()='NO, NEXT']")).click();
				
		driver.findElement(By.name("action")).click();
		
		
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='selectassets-form']//div[@class='col-sm-4 card-style'][1]//label//span[4]")).click();
		driver.findElement(By.xpath("//button[text()='NEXT']")).click();
		driver.findElement(By.xpath("//button[@value='add-asset-1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='same-address-question']//div//div[2]//span[text()='Yes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='asset00-asset-form']/div[4]/div/div[2]/label[1]/span[4]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='radio-section-content ex-no-pad radio-list-top d-flex flex-wrap col-md-8']//label[3]/span[text()='Residential']")).click();
		driver.findElement(By.name("Assets[0].Entries[0].Asset.MarketValue")).sendKeys("180000");
		driver.findElement(By.id("Assets_0__Entries_0__Asset_MPACAssessmentValue")).sendKeys("160000");
		driver.findElement(By.id("Assets_0__Entries_0__Asset_HeatingCosts")).sendKeys("200");
		driver.findElement(By.xpath("//button[text()='ADD']")).click();
		Thread.sleep(1200);
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		
		
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='selectassets-form']//div[@class='col-sm-4 card-style'][1]//label//span[4]")).click();
		driver.findElement(By.xpath("//button[text()='NEXT']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@value='add-asset-1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='same-address-question']//div//div[2]//span[text()='Yes']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='asset00-asset-form']/div[4]/div/div[2]/label[1]/span[4]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='radio-section-content ex-no-pad radio-list-top d-flex flex-wrap col-md-8']//label[3]/span[text()='Residential']")).click();
		driver.findElement(By.name("Assets[0].Entries[0].Asset.MarketValue")).sendKeys("180000");
		driver.findElement(By.id("Assets_0__Entries_0__Asset_MPACAssessmentValue")).sendKeys("160000");
		driver.findElement(By.id("Assets_0__Entries_0__Asset_HeatingCosts")).sendKeys("200");
		driver.findElement(By.xpath("//div[@id='asset00-asset-form']//div[@class='d-flex flex-wrap']//div[@class='radio-section-content ex-no-pad text-nowrap radio-list-top']//label[1]")).click();	
		driver.findElement(By.id("Assets_0__Entries_0__Asset_CurrentBalance")).sendKeys("5000");
		driver.findElement(By.id("Assets_0__Entries_0__Asset_PaymentAmount")).sendKeys("120");
		driver.findElement(By.id("Assets_0__Entries_0__Asset_FinancialInstitution")).sendKeys("ASAPP");
		driver.findElement(By.xpath("//div[@class='col-md-8 p-0']//label[4]/span[text()='Monthly']")).click();
		driver.findElement(By.xpath("//button[text()='ADD']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Use As Collateral']")).click();
		
		driver.findElement(By.xpath("//button[@value='next']")).click();
		
		
//		Insurance
		driver.findElement(By.xpath("//button[@class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label//span[text()='Life Insurance']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("cumis-recalculate-premium-btn")).click();
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String Insurance_Total =driver.findElement(By.xpath("//div[@class='table-totals']//div[4]//div[2]//span")).getText();
		System.out.println(Insurance_Total);
		
		driver.findElement(By.xpath("//div[@class='applicant-consents']//div[@class='col-12 col-sm-4 vertical-center-flex']//label[2]//span[text()='No']")).click();
		driver.findElement(By.xpath("//div[@class='applicant']//div[1]//div//div//div//div//input[@id='Applicants___appIndex____BenefitWaiversDetails___waiverIndex____Reason']")).sendKeys("Already has enough insurance");
		driver.findElement(By.xpath("//div[@class='applicant']//div[3]//div//div//div//div//input[@id='Applicants___appIndex____BenefitWaiversDetails___waiverIndex____Reason']")).sendKeys("Too expensive");
		driver.findElement(By.id("cumis-insurance-next-btn")).click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("cumis-insurance-next-btn")).click();
		
		driver.findElement(By.xpath("//button[text()='NEXT']")).click();
		
		
		
//		Deposit Amount
    	driver.findElement(By.id("DepositAmount_0")).sendKeys("1000");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent next']")).click();
        
//		Account Funding
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='account-funding-container animated slideInUp3']//div[@data-submit-method='Mail']")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("action")).click();
		
//		POI
		driver.findElement(By.id("btnPOImanual")).click();
		driver.findElement(By.xpath("//div[@id='POImanual']//div[@class='animated slideInUp4 w-100']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-document-type='DirectDepositBankStatement']")).sendKeys("C:\\Users\\lucif\\Downloads\\Test.pdf");
		
		Thread.sleep(2000);
		driver.findElement(By.name("action")).click();
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='NEXT']")).click();
		
		
//		Document Signing
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='col-lg-6 col-12']//button[text()='Sign now ']")).click();
		
//		DocuSign
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		driver.switchTo().frame("docuSignFrame");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='action-bar-btn-continue']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[contains(text(),'Initial')]")).click();
		driver.findElement(By.xpath("//button[text()='Adopt and Initial']")).click();
		
		driver.findElement(By.xpath("//div[@class='doc-tab signature-tab owned signing-required has-tab-error']//div[text()='Sign']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@class='rb_label']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='doc-tab signature-tab owned signing-required has-tab-error']//div[text()='Sign']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-done-signing btn-main']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.name("action")).click();
		
	}

}
