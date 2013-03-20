package charactergen.classes;

import java.util.Arrays;

public class Barbarian extends BaseClass {

    public Barbarian() {
        setRanks(Arrays.asList(0, 3, 1, 4, 5, 2));
        setHealth(15);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Barbarian";
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
        return 8;
    }
}
