import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.CacheLookup
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class HomePage(private val driver: WebDriver) {

    @FindBy(xpath = "/html/body/div[1]/h2")
    @CacheLookup
    private val TXT_TITLE: WebElement? = null

    @FindBy(name = "uid")
    @CacheLookup
    private val FLD_USERID: WebElement? = null

    @FindBy(name = "password")
    @CacheLookup
    public val FLD_PASS: WebElement? = null

    @FindBy(name = "btnLogin")
    @CacheLookup
    private val BTN_LOGIN: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun logIn(userid: String, password: String) {
        FLD_USERID?.clear()
        FLD_USERID?.sendKeys(userid)
        FLD_PASS?.clear()
        FLD_PASS?.sendKeys(password)
        BTN_LOGIN?.click()
    }

    fun isPageOpened(): Boolean{
        return TXT_TITLE?.text.toString().contains("Guru99 Bank")
    }
}