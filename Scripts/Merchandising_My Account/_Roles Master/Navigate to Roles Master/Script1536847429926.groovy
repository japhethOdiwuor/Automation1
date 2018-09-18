import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

KeywordLogger log = new KeywordLogger()

WebUI.delay(2)

WebUI.click(findTestObject('Landing Page/tab- Dash Options', [('DashOption') : 'My Account']))

WebUI.delay(2)

not_run: WebUI.click(findTestObject('Landing Page/link- Screen Option', [('ScreenOption') : 'My Account']))

WebUI.delay(2)

WebUI.click(findTestObject('Merchandising/_My Account/span- Page', [('PageName') : 'Roles']))

WebUI.delay(2)

log.logWarning('Navigating to Role Master')

pageText = WebUI.getText(findTestObject('Merchandising/_My Account/text- Roles Master'))

if (pageText.contains('roles')) {
    log.logWarning('Page text present on Roles Master = ' + pageText)
} else {
    log.logWarning('Failed to Load Roles Master')
}

WebUI.delay(1)

