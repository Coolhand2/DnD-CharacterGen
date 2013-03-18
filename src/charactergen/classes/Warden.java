package charactergen.classes;

import java.util.Arrays;

public class Warden extends BaseClass {

    public Warden() {
        setRanks(Arrays.asList(0, 3, 1, 4, 2, 5));
        setHealth(17);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Warden";
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
