package charactergen.classes;

import java.util.Arrays;

public class Ardent extends BaseClass {

    public Ardent() {
        setRanks(Arrays.asList(4, 1, 3, 2, 0, 5));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Ardent";
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
