package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CanCaptureTest.class, IsWalkLegalTest.class, InRangeTest.class, EvalTest.class, 
	GameEngineTest.class, CheckerMoveTest.class, CheckersTest.class, CheckerFrameTest.class,
	UnitTest12.class, UnitTest16.class, UnitTest8.class, UnitTest4.class, UnitTest21.class})
public class AllTests {

}
