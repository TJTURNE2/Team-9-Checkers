package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CanCaptureTest.class, IsWalkLegalTest.class, InRangeTest.class, EvalTest.class })
public class AllTests {

}