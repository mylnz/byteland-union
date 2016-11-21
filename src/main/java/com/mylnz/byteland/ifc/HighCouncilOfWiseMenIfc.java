package com.mylnz.byteland.ifc;

import java.util.List;

/**
 * Created by sozl724 on 21.11.2016.
 * HighCouncilOfWiseMenIfc
 */
public interface HighCouncilOfWiseMenIfc {
    /**
     * @param connectedCities
     * @return step count to unify.
     * <p>
     * This method is beta version to calculate the step count
     */
    int getStepCountToUnifyBeta(List<Integer> connectedCities);

    /**
     * @param connectedCities
     * @return step count to unify.
     */
    int getStepCountToUnify(List<Integer> connectedCities);
}
