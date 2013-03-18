package charactergen.classes;

import java.util.Arrays;

public class Avenger extends BaseClass {

    public Avenger() {
        setRanks(Arrays.asList(4, 1, 3, 2, 0, 5));
        setHealth(14);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Avenger";
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
