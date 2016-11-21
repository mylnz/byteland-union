package com.mylnz.byteland;

import com.mylnz.byteland.ifc.LandStructureUtilsIfc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mylnz on 14.11.2016.
 * structure/restructure Utils
 */
public class LandStructureUtils implements LandStructureUtilsIfc {


    public Map<Integer, Set<Integer>> getCityConnectionMap(List<Integer> roadConnectionList) {
        Map<Integer, Set<Integer>> cityConnectedMap = getInitializedCityMap(roadConnectionList);

        Integer i = 0;
        for (Integer input : roadConnectionList) {
            cityConnectedMap.get(input).add(++i);
        }

        return cityConnectedMap;
    }

    private Map<Integer, Set<Integer>> getInitializedCityMap(List<Integer> roadConnectionList) {
        Map<Integer, Set<Integer>> initCityMap = new HashMap<>();

        roadConnectionList.forEach(connectedCity -> initCityMap.put(connectedCity, new HashSet<>()));

        return initCityMap;
    }

    public Set<Integer> getNodeSet(Map<Integer, Set<Integer>> cityConnectionMap) {
        return cityConnectionMap.keySet();
    }

    private Set<Integer> getNodeSet(List<Integer> roadConnectionList) {
        return roadConnectionList.stream().distinct().collect(Collectors.toSet());
    }

    public Set<Integer> getLeafCitySet(List<Integer> roadConnectionList) {
        Set<Integer> nodeSet = getNodeSet(roadConnectionList);
        Integer cityCount = roadConnectionList.size() + 1;

        Set<Integer> leafCitySet = new HashSet<>();
        for (int i = 0; i < cityCount; i++) {
            if (!nodeSet.contains(i)) {
                leafCitySet.add(i);
            }
        }

        return leafCitySet;
    }

    public int getMaxLeafCount(Map<Integer, Set<Integer>> cityConnectedMap) {
        final Long[] maxLeafCount = {0L};
        Set<Integer> nodeSet = cityConnectedMap.keySet();

        cityConnectedMap.forEach((node, connectedCitySet) -> {
            final Long tempMaxLeafCount = connectedCitySet.stream().filter(val -> !nodeSet.contains(val)).count();
            if (maxLeafCount[0] < tempMaxLeafCount) {
                maxLeafCount[0] = tempMaxLeafCount;
            }
        });

        return maxLeafCount[0].intValue() == 1 ? 0 : maxLeafCount[0].intValue();
    }

}
