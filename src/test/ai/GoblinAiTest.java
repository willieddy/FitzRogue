package test.ai;

import main.ai.GoblinAi;
import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

/**
 * Created by wilhelm on 4/5/15.
 */
public class GoblinAiTest {

    private GoblinAi fixture = new GoblinAi();

    @Test
    public void testRandomMove() {
        int[] moveArray = new int[8];

        for (int i = 0; i < 1000; i++) {
            switch (fixture.onUpdate()) {
                case UP:
                    moveArray[0]++;
                    break;
                case DOWN:
                    moveArray[1]++;
                    break;
                case LEFT:
                    moveArray[2]++;
                    break;
                case RIGHT:
                    moveArray[3]++;
                    break;
                case TOP_LEFT:
                    moveArray[4]++;
                    break;
                case BOTTOM_LEFT: moveArray[5]++;
                    break;
                case TOP_RIGHT: moveArray[6]++;
                    break;
                case BOTTOM_RIGHT: moveArray[7]++;
                    break;
                default: break;

            }
        }

        Assert.that(moveArray[0] > 10, "Up less than 10");
        Assert.that(moveArray[1] > 10, "Down less than 10");
        Assert.that(moveArray[2] > 10, "Left less than 10");
        Assert.that(moveArray[3] > 10, "Right less than 10");
        Assert.that(moveArray[4] > 10, "Top left less than 10");
        Assert.that(moveArray[5] > 10, "Bottom left less than 10");
        Assert.that(moveArray[6] > 10, "Top right less than 10");
        Assert.that(moveArray[7] > 10, "Bottom right less than 10");
    }
}
