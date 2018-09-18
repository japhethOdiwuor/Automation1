import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

KeywordLogger log = new KeywordLogger()

WebUI.openBrowser(GlobalVariable.baseURL)

log.logWarning('URL in Use: ' + GlobalVariable.baseURL)

WebUI.maximizeWindow()

WebUI.delay(1)

WebUI.setEncryptedText(findTestObject('Login_Logout/input- UserName'), 'jJhPGCM/67Sg2G4Sx+AWxR27dT0g3RIN')

WebUI.click(findTestObject('Login_Logout/btn- Next'))

WebUI.delay(2)

WebUI.setEncryptedText(findTestObject('Login_Logout/input- Password'), '4nvbrPglk7k=')

WebUI.click(findTestObject('Login_Logout/btn- Login'))

WebUI.delay(2)

if (WebUI.verifyTextNotPresent('Sign in to Continue', false, FailureHandling.OPTIONAL)) {
    log.logWarning('Successfully Loged Into WebApp')
} else {
    log.logError('FAILED to Log Into WebApp')
}

