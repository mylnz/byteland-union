import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class HighCouncilOfWiseMen {


    public static int getStepCountToUnifyBeta(List<Integer> connectedCities) {

        Map<Integer, Set<Integer>> cityConnectedMap = LandStructureUtils.getCityConnectionMap(connectedCities);

        Set<Integer> nodeSet = cityConnectedMap.keySet();

        int maxLeafCount = LandStructureUtils.getMaxLeafCount(cityConnectedMap);

        return (int) (Math.ceil(nodeSet.size() * 0.5) + maxLeafCount);
    }

    /**
     * @param connectedCities user input
     * @return stepCountToUnify
     */
    static int getStepCountToUnify(List<Integer> connectedCities) {

        int stepCountToUnify = 0;

        Map<Integer, Set<Integer>> cityConnectionMap = LandStructureUtils.getCityConnectionMap(connectedCities);

        Set<Integer> nodeSet = LandStructureUtils.getNodeSet(cityConnectionMap);

        Set<Integer> leafCitySet = LandStructureUtils.getLeafCitySet(connectedCities);

        while (nodeSet.size() != 0) {
            unifyProcess(cityConnectionMap, leafCitySet, nodeSet);
            stepCountToUnify++;
        }

        return stepCountToUnify;
    }

    private static void unifyProcess(Map<Integer, Set<Integer>> cityConnectionMap, Set<Integer> leafCitySet, Set<Integer> nodeSet) {
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
                    connectedNextNode = (Integer) cityConnectionMap.get(node).toArray() [0];
                    leafCity = getLeafInSet(leafCitySet, cityConnectionMap.get(connectedNextNode));

                    if (leafCity < 0) {// there is not any leaf city
                        if( !(unifiedCityList.contains(node) && unifiedCityList.contains(connectedNextNode)) ) {
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

                    if( !(unifiedCityList.contains(node) && unifiedCityList.contains(leafCity)) ){
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

    private static Integer getLeafInSet(Set<Integer> leafCitySet, Set<Integer> cityRoadSet) {
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
