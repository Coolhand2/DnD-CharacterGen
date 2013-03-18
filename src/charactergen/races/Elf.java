package charactergen.races;

import charactergen.Attributes;

public class Elf extends BaseRace {

    public Elf() {
        setBonuses(Attributes.DEX, Attributes.INT);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Elf";
    }
}
