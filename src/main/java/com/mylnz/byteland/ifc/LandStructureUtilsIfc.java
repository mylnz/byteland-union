package com.mylnz.byteland.ifc;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sozl724 on 21.11.2016.
 * LandStructureUtilsIfc
 */
public interface LandStructureUtilsIfc {
    /**
     * @param roadConnectionList
     * @return CityConnectionMap is connection map
     */
    Map<Integer, Set<Integer>> getCityConnectionMap(List<Integer> roadConnectionList);

    /**
     * @param cityConnectionMap
     * @return NodeSet on land
     */
    Set<Integer> getNodeSet(Map<Integer, Set<Integer>> cityConnectionMap);

    /**
     * @param roadConnectionList
     * @return LeafCitySet on land
     */
    Set<Integer> getLeafCitySet(List<Integer> roadConnectionList);

    /**
     * @param cityConnectedMap
     * @return MaxLeafCount on city connection map
     */
    int getMaxLeafCount(Map<Integer, Set<Integer>> cityConnectedMap);
}
