package charactergen.classes;

import java.util.Arrays;

public class Warlord extends BaseClass {

    public Warlord() {
        setRanks(Arrays.asList(0, 4, 3, 1, 5, 2));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Warlord";
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Leader";
    }
}
