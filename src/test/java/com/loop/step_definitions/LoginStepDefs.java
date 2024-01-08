package com.loop.step_definitions;

import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
       // System.out.println("this is given step");
        Driver.getdriver().get(ConfigurationReader.getproperty("env"));

    }
    @When("user enters username for client")
    public void user_enters_username_for_client() {
        //System.out.println("this is when");
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.extraSmall);
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
    }
    @When("user enters password for client")
    public void user_enters_password_for_client() {
        //System.out.println("this is when/and");
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
       // System.out.println("this is when/and");
        loginPage.loginButton.click();
    }
    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {
       // System.out.println("this is then");
        Assert.assertTrue(Driver.getdriver().getCurrentUrl().contains("https://beta.docuport.app/"));
    }


    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters password for advisor")
    public void user_enters_password_for_advisor() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should see the home page for advisor")
    public void user_should_see_the_home_page_for_advisor() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("user enters username for supervisor")
    public void user_enters_username_for_supervisor() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters password for supervisor")
    public void user_enters_password_for_supervisor() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should see the home page for supervisor")
    public void user_should_see_the_home_page_for_supervisor() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
