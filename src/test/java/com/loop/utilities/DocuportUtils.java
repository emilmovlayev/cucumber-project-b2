package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.InputMismatchException;

public class DocuportUtils {

    /**
     * logins to the docuport application
     * @param driver, which initialized in test base
     * @param role, comes from docuport constants
     * @author Emil
     */
    public static void login(WebDriver driver,String role) throws InterruptedException {
       // driver.get("https://beta.docuport.app/");
        Driver.getdriver().get(ConfigurationReader.getproperty("env"));
        WebElement username = Driver.getdriver().findElement(By.xpath("//label[.='Username or email']//following-sibling::input"));
        WebElement password = Driver.getdriver().findElement(By.xpath("//input[@type='password']"));
        WebElement loginBUtton = Driver.getdriver().findElement(By.xpath("//button[@type='submit']"));
        switch (role.toLowerCase()) {
            case "client":
                username.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            default:
                throw new InputMismatchException("There us not such a role: " + role);
        }

        loginBUtton.click();

        if (role.toLowerCase().equals("client")) {
            Thread.sleep(3000);
            WebElement cont = Driver.getdriver().findElement(By.xpath("//button[@type='submit']"));
            cont.click();
            Thread.sleep(3000);
        }
    }
    /**
     * logs out from the application
     * @param driver
     * @author Emil
     */
    public static void logOut(WebDriver driver){
        Driver.getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userIcon = Driver.getdriver().findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        Driver.getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement logOut =Driver.getdriver().findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
        Driver.getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
