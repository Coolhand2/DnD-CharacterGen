package charactergen.races;

import charactergen.Attributes;

public class Shardmind extends BaseRace {

    public Shardmind(int i) {
        setBonuses(Attributes.INT, i);
        setAttribute(i);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Shardmind (" + _attribute + ")";
    }
}
