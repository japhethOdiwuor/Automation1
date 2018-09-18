import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordLogger log = new KeywordLogger()

WebUI.delay(1)

WebUI.click(findTestObject('Merchandising/_My Account/label- tabs -(All_Active_Inactive)', [('label') : 'All']))

WebUI.delay(2)

table_FullName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : VIEW_User_ROW, ('col') : '3']))

table_Email = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : VIEW_User_ROW, ('col') : '4']))

table_MobileNumber = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : VIEW_User_ROW
            , ('col') : '5']))

WebUI.click(findTestObject('Merchandising/_My Account/table- Action Buttons', [('Action') : 'View', ('row') : VIEW_User_ROW]))

WebUI.delay(2)

ViewPage_FullName = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Full Name'), 
    'value')

ViewPage_Email = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Email'), 'value')

ViewPage_MobileNumber = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Users_EDIT- VIEW- NEW/input- Mobile Number'), 
    'value')

if (((table_FullName == ViewPage_FullName) && (table_Email == ViewPage_Email)) && (table_MobileNumber == ViewPage_MobileNumber)) {
    log.logWarning((('FullName Selected from Listing Page = ' + table_FullName) + ' | FullName from EDIT Page = ') + ViewPage_FullName)

    log.logWarning((('Email Selected from Listing Page = ' + table_Email) + ' | Email from EDIT Page = ') + ViewPage_Email)

    log.logWarning((('Mobile Number Selected from Listing Page = ' + table_MobileNumber) + ' | Mobile Number from EDIT Page = ') + 
        ViewPage_MobileNumber)

    log.logWarning('Successfully Verified Values from Listing Page matches values from Edit Page')
} else {
    log.logError((('FullName Selected from Listing Page = ' + table_FullName) + ' | FullName from EDIT Page = ') + ViewPage_FullName)

    log.logError((('Email Selected from Listing Page = ' + table_Email) + ' | Email from EDIT Page = ') + ViewPage_Email)

    log.logError((('Mobile Number Selected from Listing Page = ' + table_MobileNumber) + ' | Mobile Number from EDIT Page = ') + 
        ViewPage_MobileNumber)

    KeywordUtil.markError('DATA value(s) NOT Matching after comparisson')
}

if (WebUI.verifyElementNotInViewport(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', 
        [('Action') : 'Reset']), 5, FailureHandling.OPTIONAL) && WebUI.verifyElementNotInViewport(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', 
        [('Action') : 'Save']), 5, FailureHandling.OPTIONAL)) {
    log.logWarning('Successfully Verified RESET and SAVE buttons are Not Visible in VIEW Page')
} else {
    log.logError('RESET and SAVE buttons are Not Visible in VIEW Page')

    KeywordUtil.markError('Buttons expected to be Hidden are VISIBLE')
}

WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'List']))

if (WebUI.verifyElementVisibleInViewport(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', 
        [('Action') : 'New']), 5, FailureHandling.OPTIONAL)) {
    log.logWarning('List Button Navigates user Back to Listing Page')
} else {
    log.logError('LIST button NOT Working')

    KeywordUtil.markError('FAILED to navigate back to Listing Page')
}

