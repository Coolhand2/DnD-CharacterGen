package charactergen.races;

import charactergen.Attributes;

public class HalfOrc extends BaseRace {

    public HalfOrc() {
        setBonuses(Attributes.STR, Attributes.DEX);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "HalfOrc";
    }
}
