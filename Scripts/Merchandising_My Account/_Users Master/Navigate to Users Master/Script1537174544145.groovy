import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordLogger log = new KeywordLogger()

WebUI.delay(2)

WebUI.click(findTestObject('Landing Page/tab- Dash Options', [('DashOption') : 'My Account']))

WebUI.delay(2)

not_run: WebUI.click(findTestObject('Landing Page/link- Screen Option', [('ScreenOption') : 'My Account']))

WebUI.delay(2)

WebUI.click(findTestObject('Merchandising/_My Account/span- Page', [('PageName') : 'Users']))

WebUI.delay(2)

log.logWarning('Navigating to USER Master')

pageText = WebUI.getText(findTestObject('Merchandising/_My Account/text- User Master'))

if (pageText.contains('manage the users')) {
    log.logWarning('Page text present on User Master = ' + pageText)
} else {
    log.logWarning('Failed to Load User Master')
}

WebUI.delay(1)

