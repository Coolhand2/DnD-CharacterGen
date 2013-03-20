package charactergen.classes;

import java.util.Arrays;

public class Cleric extends BaseClass {

    public Cleric() {
        setRanks(Arrays.asList(1, 4, 3, 5, 0, 2));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Cleric";
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Leader";
    }

    @Override
    public int getSurges() {
        return 7;
    }
}
