package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provide implementation for IretryAnalyser interface
 * @author jhans
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{
	
	int count=1;
	int retrycount=3;                         
	                               //PASS //FAIL
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		     //1<=3  2<=3 3<=3 4<=3
		
		while(count<=retrycount)
		{
			count++; //2 3 4
			return true; //retry retry retry
		}
		
		return false; //dont retry
	}

}
