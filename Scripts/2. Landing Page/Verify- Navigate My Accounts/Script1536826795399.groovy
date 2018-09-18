import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordLogger log = new KeywordLogger()

WebUI.click(findTestObject('Landing Page/tab- Dash Options', [('DashOption') : 'My Account']))

WebUI.delay(2)

if (WebUI.verifyElementNotPresent(findTestObject('Landing Page/tab- Dash Options', [('DashOption') : 'My Account']), 5, 
    FailureHandling.OPTIONAL)) {
    log.logWarning('Successfully Navigated To My Accounts Screen')

    WebUI.click(findTestObject('Landing Page/link- Screen Option', [('ScreenOption') : 'Dashboard']))

    WebUI.delay(2)
} else {
    log.logError('FAILED! My Account not linking to its Set Screen')

    KeywordUtil.markError('ERROR on Navigating My Account')
}

