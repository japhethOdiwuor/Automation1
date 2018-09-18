import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordLogger log = new KeywordLogger()

WebUI.delay(1)

tabOptions = ['All', 'Active', 'Inactive']

for (tabOptionsLoop = 0; tabOptionsLoop < tabOptions.size(); tabOptionsLoop++) {
    log.logWarning(('===Executing for Tab Filter Option = ' + (tabOptions[tabOptionsLoop])) + '===')

    WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : tabOptions[tabOptionsLoop]]))

    WebDriver driver = DriverFactory.getWebDriver()

    WebUI.delay(2)

    'To locate table header on User Master Page'
    WebElement Table = driver.findElement(By.xpath('//table/thead/tr'))

    'Locate all columns available on the table header'
    List<WebElement> columns = Table.findElements(By.xpath('//table/thead/tr/th'))

    def TotalColumns = columns.size()

    //log.logWarning('total columns= ' + TotalColumns)
    Expected_Headers = ['Username', 'Full Name', 'E-Mail', 'Mobile Number', 'Active', 'Actions']

    for (cols = 2; cols <= TotalColumns; cols++) {
        ColumnName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Header', [('col') : cols]))

        //log.logWarning(((('Column (' + cols) + ')') + ' is Named -> ') + ColumnName)

        if (((((ColumnName.contains('Username') || ColumnName.contains('Full Name')) || ColumnName.contains('E-Mail')) || 
        ColumnName.contains('Mobile Number')) || ColumnName.contains('Active')) || ColumnName.contains('Actions')) {
            log.logWarning((('Verified ColumnName ``' + ColumnName) + '`` | Against Expected Headers') + Expected_Headers)
        } else {
            log.logError('FAILED to verify Existing column Name against expected Headers')

            KeywordUtil.markError('A column exists that is not Expected')
        }
    }
}