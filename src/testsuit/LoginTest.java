package testsuit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        sendTextToElement(By.xpath("//div/parent::div[1]/child::div[3]//child::div/child::div/child::form/child::div/child::input"),"justgo");
        sendTextToElement(By.xpath("//input[@name = 'password']/self::input"),"123456");
        clickOnElement(By.xpath("//div[3][@class = 'login']/child::input"));
        verifyElements("Accounts Overview not displayed","Accounts Overview",By.linkText("Accounts Overview"));
    }

    @Test
    public void verifyTheErrorMessage() {

        sendTextToElement(By.xpath("//div/parent::div[1]/child::div[3]//child::div/child::div/child::form/child::div/child::input"),"justgo");
        sendTextToElement(By.xpath("//input[@name = 'password']/self::input"),"123456");
        clickOnElement(By.xpath("//div[3][@class = 'login']/child::input"));
        verifyElements("error message","The username and password could not be verified.",By.xpath("//div[@id = 'rightPanel']/child::p"));
    }
    @Test
    public void userShouldLogOutSuccessfully(){

        sendTextToElement(By.xpath("//div/parent::div[1]/child::div[3]//child::div/child::div/child::form/child::div/child::input"),"justgo");
        sendTextToElement(By.xpath("//input[@name = 'password']/self::input"),"123456");
        clickOnElement(By.xpath("//div[3][@class = 'login']/child::input"));
        clickOnElement(By.linkText("Log Out"));

        verifyElements("can not see the login message","Customer Login",By.xpath("//div[@id = 'bodyPanel']/descendant::h2"));
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
