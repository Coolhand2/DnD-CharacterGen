package charactergen.classes;

import java.util.Arrays;

public class Invoker extends BaseClass {

    public Invoker() {
        setRanks(Arrays.asList(3, 4, 1, 2, 0, 5));
        setHealth(10);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Invoker";
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
