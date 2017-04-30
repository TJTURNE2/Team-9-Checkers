package junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import checkers.CheckerFrame;
import checkers.JunitTester;

public class CheckerFrameTest {
	
	JunitTester JunitTester = new JunitTester();
	
	@Test
	public void CFrameTest() {
		assertNotNull(JunitTester.getCheckerFrame());
		
		//JunitTester.CFrameTest(); // old test
	}

}
