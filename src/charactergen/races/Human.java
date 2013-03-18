package charactergen.races;

public class Human extends BaseRace {

    public Human(int i) {
        setBonuses(i);
        setAttribute(i);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Human (" + _attribute + ")";
    }
}
