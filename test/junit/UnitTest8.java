/*
 * 
 */
package junit;


import static org.junit.Assert.assertTrue;
import org.junit.Test;
import checkers.JunitTester;

// TODO: Auto-generated Javadoc
/**
 * The Class UnitTest8.
 */
//test For Can Walk
public class UnitTest8 {
	
	/** The board 1. */
	int[][] board1 = {
		{	1,	1,	1,	3,	3,	1,	3,	0	},
		{	2,	3,	0,	3,	2,	3,	2,	3	},
		{	3,	0,	3,	0,	3,	0,	3,	2	},
		{	0,	3,	0,	3,	0,	3,	0,	3	},
		{	3,	2,	3,	1,	3,	0,	3,	2	},
		{	0,	3,	3,	3,	2,	3,	3,	3	},
		{	3,	4,	3,	2,	3,	0,	3,	2	},
		{	1,	3,	3,	3,	2,	3,	0,	3	}};
	
	/** The board 2. */
	int[][] board2 = {
			{	2,	1,	1,	3,	3,	1,	3,	0	},
			{	2,	3,	0,	3,	2,	3,	2,	3	},
			{	3,	0,	3,	0,	3,	0,	3,	2	},
			{	0,	3,	0,	3,	0,	3,	0,	3	},
			{	3,	2,	3,	1,	3,	0,	3,	2	},
			{	0,	3,	3,	3,	2,	3,	3,	3	},
			{	3,	4,	3,	2,	3,	0,	3,	2	},
			{	1,	3,	3,	3,	2,	3,	0,	3	}};
	
	/** The board 3. */
	int[][] board3 = {
			{	3,	1,	1,	3,	3,	1,	3,	0	},
			{	2,	3,	0,	3,	2,	3,	2,	3	},
			{	3,	0,	3,	0,	3,	0,	3,	2	},
			{	0,	3,	0,	3,	0,	3,	0,	3	},
			{	3,	2,	3,	1,	3,	0,	3,	2	},
			{	0,	3,	3,	3,	2,	3,	3,	3	},
			{	3,	4,	3,	2,	3,	0,	3,	2	},
			{	1,	3,	3,	3,	2,	3,	0,	3	}};
	
	/** The board 4. */
	int[][] board4 = {
			{	4,	1,	1,	3,	3,	1,	3,	0	},
			{	2,	3,	0,	3,	2,	3,	2,	3	},
			{	1,	0,	1,	0,	3,	0,	3,	2	},
			{	0,	3,	0,	3,	0,	3,	0,	3	},
			{	3,	2,	3,	1,	3,	0,	3,	2	},
			{	0,	3,	3,	3,	2,	3,	3,	3	},
			{	3,	4,	3,	2,	3,	0,	3,	2	},
			{	1,	3,	3,	3,	2,	3,	0,	3	}};
	
	/** The board 5. */
	int[][] board5 = {
			{	0,	1,	0,	3,	3,	1,	3,	0	},
			{	2,	3,	0,	3,	2,	3,	2,	3	},
			{	0,	0,	0,	0,	3,	0,	3,	2	},
			{	0,	3,	0,	3,	0,	3,	0,	3	},
			{	3,	2,	3,	1,	3,	0,	3,	2	},
			{	0,	3,	3,	3,	2,	3,	3,	3	},
			{	3,	4,	3,	2,	3,	0,	3,	2	},
			{	1,	3,	3,	3,	2,	3,	0,	3	}};
	
	/** The board 6. */
	int[][] board6 = {
			{	1,	0,	0,	3,	3,	1,	3,	0	},
			{	0,	0,	0,	3,	2,	3,	2,	3	},
			{	0,	0,	0,	0,	3,	0,	3,	2	},
			{	0,	3,	0,	3,	0,	3,	0,	3	},
			{	3,	2,	3,	1,	3,	0,	3,	2	},
			{	0,	3,	3,	3,	2,	0,	0,	0	},
			{	3,	4,	3,	2,	3,	0,	0,	0	},
			{	1,	3,	3,	3,	2,	0,	0,	1	}};
	
	/** The board 7. */
	int[][] board7 = {
			{	2,	0,	0,	3,	3,	1,	3,	0	},
			{	0,	0,	0,	3,	2,	3,	2,	3	},
			{	0,	0,	0,	0,	3,	0,	3,	2	},
			{	0,	3,	0,	3,	0,	3,	0,	3	},
			{	3,	2,	3,	1,	3,	0,	3,	2	},
			{	0,	3,	3,	3,	2,	0,	0,	0	},
			{	3,	4,	3,	2,	3,	0,	0,	0	},
			{	1,	3,	3,	3,	2,	0,	0,	2	}};
	
	/** The board 8. */
	int[][] board8 = {
			{	3,	0,	0,	3,	3,	1,	3,	0	},
			{	0,	0,	0,	3,	2,	3,	2,	3	},
			{	0,	0,	0,	0,	3,	0,	3,	2	},
			{	0,	3,	0,	3,	0,	3,	0,	3	},
			{	3,	2,	3,	1,	3,	0,	3,	2	},
			{	0,	3,	3,	3,	2,	3,	3,	3	},
			{	3,	4,	3,	2,	3,	0,	3,	2	},
			{	1,	3,	3,	3,	2,	3,	0,	3	}};
	
	/** The board 9. */
	int[][] board9 = {
			{	4,	0,	0,	3,	3,	1,	3,	0	},
			{	0,	0,	0,	3,	2,	3,	2,	3	},
			{	0,	0,	0,	0,	3,	0,	3,	2	},
			{	0,	3,	0,	3,	0,	3,	0,	3	},
			{	3,	2,	3,	1,	3,	0,	3,	2	},
			{	0,	3,	3,	3,	2,	3,	3,	3	},
			{	3,	4,	3,	2,	3,	0,	3,	2	},
			{	1,	3,	3,	3,	2,	3,	0,	3	}};
	
	/** The board 10. */
	int[][] board10 = {
			{	0,	1,	0,	3,	3,	1,	3,	0	},
			{	0,	3,	0,	3,	2,	3,	2,	3	},
			{	0,	0,	0,	0,	3,	0,	3,	2	},
			{	0,	3,	0,	3,	0,	3,	0,	3	},
			{	3,	2,	3,	1,	3,	0,	3,	2	},
			{	0,	3,	3,	3,	2,	3,	3,	3	},
			{	3,	4,	3,	2,	3,	0,	3,	2	},
			{	1,	3,	3,	3,	2,	3,	0,	3	}};
	
	/** The test. */
	JunitTester test = new JunitTester();
	
	/**
	 * Test can walk.
	 */
	@Test
	public void testCanWalk() {
		assertTrue("Can Walk", !test.isCanWalk(board1, 0, 0));
		assertTrue("Can Walk", !test.isCanWalk(board2, 0, 0));
		assertTrue("Can Walk", !test.isCanWalk(board3, 0, 0));
		assertTrue("Can Walk", !test.isCanWalk(board4, 0, 0));
		assertTrue("Can Walk", !test.isCanWalk(board5, 0, 0));
		assertTrue("Can Walk", test.isCanWalk(board6, 0, 0));
		assertTrue("Can Walk", test.isCanWalk(board7, 7, 7));
		assertTrue("Can Walk", test.isCanWalk(board8, 0, 0));
		assertTrue("Can Walk", test.isCanWalk(board9, 0, 0));
		assertTrue("Can Walk", !test.isCanWalk(board10, 0, 0));
	}

}
