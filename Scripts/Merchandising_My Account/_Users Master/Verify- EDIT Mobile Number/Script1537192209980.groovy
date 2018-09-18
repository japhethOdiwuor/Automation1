import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

WebUI.clearText(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Mobile Number'))

int n = rnd.nextInt(798765400) + 790000000

WebUI.setText(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Mobile Number'), ('+254'+ n))

WebUI.sendKeys(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Max Number Logins'), Keys.chord(Keys.NUMPAD5))

WebUI.clearText(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Payroll Number'))

WebUI.setText(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Payroll Number'), 'DukaTest--' + n)

WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'Save']))

WebUI.delay(2)

Message_AfterSaving = WebUI.getText(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/PopUp-Save Message'))

if (Message_AfterSaving.contains('Success')) {
	log.logWarning('Displayed Message = ' + Message_AfterSaving)

	log.logWarning('PASSED: Mobile Number Edited and Saved Successfully')
} else {
	log.logError('Displayed Message = ' + Message_AfterSaving)

	log.logError('ERROR: failed to Save Edited Mobile Number')

	KeywordUtil.markError('ERROR while Saving edited mobile Number')
}

MobileNumber_AfterEdit = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Mobile Number'),
		'value')

WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'List']))

WebUI.delay(2)

tableResult_EditedMobileNumber = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : Edit_User_ROW
	, ('col') : '5']))

if (tableResult_EditedMobileNumber == MobileNumber_AfterEdit) {
	log.logWarning((('tableResult MobileNumber = ' + tableResult_EditedMobileNumber) + ' | MobileNumber set during Edit = ') +
			MobileNumber_AfterEdit)

	log.logWarning('Successfully EDITED Mobile Number')
} else {
	log.logError((('tableResult Mobile Number = ' + tableResult_EditedMobileNumber) + ' | MobileNumber set during Edit = ') +
			MobileNumber_AfterEdit)

	log.logError('ERROR Encountered while EDITING Mobile Number')

	KeywordUtil.markError('Mobile Number Editing Failed')
}



