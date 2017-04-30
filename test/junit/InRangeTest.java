package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import checkers.JUnitTester;

public class InRangeTest {

	public InRangeTest() {
	}

	@Test
	public void inRangeTest1() {
		assertTrue(JUnitTester.inRangeTest(0, 7));
	}
	
	@Test
	public void inRangeTest2() {
		assertFalse(JUnitTester.inRangeTest(-1, 7));
	}
	
	@Test
	public void inRangeTest3() {
		assertFalse(JUnitTester.inRangeTest(8, 7));
	}
	
	@Test
	public void inRangeTest4() {
		assertFalse(JUnitTester.inRangeTest(0, -1));
	}

	@Test
	public void inRangeTest5() {
		assertFalse(JUnitTester.inRangeTest(0, 8));
	}
}
