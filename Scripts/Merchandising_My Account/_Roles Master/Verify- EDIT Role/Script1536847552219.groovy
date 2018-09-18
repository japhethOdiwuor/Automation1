import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

KeywordLogger log = new KeywordLogger()

Random rnd = new Random()

WebUI.delay(1)

WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'All']))

WebUI.delay(2)

table_RoleName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '3', ('col') : '2']))

WebUI.click(findTestObject('Merchandising/_My Account/table- Action Buttons', [('Action') : 'Edit', ('row') : '3']))

WebUI.delay(2)

EditPage_RoleName = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/input- Role Name'), 
    'value')

if (table_RoleName == EditPage_RoleName) {
    log.logWarning((('RoleName Selected from Listing Page = ' + table_RoleName) + ' | RoleName from EDIT Page = ') + EditPage_RoleName)

    log.logWarning('Successfuly Verified Edit Button Links to Editing Page for Role Name selected')
} else {
    log.logError((('RoleName Selected from Listing Page = ' + table_RoleName) + ' | RoleName from EDIT Page = ') + EditPage_RoleName)

    log.logError('EDIT Button NOT WOrking as Expected')

    KeywordUtil.markError('Role Names NOT Matching')
}

WebUI.clearText(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/input- Role Name'))

int n = rnd.nextInt(50) + 1

WebUI.setText(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/input- Role Name'), ("Test Edit Role" + 
    '--') + n)

WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'Save']))

WebUI.delay(2)

Message_AfterSaving = WebUI.getText(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/PopUp-Save Message'))

if (Message_AfterSaving.contains('Success')) {
    log.logWarning('Displayed Message = ' + Message_AfterSaving)

    log.logWarning('PASSED: Role Edited and Saved Successfully')
} else {
    log.logError('Displayed Message = ' + Message_AfterSaving)

    log.logError('ERROR: failed to Save Edited Role')

    KeywordUtil.markError('ERROR while Saving edited Role Name')
}

RoleName_AfterEdit = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/input- Role Name'),
	'value')

WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'List']))

WebUI.delay(1)

WebUI.setText(findTestObject('Merchandising/_My Account/input- Search'), RoleName_AfterEdit)

WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

WebUI.delay(2)

table_Result_EditedRoleName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1'
            , ('col') : '2']))

if (table_Result_EditedRoleName.equalsIgnoreCase(RoleName_AfterEdit)) {
    log.logWarning('tableResult RoleName after Search = ' + table_Result_EditedRoleName + ' | RoleName set during Edit = ' + RoleName_AfterEdit)

    log.logWarning('Successfully EDITED RoleName')
} else {
    log.logError('tableResult RoleName after Search = ' + table_Result_EditedRoleName + ' | RoleName set during Edit = ' + RoleName_AfterEdit)

    log.logError('ERROR Encountered while EDITING Role Name')
}

WebUI.clearText(findTestObject('Merchandising/_My Account/input- Search'))

WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

