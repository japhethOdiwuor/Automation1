import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordLogger log = new KeywordLogger()

WebUI.delay(2)

WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'Inactive']))

WebUI.delay(2)

WebDriver driver = DriverFactory.getWebDriver()

'To locate table on Roles Master Page'
WebElement Table = driver.findElement(By.xpath('//*/div[@class="col-sm-12"]//table'))

'Locate all rows available in roles master page'
List<WebElement> rows = Table.findElements(By.xpath('//*/div[@class="col-sm-12"]//table/tbody/tr/td[4]/button[3]'))

def TotalRows = rows.size()

if (TotalRows >= 2) {
    roleName_InActive = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '2', ('col') : '2']))

    log.logWarning('The Role Name selected before Bulk Activation = ' + roleName_InActive)

    WebUI.click(findTestObject('Merchandising/_My Account/table- Check All'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Merchandising/_My Account/dropdown- Bulk Action'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Merchandising/_My Account/dropdown- Select- Bulk Action', [('BulkAction') : 'Activate']))

    WebUI.click(findTestObject('Merchandising/_My Account/btn- Apply'))

    WebUI.delay(2)

    if (WebUI.verifyElementPresent(findTestObject('Merchandising/_My Account/element- PopUp'), 5, FailureHandling.OPTIONAL)) {
        log.logWarning('PopUp Successfully Displayed For Attempted Activation')
    } else {
        log.logError('No POPUP is displayed when one propmpts for Activation')
    }
    
    WebUI.click(findTestObject('Merchandising/_My Account/element- PopUp- btn Select', [('SelectAction') : 'No']))

    WebUI.delay(1)

    if (WebUI.verifyTextPresent(roleName_InActive, false, FailureHandling.OPTIONAL)) {
        log.logWarning('Success: Bulk Activation cancelled by Selecting NO on PopUp')
    } else {
        log.logError('FAILED: Bulk Activation Still Executed even upon selecting NO on PopUp')

        KeywordUtil.markFailed('Selecting NO on PopUp for Bulk Activation Failed')
    }
    
    WebUI.click(findTestObject('Merchandising/_My Account/btn- Apply'))

    WebUI.delay(1)
	
	log.logWarning("--Proceeding to Test Role Activation by Selecting YES on PopUp")
	
	
    WebUI.click(findTestObject('Merchandising/_My Account/element- PopUp- btn Select', [('SelectAction') : 'Yes']))

    Messsage_PopUp = WebUI.getText(findTestObject('Merchandising/_My Account/PopUp- Acti_DeActi(vation) Message'))

    if (Messsage_PopUp.contains('Success')) {
        log.logWarning('Message on Activation = | ' + Messsage_PopUp)

        log.logWarning('Successfully Performed Bulk Activation Action')
    } else {
        log.logError('popUp Message = ' + Messsage_PopUp)

        log.logError('FAILED To Perform Bulk Activation')
    }
    
    WebUI.setText(findTestObject('Merchandising/_My Account/input- Search'), roleName_InActive)

    WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

    WebUI.delay(2)

    if (WebUI.verifyElementNotPresent(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1', ('col') : '2']), 
        5, FailureHandling.OPTIONAL)) {
        log.logWarning('Successfully Verified Previously Seected Role No Longer InActive')
    } else {
        log.logError('FAILED to Activate Role')

        KeywordUtil.markError('There was an ERROR encountered while Activating')
    }
    
    WebUI.clearText(findTestObject('Merchandising/_My Account/input- Search'))

    WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))
} else {
    log.logWarning('Nothing to Activate as Not enough Inactive roles present to perform Bulk Activation')
}