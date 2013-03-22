package charactergen.classes;

import charactergen.Attributes;
import java.util.List;
import java.util.Vector;

public abstract class BaseClass {

    private Vector<Integer> _ranks = new Vector<>();
    private Vector<Integer> _preferred = new Vector<>();
    private int _baseHealth = 0;
    protected int _levelHealth = 0;

    protected void setHealth(int i) {
        _baseHealth = i;
        _levelHealth = (i / 2) - 1;
    }

    public Vector<Integer> getRanks() {
        return _ranks;
    }

    public Vector<Integer> getPreferred() {
        return _preferred;
    }

    public void setRanks(List<Integer> ranks) {
        _ranks = new Vector<>(ranks);
        setPreferred();
    }

    private void setPreferred() {
        for (int i = 0; i < 3; i++) {
            _preferred.add(_ranks.indexOf(i));
        }
    }

    public abstract String getName();

    public abstract String getRole();

    public abstract int getSurges();

    public int getBaseHealth() {
        return _baseHealth;
    }

    public int getLevelHealth() {
        return _levelHealth;
    }
}
