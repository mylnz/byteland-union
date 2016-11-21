package com.mylnz.byteland.ifc;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sozl724 on 21.11.2016.
 * LandStructureUtilsIfc
 */
public interface LandStructureUtilsIfc {
    Map<Integer, Set<Integer>> getCityConnectionMap(List<Integer> roadConnectionList);

    Set<Integer> getNodeSet(Map<Integer, Set<Integer>> cityConnectionMap);

    Set<Integer> getLeafCitySet(List<Integer> roadConnectionList);

    int getMaxLeafCount(Map<Integer, Set<Integer>> cityConnectedMap);
}
