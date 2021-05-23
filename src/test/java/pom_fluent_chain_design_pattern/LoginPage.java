package pom_fluent_chain_design_pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private final WebDriver driver;
	
	private LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	  
    @FindBy(xpath = "//input[@id='txtUsername']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='txtPassword']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='btnLogin']")
    private WebElement loginBtn;

    public static LoginPage using(WebDriver driver) {
        return new LoginPage(driver);
    }

    public LoginPage launch() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        return this;
    }
    
    public LoginPage setUsername(String username) {
        this.userName.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public void login() {
        this.loginBtn.click();
    }

}