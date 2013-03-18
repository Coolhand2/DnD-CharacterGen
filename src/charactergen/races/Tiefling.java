package charactergen.races;

import charactergen.Attributes;

public class Tiefling extends BaseRace {

    public Tiefling() {
        setBonuses(Attributes.STR, Attributes.CHA);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Tiefling";
    }
}
