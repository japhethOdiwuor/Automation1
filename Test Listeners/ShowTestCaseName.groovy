import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

class ShowTestCaseName {

	KeywordLogger log = new KeywordLogger()
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		
		
		log.logWarning('--- Begin Test:= ' + testCaseContext.getTestCaseId() + ' ---')
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		def testCaseContextB= testCaseContext.getTestCaseId()
		log.logWarning('--- End Test:= ' + testCaseContextB + ' ---')
	}
}