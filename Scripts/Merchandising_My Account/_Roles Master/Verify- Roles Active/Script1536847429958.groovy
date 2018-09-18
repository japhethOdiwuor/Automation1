import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

KeywordLogger log = new KeywordLogger()

WebUI.delay(1)

'Click on Active tab selection'
WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'Active']))

WebUI.delay(2)

WebDriver driver = DriverFactory.getWebDriver()

'To locate table on Roles Master Page'
WebElement Table = driver.findElement(By.xpath('//*/div[@class="col-sm-12"]//table'))

'Locate all rows available in roles master page'
List<WebElement> rows = Table.findElements(By.xpath('//*/div[@class="col-sm-12"]//table/tbody/tr/td[4]/button[3]'))

def TotalRows = rows.size()

if (TotalRows >= 1) {
    for (int i = 0; i < rows.size(); i++) {
        columntext = rows.get(i).getText().toString()

        expectedText = 'Deactivate'

        if (columntext != expectedText) {
            log.logError((((('text on column ' + i) + ' = ') + columntext) + ' | Expected Text->') + expectedText)

            KeywordUtil.markError('Page contains erroneous DATA')
        } else {
            log.logWarning((((('PASSED : text on column ' + i) + ' = ') + columntext) + ' | Matches Expected text->') + expectedText)
        }
    }
} else {
    log.logWarning(' Nothing to verify as there are currently no Active Roles')
}

