package kpolicar.ui;

import kpolicar.Main;
import kpolicar.game.Preferences;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class PreferencesPanel extends JPanel {
    public JFormattedTextField rows;
    public JFormattedTextField columns;
    public JFormattedTextField variations;
    Preferences preferences = Main.preferences;

    NumberFormatter formatter;

    public PreferencesPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setupNumberFormatter();

        JLabel label = new JLabel("Modify preferences");
        add(label);
        addFields();
    }

    protected void addFields() {
        rows = new JFormattedTextField(formatter);
        columns = new JFormattedTextField(formatter);
        variations = new JFormattedTextField(formatter);

        rows.setValue(preferences.rows);
        columns.setValue(preferences.columns);
        variations.setValue(preferences.palette.length);

        JLabel rowsLabel = new JLabel("Rows");
        JLabel columnsLabel = new JLabel("Columns");
        JLabel variationsLabel = new JLabel("Variations");
        rowsLabel.setLabelFor(rows);
        columnsLabel.setLabelFor(columns);
        variationsLabel.setLabelFor(variations);

        add(rowsLabel);
        add(rows);
        add(columnsLabel);
        add(columns);
        add(variationsLabel);
        add(variations);
    }

    protected void setupNumberFormatter() {
        NumberFormat format = NumberFormat.getInstance();
        formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(2);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
    }
}
