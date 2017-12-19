import org.testng.Assert
import org.testng.annotations.Test

class TC_LogIn_Test() : TestBase() {

    @Test
    fun login() {
        val homePage = HomePage(driver)
        Assert.assertTrue(homePage.isPageOpened())
        homePage.logIn(UtilResources.getParam("username"), UtilResources.getParam("password"))

        val resultPage = ResultPage(driver)
        resultPage.isManagerIDDisplayed()
    }
}