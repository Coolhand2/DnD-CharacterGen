/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen;

import charactergen.ui.MainInterface;
import java.awt.EventQueue;

/**
 *
 * @author Mike
 */
public class CharacterGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainInterface mainInterface = new MainInterface(new Character());
            }
        });
    }
}
