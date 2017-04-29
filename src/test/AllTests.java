package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GameEngineTest.class, CheckerMoveTest.class, CheckersTest.class, CheckerFrameTest.class })
public class AllTests {

}
