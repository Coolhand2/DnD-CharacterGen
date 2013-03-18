package charactergen.races;

import charactergen.Attributes;

public class Eladrin extends BaseRace {

    public Eladrin() {
        setBonuses(Attributes.DEX, Attributes.INT);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Eladrin";
    }
}
