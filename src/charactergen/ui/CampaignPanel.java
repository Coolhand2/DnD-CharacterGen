/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen.ui;

import charactergen.Character;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import charactergen.support.ClipboardCopy;

/**
 *
 * @author Mike
 */
public class CampaignPanel extends JPanel {

    private Character _character;
    private JEditorPane _infoPane;
    private JButton _copyButton;

    public CampaignPanel(Character c) {
        _character = c;
        loadPanel();
        setupPanel();
        attachListeners();
    }

    private void loadPanel() {
        _infoPane = new JEditorPane();
        _copyButton = new JButton("Copy to Clipboard");

        Dimension d = new Dimension(200, 200);
        _infoPane.setEditable(false);
        _infoPane.setMinimumSize(d);
    }

    private void setupPanel() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                .addComponent(_infoPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_copyButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addComponent(_infoPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_copyButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    }

    private void attachListeners() {
        _character.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _infoPane.setText(_character.toString());
            }
        });

        _copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClipboardCopy cc = new ClipboardCopy();
                cc.toClipboard(_infoPane.getText());
            }
        });
    }
}
