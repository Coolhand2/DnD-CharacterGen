package charactergen.races;

import charactergen.Attributes;

public class Gnome extends BaseRace {

    public Gnome() {
        setBonuses(Attributes.INT, Attributes.CHA);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Gnome";
    }
}
