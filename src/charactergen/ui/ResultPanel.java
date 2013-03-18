/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen.ui;

import charactergen.Attributes;
import charactergen.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author Mike
 */
public class ResultPanel extends JPanel {

    private Character _character;
    private JLabel _strengthValue, _dexterityValue, _constitutionValue, _intelligenceValue, _wisdomValue, _charismaValue;
    private JLabel _strengthMod, _dexterityMod, _constitutionMod, _intelligenceMod, _wisdomMod, _charismaMod;
    private JLabel _healthValue, _levelValue;

    public ResultPanel(Character c) {
        _character = c;
        loadPanel();
        setupPanel();
        attachListeners();
    }

    private void loadPanel() {
        _strengthValue = new JLabel("10");
        _dexterityValue = new JLabel("10");
        _constitutionValue = new JLabel("10");
        _intelligenceValue = new JLabel("10");
        _wisdomValue = new JLabel("10");
        _charismaValue = new JLabel("10");

        _strengthMod = new JLabel("+0");
        _dexterityMod = new JLabel("+0");
        _constitutionMod = new JLabel("+0");
        _intelligenceMod = new JLabel("+0");
        _wisdomMod = new JLabel("+0");
        _charismaMod = new JLabel("+0");

        _healthValue = new JLabel("0");
        _levelValue = new JLabel("1");
    }

    private void setupPanel() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JLabel strengthLabel = new JLabel("STR");
        JLabel dexterityLabel = new JLabel("DEX");
        JLabel constitutionLabel = new JLabel("CON");
        JLabel intelligenceLabel = new JLabel("INT");
        JLabel charismaLabel = new JLabel("CHA");
        JLabel wisdomLabel = new JLabel("WIS");

        JLabel attributeTitle = new JLabel("Attribute");
        JLabel attributeValue = new JLabel("Value");
        JLabel attributeMod = new JLabel("Modifier");

        JLabel levelLabel = new JLabel("Level: ");
        JLabel healthLabel = new JLabel("Health: ");

        JSeparator separatorOne = new JSeparator(JSeparator.HORIZONTAL);
        JSeparator separatorTwo = new JSeparator(JSeparator.HORIZONTAL);
        JSeparator separatorThree = new JSeparator(JSeparator.HORIZONTAL);
        JSeparator separatorFour = new JSeparator(JSeparator.HORIZONTAL);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addGroup(
                layout.createParallelGroup()
                .addComponent(attributeTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(attributeValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(attributeMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(separatorOne, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(
                layout.createParallelGroup()
                .addComponent(strengthLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_strengthValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_strengthMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(dexterityLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_dexterityValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_dexterityMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(constitutionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_constitutionValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_constitutionMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(intelligenceLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_intelligenceValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_intelligenceMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(wisdomLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_wisdomValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_wisdomMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(charismaLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_charismaValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_charismaMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(separatorFour, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(
                layout.createParallelGroup()
                .addComponent(levelLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_levelValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(healthLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_healthValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                .addGroup(
                layout.createSequentialGroup()
                .addComponent(attributeTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(attributeValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(attributeMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(separatorOne, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(
                layout.createSequentialGroup()
                .addComponent(strengthLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_strengthValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_strengthMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(
                layout.createSequentialGroup()
                .addComponent(dexterityLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_dexterityValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_dexterityMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(
                layout.createSequentialGroup()
                .addComponent(constitutionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_constitutionValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_constitutionMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(
                layout.createSequentialGroup()
                .addComponent(intelligenceLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_intelligenceValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_intelligenceMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(
                layout.createSequentialGroup()
                .addComponent(wisdomLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_wisdomValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_wisdomMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(
                layout.createSequentialGroup()
                .addComponent(charismaLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_charismaValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_charismaMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(separatorFour, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(
                layout.createSequentialGroup()
                .addComponent(levelLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_levelValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(
                layout.createSequentialGroup()
                .addComponent(healthLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_healthValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }

    private void attachListeners() {
        _character.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                updateValues();
            }
        });
    }

    private void updateValues() {
        Attributes attributes = _character.getAttributes();
        int health = _character.getHealth();
        int level = _character.getLevel();

        _strengthValue.setText(String.valueOf(attributes.get(Attributes.STR)));
        _dexterityValue.setText(String.valueOf(attributes.get(Attributes.DEX)));
        _constitutionValue.setText(String.valueOf(attributes.get(Attributes.CON)));
        _intelligenceValue.setText(String.valueOf(attributes.get(Attributes.INT)));
        _wisdomValue.setText(String.valueOf(attributes.get(Attributes.WIS)));
        _charismaValue.setText(String.valueOf(attributes.get(Attributes.CHA)));

        _strengthMod.setText(String.valueOf(attributes.getMod(Attributes.STR)));
        _dexterityMod.setText(String.valueOf(attributes.getMod(Attributes.DEX)));
        _constitutionMod.setText(String.valueOf(attributes.getMod(Attributes.CON)));
        _intelligenceMod.setText(String.valueOf(attributes.getMod(Attributes.INT)));
        _wisdomMod.setText(String.valueOf(attributes.getMod(Attributes.WIS)));
        _charismaMod.setText(String.valueOf(attributes.getMod(Attributes.CHA)));

        _healthValue.setText(String.valueOf(health));
        _levelValue.setText(String.valueOf(level));
    }
}
