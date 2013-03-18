package charactergen.classes;

import java.util.Arrays;

public class Bard extends BaseClass {

    public Bard() {
        setRanks(Arrays.asList(3, 4, 2, 1, 5, 0));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Bard";
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Leader";
    }
}
