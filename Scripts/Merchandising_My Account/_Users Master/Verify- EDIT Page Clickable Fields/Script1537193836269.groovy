import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordLogger log = new KeywordLogger()

WebUI.delay(1)

WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'All']))

WebUI.delay(2)

WebUI.click(findTestObject('Merchandising/_My Account/table- Action Buttons', [('Action') : 'Edit', ('row') : Edit_User_ROW]))

WebUI.delay(2)
if (WebUI.verifyElementClickable(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- UserName'), FailureHandling.OPTIONAL)
) {
	log.logWarning("``User Name`` field is Clickable")
}

else{
	log.logError("``User Name`` field NOT Clickable")
}

if (WebUI.verifyElementClickable(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Max Number Logins'),
FailureHandling.OPTIONAL)) {
	log.logWarning("``Max Number of Logins`` field is Clickable")
}

else{
	log.logError("``Max Number of Logins`` field NOT Clickable")
}

if (WebUI.verifyElementClickable(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Full Name'), FailureHandling.OPTIONAL)
) {
	log.logWarning("``Full Name`` field is Clickable")
}

else{
	log.logError("``Full Name`` field NOT Clickable")
}

if (WebUI.verifyElementClickable(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Payroll Number'), FailureHandling.OPTIONAL)
) {
	log.logWarning("``Payroll Number`` field is Clickable")
}

else{
	log.logError("``Payroll Number`` field NOT Clickable")
}

if (WebUI.verifyElementClickable(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Email'), FailureHandling.OPTIONAL)
) {
	log.logWarning("``Email`` field is Clickable")
}

else{
	log.logError("``Email`` field NOT Clickable")
}

if (WebUI.verifyElementClickable(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Mobile Number'), FailureHandling.OPTIONAL)
) {
	log.logWarning("``Mobile Number`` field is Clickable")
}

else{
	log.logError("``Mobile Number`` field NOT Clickable")
}

if (WebUI.verifyElementClickable(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/dropdown- Default Module'),
FailureHandling.OPTIONAL)) {
	log.logWarning("``Default Module`` field is Clickable")
}

else{
	log.logError("``Default Module`` field NOT Clickable")
}

if (WebUI.verifyElementClickable(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/dropdown- Default Language'),
FailureHandling.OPTIONAL)) {
	log.logWarning("``Default Language`` field is Clickable")
}

else{
	log.logError("``Default Language`` field NOT Clickable")
}

if (WebUI.verifyElementClickable(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/checkbox- Change Password'),
FailureHandling.OPTIONAL)) {
	log.logWarning("``Change Password`` Checkbox is Clickable")
}
else{
	log.logError("FAILED:``Change Password`` Checkbox NOT Clickable ")
}

WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'List']))

