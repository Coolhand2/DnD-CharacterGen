package charactergen.races;

import charactergen.Attributes;

public class Deva extends BaseRace {

    public Deva() {
        setBonuses(Attributes.INT, Attributes.WIS);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Deva";
    }
}
