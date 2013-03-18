/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen.generators;

/**
 *
 * @author Mike
 */
public class ImpossibleSpread extends BaseGenerator{

    @Override
    public String getName() {
        return "The Impossibru Array";
    }

    @Override
    public int[] getAttributes() {
        int[] local = {19, 19, 19, 19, 19, 19};
        return local;
    }
}
