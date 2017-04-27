package test;

import static org.junit.Assert.*;

import org.junit.Test;
import checkers.GameEngine;

public class GameEngineTest 
{
	@Test
	public void testCopyBoard()
	{
		// Generic in-game board to be copied
		int[][] testBoard1 = {
				{0,	0, 2, 0, 2, 0, 2, 0},
				{0, 2, 0, 0, 0, 3, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0},
				{0, 2, 0, 0, 0, 2, 0, 2},
				{3, 0, 0, 0, 1, 0, 2, 0},
				{0, 0, 0, 0, 0, 3, 0, 3},
				{1, 0, 0, 0, 2, 0, 4, 0},
				{0, 2, 0, 0, 0, 0, 0, 1}};
		
		// Expected result
		int[][] expectedBoard1 = {
				{0,	0, 2, 0, 2, 0, 2, 0},
				{0, 2, 0, 0, 0, 3, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0},
				{0, 2, 0, 0, 0, 2, 0, 2},
				{3, 0, 0, 0, 1, 0, 2, 0},
				{0, 0, 0, 0, 0, 3, 0, 3},
				{1, 0, 0, 0, 2, 0, 4, 0},
				{0, 2, 0, 0, 0, 0, 0, 1}};
		
		// Actual result
		int[][] actualBoard1 = GameEngine.copyBoard(testBoard1);
		
		assertArrayEquals(expectedBoard1, actualBoard1);
	}
}
