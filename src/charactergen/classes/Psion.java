package charactergen.classes;

import java.util.Arrays;

public class Psion extends BaseClass {

    public Psion() {
        setRanks(Arrays.asList(5, 4, 3, 0, 2, 1));
        setHealth(12);
        _levelHealth = 4;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Psion";
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
