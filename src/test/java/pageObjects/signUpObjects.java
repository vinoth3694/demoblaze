package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signUpObjects {
	

	// Initialize elements using PageFactory
    public signUpObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//a[@id='signin2']") 
	public WebElement signupbtn; 
	
	public void clickonSignUpButtonOnHomepage() {
		signupbtn.click();
	}
	
	@FindBy(xpath="//input[@id='sign-username']") 
	public WebElement username;
	public void EnterUserName(String user_name) {
		username.sendKeys(user_name);
	}
	
	@FindBy(xpath="//input[@id='sign-password']") 
	public WebElement password;
	public void EnterPassword(String pass_word) {
		password.sendKeys(pass_word);
	}
	
	@FindBy(xpath="//button[.='Sign up']") 
	public WebElement signup;
	public void ClickOnSignUpToRegister() {
		signup.click();
	}
	
	@FindBy(xpath="(//button[.='Close'])[2]") 
	public WebElement closeBtn;
	public void ClickOnCloseButton() {
		closeBtn.click();
	}	
	

}

