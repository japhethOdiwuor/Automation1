import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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

WebUI.click(findTestObject('Merchandising/_My Account/dropdown- Order By'))

WebUI.delay(1)

WebUI.click(findTestObject('Merchandising/_My Account/dropdown- Select- Order By Option', [('orderby') : orderBy]))

WebUI.delay(2)

WebUI.click(findTestObject('Merchandising/_My Account/span- Asc_Desc(ending)'))

WebUI.delay(2)

FirstSort_FullName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1', ('col') : '3']))

WebUI.click(findTestObject('Merchandising/_My Account/span- Asc_Desc(ending)'))

WebUI.delay(2)

SecondSort_FullName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1', ('col') : '3']))

if (FirstSort_FullName == SecondSort_FullName) {
    log.logError((('Full Name on 1st Sort ->' + FirstSort_FullName) + ' | Full Name on 2nd Sort ->') + SecondSort_FullName)

    log.logError(('Order by |``' + orderBy) + '``| Not Working')

    KeywordUtil.markError('Order By Ascending and Descending Order for full names NOT WORKING')
} else {
    log.logWarning((('Full Name on 1st Sort ->' + FirstSort_FullName) + ' | Full Name on 2nd Sort ->') + SecondSort_FullName)

    log.logWarning(('Verified: Order by ``|' + orderBy) + '|`` Successfull')
}

