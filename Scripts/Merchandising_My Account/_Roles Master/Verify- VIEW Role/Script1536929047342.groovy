import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordLogger log = new KeywordLogger()

WebUI.delay(1)

WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'All']))

WebUI.delay(2)

table_RoleName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '3', ('col') : '2']))

WebUI.click(findTestObject('Merchandising/_My Account/table- Action Buttons', [('Action') : 'View', ('row') : '3']))

WebUI.delay(2)

ViewPage_RoleName = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/input- Role Name'),
		'value')

if (table_RoleName == ViewPage_RoleName) {
	log.logWarning((('RoleName Selected from Listing Page = ' + table_RoleName) + ' | RoleName from VIEW Page = ') + ViewPage_RoleName)

	log.logWarning('Successfuly Verified VIEW Button Links to VIEW Page for Selected Role Name')
} else {
	log.logError((('RoleName Selected from Listing Page = ' + table_RoleName) + ' | RoleName from VIEW Page = ') + ViewPage_RoleName)

	log.logError('VIEW Button NOT WOrking as Expected')

	KeywordUtil.markError('Role Names NOT Matching')
}

if (WebUI.verifyElementNotClickable(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/input- Role Name'),
FailureHandling.OPTIONAL)) {
	log.logWarning('Successfully Verified Field cannot Be Edited In VIEW Mode')
} else {
	log.logError('FAILED: Field Editable in VIEW Mode')

	KeywordUtil.markError('Role Name NOT Locked for EDIT')
}

WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'List']))

if (WebUI.verifyElementNotVisibleInViewport(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New',
[('Action') : 'Reset']), 5, FailureHandling.OPTIONAL) && WebUI.verifyElementNotVisibleInViewport(findTestObject(
'Merchandising/_My Account/_EDIT- VIEW- NEW Roles/btn- List_Reset_Save', [('Action') : 'Save']), 5, FailureHandling.OPTIONAL)) {
	log.logWarning('On VIEW Page Only ``LIST`` Action Button is Available')
} else {
	log.logError('SAVE &/or RESET Button(s) Available')

	KeywordUtil.markError('UN-USABLE Action Button(s) Available on Page')
}


if (WebUI.verifyElementVisibleInViewport(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New',
[('Action') : 'New']), 5, FailureHandling.OPTIONAL)) {
	log.logWarning("List Button Navigates user Back to Listing Page")
}

else{
	log.logError("LIST button NOT Working")
	KeywordUtil.markError("FAILED to navigate back to Listing Page")
}