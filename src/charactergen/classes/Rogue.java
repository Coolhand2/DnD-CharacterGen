package charactergen.classes;

import java.util.Arrays;

public class Rogue extends BaseClass {

    public Rogue() {
        setRanks(Arrays.asList(1, 0, 3, 4, 5, 2));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Rogue";
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
