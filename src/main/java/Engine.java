import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by mylnz on 14.11.2016.
 */
public class Engine {

    public static void main(String[] args) {
        try {
            Map<Integer, List<Integer>> inputDataMap = getInputDataMap();

            inputDataMap.forEach((numberOfStates, connectedCities) -> {
                System.out.println(HighCouncilOfWiseMen.getStepCountToUnify(connectedCities));
            });

        } catch (Exception e) {
            e.getMessage();
        }

    }

    private static Map<Integer, List<Integer>> getInputDataMap() throws Exception {

        BufferedReader handleInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter test count: ");
        int testCount = Integer.parseInt(handleInput.readLine());
        ValidationUtils.isTestCountNotValid(testCount);

        Map<Integer, List<Integer>> inputDataMap = new HashMap<>();

        for (int i = 0; i < testCount; i++) {
            System.out.print("Enter city count: ");
            int cityCount = Integer.parseInt(handleInput.readLine());

            System.out.print("Enter road connections: ");
            List<Integer> roadConnections = Arrays.asList(handleInput.readLine().split(" ")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());

            ValidationUtils.isInputDataNotValid(cityCount, roadConnections);

            inputDataMap.put(cityCount, roadConnections);

        }
        return inputDataMap;
    }
}