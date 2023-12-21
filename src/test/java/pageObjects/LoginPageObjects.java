package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	//click on Login button
		@FindBy(xpath = "//a[@id='login2']")
		public WebElement LoginBtn;

		//Enter username
		@FindBy(xpath ="//input[@id='loginusername']")
		public WebElement login_username;
		
		//Enter password
		@FindBy(xpath = "//input[@id='loginpassword']")
		public WebElement login_password;
		
		//Click on Login Buttom
		@FindBy(xpath = "//button[contains(text(),'Log in')]")
		public WebElement login_loginbutton;
		
		//Click on close button
		@FindBy(xpath = "(//button[@class='btn btn-secondary'])[3]")
		public WebElement login_closebutton;
		
		//Verify Welcome message after Login
		@FindBy(id="nameofuser")
		public WebElement verifyMessage;

		private WebDriver driver;
		
		//Initialize webelements  using PageFactory
		public LoginPageObjects(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		
		public void clickOnLoginBtnHomepage() {
			LoginBtn.click();
		}
		
		public void EnterUsername(String str) {
			login_username.sendKeys(str);
		}
		
		public void EnterPassword(String str) {
			login_password.sendKeys(str);
		}
		
		public void clickOnLogin() {
			login_loginbutton.click();
		}
		
		public void clickOnClose() {
			login_closebutton.click();
		}
		
		public String verifyLogin() {
			return verifyMessage.getText();
		}

}
