package charactergen.classes;

import java.util.Arrays;

public class Monk extends BaseClass {

    public Monk() {
        setRanks(Arrays.asList(1, 0, 3, 4, 2, 5));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Monk";
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Striker";
    }

    @Override
    public int getSurges() {
        return 7;
    }
}
