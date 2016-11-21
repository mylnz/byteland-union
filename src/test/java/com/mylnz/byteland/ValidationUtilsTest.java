package com.mylnz.byteland;

import com.mylnz.byteland.ifc.ValidationUtilsIfc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

/**
 * Created by mylnz on 15.11.2016.
 * ValidationUtilsTest
 */

@RunWith(JUnit4.class)
public class ValidationUtilsTest {
    private ValidationUtilsIfc validationUtilsIfc;

    private ValidationUtilsIfc getValidationUtilsIfc() {
        if (validationUtilsIfc == null) {
            validationUtilsIfc = new ValidationUtils();
        }
        return validationUtilsIfc;
    }

    @Before
    public void setUp() throws Exception {
    }


    @Test(expected = Exception.class)
    public void isInputDataNotValidTest() throws Exception {
        getValidationUtilsIfc().isInputDataNotValid(3, Arrays.asList(0, 1, 2));
    }

    @Test(expected = Exception.class)
    public void isTestCountNotValidTest() throws Exception {
        getValidationUtilsIfc().isTestCountNotValid(1001);
    }
}
