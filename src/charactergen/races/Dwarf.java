package charactergen.races;

import charactergen.Attributes;

public class Dwarf extends BaseRace {

    public Dwarf() {
        setBonuses(Attributes.CON, Attributes.WIS);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Dwarf";
    }
}
