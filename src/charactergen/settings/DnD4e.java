/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen.settings;

import charactergen.classes.Ardent;
import charactergen.classes.Avenger;
import charactergen.classes.Barbarian;
import charactergen.classes.Bard;
import charactergen.classes.BaseClass;
import charactergen.classes.Battlemind;
import charactergen.classes.Cleric;
import charactergen.classes.Druid;
import charactergen.classes.Fighter;
import charactergen.classes.Invoker;
import charactergen.classes.Monk;
import charactergen.classes.Paladin;
import charactergen.classes.Psion;
import charactergen.classes.Ranger;
import charactergen.classes.Rogue;
import charactergen.classes.RunePriest;
import charactergen.classes.Seeker;
import charactergen.classes.Shaman;
import charactergen.classes.Sorcerer;
import charactergen.classes.Warden;
import charactergen.classes.Warlock;
import charactergen.classes.Warlord;
import charactergen.classes.Wizard;
import charactergen.generators.BaseGenerator;
import charactergen.generators.DualSpecSpread;
import charactergen.generators.ImpossibleSpread;
import charactergen.generators.NormalRoll;
import charactergen.generators.NormalSpread;
import charactergen.generators.PowerRoll;
import charactergen.generators.SpecialSpread;
import charactergen.races.BaseRace;
import charactergen.races.Deva;
import charactergen.races.Dragonborn;
import charactergen.races.Dwarf;
import charactergen.races.Eladrin;
import charactergen.races.Elf;
import charactergen.races.Githzerai;
import charactergen.races.Gnome;
import charactergen.races.Goliath;
import charactergen.races.HalfElf;
import charactergen.races.HalfOrc;
import charactergen.races.Halfling;
import charactergen.races.Human;
import charactergen.races.Minotaur;
import charactergen.races.Shardmind;
import charactergen.races.Shifter;
import charactergen.races.Tiefling;
import charactergen.races.Wilden;

/**
 *
 * @author Mike
 */
public class DnD4e extends BaseSetting {

    private final BaseClass[] _classes = {
        new Ardent(), new Avenger(), new Barbarian(), new Bard(),
        new Battlemind(), new Cleric(), new Druid(), new Fighter(),
        new Invoker(), new Monk(), new Paladin(), new Psion(), new Ranger(),
        new Rogue(), new RunePriest(), new Seeker(), new Shaman(),
        new Sorcerer(), new Warden(), new Warlock(), new Warlord(), new Wizard()
    };
    private final BaseRace[] _races = {
        new Deva(), new Dragonborn(), new Dwarf(), new Eladrin(), new Elf(),
        new Githzerai(1), new Githzerai(3), new Gnome(), new Goliath(),
        new HalfElf(), new HalfOrc(), new Halfling(), new Human(0), new Human(1),
        new Human(2), new Human(3), new Human(4), new Human(5), new Minotaur(2),
        new Minotaur(4), new Shardmind(4), new Shardmind(5), new Shifter(),
        new Tiefling(), new Wilden(2), new Wilden(1)
    };
    private final BaseGenerator[] _generators = {
        new NormalSpread(), new SpecialSpread(), new DualSpecSpread(),
        new NormalRoll(), new PowerRoll(), new ImpossibleSpread()
    };

    @Override
    public String getName() {
        return "DnD 4e";
    }

    @Override
    public BaseGenerator[] getGenerators() {
        return _generators;
    }

    @Override
    public BaseClass[] getClasses() {
        return _classes;
    }

    @Override
    public BaseRace[] getRaces() {
        return _races;
    }
}
