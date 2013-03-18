package charactergen.classes;

import java.util.Arrays;

public class Shaman extends BaseClass {

    public Shaman() {
        setRanks(Arrays.asList(3, 4, 1, 2, 0, 5));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Shaman";
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
