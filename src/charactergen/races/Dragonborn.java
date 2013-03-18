package charactergen.races;

import charactergen.Attributes;

public class Dragonborn extends BaseRace {

    public Dragonborn() {
        setBonuses(Attributes.STR, Attributes.CHA);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Dragonborn";
    }
}
