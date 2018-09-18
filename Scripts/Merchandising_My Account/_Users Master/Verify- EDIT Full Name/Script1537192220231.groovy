import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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
import org.openqa.selenium.Keys as Keys

KeywordLogger log = new KeywordLogger()

Random rnd = new Random()

WebUI.delay(1)

WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'All']))

WebUI.delay(2)

table_FullName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : Edit_User_ROW, ('col') : '3']))

table_Email = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : Edit_User_ROW, ('col') : '4']))

table_MobileNumber = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : Edit_User_ROW
            , ('col') : '5']))

WebUI.click(findTestObject('Merchandising/_My Account/table- Action Buttons', [('Action') : 'Edit', ('row') : Edit_User_ROW]))

WebUI.delay(2)

EditPage_FullName = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Full Name'), 
    'value')

EditPage_Email = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Email'), 'value')

EditPage_MobileNumber = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Mobile Number'), 
    'value')

EditPage_MaxLogins = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Max Number Logins'), 
    'value')

if (((table_FullName == EditPage_FullName) && (table_Email == EditPage_Email)) && (table_MobileNumber == EditPage_MobileNumber)) {
    log.logWarning((('FullName Selected from Listing Page = ' + table_FullName) + ' | FullName from EDIT Page = ') + EditPage_FullName)

    log.logWarning((('Email Selected from Listing Page = ' + table_Email) + ' | Email from EDIT Page = ') + EditPage_Email)

    log.logWarning((('Mobile Number Selected from Listing Page = ' + table_MobileNumber) + ' | Mobile Number from EDIT Page = ') + 
        EditPage_MobileNumber)

    log.logWarning('Successfully Verified Values from Listing Page matches values from Edit Page')
} else {
    log.logError((('FullName Selected from Listing Page = ' + table_FullName) + ' | FullName from EDIT Page = ') + EditPage_FullName)

    log.logError((('Email Selected from Listing Page = ' + table_Email) + ' | Email from EDIT Page = ') + EditPage_Email)

    log.logError((('Mobile Number Selected from Listing Page = ' + table_MobileNumber) + ' | Mobile Number from EDIT Page = ') + 
        EditPage_MobileNumber)

    KeywordUtil.markError('DATA value(s) NOT Matching after comparisson')
}

log.logWarning('Maximum Logins for User = ' + EditPage_MaxLogins)

WebUI.clearText(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Full Name'))

int n = rnd.nextInt(50) + 1

WebUI.setText(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Full Name'), ('Test Create User' + 
    '--') + n)

WebUI.sendKeys(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Max Number Logins'), Keys.chord(Keys.NUMPAD5))

WebUI.clearText(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Payroll Number'))

WebUI.setText(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Payroll Number'), 'DukaTest--' + n)

WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'Save']))

WebUI.delay(2)

Message_AfterSaving = WebUI.getText(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/PopUp-Save Message'))

if (Message_AfterSaving.contains('Success')) {
    log.logWarning('Displayed Message = ' + Message_AfterSaving)

    log.logWarning('PASSED: User Edited and Saved Successfully')
} else {
    log.logError('Displayed Message = ' + Message_AfterSaving)

    log.logError('ERROR: failed to Save Edited User')

    KeywordUtil.markError('ERROR while Saving edited User Name')
}

FullName_AfterEdit = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Full Name'), 
    'value')

WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'List']))

WebUI.delay(1)

WebUI.setText(findTestObject('Merchandising/_My Account/input- Search'), FullName_AfterEdit)

WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

WebUI.delay(2)

table_Result_EditedFullName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1'
            , ('col') : '3']))

if (table_Result_EditedFullName == FullName_AfterEdit) {
    log.logWarning((('tableResult FullName after Search = ' + table_Result_EditedFullName) + ' | FullName set during Edit = ') + 
        FullName_AfterEdit)

    log.logWarning('Successfully EDITED FullName')
} else {
    log.logError((('tableResult FullName after Search = ' + table_Result_EditedFullName) + ' | FullName set during Edit = ') + 
        FullName_AfterEdit)

    log.logError('ERROR Encountered while EDITING Full Name')
	KeywordUtil.markError("Full Name Editing Failed")
}

WebUI.clearText(findTestObject('Merchandising/_My Account/input- Search'))

WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

