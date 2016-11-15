import java.util.*;

/**
 * Created by mylnz on 14.11.2016.
 */
public class LandStructureUtils {


    public static Map<Integer, Set<Integer>> getCityConnectedMap(List<Integer> roadConnectionList) {
        Map<Integer, Set<Integer>> cityConnectedMap = getInitializedCityMap(roadConnectionList);

        Integer i = 0;
        for (Integer input : roadConnectionList) {
            cityConnectedMap.get(input).add(++i);
        }

        return cityConnectedMap;
    }

    private static Map<Integer, Set<Integer>> getInitializedCityMap(List<Integer> roadConnectionList) {
        Map<Integer, Set<Integer>> initCityMap = new HashMap<>();

        roadConnectionList.forEach(connectedCity -> {
            initCityMap.put(connectedCity, new HashSet<>());
        });

        return initCityMap;
    }

    public static List<Integer> getNodeList(List<Integer> roadConnectionList) {
        List<Integer> nodeList = new ArrayList<>();
        roadConnectionList.stream().distinct().forEach(node -> {
            nodeList.add(node);
        });

        return nodeList;
    }

    public static int getMaxLeafCount(Map<Integer, Set<Integer>> cityConnectedMap) {
        final Long[] maxLeafCount = {0L};
        Set<Integer> nodeSet = cityConnectedMap.keySet();

        cityConnectedMap.forEach((node, connectedCitySet) ->{
            final Long tempMaxLeafCount = connectedCitySet.stream().filter(val -> !nodeSet.contains(val)).count();
            if (maxLeafCount[0]< tempMaxLeafCount){
                maxLeafCount[0] = tempMaxLeafCount;
            }
        });

        return maxLeafCount[0].intValue() ==1 ? 0 : maxLeafCount[0].intValue();
    }

}
