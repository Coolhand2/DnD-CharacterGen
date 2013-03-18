package charactergen.races;

import charactergen.Attributes;

public class Halfling extends BaseRace {

    public Halfling() {
        setBonuses(Attributes.DEX, Attributes.CHA);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Halfling";
    }
}
