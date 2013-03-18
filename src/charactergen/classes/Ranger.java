package charactergen.classes;

import java.util.Arrays;

public class Ranger extends BaseClass {

    public Ranger() {
        setRanks(Arrays.asList(0, 1, 3, 4, 2, 5));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Ranger";
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Striker";
    }
}
