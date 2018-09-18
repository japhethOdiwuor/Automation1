import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordLogger log = new KeywordLogger()

WebUI.delay(4)

WebDriver driver = DriverFactory.getWebDriver()

'To locate screen section on merchandising page'
WebElement Pages = driver.findElement(By.xpath('//*/div/nav/ul'))

'Locate all screens available in merchandising page'
List<WebElement> screens = Pages.findElements(By.xpath('//*/div/nav/ul/li/a/span'))

def TotalScreens = screens.size()

log.logWarning('Screen Options Available =' + TotalScreens)

for (int i = 0; i < screens.size(); i++) {
    screentext = screens.get(i).getText().toString()

    log.logWarning((('Screen option ' + i) + ' = ') + screentext)
}