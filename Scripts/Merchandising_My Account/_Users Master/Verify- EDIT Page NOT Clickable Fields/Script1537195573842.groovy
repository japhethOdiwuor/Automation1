import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

KeywordLogger log = new KeywordLogger()

WebUI.delay(1)

WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'All']))

WebUI.delay(2)

WebUI.click(findTestObject('Merchandising/_My Account/table- Action Buttons', [('Action') : 'Edit', ('row') : Edit_User_ROW]))

WebUI.delay(2)

log.logWarning('==Verify- Input Fields in EDIT Page are Locked and Do Not allow for Editing ==')

if (WebUI.verifyElementNotClickable(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Domain'), FailureHandling.OPTIONAL)
) {
    log.logWarning('``Domain`` field is NOT Clickable')
} else {
    log.logError('``Domain`` field is Clickable')
}

if (WebUI.verifyElementNotClickable(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Password'),
	FailureHandling.OPTIONAL)) {
	log.logWarning('``Password`` field is NOT Clickable')
} else {
	log.logError('``Password`` field is Clickable')
}

if (WebUI.verifyElementNotClickable(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Confirm Password'), 
    FailureHandling.OPTIONAL)) {
    log.logWarning('``Confirm Password`` field is NOT Clickable')
} else {
    log.logError('``Confirm Password`` field is Clickable')
}

WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'List']))


