package com.mylnz.byteland;

import com.mylnz.byteland.ifc.ValidationUtilsIfc;

import java.util.List;

/**
 * Created by mylnz on 14.11.2016.
 */
public class ValidationUtils implements ValidationUtilsIfc {


    private static final int MAX_CITY_COUNT = 600;
    private static final int MIN_CITY_COUNT = 2;

    private static final int MAX_TEST_COUNT = 1000;
    private static final int MINT_TEST_COUNT = 1;

    public void isInputDataNotValid(int numberOfStates, List<Integer> connectedCities) throws Exception {
        if (numberOfStates < MIN_CITY_COUNT) {
            throw new Exception("At least " + MIN_CITY_COUNT + " cities are needed.");
        }
        if (numberOfStates > MAX_CITY_COUNT) {
            throw new Exception("Max " + MAX_CITY_COUNT + " cities can be processed.");
        }
        if (connectedCities.size() + 1 != numberOfStates) {
            throw new Exception("Connections of cities are not valid");
        }
    }

    public void isTestCountNotValid(int testCount) throws Exception {
        if(testCount < MINT_TEST_COUNT || testCount > MAX_TEST_COUNT){
            throw new Exception("Test Count Not Valid");
        }
    }

}
