package Lesson1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;

    private int currentSize;
    private int currentWin;

    JButton btnStart;

    private JPanel gameModePanel(){
        Label label = new Label("Веберите режим игры: ");
        JRadioButton radioButton0 = new JRadioButton("Человек против компьютера.");
        JRadioButton radioButton1 = new JRadioButton("Человек против человека.");
        JPanel panel = new JPanel(new GridLayout(3, 1));
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton0);
        buttonGroup.add(radioButton1);
        panel.add(label);
        panel.add(radioButton0);
        panel.add(radioButton1);
        return panel;
    }

    private JPanel fieldSizeSliderPanel(){

        JSlider slider = new JSlider(0, 3, 10, 3);
        Label fieldSizeLabel = new Label("Установленный размер поля: " + currentSize);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentSize = slider.getValue();
                fieldSizeLabel.setText("Установленный размер поля: " + currentSize);
            }
        });
        Label choiceOfSize = new Label("Выберите размер поля.");

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(choiceOfSize);
        panel.add(fieldSizeLabel);
        panel.add(slider);

        return panel;
    }
    private JPanel winCountPanel() {
        Label winSize = new Label("Выберите длину для победы.");
        JSlider slider = new JSlider(0,3,5,3);
        Label winSizeSlider = new Label("Установленная длина: " + currentWin);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentWin = slider.getValue();
                winSizeSlider.setText("Установленная длина: " + currentWin);
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(winSize);
        panel.add(winSizeSlider);
        panel.add(slider);

        return panel;
    }


    public SettingWindow(GameWindow gameWindow){
        btnStart = new JButton("Start new game");

        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(gameModePanel());
        panel.add(fieldSizeSliderPanel());
        panel.add(winCountPanel());

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gameWindow.startNewGame(0, 3, 3, 3);
                setVisible(false);
            }
        });
        add(panel);
        add(btnStart, BorderLayout.SOUTH);
    }
}