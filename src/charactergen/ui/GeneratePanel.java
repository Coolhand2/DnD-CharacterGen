/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen.ui;

import charactergen.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author Mike
 */
public class GeneratePanel extends JPanel {

    private Character _character;
    private JButton _generate;
    private JButton _attributeSet;

    public GeneratePanel(Character c) {
        _character = c;
        loadPanel();
        setupPanel();
        attachListeners();
    }

    private void loadPanel() {
        _generate = new JButton("Generate!");
        _attributeSet = new JButton("Set Attribute Preferences");
    }

    private void setupPanel() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JSeparator top = new JSeparator(JSeparator.HORIZONTAL);
        JSeparator mid = new JSeparator(JSeparator.HORIZONTAL);


        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addComponent(top)
                .addComponent(_attributeSet)
                .addComponent(mid)
                .addComponent(_generate));
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                .addComponent(top)
                .addComponent(_attributeSet, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mid)
                .addComponent(_generate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    }

    private void attachListeners() {
        _generate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                _character.generateAttributes();
            }
        });

        _attributeSet.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                new AttributePreferences(_character);
            }
        });
    }
}
