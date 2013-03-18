package charactergen.classes;

import java.util.Arrays;

public class Fighter extends BaseClass {

    public Fighter() {
        setRanks(Arrays.asList(0, 1, 3, 4, 2, 5));
        setHealth(15);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Fighter";
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Defender";
    }
}
