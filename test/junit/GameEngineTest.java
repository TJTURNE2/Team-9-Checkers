package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import checkers.JunitTester;

public class GameEngineTest {

	@Test
	public void getOpponentTest1() {
		assert(JunitTester.getOpponentTest(1) == 2);
	}
	
	@Test
	public void getOpponentTest2() {
		assert(JunitTester.getOpponentTest(2) == 1);
	}
}
