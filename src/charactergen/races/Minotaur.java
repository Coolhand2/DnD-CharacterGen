package charactergen.races;

import charactergen.Attributes;

public class Minotaur extends BaseRace {

    public Minotaur(int i) {
        setBonuses(Attributes.STR, i);
        setAttribute(i);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Minotaur (" + _attribute + ")";
    }
}
