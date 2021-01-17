package gmibank.pages;

import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US004_LoginPage {
    public US004_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="account-menu")
    public WebElement accountIcon;

    @FindBy(id = "login-item")
    public WebElement signInIcon;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordBox;
    
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitSignIn;

    @FindBy(id = "entity-menu")
    public WebElement myOperations;

    @FindBy(id="account-menu")
    public WebElement accountIconLogout;

    @FindBy(linkText = "Sign out")
    public WebElement signOut;

    @FindBy(linkText = "SIGN IN AGAIN")
    public WebElement loggedOut;

    public void login(){
        String username = ConfigurationReader.getProperty("username1") ;
        String password = ConfigurationReader.getProperty("password1") ;

        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);

    }
}
