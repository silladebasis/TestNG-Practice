package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getTestContext().getName());
        System.out.println(result.getName());
        System.out.println("On Test Success is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

    }
}
