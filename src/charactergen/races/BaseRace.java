/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen.races;

import charactergen.Attributes;
import java.util.Vector;

/**
 *
 * @author Mike
 */
public abstract class BaseRace {

    protected Vector<Integer> _bonuses = new Vector<Integer>();
    protected String _attribute = "";

    public Vector<Integer> getBonuses() {
        return _bonuses;
    }

    public void setBonuses(int a, int b) {
        _bonuses.add(a);
        _bonuses.add(b);
    }

    public void setBonuses(int a) {
        _bonuses.add(a);
    }

    public void setAttribute(int i) {
        _attribute = Attributes.getAttributeName(i);
    }

    public String getAttributeName() {
        return _attribute;
    }

    public abstract String getName();
}
