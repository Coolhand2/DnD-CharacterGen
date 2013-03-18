package charactergen.races;

import charactergen.Attributes;

public class Githzerai extends BaseRace {

    public Githzerai(int i) {
        setBonuses(Attributes.WIS, i);
        setAttribute(i);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Githzerai (" + _attribute + ")";
    }
}
