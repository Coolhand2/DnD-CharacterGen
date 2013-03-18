/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen.settings;

import charactergen.classes.BaseClass;
import charactergen.generators.BaseGenerator;
import charactergen.races.BaseRace;

/**
 *
 * @author Mike
 */
public abstract class BaseSetting {

    public static final BaseSetting[] SETTINGS = {new DnD4e()};

    public abstract BaseGenerator[] getGenerators();

    public abstract BaseClass[] getClasses();

    public abstract BaseRace[] getRaces();

    public abstract String getName();
}
