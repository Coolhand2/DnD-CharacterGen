package charactergen.classes;

import java.util.Arrays;

public class Battlemind extends BaseClass {

    public Battlemind() {
        setRanks(Arrays.asList(3, 4, 0, 5, 1, 2));
        setHealth(15);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Battlemind";
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Defender";
    }

    @Override
    public int getSurges() {
        return 9;
    }
}
