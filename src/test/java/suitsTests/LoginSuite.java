package suitsTests;

import loginTests.InValidLoginTestWithPageObjectWithExcel;
import loginTests.LoginTestWithPageObjectWithExcel;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                InValidLoginTestWithPageObjectWithExcel.class,
                LoginTestWithPageObjectWithExcel.class
        }
)
public class LoginSuite {
}
