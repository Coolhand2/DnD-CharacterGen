/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen.ui;

import charactergen.Character;
import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author Mike
 */
public class MainInterface extends JFrame {

    private Character _character;

    public MainInterface(Character c) {
        _character = c;
        setupFrame();
        loadFrame();
        pack();
    }

    private void setupFrame() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Character Generator");
    }

    private void loadFrame() {

        Container mainPanel = getContentPane();
        ChoicePanel choicePanel = new ChoicePanel(_character);
        GeneratePanel generatePanel = new GeneratePanel(_character);
        ResultPanel resultPanel = new ResultPanel(_character);
        CampaignPanel campaignPanel = new CampaignPanel(_character);

        JSeparator horizontalSeparator = new JSeparator(JSeparator.HORIZONTAL);
        JSeparator verticalSeparator = new JSeparator(JSeparator.VERTICAL);

        GroupLayout mainLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainLayout);
        mainLayout.setAutoCreateGaps(true);
        mainLayout.setAutoCreateContainerGaps(true);

        mainLayout.setVerticalGroup(
                mainLayout.createParallelGroup()
                .addGroup(
                mainLayout.createSequentialGroup()
                .addComponent(choicePanel)
                .addComponent(generatePanel)
                .addComponent(horizontalSeparator)
                .addComponent(campaignPanel))
                .addComponent(verticalSeparator)
                .addGroup(
                mainLayout.createParallelGroup()
                .addComponent(resultPanel)));
        mainLayout.setHorizontalGroup(
                mainLayout.createSequentialGroup()
                .addGroup(
                mainLayout.createParallelGroup()
                .addComponent(choicePanel)
                .addComponent(generatePanel)
                .addComponent(horizontalSeparator)
                .addComponent(campaignPanel))
                .addComponent(verticalSeparator)
                .addGroup(
                mainLayout.createParallelGroup()
                .addComponent(resultPanel)));
    }
}
