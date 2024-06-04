package Lesson2.bricks;

import Lesson2.circles.Background;
import Lesson2.circles.Ball;
import Lesson2.common.CanvasRepaintListener;
import Lesson2.common.Interactable;
import Lesson2.common.MainCanvas;
import Lesson2.common.Sprite;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 1200;
    private static final int POS_Y = 200;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private final Interactable[] interactables = new Interactable[10];

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setTitle("Bricks");
        interactables[0] = new Background();

        for (int i = 0; i < interactables.length; i++) {
            interactables[i] = new Brick();
        }

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        setVisible(true);
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (Interactable interactable : interactables) {
            interactable.update(canvas, deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g) {
        for (Interactable interactable : interactables) {
            interactable.render(canvas, g);
        }
    }
}
