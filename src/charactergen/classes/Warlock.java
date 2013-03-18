package charactergen.classes;

import java.util.Arrays;

public class Warlock extends BaseClass {

    public Warlock() {
        setRanks(Arrays.asList(3, 4, 1, 2, 5, 0));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Warlock";
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
