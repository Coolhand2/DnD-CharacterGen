package charactergen.classes;

import java.util.Arrays;

public class Druid extends BaseClass {

    public Druid() {
        setRanks(Arrays.asList(3, 1, 2, 4, 0, 5));
        setHealth(12);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Druid";
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
