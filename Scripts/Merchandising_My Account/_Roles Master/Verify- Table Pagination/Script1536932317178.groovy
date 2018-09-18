import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

KeywordLogger log = new KeywordLogger()

WebUI.delay(2)

WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'All']))

WebUI.delay(2)

WebDriver driver = DriverFactory.getWebDriver()

'To locate pagination ribbon'
WebElement Pagination = driver.findElement(By.xpath('//*/div[@class="col-md-8"]/ul'))

'Locate number of elements present on pagination ribbon'
List<WebElement> pages = Pagination.findElements(By.xpath('//*/div[@class="col-md-8"]/ul/li/a'))

def TotalPages = pages.size()

def page1_roleName

def page2_roleName

page1_roleName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1', ('col') : '2']))

if (TotalPages > 5) {
    for (int i; i < pages.size(); i++) {
        pageNumbertext = pages.get(i).getText().toString()

        //log.logWarning('Pagination ribbon text Loop -> ' + i + " = "+pageNumbertext)
        if (pageNumbertext == '2') {
            pages.get(i).click()

            WebUI.delay(2)

            page2_roleName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1'
                        , ('col') : '2']))

            if (page1_roleName != page2_roleName) {
                log.logWarning((('Role Name-> Page 1 = ' + page1_roleName) + ' | & | Page 2 = ') + page2_roleName)

                log.logWarning('Success: Pagination to Page 2 Working')
            } else {
                log.logError('Table data for Role Name did Not Change upon Pagination to Page 2')

                KeywordUtil.markError('Pagination to page 2 NOT Working')
            }
        }
    }
} else {
    log.logWarning('Pagination Cannot be verified since currently only ONE Page of Data Available')
}

