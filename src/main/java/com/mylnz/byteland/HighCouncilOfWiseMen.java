package com.mylnz.byteland;

import com.mylnz.byteland.ifc.HighCouncilOfWiseMenIfc;
import com.mylnz.byteland.ifc.LandStructureUtilsIfc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HighCouncilOfWiseMen implements HighCouncilOfWiseMenIfc {

    private LandStructureUtilsIfc landStructureUtilsIfc;

    private LandStructureUtilsIfc getLandStructureUtilsIfc() {
        if (landStructureUtilsIfc == null) {
            landStructureUtilsIfc = new LandStructureUtils();
        }
        return landStructureUtilsIfc;
    }

    public int getStepCountToUnifyBeta(List<Integer> connectedCities) {

        Map<Integer, Set<Integer>> cityConnectedMap = getLandStructureUtilsIfc().getCityConnectionMap(connectedCities);

        Set<Integer> nodeSet = cityConnectedMap.keySet();

        int maxLeafCount = getLandStructureUtilsIfc().getMaxLeafCount(cityConnectedMap);

        return (int) (Math.ceil(nodeSet.size() * 0.5) + maxLeafCount);
    }

    /**
     * @param connectedCities user input
     * @return stepCountToUnify
     */
    public int getStepCountToUnify(List<Integer> connectedCities) {

        int stepCountToUnify = 0;

        Map<Integer, Set<Integer>> cityConnectionMap = getLandStructureUtilsIfc().getCityConnectionMap(connectedCities);

        Set<Integer> nodeSet = getLandStructureUtilsIfc().getNodeSet(cityConnectionMap);

        Set<Integer> leafCitySet = getLandStructureUtilsIfc().getLeafCitySet(connectedCities);

        while (nodeSet.size() != 0) {
            unifyProcess(cityConnectionMap, leafCitySet, nodeSet);
            stepCountToUnify++;
        }

        return stepCountToUnify;
    }

    private void unifyProcess(Map<Integer, Set<Integer>> cityConnectionMap, Set<Integer> leafCitySet, Set<Integer> nodeSet) {
        Object[] internalNodes = nodeSet.toArray();

        Integer leafCity, node, connectedNextNode;

        // already unified cities list in this step
        List<Integer> unifiedCityList = new ArrayList<>();

        for (int i = 0; i < internalNodes.length; i++) {
            node = (Integer) internalNodes[i];
            if (cityConnectionMap.get(node) != null) {
                leafCity = getLeafInSet(leafCitySet, cityConnectionMap.get(node));

                if (leafCity < 0) {// there is not any leaf city
                    // check for next node
                    connectedNextNode = (Integer) cityConnectionMap.get(node).toArray()[0];
                    leafCity = getLeafInSet(leafCitySet, cityConnectionMap.get(connectedNextNode));

                    if (leafCity < 0) {// there is not any leaf city
                        if (!(unifiedCityList.contains(node) && unifiedCityList.contains(connectedNextNode))) {
                            // then unify the node with secondnode
                            cityConnectionMap.get(node).addAll(cityConnectionMap.get(connectedNextNode));
                            cityConnectionMap.get(node).remove(connectedNextNode);
                            nodeSet.remove(connectedNextNode);
                            cityConnectionMap.remove(connectedNextNode);

                            unifiedCityList.add(node);
                            unifiedCityList.add(connectedNextNode);
                        }
                    }

                } else { // there is at least a leaf city

                    if (!(unifiedCityList.contains(node) && unifiedCityList.contains(leafCity))) {
                        Set<Integer> mapConnectionSet = cityConnectionMap.get(node);
                        mapConnectionSet.remove(leafCity);
                        leafCitySet.remove(leafCity);

                        if (mapConnectionSet.isEmpty()) {
                            leafCitySet.add(node);
                            cityConnectionMap.remove(node);
                        }

                        unifiedCityList.add(node);
                        unifiedCityList.add(leafCity);
                    }

                }
            }
        }

    }

    private Integer getLeafInSet(Set<Integer> leafCitySet, Set<Integer> cityRoadSet) {
        // there is not any leaf city
        Integer leafCityInSet = -1;

        for (Integer city : cityRoadSet) {
            if (leafCitySet.contains(city)) {
                leafCityInSet = city;
                break;
            }
        }
        return leafCityInSet;
    }

}
