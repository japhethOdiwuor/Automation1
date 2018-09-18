import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordLogger log = new KeywordLogger()

WebUI.delay(2)

WebUI.click(findTestObject('Login_Logout/btn- LogOut'))

WebUI.delay(2)

if (WebUI.verifyTextPresent('Sign in to Continue', false, FailureHandling.OPTIONAL)) {
    log.logWarning('Successfully Logged Out of Application')
} else {
    log.logError('FAILED to Log User Out of WebApp')
}

