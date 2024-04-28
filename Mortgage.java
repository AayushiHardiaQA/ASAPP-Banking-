package Products.UnicoreDNA;
 
import java.sql.Driver;

import java.time.Duration;
 
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WindowType;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
 
public class Mortgage {
 
    public static void main(String[] args) throws InterruptedException {

        System.getProperty("webdrive.chrome.driver","C:\\Selenium Webdriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);

        Actions keys = new Actions(driver);
 
        

        String Purchase_Amount = "120000";

        String Downpayment_Amount= "80000";

        String Loan_Amount = "10000";

        String ApplicantEmail = "tester123@mailinator.com";

        String ApplicantPassword = "Tester@123";

        String ApplicantFirstName = "WARREN";

        String ApplicantLastName = "CHOW";

        String MemberProfilePasscode = "TesterASAPP123";

        String Applicant_Address = "5 BAINTREE ST MARKHAM ON L6E1G7";

        String BirthdayMonth = "February";

        String BirthDay = "18";

        String BirthdayYear = "1956";

        String SIN = "719 029 506";

        String Gender = "M";

        String Maritials_Status = "Married";

        String Applicant_PhoneNumber = "(905)201-0028";

        String PhoneNumber_Type = "Home";


        Thread.sleep(1000);

        driver.get("https://asapp-test-16.uat.asappbanking.com/");

        driver.manage().window().maximize();

        String ParentTab = driver.getWindowHandle();

        Thread.sleep(1500);

//           if (driver.findElement(By.xpath("//div[@class='col-12 col-md-10 col-lg-5 bg-white p-4 border-5 primary-border']")).isDisplayed()) {

//               

//               driver.findElement(By.xpath("//label[@for='testAgreement']")).click();

//               driver.findElement(By.xpath("//button[@id='continueBtn']")).click();

//               

//           }

//            

//           else {

//               

//           }

//        

        driver.findElement(By.xpath("//div[text()='Mortgage']")).click();

        Thread.sleep(1200);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//div[@class='accordion_box_pop accordion_box slideInUp3 animated product-container z-1 ']//div//div[3]//div//div[2]//div//button[1]")).click();

        driver.findElement(By.xpath("//div[@class='form-group mortgage-types-container-2-2']//label[1]")).click();

        driver.findElement(By.id("Categories_2__Products_2__ValueOfHome")).sendKeys(Purchase_Amount);

        driver.findElement(By.id("Categories_2__Products_2__DownPayment")).sendKeys(Downpayment_Amount);

        driver.findElement(By.xpath("//*[@id='app-form']/div[2]/div[6]/div[3]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/label[2]/span[4]")).click();

        driver.findElement(By.xpath("//*[@id='app-form']/div[2]/div[6]/div[3]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[4]/div[1]/div/label[1]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id='app-form']/div[2]/div[6]/div[3]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[14]/div/div[2]/label[1]/span[4]")).click();

         driver.findElement(By.id("Categories_2__Products_2__PaymentFrequency")).sendKeys("Monthly");

        keys.sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id='app-form']/div[2]/div[6]/div[3]/div[2]/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/label[2]/span[text()='No']")).click();
 
        

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='row form-inline negative-margin']//button[text()='select']")).click();

        driver.findElement(By.xpath("//button[@class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent auto-validate-visible-fields submit-products']")).click();

        driver.findElement(By.name("action")).click();

        driver.findElement(By.id("Email")).sendKeys(ApplicantEmail);

        driver.findElement(By.id("PreferredBranchId")).sendKeys("Chetwynd - 85011000 - SP, MPLOC, GMP, MTL    ");

        keys.sendKeys(Keys.ENTER).build().perform();
 
        driver.findElement(By.id("toggle-password")).sendKeys(ApplicantPassword);

        String ApplicationID= driver.findElement(By.xpath("//div[@class='numb_m']")).getText();

        System.out.println(ApplicationID);

        Thread.sleep(1000);

        driver.findElement(By.id("btn-setup-submit")).click();

        driver.findElement(By.xpath("//*[@id='personalInformationForm']/div[1]/div/div[2]/div[2]/div/div/label[2]/span[4]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='personalInformationForm']/div[1]/div/div[2]/div[4]/div/div/div/div[5]/div[3]/p/label/span[4]")).click();

        driver.findElement(By.xpath("//div[@class='right']//button[@id='buttonIdentityToggle']")).click();
 
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


        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.fakenamegenerator.com/social-insurance-number.php");

        String Get_Random_sin= driver.findElement(By.xpath("//div[@class='content']//p[2]")).getText();

        String[] Random_sin =Get_Random_sin.split(":");

        driver.switchTo().window(ParentTab);

        driver.findElement(By.id("PersonalInfo_SIN")).sendKeys(Random_sin[1]);

//        driver.findElement(By.id("PersonalInfo_InternationalSIN")).sendKeys(SIN.trim().replaceAll("\\s",""));

        Thread.sleep(1000);

//        Gender

        if (Gender== "M") {

            driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()= 'Male']")).click();

        }

        else {

            driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()= 'Female']")).click();

        }

//        Maritials Status

        if (Maritials_Status == "Married") {

            driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()= 'Married']")).click();

        }

        else {

            driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()= 'Single']")).click();

        }

        driver.findElement(By.id("PersonalInfo_SitizenshipCountry")).sendKeys("Canada");

        driver.findElement(By.id("PersonalInfo_ResidenceCountry")).sendKeys("Canada");

        driver.findElement(By.id("nextBtn")).click();

        Thread.sleep(2500);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect own-type-no-rent mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='Own']")).click();

        Thread.sleep(1000);

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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[@id='ContactInformation_PhoneNumber']")).sendKeys(Applicant_PhoneNumber);

        if (PhoneNumber_Type == "Home") {

            driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='Home']")).click();

        }

        else {

            driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='Mobile']")).click();

        }

//        driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect alternative-phone-number-no alternative-phone-number mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='No']")).click();

        Thread.sleep(1000);

        driver.findElement(By.id("nextBtn")).click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(2500);

        driver.findElement(By.xpath("//label//span[text()='Employed']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//label//span[text()='Full Time']")).click();

        if(driver.findElement(By.xpath("//div[@id='employer-address-section']")).isDisplayed()) {

            driver.findElement(By.xpath("//input[@id='EmploymentInformation_EmployerAddressLookup']")).sendKeys("109 ALBERT ST NE AIRDRIE AB T4B0R5");

            Thread.sleep(3000);

            keys.sendKeys(Keys.SPACE).build().perform();

            Thread.sleep(2000);

            keys.sendKeys(Keys.ARROW_DOWN).build().perform();

            keys.sendKeys(Keys.ENTER).build().perform();

            Thread.sleep(1000);

            driver.findElement(By.id("EmploymentInformation_EmployerPhoneNumber")).sendKeys("1236781933");

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

        driver.findElement(By.id("EmploymentInformation_JobTitle")).sendKeys("Manager");

        driver.findElement(By.id("EmploymentInformation_EmployerName")).sendKeys("Employee One");

        Thread.sleep(1000);

        driver.findElement(By.id("EmploymentInformation_HireDate_Month")).sendKeys("June");

        driver.findElement(By.id("EmploymentInformation_HireDate_Year")).sendKeys("2018");

        driver.findElement(By.id("EmploymentInformation_AnnualIncome")).sendKeys("200000");

        driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect has-monthly-payment-obligations-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();

        driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect has-owe-personal-income-taxes-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();

        driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect is-payroll-deposited-into-account-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();

        driver.findElement(By.xpath("//button[@id='nextBtn']")).click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Thread.sleep(1200);

        driver.findElement(By.id("EmploymentInformation_KinFirstName")).sendKeys("JAMES");

        driver.findElement(By.id("EmploymentInformation_KinLastName")).sendKeys("Luther");

        driver.findElement(By.id("EmploymentInformation_KinPhone")).sendKeys("0128387411");

        driver.findElement(By.id("EmploymentInformation_KinAddressLookup")).sendKeys("5135 10E AVE MONTREAL QC H1Y2G5");

        Thread.sleep(1000);

        keys.sendKeys(Keys.SPACE).build().perform();

        Thread.sleep(1000);

        keys.sendKeys(Keys.ARROW_DOWN).build().perform();

        Thread.sleep(1000);

        keys.sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(1500);

        driver.findElement(By.id("nextBtn")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("AML")).sendKeys("Term Deposits Only – I’m opening this account for investing only");

        driver.findElement(By.id("HowYouHeard")).sendKeys("Online advertising");


        Thread.sleep(20000);

//        driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect above_all_yes mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();

//        driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect us-resident-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();

//        driver.findElement(By.xpath("//label[@class='mdl-radio label-text-large mdl-js-radio mdl-js-ripple-effect otherResidentForTaxPurposes-no mdl-js-ripple-effect--ignore-events is-upgraded']//span[4]")).click();

//        

        driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='I consent to allow FI Name to access my Credit Report.']")).click();

        driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='I consent to the SIN for Administrative Purposes Content']")).click();

        driver.findElement(By.xpath("//label[@class='mr-3 mb-3 mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='I consent to the account agreement terms and conditions.']")).click();

        driver.findElement(By.name("action")).click();

        Thread.sleep(5000);

        driver.findElement(By.name("action")).click();

        Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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

        driver.findElement(By.xpath("//div[@class='col-sm-9 mt-3 mt-sm-0 home-type-container d-flex']//label[1]")).click();

        driver.findElement(By.id("DwellingType")).sendKeys("Duplex");

        driver.findElement(By.id("PropertyStyle")).sendKeys("Two Story");

        keys.sendKeys(Keys.ENTER).build().perform();

        driver.findElement(By.xpath("//div[@class='col-sm-9 mt-3 mt-sm-0 d-flex flex-wrap flex-lg-nowrap']//label[2]")).click();

//        driver.findElement(By.id("AddressAutoCompleteViewModel_MortgageCountry")).sendKeys("Canada");

        driver.findElement(By.id("AddressAutoCompleteViewModel_AddressLookup")).sendKeys("22 Roger street");

        Thread.sleep(1000);

        keys.sendKeys(Keys.SPACE).build().perform();

        Thread.sleep(2000);

        keys.sendKeys(Keys.ARROW_DOWN).build().perform();

        keys.sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(1500);

        driver.findElement(By.name("action")).click();

        driver.findElement(By.xpath("//div[@class='is-owner-occupied-container row align-items-baseline']//div[2]//label[1]")).click();

        driver.findElement(By.xpath("//div[@class='row mortgage-residence align-items-baseline']//div[2]//label[2]")).click();

        driver.findElement(By.xpath("//div[@class='row garage-type-container align-items-baseline']//div[2]//label[2]")).click();

        driver.findElement(By.id("SquareFootage")).sendKeys("1200");

        driver.findElement(By.id("YearBuilt")).sendKeys("2021");

        driver.findElement(By.id("HeatingSource")).sendKeys("Electric");

        driver.findElement(By.xpath("//form[@id='mortgage-form']//div[10]//div[2]//label[2]")).click();

        driver.findElement(By.xpath("//form[@id='mortgage-form']//div[11]//div[2]//label[2]")).click();

        Thread.sleep(1000);

        driver.findElement(By.name("action")).click();

        driver.findElement(By.id("MonthlyEstimatedHeatingCosts")).sendKeys("10");

        driver.findElement(By.id("AnnualPropertyTax")).sendKeys("100");

        driver.findElement(By.name("action")).click();

        driver.findElement(By.xpath("//div[@class='form-group first-time-buyer-container mb-0']//div//div//label[2]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='form-group has-selling-property mb-0']//div//div[1]//label[2]")).click();

        driver.findElement(By.xpath("//div[@class='col-lg-12 down-payment-source-container']//div//div[1]//label")).click();

        driver.findElement(By.xpath("//input[@id='PersonalSavingsDownPaymentAmount']")).sendKeys("80000");

        driver.findElement(By.name("action")).click();

//        driver.findElement(By.xpath("//div[@id='mortgage-form']//div//div[2]//div//div//label[2]")).click();

//        driver.findElement(By.id("AddressAutoCompleteViewModel_AddressLookup")).sendKeys("677 Richard Street");

//        Thread.sleep(1000);

//        keys.sendKeys(Keys.SPACE).build().perform();

//        Thread.sleep(2000);

//        keys.sendKeys(Keys.ARROW_DOWN).build().perform();

//        keys.sendKeys(Keys.ENTER).build().perform();

//        Thread.sleep(1500);

//        

//        driver.findElement(By.name("action")).click();

//        driver.findElement(By.xpath("//div[@class='row mx-0 validation-group']//div[2]//label[3]")).click();

//        driver.findElement(By.id("MarketValue")).sendKeys(Keys.BACK_SPACE);

//        driver.findElement(By.id("MarketValue")).sendKeys("170000");

//        driver.findElement(By.id("HeatingCosts")).clear();

//        driver.findElement(By.id("HeatingCosts")).sendKeys("200");

//        driver.findElement(By.name("action")).click();

        Thread.sleep(3000);

        driver.findElement(By.name("action")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Next']")).click();

 
        //Insurance

        driver.findElement(By.xpath("//button[@class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent next']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='flex-grow-1 col-lg-12 p-0']//div[2]//div[2]//div//p//label//span[text()='Life Insurance']")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("cumis-recalculate-premium-btn")).click();

        Thread.sleep(20000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String Insurance_Total =driver.findElement(By.xpath("//div[@class='table-totals']//div[4]//div[2]//span")).getText();

        System.out.println(Insurance_Total);

        driver.findElement(By.xpath("//div[@class='applicant-consents']//label[@class='mdl-radio mdl-js-radio mdl-js-ripple-effect my-0 cumis-track-field-radio mdl-js-ripple-effect--ignore-events is-upgraded']//span[text()='No']")).click();

        driver.findElement(By.xpath("//div[@class='applicant']//div[1]//div//div//div//div//input[@id='Applicants___appIndex____BenefitWaiversDetails___waiverIndex____Reason']")).sendKeys("Already has enough insurance");

        driver.findElement(By.xpath("//div[@class='applicant']//div[3]//div//div//div//div//input[@id='Applicants___appIndex____BenefitWaiversDetails___waiverIndex____Reason']")).sendKeys("Too expensive");

        driver.findElement(By.id("cumis-insurance-next-btn")).click();

        Thread.sleep(5000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("cumis-insurance-next-btn")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='account-funding-container animated slideInUp3']//div[3]//div//h3[text()='CHEQUE IN-MAIL']")).click();

        driver.findElement(By.name("action")).click();

        driver.findElement(By.id("btnPOImanual")).click();

        driver.findElement(By.xpath("//div[@id='POImanual']//div[@class='animated slideInUp4 w-100']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@data-document-type='DirectDepositBankStatement']")).sendKeys("C:/Users/Sayan Pal/Downloads/sample.pdf");

        Thread.sleep(3000);

        driver.findElement(By.name("action")).click();

        driver.findElement(By.xpath("//button[text()='NEXT']")).click();

        driver.findElement(By.xpath("//div[@class='col-lg-6 col-12']//button[text()='Sign now ']")).click();

 
    }
 
}
