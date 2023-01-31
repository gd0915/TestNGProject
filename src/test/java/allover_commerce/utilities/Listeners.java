package allover_commerce.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {
    /*
    ITestListener is an interface
    We use this interface to customize/power testNG framework
    onStart, onFinish, OnTestStart, onTestFinish, onTestSuccess, onTestFailure are special method names are used to LISTEN test methods.
    We especially use listeners for adding a special condition such as pass, fail, or slipped
     */

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart - Execute ONCE before ALL tests : "+context.getName());//Our project name
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish - Execute ONCE after ALL tests : "+context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart - Execute ONCE before EACH @Test : "+result.getName());//test method name
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess - Execute AFTER EACH PASSED @Test : "+result.getName());//test method name
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure - Execute AFTER EACH FAILED @Test : "+result.getName());
        try {
            ReusableMethods.getScreenshot("TEST CASE FAILED :" + result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped - Execute AFTER EACH SKIPPED @Test : "+result.getName());//test method name
    }
}

