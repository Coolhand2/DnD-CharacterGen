package charactergen.classes;

import java.util.Arrays;

public class Sorcerer extends BaseClass {

    public Sorcerer() {
        setRanks(Arrays.asList(2, 1, 3, 4, 5, 0));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Sorcerer";
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
        return 6;
    }
}
