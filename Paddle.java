import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Paddle {
    int x;
    int y;
    int dir;

    Paddle(int Px, int Py) {
        x = Px;
        y = Py;
        dir = 0;
    }

    public void move(int di) {
        switch (di) {
            case KeyEvent.VK_DOWN:
                y = y - 1;
                dir = -1;
                break;
            case KeyEvent.VK_UP:
                y = y + 1;
                dir = 1;
                break;
            case KeyEvent.VK_W:
                y = y + 1;
                dir = 1;
                break;
            case KeyEvent.VK_S:
                y = y - 1;
                dir = -1;
            case 0:
                dir = 0;
        }
    }
}
