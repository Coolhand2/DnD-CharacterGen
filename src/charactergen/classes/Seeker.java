package charactergen.classes;

import java.util.Arrays;

public class Seeker extends BaseClass {

    public Seeker() {
        setRanks(Arrays.asList(1, 2, 3, 4, 0, 5));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Seeker";
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Controller";
    }
}
