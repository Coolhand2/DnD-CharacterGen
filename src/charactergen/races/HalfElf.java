package charactergen.races;

import charactergen.Attributes;

public class HalfElf extends BaseRace {

    public HalfElf() {
        setBonuses(Attributes.CON, Attributes.CHA);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "HalfElf";
    }
}
