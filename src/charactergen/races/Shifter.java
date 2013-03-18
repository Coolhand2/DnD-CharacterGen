package charactergen.races;

import charactergen.Attributes;

public class Shifter extends BaseRace {

    public Shifter() {
        setBonuses(Attributes.STR, Attributes.WIS);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Shifter";
    }
}
