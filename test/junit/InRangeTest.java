package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import checkers.JunitTester;

public class InRangeTest {
	JunitTester JunitTester =  new JunitTester();
	public InRangeTest() {
	}

	//values both in range
	@Test
	public void inRangeTest1() {
		assertTrue(JunitTester.inRangeTest(0, 7));
	}
	
	//first value below range
	@Test
	public void inRangeTest2() {
		assertFalse(JunitTester.inRangeTest(-1, 7));
	}
	
	//first value above range
	@Test
	public void inRangeTest3() {
		assertFalse(JunitTester.inRangeTest(8, 7));
	}
	
	//second value below range
	@Test
	public void inRangeTest4() {
		assertFalse(JunitTester.inRangeTest(0, -1));
	}

	//second value above range
	@Test
	public void inRangeTest5() {
		assertFalse(JunitTester.inRangeTest(0, 8));
	}
}
