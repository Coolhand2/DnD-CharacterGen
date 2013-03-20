package charactergen.classes;

import java.util.Arrays;

public class Wizard extends BaseClass {

    public Wizard() {
        setRanks(Arrays.asList(4, 2, 3, 0, 1, 5));
        setHealth(10);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Wizard";
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Controller";
    }

    @Override
    public int getSurges() {
        return 6;
    }
}
