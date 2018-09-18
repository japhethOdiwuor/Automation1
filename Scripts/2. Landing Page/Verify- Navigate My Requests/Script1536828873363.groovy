import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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

WebUI.scrollToElement(findTestObject('Landing Page/tab- Dash Options', [('DashOption') : 'My Requests']), 5)

WebUI.delay(2)

WebUI.click(findTestObject('Landing Page/tab- Dash Options', [('DashOption') : 'My Requests']))

WebUI.delay(2)

if (WebUI.verifyTextPresent('Request Details', false, FailureHandling.OPTIONAL)) {
    log.logWarning('Successfully Navigated To My Requests Screen')

    WebUI.click(findTestObject('Landing Page/link- Screen Option', [('ScreenOption') : 'Dashboard']))

    WebUI.delay(2)
} else {
    log.logError('FAILED! My Requests not linking to its Set Screen')

    KeywordUtil.markError('ERROR while Navigating to My Requests')
}

