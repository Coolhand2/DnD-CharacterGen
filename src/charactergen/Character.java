/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen;

import charactergen.classes.*;
import charactergen.generators.*;
import charactergen.races.*;
import charactergen.settings.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Mike
 */
public class Character {

    List<ActionListener> _listeners = new ArrayList<>();
    private BaseGenerator _generator;
    private BaseRace _race;
    private BaseClass _class;
    private Attributes _attributes;
    private int _level;
    private int _health;
    private Vector<ClassMap> _classMap;
    private BaseSetting _setting;
    private int _initiative;

    public Character() {
        _level = 1;
        _health = 0;
        _initiative = 0;
        _attributes = new Attributes();
        _generator = new NormalSpread();
        _race = new Deva();
        _class = new Ardent();
        _classMap = new Vector<>();
        _setting = new DnD4e();

        BaseGenerator g = new SpecialSpread();
        for (BaseClass bc : _setting.getClasses()) {
            for (BaseRace br : _setting.getRaces()) {
                int[] attributes = g.getAttributes();
                Vector<Integer> bonuses = br.getBonuses();
                Vector<Integer> ranks = bc.getRanks();
                Vector<Integer> preferred = bc.getPreferred();
                int[] sums = {0, 0, 0, 0, 0, 0};
                for (int i = 0; i < 6; i++) {
                    sums[i] += (bonuses.contains(i)) ? 2 : 0;
                    sums[i] += attributes[ranks.elementAt(i)];
                }
                float average = 0;
                for (int index : preferred) {
                    average += sums[index];
                }
                average /= 3;
                ClassMap cm = new ClassMap(bc, br, Math.round(average));
                _classMap.add(cm);
            }
        }
    }

    public void setGenerator(BaseGenerator g) {
        _generator = g;
    }

    public void setRace(BaseRace r) {
        _race = r;
    }

    public void setClass(BaseClass c) {
        _class = c;
    }

    public void setLevel(int l) {
        _level = l;
    }

    public void setInitiativeBonus(int i){
        _initiative += i;
    }

    public int getInitiative(){
        return _initiative + (int)(_level/2) + _attributes.getMod(Attributes.DEX);
    }

    public void generateAttributes() {
        int[] attributes = _generator.getAttributes();
        Vector<Integer> bonuses = _race.getBonuses();
        Vector<Integer> ranks = _class.getRanks();
        Vector<Integer> preferred = _class.getPreferred();
        int[] sums = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 6; i++) {
            sums[i] += (bonuses.contains(i)) ? 2 : 0;
            sums[i] += attributes[ranks.elementAt(i)];
        }
        _health = attributes[Attributes.CON] + _class.getBaseHealth();
        for (int i = 0; i < _level; i++) {
            if(i > 1){
                _health += _class.getLevelHealth();
            }
            switch (i) {
                case 4:
                case 8:
                case 14:
                case 18:
                case 24:
                case 28:
                    sums[preferred.elementAt(0)]++;
                    sums[preferred.elementAt(1)]++;
                    if( preferred.contains(Attributes.CON)){
                        _health++;
                    }
                    break;
                case 11:
                case 21:
                    for (int k = 0; k < 6; k++) {
                        sums[k]++;
                    }
                    _health++;
                    break;
            }
        }
        _attributes.setAll(sums);
        notifyListeners();
    }

    public Attributes getAttributes() {
        return _attributes;
    }

    public int getMaxHealth() {
        return _health;
    }

    public int getBloodied(){
        return (int)getMaxHealth()/2;
    }

    public int getSurgeValue(){
        return (int)getMaxHealth()/4;
    }

    public int getSurgeAmount(){
        return _class.getSurges() + _attributes.getMod(Attributes.CON);
    }

    public int getLevel() {
        return _level;
    }

    public int getMeleeAttack(){
        return _attributes.getMod(Attributes.STR) + (int)Math.floor(_level/2);
    }

    public int getRangedAttack(){
        return _attributes.getMod(Attributes.DEX) + (int)Math.floor(_level/2);
    }

    public int getFortitude(){
        return Math.max(_attributes.getMod(Attributes.STR), _attributes.getMod(Attributes.CON)) + (int)Math.floor(_level/2);
    }

    public int getReflex(){
        return Math.max(_attributes.getMod(Attributes.DEX), _attributes.getMod(Attributes.INT)) + (int)Math.floor(_level/2);
    }

    public int getWill(){
        return Math.max(_attributes.getMod(Attributes.WIS), _attributes.getMod(Attributes.CHA)) + (int)Math.floor(_level/2);
    }

    public void addActionListener(ActionListener al) {
        _listeners.add(al);
    }

    private void notifyListeners() {
        for (ActionListener al : _listeners) {
            al.actionPerformed((ActionEvent) null);
        }
    }

    public BaseClass getClassType() {
        return _class;
    }

    public Vector<BaseRace> getRankedRaces(int rank) {
        Vector<BaseRace> br = new Vector<>();
        for (ClassMap item : _classMap) {
            if (item.getClassType().getName().equals(_class.getName())) {
                if (item.getAverage() == rank) {
                    br.add(item.getRace());
                }
            }
        }
        return br;
    }

    public Vector<BaseClass> getRankedClasses(int rank) {
        Vector<BaseClass> bc = new Vector<>();
        for (ClassMap item : _classMap) {
            if (item.getRace().getName().equals(_race.getName())) {
                if (item.getAverage() == rank) {
                    bc.add(item.getClassType());
                }
            }
        }
        return bc;
    }

    @Override
    public String toString() {
        String description = "";
        description += _class.getName() + " " + _race.getName();
        description += " level(" + getLevel() + ") health(" + getMaxHealth() + ")";
        description += " bloodied(" + getBloodied() + ") healing surge(" + getSurgeValue() + ")";
        description += " melee(" + getMeleeAttack() + ")";
        description += " ranged(" + getRangedAttack() + ")";
        description += " fortitude(" + getFortitude() + ")";
        description += " reflex(" + getReflex() + ")";
        description += " will(" + getWill() + ")";

        return description;
    }
}
