package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import checkers.JunitTester;

public class CheckersTest {

	@Test
	public void isPossibleSquareTest1() {
		// test 1: even + even
		assert(JunitTester.isPossibleSquareTest(2, 2) == false);
	}
	
	@Test
	public void isPossibleSquareTest2() {
		// test 2: even + odd
		assert(JunitTester.isPossibleSquareTest(2, 3) == true);
	}
	
	@Test
	public void isPossibleSquareTest3() {
		// test 3: odd + odd
		assert(JunitTester.isPossibleSquareTest(3, 3) == false);
	}
}
