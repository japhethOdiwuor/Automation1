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

Email_Search_Input = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('col') : '4', ('row') : row_get_Email]))

WebUI.delay(2)

WebUI.setText(findTestObject('Merchandising/_My Account/input- Search'), Email_Search_Input)

WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

WebUI.delay(2)

tableResult_Email = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1', ('col') : '4']))

if (Email_Search_Input == tableResult_Email) {
    log.logWarning('Email used in Search Input = ' + Email_Search_Input)

    log.logWarning('table_Result for Email = ' + tableResult_Email)

    log.logWarning('Successfully Verified Search by EMAIL')
} else {
    log.logError((('Email used in Search Input = ' + Email_Search_Input) + ' | table_Result for Email = ') + 
        tableResult_Email)

    KeywordUtil.markFailed('Failed to verify search by Email')
}

WebUI.clearText(findTestObject('Merchandising/_My Account/input- Search'))

WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

