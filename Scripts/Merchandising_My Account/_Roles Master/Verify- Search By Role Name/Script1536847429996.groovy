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

WebDriver driver = DriverFactory.getWebDriver()

'Click on ALL tab selection'
log.logWarning('-> executing for ALL filter Tab')

WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'All']))

WebUI.delay(2)

'To locate table on Roles Master Page'
WebElement Table = driver.findElement(By.xpath('//*/div[@class="col-sm-12"]//table'))

'Locate all rows available in roles master page'
List<WebElement> rows = Table.findElements(By.xpath('//*/div[@class="col-sm-12"]//table/tbody/tr'))

def TotalRows = rows.size()

if (TotalRows > 1) {
    log.logWarning('get roleName frm Table Row 3, Set it as search Input & verify tableResult on Row 1 after search')

    selected_RoleName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '3', ('col') : '2']))

    WebUI.setText(findTestObject('Merchandising/_My Account/input- Search'), selected_RoleName)

    WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

    WebUI.delay(2)

    tableResult_RoleName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1', ('col') : '2']))

    if (selected_RoleName == tableResult_RoleName) {
        log.logWarning('RoleName selected from table Row 3 = ' + selected_RoleName)

        log.logWarning('tableResult RoleName Row 1 after search = ' + tableResult_RoleName)

        log.logWarning('TEST for Search on ALL Roles Filter Page PASSED')
    } else {
        log.logError((('Selected RoleName table Row 3 = ' + selected_RoleName) + ' | tableResult RoleName Row 1 = ') + tableResult_RoleName)

        KeywordUtil.markError('Search on ALL Filter page Failed-Result NOT Matching selected Role')
    }
} else {
    log.logWarning(' Nothing to verify as there are currently no Created Roles')
}

WebUI.clearText(findTestObject('Merchandising/_My Account/input- Search'))

WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

WebUI.delay(2)

'Click on Active tab selection'
log.logWarning('-> Executing for ACTIVE filter Tab')

WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'Active']))

WebUI.delay(2)

'To locate table on Roles Master Page'
WebElement Table2 = driver.findElement(By.xpath('//*/div[@class="col-sm-12"]//table'))

'Locate all rows available in roles master page'
List<WebElement> rows2 = Table2.findElements(By.xpath('//*/div[@class="col-sm-12"]//table/tbody/tr'))

def TotalRows2 = rows2.size()

if (TotalRows2 > 1) {
    log.logWarning('get roleName frm Table Row 3, Set it as search Input & verify tableResult on Row 1 after search')

    selected_RoleName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '3', ('col') : '2']))

    WebUI.setText(findTestObject('Merchandising/_My Account/input- Search'), selected_RoleName)

    WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

    WebUI.delay(2)

    tableResult_RoleName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1', ('col') : '2']))

    if (selected_RoleName == tableResult_RoleName) {
        log.logWarning('RoleName selected from table Row 3 = ' + selected_RoleName)

        log.logWarning('tableResult RoleName Row 1 after search = ' + tableResult_RoleName)

        log.logWarning('TEST for Search on ACTIVE Roles Filter Page PASSED')
    } else {
        log.logError((('Selected RoleName table Row 3 = ' + selected_RoleName) + ' | tableResult RoleName Row 1 = ') + tableResult_RoleName)

        KeywordUtil.markError('Search on ACTIVE Filter page Failed-Result NOT Matching selected Role')
    }
} else {
    log.logWarning(' Nothing to verify as there are currently no Active Roles')
}

WebUI.clearText(findTestObject('Merchandising/_My Account/input- Search'))

WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

WebUI.delay(2)

'Click on IN-Active tab selection'
log.logWarning('-> executing for IN-ACTIVE filter Tab')

WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'Inactive']))

WebUI.delay(2)

'To locate table on Roles Master Page'
WebElement Table3 = driver.findElement(By.xpath('//*/div[@class="col-sm-12"]//table'))

'Locate all rows available in roles master page'
List<WebElement> rows3 = Table3.findElements(By.xpath('//*/div[@class="col-sm-12"]//table/tbody/tr'))

def TotalRows3 = rows3.size()

if (TotalRows3 > 1) {
    log.logWarning('get roleName frm Table Row 2, Set it as search Input & verify tableResult on Row 1 after search')

    selected_RoleName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '2', ('col') : '2']))

    WebUI.setText(findTestObject('Merchandising/_My Account/input- Search'), selected_RoleName)

    WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

    WebUI.delay(2)

    tableResult_RoleName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1', ('col') : '2']))

    if (selected_RoleName == tableResult_RoleName) {
        log.logWarning('RoleName selected from table Row 3 = ' + selected_RoleName)

        log.logWarning('tableResult RoleName Row 1 after search = ' + tableResult_RoleName)

        log.logWarning('TEST for Search on IN-ACTIVE Roles Filter Page PASSED')
    } else {
        log.logError((('Selected RoleName table Row 3 = ' + selected_RoleName) + ' | tableResult RoleName Row 1 = ') + tableResult_RoleName)

        KeywordUtil.markError('Search on ACTIVE Filter page Failed-Result NOT Matching selected Role')
    }
} else {
    log.logWarning(' Nothing to verify as there are currently no IN-Active Roles')
}

WebUI.clearText(findTestObject('Merchandising/_My Account/input- Search'))

WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

