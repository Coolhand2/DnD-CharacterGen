package charactergen.races;

import charactergen.Attributes;

public class Goliath extends BaseRace {

    public Goliath() {
        setBonuses(Attributes.STR, Attributes.CON);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Goliath";
    }
}
