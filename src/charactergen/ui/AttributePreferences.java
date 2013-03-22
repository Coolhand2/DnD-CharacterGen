/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen.ui;

import charactergen.Attributes;
import charactergen.Character;
import charactergen.classes.BaseClass;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Mike
 */
public class AttributePreferences extends JDialog {

    private Character _character;
    private JLabel _organization;
    private JButton _save, _str, _dex, _con, _int, _wis, _cha;
    private boolean _strPlaced, _dexPlaced, _conPlaced, _intPlaced, _wisPlaced, _chaPlaced;

    public AttributePreferences(Character c) {
        _character = c;

        _strPlaced = true;
        _dexPlaced = true;
        _conPlaced = true;
        _intPlaced = true;
        _wisPlaced = true;
        _chaPlaced = true;

        loadDialog();
        setupDialog();
        addListeners();
    }

    private void loadDialog() {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        _save = new JButton("Save!");

        _str = new JButton("STR");
        _dex = new JButton("DEX");
        _con = new JButton("CON");
        _int = new JButton("INT");
        _wis = new JButton("WIS");
        _cha = new JButton("CHA");

        _organization = new JLabel();
        Vector<Integer> ranks = _character.getClassType().getRanks();
        String attributes = "";
        for(Integer r : ranks){
            attributes += Attributes.getAttributeName(r) + " ";
        }
        _organization.setText(attributes);
    }

    private void setupDialog() {
        addToPanel(new JLabel("Order: "), 1, 1, 2, 1);
        addToPanel(_organization, 3, 1, 3, 1);
        addToPanel(_str, 1, 2, 1, 1);
        addToPanel(_dex, 2, 2, 1, 1);
        addToPanel(_con, 3, 2, 1, 1);
        addToPanel(_int, 4, 2, 1, 1);
        addToPanel(_wis, 5, 2, 1, 1);
        addToPanel(_cha, 6, 2, 1, 1);
        addToPanel(_save, 1, 3, 6, 1);

        pack();
        setVisible(true);
    }

    private void addListeners() {
        _save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveStats();
            }
        });
    }

    private void addToPanel(Component c, int x, int y, int w, int h) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        constraints.fill = GridBagConstraints.BOTH;
        add(c, constraints);
    }

    private void saveStats() {
        String[] array = _organization.getText().split(" ");
        int[] places = {0, 0, 0, 0, 0, 0};
        Vector<Integer> values = new Vector<>();
        for(int i = 0; i < 6; i++){
            int attribute = Attributes.translate(array[i]);
            places[attribute] = i;
        }
        for(int i : places){
            values.add(i);
        }
        BaseClass c = _character.getClassType();
        c.setRanks(values);
    }
}
