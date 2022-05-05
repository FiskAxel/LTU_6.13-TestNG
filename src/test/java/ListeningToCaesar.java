import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListeningToCaesar implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.print("Starting: " + result.getMethod().getMethodName() + ". And... ");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("it's a SUCCESS! :)");
        try {
            TestReport.writeTestStatusLine(result.getMethod().getMethodName(), "PASS");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("it FAILED! :(");
        try {
            TestReport.writeTestStatusLine(result.getMethod().getMethodName(), "FAIL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.print("Tried to run: " + result.getMethod().getMethodName() + ", but it got SKIPPED :o");
        try {
            TestReport.writeTestStatusLine(result.getMethod().getMethodName(), "SKIPPED");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite: " + context.getSuite().getName() + " is now starting...");
        try {
            TestReport.writeTestStartLine("Test suite: " + context.getSuite().getName() + " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite: " + context.getSuite().getName() + " finished!");
        try {
            TestReport.writeBlankLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
