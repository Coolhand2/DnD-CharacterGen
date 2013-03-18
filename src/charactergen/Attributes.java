/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen;

/**
 *
 * @author Mike
 */
public class Attributes {

    public static final int STR = 0;
    public static final int DEX = 1;
    public static final int CON = 2;
    public static final int INT = 3;
    public static final int WIS = 4;
    public static final int CHA = 5;
    private int[] _attributes = {0, 0, 0, 0, 0, 0};

    public void setAll(int[] a) {
        for(int i = 0; i < 6; i++){
            setAttribute(i, a[i]);
        }
    }

    public void setAttribute(int index, int value) {
        _attributes[index] = value;
    }

    public int[] getAttributes() {
        return _attributes;
    }

    public int getAttribute(int index) {
        return _attributes[index];
    }

    public int get(int index) {
        return _attributes[index];
    }

    public int getMod(int index) {
        int value = _attributes[index] - 10;
        if( value < 0){
            return (int)Math.ceil(value/2);
        } else {
            return (int)Math.floor(value/2);
        }
    }
}
