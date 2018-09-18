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

FullName_Search_Input = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('col') : '3', ('row') : row_get_UserName]))

WebUI.delay(2)

WebUI.setText(findTestObject('Merchandising/_My Account/input- Search'), FullName_Search_Input)

WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

WebUI.delay(2)

tableResult_FullName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1', ('col') : '3']))

if (FullName_Search_Input == tableResult_FullName) {
    log.logWarning('Full Name used in Search Input = ' + FullName_Search_Input)

    log.logWarning('table_Result for Full Name = ' + tableResult_FullName)

    log.logWarning('Successfully Verified Search by FULL NAME')
} else {
    log.logError((('Full Name used in Search Input = ' + FullName_Search_Input) + ' | table_Result for Full Name = ') + 
        tableResult_FullName)

    KeywordUtil.markFailed('Failed to verify search by full name')
}

WebUI.clearText(findTestObject('Merchandising/_My Account/input- Search'))

WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

