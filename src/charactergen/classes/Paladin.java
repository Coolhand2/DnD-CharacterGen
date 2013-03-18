package charactergen.classes;

import java.util.Arrays;

public class Paladin extends BaseClass {

    public Paladin() {
        setRanks(Arrays.asList(0, 4, 3, 5, 2, 1));
        setHealth(15);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Paladin";
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Defender";
    }
}
