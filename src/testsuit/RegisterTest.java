package testsuit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){

        clickOnElement(By.linkText("Register"));
        verifyElements("Signing up message not displayed","Signing up is easy!",By.xpath("//div[@id = 'mainPanel']/descendant::div[9]/child::h1"));

    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        clickOnElement(By.xpath("//div[@id = 'leftPanel']/descendant::a[2]"));
        sendTextToElement(By.xpath("//form[@id = 'customerForm']/child::table/child::tbody/child::tr/child::td[2]/child::input[1]"),"abcuser");
        sendTextToElement(By.xpath("//form[@id = 'customerForm']/descendant::td[5]/child::input"),"password12345");
        sendTextToElement(By.xpath("//form[@id = 'customerForm']/descendant::input[3]"),"amd");
        sendTextToElement(By.xpath("//form[@id = 'customerForm']/descendant::input[@id = 'customer.address.city']"),"guj");
        sendTextToElement(By.xpath("//form[@id = 'customerForm']/descendant::input[@name = 'customer.address.state']"),"ind");
        sendTextToElement(By.xpath("//tr[7]//preceding-sibling::tr[1]/descendant::input"),"hgj90");
        sendTextToElement(By.xpath("//tr[1]/following-sibling::tr[6]/child::td[2]/child::*"),"000000");
        sendTextToElement(By.xpath("//tr[1]/following-sibling::tr[7]/child::td[2]/child::input"),"00000");
        sendTextToElement(By.xpath("//input[@id = 'customer.username']"),"justgo");
        sendTextToElement(By.xpath("//input[@name = 'customer.password']"),"123456");
        sendTextToElement(By.xpath("//tr[12]/child::td[2]/child::input[@name= 'repeatedPassword']"),"123456");
        clickOnElement(By.xpath("//tr[13]/child::td[2]/child::input"));
        verifyElements("Account not created successfully","Your account was created successfully. You are now logged in.",By.xpath("//div[@id='bodyPanel']/child::div[2]/child::p"));
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
