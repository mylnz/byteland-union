import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class HighCouncilOfWiseMenTest {

    @Test
    public void getStepCountToUnifyTest () throws Exception {
        assertThat(HighCouncilOfWiseMen.getStepCountToUnify(Arrays.asList(0, 1, 2)), equalTo(2));

        assertThat(HighCouncilOfWiseMen.getStepCountToUnify(Arrays.asList(0, 1, 2, 0, 0, 3, 3)), equalTo(4));

        assertThat(HighCouncilOfWiseMen.getStepCountToUnify(Arrays.asList(0, 1, 1, 1, 1, 0, 2, 2)), equalTo(5));

        assertThat(HighCouncilOfWiseMen.getStepCountToUnify(Arrays.asList(2, 0, 4, 0, 0, 4, 5, 5, 2)), equalTo(5));
    }
}