import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordLogger log = new KeywordLogger()

WebUI.scrollToElement(findTestObject('Landing Page/tab- Dash Options', [('DashOption') : 'My Learning Modules']), 5)

WebUI.delay(2)

WebUI.click(findTestObject('Landing Page/tab- Dash Options', [('DashOption') : 'My Learning Modules']))

WebUI.delay(2)

if (WebUI.verifyTextPresent('Active', false, FailureHandling.OPTIONAL)) {
    log.logWarning('Successfully Navigated To My Learning Modules Screen')

    WebUI.click(findTestObject('Landing Page/link- Screen Option', [('ScreenOption') : 'Dashboard']))

    WebUI.delay(2)
} else {
    log.logError('FAILED! My Learning Modules not linking to its Set Screen')

    KeywordUtil.markError('ERROR while Navigating to My Learning Modules')
}

