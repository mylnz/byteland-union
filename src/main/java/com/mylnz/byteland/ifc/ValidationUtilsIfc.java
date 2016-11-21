package com.mylnz.byteland.ifc;

import java.util.List;

/**
 * Created by sozl724 on 21.11.2016.
 * ValidationUtilsIfc
 */
public interface ValidationUtilsIfc {

    void isInputDataNotValid(int numberOfStates, List<Integer> connectedCities) throws Exception;

    void isTestCountNotValid(int testCount) throws Exception;
}
