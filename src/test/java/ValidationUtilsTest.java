

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

/**
 * Created by mylnz on 15.11.2016.
 */

@RunWith(JUnit4.class)
public class ValidationUtilsTest {
    @Test(expected = Exception.class)
    public void isInputDataNotValidTest() throws Exception {
        ValidationUtils.isInputDataNotValid(3, Arrays.asList(0, 1, 2));
    }

    @Test(expected = Exception.class)
    public void isTestCountNotValidTest() throws Exception {
        ValidationUtils.isTestCountNotValid(1001);
    }
}
