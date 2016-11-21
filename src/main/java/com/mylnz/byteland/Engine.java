package com.mylnz.byteland;

import com.mylnz.byteland.ifc.HighCouncilOfWiseMenIfc;
import com.mylnz.byteland.ifc.ValidationUtilsIfc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by mylnz on 14.11.2016.
 * <p>
 * Engine of solution. As Bootstrap
 */
public class Engine {

    private HighCouncilOfWiseMenIfc highCouncilOfWiseMenIfc;
    private ValidationUtilsIfc validationUtilsIfc;

    private HighCouncilOfWiseMenIfc getHighCouncilOfWiseMenIfc() {
        if (highCouncilOfWiseMenIfc == null) {
            highCouncilOfWiseMenIfc = new HighCouncilOfWiseMen();
        }
        return highCouncilOfWiseMenIfc;
    }

    private ValidationUtilsIfc getValidationUtilsIfc() {
        if (validationUtilsIfc == null) {
            validationUtilsIfc = new ValidationUtils();
        }
        return validationUtilsIfc;
    }

    private Map<Integer, List<Integer>> getInputDataMap() throws Exception {

        BufferedReader handleInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Case Count: ");
        int testCount = Integer.parseInt(handleInput.readLine());
        getValidationUtilsIfc().isTestCountNotValid(testCount);

        Map<Integer, List<Integer>> inputDataMap = new HashMap<>();

        for (int i = 0; i < testCount; i++) {
            System.out.print("City Count: ");
            int cityCount = Integer.parseInt(handleInput.readLine());

            System.out.print("Road Connections: ");
            List<Integer> roadConnections = Arrays.stream(handleInput.readLine().split(" ")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());

            getValidationUtilsIfc().isInputDataNotValid(cityCount, roadConnections);

            inputDataMap.put(cityCount, roadConnections);

        }
        return inputDataMap;
    }


    public void main(String[] args) {
        try {
            Map<Integer, List<Integer>> inputDataMap = getInputDataMap();

            inputDataMap.forEach((numberOfStates, connectedCities) -> System.out.println(getHighCouncilOfWiseMenIfc().getStepCountToUnify(connectedCities)));

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
