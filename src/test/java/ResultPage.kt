import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.testng.Assert


class ResultPage(private val driver: WebDriver) {

    @FindBy(css = ".heading3>td")
    private var TXT_ID: WebElement? = null

    // primary contructor
    init {
        PageFactory.initElements(driver, this)
    }

    fun isManagerIDDisplayed() {
        var text = TXT_ID?.getText()
        var part = text?.split(":".toRegex())?.dropLastWhile { it.isEmpty() }?.toTypedArray()
        var dynamicText = part!![1]
        Assert.assertTrue(dynamicText.substring(1, 5) == "mngr")
        val remain = dynamicText.substring(dynamicText.length - 4)
        Assert.assertTrue(remain.matches("[0-9]+".toRegex()))
    }
}
