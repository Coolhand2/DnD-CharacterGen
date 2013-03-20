package charactergen.classes;

import java.util.Arrays;

public class RunePriest extends BaseClass {

    public RunePriest() {
        setRanks(Arrays.asList(3, 1, 2, 4, 0, 5));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Runepriest";
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
