package junit;

import static org.junit.Assert.*;

import checkers.CheckerFrame;
import checkers.IntelliChecker;
import checkers.JunitTester;
import org.junit.Test;

public class UnitTest21 {

  JunitTester JunitTester = new JunitTester();
  CheckerFrame cframe;
  @Test
  public void test() {
    IntelliChecker Checker = new IntelliChecker();
    try {
      String[] stuff = {"null","null"};
      Checker.main(stuff);
      JunitTester.getCheckers().play();
      cframe =  new JunitTester().getCheckerFrame();
      
      JunitTester.getCheckerFrame().setVisible(true);
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      //e.printStackTrace();
    }
    //JunitTester.CFrameTest();  //assertNotNull(this.JunitTester.runCheckers());
 
  
  }

}
