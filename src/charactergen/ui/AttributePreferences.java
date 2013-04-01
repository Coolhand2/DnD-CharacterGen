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
    private JLabel[] _ranks = {new JLabel(""), new JLabel(""), new JLabel(""), new JLabel(""), new JLabel(""), new JLabel("")};
    private JButton _save, _clear, _reset;
    private JButton[] _attributes ={new JButton("STR"), new JButton("DEX"), new JButton("CON"), new JButton("INT"), new JButton("WIS"), new JButton("CHA")};
    private boolean[] _placed = {true, true, true, true, true, true};
    private int _count;

    public AttributePreferences(Character c) {
        _character = c;
        _count = 6;

        loadDialog();
        setupDialog();
        addListeners();
    }

    private void loadDialog() {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        _save = new JButton("Save!");
        _clear = new JButton("Clear");
        _reset = new JButton("Reset");

        Vector<Integer> ranks = _character.getClassType().getRanks();
        int i = 0;
        for(JLabel l : _ranks){
            l.setText(Attributes.getAttributeName(ranks.get(i)));
            i++;
        }
    }

    private void setupDialog() {
        addToPanel(new JLabel("First"), 1, 1, 1, 1);
        addToPanel(new JLabel("Second"), 2, 1, 1, 1);
        addToPanel(new JLabel("Third"), 3, 1, 1, 1);
        addToPanel(new JLabel("Fourth"), 4, 1, 1, 1);
        addToPanel(new JLabel("Fifth"), 5, 1, 1, 1);
        addToPanel(new JLabel("Sixth"), 6, 1, 1, 1);
        int i = 1;
        for(JLabel l : _ranks){
            addToPanel(l, i, 2, 1, 1);
            i++;
        }
        i = 1;
        for(JButton b : _attributes){
            addToPanel(b, i, 3, 1, 1);
            i++;
        }
        addToPanel(_save, 1, 4, 2, 1);
        addToPanel(_clear, 3, 4, 2, 1);
        addToPanel(_reset, 5, 4, 2, 1);

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
        _clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearStats();
            }
        });
        _reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetStats();
            }
        });
        for(JButton b : _attributes){
            final String name = b.getText();
            b.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    toggleAttribute(name);
                }
            });
        }
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
        Vector<Integer> preferences = new Vector<>();
        for(JLabel l : _ranks){
            preferences.add(Attributes.translate(l.getText()));
        }
        _character.getClassType().resetRanks(preferences);
        setVisible(false);
    }

    private void clearStats(){
        for(JLabel l : _ranks){
            l.setText("");
        }
        boolean[] local = {false, false, false, false, false, false};
        _placed = local;
        _count = 0;
    }

    private void resetStats(){
        Vector<Integer> preferences = _character.getClassType().getDefaultRanks();
        int i = 0;
        for(JLabel l : _ranks){
            l.setText(Attributes.getAttributeName(preferences.get(i)));
            i++;
        }
        boolean[] local = {true, true, true, true, true, true};
        _placed = local;
        _count = 6;
    }

    private void toggleAttribute(String attribute){
        int value = Attributes.translate(attribute);
        if(_placed[value]){
            removeAttribute(attribute);
            _count--;
        } else {
            addAttribute(attribute);
            _count++;
        }
        _placed[value] = !_placed[value];
    }
    private void addAttribute(String attribute){
        int value = Attributes.translate(attribute);
        _ranks[_count].setText(attribute);
    }

    private void removeAttribute(String attribute){
        int i = 0;
        for(JLabel l : _ranks){
            if( l.getText().equals(attribute) ){
                l.setText("");
                shrink(i);
            }
            i++;
        }
    }

    private void shrink(int i){
        for(; i < 5; i++){
            _ranks[i].setText(_ranks[i+1].getText());
            _ranks[i+1].setText("");
        }
    }
}
