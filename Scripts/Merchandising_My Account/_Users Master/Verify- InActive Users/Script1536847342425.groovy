import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordLogger log = new KeywordLogger()

WebUI.delay(2)

'Click on InActive tab selection'
WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'Inactive']))

WebUI.delay(2)

WebDriver driver = DriverFactory.getWebDriver()

'To locate table on User Master Page'
WebElement Table = driver.findElement(By.xpath('//*/div[@class="col-sm-12"]//table'))

'Locate all rows available on user master page'
List<WebElement> rows = Table.findElements(By.xpath('//*/div[@class="col-sm-12"]//table/tbody/tr/td[4]/button[3]'))

def TotalRows = rows.size()

if (TotalRows >= 1) {
    for (int i = 0; i < rows.size(); i++) {
        columntext = rows.get(i).getText().toString()

        expectedText = 'Activate'

        if (columntext != expectedText) {
            log.logError((((('text on column ' + i) + ' = ') + columntext) + ' | Expected Text->') + expectedText)

            KeywordUtil.markError('there is erroneous DATA present on page')
        } else {
            log.logWarning((((('PASSED : text on column ' + i) + ' = ') + columntext) + 'Matches Expected text->') + expectedText)
        }
    }
} else {
    log.logWarning('Nothing to verify as there are currently no InActive Users')
}

