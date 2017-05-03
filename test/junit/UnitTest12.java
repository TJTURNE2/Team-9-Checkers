/*
 * 
 */
package junit;


import static org.junit.Assert.*;

import org.junit.Test;

import checkers.JunitTester;

// TODO: Auto-generated Javadoc
/**
 * The Class UnitTest12.
 */
public class UnitTest12 {

	/** The board 1. */
	int[][] board1 = {
			{	0,	1,	0,	1,	0,	1,	0,	1	},
			{	0,	0,	0,	0,	0,	0,	0,	0	},
			{	0,	0,	0,	0,	0,	0,	0,	0	},
			{	0,	0,	0,	0,	0,	0,	0,	0	},
			{	0,	0,	0,	0,	0,	0,	0,	0	},
			{	0,	0,	0,	0,	0,	0,	0,	0	},
			{	0,	0,	0,	0,	0,	0,	0,	0	},
			{	0,	0,	0,	0,	0,	0,	0,	0	}};
		
		/** The board 2. */
		int[][] board2 = {
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	2,	0,	2,	0,	2,	0,	2,	0	}};
		
		/** The board 3. */
		int[][] board3 = {
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	2,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	2,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	2,	0,	2,	0,	2	}};
		
		/** The board 4. */
		int[][] board4 = {
				{	0,	1,	0,	1,	0,	1,	0,	1	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	}};
		
		/** The board 5. */
		int[][] board5 = {
				{	0,	1,	0,	1,	0,	2,	0,	2	},
				{	2,	0,	2,	0,	2,	0,	0,	0	},
				{	0,	2,	0,	0,	0,	2,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	}};

		
		/** The board 6. */
		int[][] board6 = {
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	0,	0,	0,	0,	0,	0	},
				{	0,	0,	1,	0,	1,	0,	0,	0	},
				{	0,	1,	0,	1,	0,	0,	0,	0	},
				{	2,	0,	2,	0,	1,	0,	0,	0	}};
		
//		int[][] board7 = {
//				{	0,	0,	0,	0,	0,	0,	0,	0	},
//				{	0,	0,	0,	0,	0,	0,	0,	0	},
//				{	0,	0,	0,	0,	0,	0,	0,	0	},
//				{	0,	0,	0,	0,	0,	0,	0,	0	},
//				{	0,	0,	0,	0,	0,	0,	0,	0	},
//				{	0,	0,	0,	0,	0,	0,	0,	0	},
//				{	0,	0,	0,	0,	0,	0,	0,	0	},
//				{	0,	0,	0,	0,	0,	0,	0,	0	}};
		
		/** The test. */
JunitTester test = new JunitTester();
		
		/**
		 * Test no moves left.
		 */
		@Test
		public void testNoMovesLeft() {
			System.out.println(board6[7][2]+" "+ test.isCanWalk(board6, 7, 2) + " " + test.hasNoMoves(board6, 2));			
			assertTrue("Moves Left", !test.hasNoMoves(board1, 1));
			assertTrue("Moves Left", !test.hasNoMoves(board2, 2)); 
			assertTrue("Moves Left", test.hasNoMoves(board3, 1));
			assertTrue("Moves Left", test.hasNoMoves(board4, 2));
			assertTrue("Moves Left", !test.hasNoMoves(board5, 1));
			assertTrue("Moves Left", !test.hasNoMoves(board6, 2));

		}
	}
