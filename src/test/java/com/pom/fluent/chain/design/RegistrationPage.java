package com.pom.fluent.chain.design;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private final WebDriver driver;
    
    private RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement phone;

    @FindBy(xpath = "//input[@value='FeMale']")
    private WebElement femaleRadBtn;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement submit;

   
    public static RegistrationPage using(WebDriver driver) {
        return new RegistrationPage(driver);
    }

    public RegistrationPage launch() {
        driver.get("http://demo.automationtesting.in/Register.html");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public RegistrationPage enterPhone(String phone) {
        this.phone.sendKeys(phone);
        return this;
    }

    public RegistrationPage clickFemaleRadioBtn() {
        this.femaleRadBtn.click();
        return this;
    }

    public void submit() {
        this.submit.click();
    }
}