package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Vova on 14.12.2017.
 */
public class CalcMenu extends JFrame {

    JButton dietButton;
    JComboBox list;
    JLabel label;
    JButton addButton;
    JTextField textField;
    JTextArea textArea;
    HashMap<String, Banan> hashMap = new HashMap<>();


    public CalcMenu() {
        super("Calories calculator");
        hashMap.put("Banan", new Banan("calorii", "sdfg"));
        hashMap.put("Apple", new Banan("calories", "gramms"));
        this.setBounds(100, 100, 700, 450);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        GridBagLayout gbl = new GridBagLayout();
        container.setLayout(gbl);
        GridBagConstraints c = new GridBagConstraints();

        gbl.preferredLayoutSize(container);

        list = new JComboBox(hashMap.keySet().toArray());
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 70;
        c.insets.left = 10;
        c.insets.top = 10;
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(hashMap.get(list.getItemAt(list.getSelectedIndex())).toString());

            }
        });
        gbl.setConstraints(list, c);
        container.add(list);

        /*"<html><ul><li> Белки 5 грамм</li>" +
                "<li> Жиры 0,2 грамма</li><li> Углеводы 3 грамма</li><ul>"*/

        label = new JLabel();
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 1;
        c.gridx = 0;
        gbl.setConstraints(label, c);
        container.add(label);

        addButton = new JButton("Добавить");
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.SOUTHWEST;
        c.gridy = 2;
        c.gridx = 0;
        c.insets.bottom = 10;
        c.insets.left = 10;
        gbl.setConstraints(addButton, c);
        container.add(addButton);

        textField = new JTextField("gaga");
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridy = 0;
        c.gridx = 1;
        gbl.setConstraints(textField, c);
        container.add(textField);

        dietButton = new JButton("Diet");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.SOUTH;
        c.gridy = 2;
        c.gridx = 1;
        gbl.setConstraints(dietButton, c);
        container.add(dietButton);

        textArea = new JTextArea("textarea");
        textArea.setEditable(false);
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 0;
        c.gridx = 3;
        c.gridwidth = 3;
        c.gridheight = GridBagConstraints.REMAINDER;
        c.weightx = 1;
        c.weighty = 1;
        gbl.setConstraints(textArea, c);
        container.add(textArea);

        //выдает индекс элемента из выпадающего меня от 0

        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

    class Banan {

        public String s1, s2;

        public Banan(String s1, String s2) {


            this.s1 = s1;
            this.s2 = s2;
        }


        public String description() {

            return s1 + " " + s2;
        }
    }
}
