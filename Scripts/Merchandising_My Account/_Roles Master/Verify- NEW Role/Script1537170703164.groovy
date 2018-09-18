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

Random rnd = new Random()

int n = rnd.nextInt(50) + 1

WebUI.delay(1)

WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'New']))

WebUI.delay(2)

if (WebUI.verifyTextPresent('Create New Role', false, FailureHandling.OPTIONAL)) {
    log.logWarning('Successfully Navigated to Create NEW ROLE Page')

    WebUI.setText(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/input- Role Name'), (Role_Name + '--') + 
        n)

    WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/dropdown- Module Name'))

    log.logWarning((('Role Name to be Created = ' + Role_Name) + '--') + n)

    WebUI.delay(1)

    WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/dropdown- Select- Module Name'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/Permission- Dash View'))

    WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'Reset']))

    log.logWarning('Resetting Page to Verify clearing of set Role')

    WebUI.delay(2)

    roleInput_Field = WebUI.getAttribute(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/input- Role Name'), 
        'value')

    if (((Role_Name + '--') + n) != roleInput_Field) {
        log.logWarning((((('Set Role BEFORE Resetting = ' + Role_Name) + '--') + n) + ' | Role AFTER Resetting = ') + roleInput_Field)

        log.logWarning('Successfully RESET Role Name field')

        WebUI.setText(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/input- Role Name'), (Role_Name + 
            '--') + n)
    } else {
        log.logError((((('Set Role BEFORE Resetting = ' + Role_Name) + '--') + n) + ' | Role AFTER Resetting = ') + roleInput_Field)
    }
    
    WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/dropdown- Module Name'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/dropdown- Select- Module Name'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/Permission- Dash View'))

    WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'Save']))

    WebUI.delay(2)

    message_After_Save = WebUI.getText(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/PopUp-Save Message'))

    if (message_After_Save.contains('Success')) {
        log.logWarning('Successfully Saved Newly Created Role')
    } else {
        log.logError('Failed to Save Newly Created Role')
    }
    
    WebUI.click(findTestObject('Merchandising/_My Account/_Roles_EDIT- VIEW- NEW/btn- List_Reset_Save_New', [('Action') : 'List']))

    WebUI.setText(findTestObject('Merchandising/_My Account/input- Search'), (Role_Name + '--') + n)

    WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

    WebUI.delay(2)

    tableResult_RoleName = WebUI.getText(findTestObject('Merchandising/_My Account/table- Verify Data', [('row') : '1', ('col') : '2']), 
        FailureHandling.STOP_ON_FAILURE)

    if (tableResult_RoleName == ((Role_Name + '--') + n)) {
        log.logWarning('Successfully Added Newly Created Role to List')
    } else {
        log.logError('Failed to ADD Newly Created Role to Existing List')

        KeywordUtil.markError('Created ROLE Not present on Available list')
    }
} else {
    log.logError('FAILED To Navigate to Create New Role Page')

    KeywordUtil.markError('NEW button Not Linking to Create NEW Role Page')
}

WebUI.clearText(findTestObject('Merchandising/_My Account/input- Search'))

WebUI.click(findTestObject('Merchandising/_My Account/btn- Search'))

