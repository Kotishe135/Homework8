package com.company;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class Main {
    private static final int FRAME_WIDTH = 380;
    private static final int FRAME_HEIGHT = 120;
    private static final int NAME_WIDTH = 150;
    private static final int PANEL_WIDTH = 100;
    private static final int PANEL_HEIGHT = 60;
    private static final int STANDART_HEIGHT = 25;
    private static final int BORDER = 5;
    private static final int MAX_AGE = 140;

    private Main() {
    }

    /**The method creates a window for adding a person to the queue.*/
    public static void window(final Mail queque) {
        Integer[] ages = new Integer[MAX_AGE];
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame wind = new JFrame("Очередь");
        JTextField name = new JTextField();
        JLabel namePeole = new JLabel("Имя Фамилия Отчество");
        JLabel agePeople = new JLabel("Возраст");
        JComboBox age;
        JPanel genderPanel = new JPanel();
        ButtonGroup gender = new ButtonGroup();
        JRadioButton male = new JRadioButton("Мужской", true);
        JRadioButton female = new JRadioButton("Женский", false);
        JButton addPeople = new JButton("Добавить");
        JButton delPeople = new JButton("Отпустить");

        name.setSize(NAME_WIDTH, STANDART_HEIGHT);
        name.setLocation(0, 0);

        gender.add(male);
        male.setActionCommand("Мужской");
        gender.add(female);
        female.setActionCommand("Женский");
        genderPanel.setBounds(0, STANDART_HEIGHT, PANEL_WIDTH, PANEL_HEIGHT);
        genderPanel.add(male);
        genderPanel.add(female);

        for (int i = 0; i < ages.length;) {
            ages[i] = ++i;
        }
        age = new JComboBox<Integer>(ages);
        age.setEditable(false);
        age.setSize(name.getWidth() - genderPanel.getWidth(), STANDART_HEIGHT);
        age.setLocation(genderPanel.getWidth(), STANDART_HEIGHT);

        namePeole.setBounds(name.getWidth() + BORDER, 0, name.getWidth(), STANDART_HEIGHT);
        agePeople.setBounds(name.getWidth() + BORDER, STANDART_HEIGHT, name.getWidth(), STANDART_HEIGHT);

        addPeople.setBounds(namePeole.getLocation().x + namePeole.getWidth(), 0,
                FRAME_WIDTH - (namePeole.getLocation().x + namePeole.getWidth()), STANDART_HEIGHT);
        addPeople.setMargin(new Insets(1, 1, 1, 1));
        addPeople.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (!name.getText().equals("")) {
                    queque.addPeople(new People(name.getText(),
                            gender.getSelection().getActionCommand(), ages[age.getSelectedIndex()]));
                    name.setText("");
                }
            }
        });

        delPeople.setBounds(namePeole.getLocation().x + namePeole.getWidth(), STANDART_HEIGHT,
                FRAME_WIDTH - (namePeole.getLocation().x + namePeole.getWidth()), STANDART_HEIGHT);
        delPeople.setMargin(new Insets(1, 1, 1, 1));
        delPeople.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                People people = queque.pullPeople();
                String ending = "";
                try {
                    if (people.getGender().equals("Женский")) {
                        ending = "а";
                    }
                    JOptionPane.showMessageDialog(null,
                            "Отпущен" + ending + " " + people.getName()
                                    + "\nВозраст: " + people.getAge());
                } catch (NullPointerException err) {
                    JOptionPane.showMessageDialog(null, "Очередь пуста");
                }
            }
        });

        wind.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        wind.setLocation((screenSize.width - wind.getWidth()) / 2, (screenSize.height - wind.getHeight()) / 2);
        wind.setLayout(null);
        wind.setResizable(false);
        wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wind.getContentPane().add(name);
        wind.getContentPane().add(age);
        wind.getContentPane().add(genderPanel);
        wind.getContentPane().add(namePeole);
        wind.getContentPane().add(agePeople);
        wind.getContentPane().add(addPeople);
        wind.getContentPane().add(delPeople);
        wind.setVisible(true);
    }

    public static void main(final String[] args) {
        Mail mail = new Mail();
        window(mail);
    }
}
