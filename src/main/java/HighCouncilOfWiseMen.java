import java.util.*;

public class HighCouncilOfWiseMen {


    public static int getStepCountToUnify (List<Integer> connectedCities){

        Map<Integer, Set<Integer>> cityConnectedMap =  LandStructureUtils.getCityConnectedMap(connectedCities);

        Set<Integer> nodeSet = cityConnectedMap.keySet();

        int maxLeafCount = LandStructureUtils.getMaxLeafCount(cityConnectedMap);

        return (int) (Math.ceil(nodeSet.size() * 0.5)+ maxLeafCount);
    }
}
