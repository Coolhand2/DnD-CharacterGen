/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergen.ui;

import charactergen.Character;
import charactergen.classes.BaseClass;
import charactergen.generators.BaseGenerator;
import charactergen.races.BaseRace;
import charactergen.settings.BaseSetting;
import charactergen.settings.DnD4e;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Mike
 */
public class ChoicePanel extends JPanel {

    private Character _character;
    private JComboBox _generatorBox;
    private JComboBox _classBox;
    private JComboBox _raceBox;
    private JComboBox _settingsBox;
    private JSpinner _levelSpinner;
    private ActionListener _raceListener;
    private ActionListener _classListener;
    private ActionListener _generatorListener;
    private JButton _classLock;
    private JButton _raceLock;
    private boolean _classLocked;
    private boolean _raceLocked;
    private BaseSetting _setting;
    private final String SEPARATOR = "------------";

    public ChoicePanel(Character c) {
        _character = c;
        _setting = new DnD4e();
        _classLocked = false;
        _raceLocked = false;
        loadPanel();
        setupPanel();
        attachListeners();
    }

    private void loadPanel() {
        Vector<String> settings = new Vector<>();
        for (BaseSetting bs : BaseSetting.SETTINGS) {
            settings.add(bs.getName());
        }
        Vector<String> generators = new Vector<>();
        for(BaseGenerator bg : _setting.getGenerators()){
            generators.add(bg.getName());
        }
        Vector<String> classes = new Vector<>();
        for(BaseClass bc : _setting.getClasses()){
            classes.add(bc.getName());
        }
        Vector<String> races = new Vector<>();
        for(BaseRace br : _setting.getRaces()){
            races.add(br.getName());
        }
        _settingsBox = new JComboBox(settings);
        _generatorBox = new JComboBox(generators);
        _classBox = new JComboBox(classes);
        _raceBox = new JComboBox(races);
        _levelSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
    }

    private void setupPanel() {

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel settingLabel = new JLabel("Setting: ");
        JLabel editionLabel = new JLabel("Roll Type: ");
        JLabel classLabel = new JLabel("Class: ");
        JLabel raceLabel = new JLabel("Race: ");
        JLabel levelLabel = new JLabel("Level: ");

        JLabel placeholder = new JLabel("");

        _classLock = new JButton("Lock");
        _raceLock = new JButton("Lock");

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addGroup(
                layout.createParallelGroup()
                .addComponent(settingLabel)
                .addComponent(_settingsBox)
                .addComponent(placeholder))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(editionLabel)
                .addComponent(_generatorBox)
                .addComponent(placeholder))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(classLabel)
                .addComponent(_classBox)
                .addComponent(_classLock))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(raceLabel)
                .addComponent(_raceBox)
                .addComponent(_raceLock))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(levelLabel)
                .addComponent(_levelSpinner)
                .addComponent(placeholder)));
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addGroup(
                layout.createParallelGroup()
                .addComponent(settingLabel)
                .addComponent(editionLabel)
                .addComponent(classLabel)
                .addComponent(raceLabel)
                .addComponent(levelLabel))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(_settingsBox)
                .addComponent(_generatorBox)
                .addComponent(_classBox)
                .addComponent(_raceBox)
                .addComponent(_levelSpinner))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(placeholder)
                .addComponent(placeholder)
                .addComponent(_classLock)
                .addComponent(_raceLock)
                .addComponent(placeholder)));
    }

    private void attachListeners() {
        _settingsBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object index = _settingsBox.getSelectedItem();
                for (BaseSetting bs : BaseSetting.SETTINGS) {
                    if (bs.getName().equals(index.toString())) {
                        _setting = bs;
                    }
                }
                _generatorBox.removeActionListener(_generatorListener);
                _generatorBox.removeAllItems();
                for (BaseGenerator bg : _setting.getGenerators()) {
                    _generatorBox.addItem(bg.getName());
                }
                _generatorBox.addActionListener(_generatorListener);

                _classBox.removeActionListener(_classListener);
                _classBox.removeAllItems();
                for (BaseClass bc : _setting.getClasses()) {
                    _classBox.addItem(bc.getName());
                }
                _classBox.addActionListener(_classListener);

                _raceBox.removeActionListener(_raceListener);
                _raceBox.removeAllItems();
                for (BaseRace br : _setting.getRaces()) {
                    _raceBox.addItem(br.getName());
                }
                _raceBox.addActionListener(_raceListener);
            }
        });

        _generatorListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Object index = _generatorBox.getSelectedItem();
                for (BaseGenerator bg : _setting.getGenerators()) {
                    if (bg.getName().equals(index.toString())) {
                        _character.setGenerator(bg);
                    }
                }
            }
        };

        _raceListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Object index = _raceBox.getSelectedItem();
                for (BaseRace br : _setting.getRaces()) {
                    if (br.getName().equals(index.toString())) {
                        _character.setRace(br);
                    }
                }
                setPreferredClasses();
            }
        };

        _classListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Object index = _classBox.getSelectedItem();
                for (BaseClass bc : _setting.getClasses()) {
                    if (bc.getName().equals(index.toString())) {
                        _character.setClass(bc);
                    }
                }
                setPreferredRaces();
            }
        };

        _generatorBox.addActionListener(_generatorListener);
        _classBox.addActionListener(_classListener);
        _raceBox.addActionListener(_raceListener);

        _classLock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                _classBox.setEnabled(_classLocked);
                _classLocked = !_classLocked;
                if (_classLocked) {
                    _classLock.setText("Unlock");
                } else {
                    _classLock.setText("Lock");
                }
            }
        });
        _raceLock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                _raceBox.setEnabled(_raceLocked);
                _raceLocked = !_raceLocked;
                if (_raceLocked) {
                    _raceLock.setText("Unlock");
                } else {
                    _raceLock.setText("Lock");
                }
            }
        });

        _levelSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                _character.setLevel(Integer.parseInt(_levelSpinner.getValue().toString()));
            }
        });
    }

    private void setPreferredRaces() {
        if (!_raceLocked) {
            _raceBox.removeActionListener(_raceListener);
            _raceBox.removeAllItems();
            Vector<BaseRace> preferred = _character.getRankedRaces(16);
            Vector<BaseRace> average = _character.getRankedRaces(15);
            Vector<BaseRace> poor = _character.getRankedRaces(14);
            for (BaseRace item : preferred) {
                _raceBox.addItem(item.getName());
            }
            _raceBox.addItem(SEPARATOR);
            for (BaseRace item : average) {
                _raceBox.addItem(item.getName());
            }
            _raceBox.addItem(SEPARATOR);
            for (BaseRace item : poor) {
                _raceBox.addItem(item.getName());
            }
            _character.setRace(preferred.elementAt(0));
            _raceBox.addActionListener(_raceListener);
        }
    }

    private void setPreferredClasses() {
        if (!_classLocked) {
            _classBox.removeActionListener(_classListener);
            _classBox.removeAllItems();
            Vector<BaseClass> preferred = _character.getRankedClasses(16);
            Vector<BaseClass> average = _character.getRankedClasses(15);
            Vector<BaseClass> poor = _character.getRankedClasses(14);
            for (BaseClass item : preferred) {
                _classBox.addItem(item.getName());
            }
            _classBox.addItem(SEPARATOR);
            for (BaseClass item : average) {
                _classBox.addItem(item.getName());
            }
            for (BaseClass item : poor) {
                _classBox.addItem(item.getName());
            }
            _character.setClass(preferred.elementAt(0));
            _classBox.addActionListener(_classListener);
        }
    }
}
