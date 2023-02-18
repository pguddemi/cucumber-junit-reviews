package com.cydeo.step_definitions;

import com.cydeo.pages.SeamlessLoginPage;
import com.cydeo.pages.SeamlessLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_step_definition {

    SeamlessLoginPage loginPage = new SeamlessLoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("seamless.url"));
    }
    @When("the user enter valid username")
    public void the_user_enter_valid_username() {
        loginPage.txt_username.sendKeys(ConfigurationReader.getProperty("seamlesslyUsername"));
    }
    @When("the user enter valid password")
    public void the_user_enter_valid_password() {
        loginPage.txt_password.sendKeys(ConfigurationReader.getProperty("seamlesslyPassword"));
    }
    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
        loginPage.btn_log_in.click();
    }
    @Then("the user should be able to log in")
    public void the_user_should_be_able_to_log_in() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Files"));
    }
}
