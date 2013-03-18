package charactergen.races;

import charactergen.Attributes;

public class Wilden extends BaseRace {

    public Wilden(int i) {
        setBonuses(Attributes.WIS, i);
        setAttribute(i);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Wilden (" + getAttributeName() + ")";
    }
}
