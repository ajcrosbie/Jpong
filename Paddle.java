import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Paddle {
    int x;
    int y;
    int ix;
    int iy;
    int dir;

    Paddle(int Px, int Py) {
        x = Px;
        y = Py;
        ix = Px;
        iy = Py;
        dir = 0;
    }

    public void move(int di) {
        switch (di) {
            case KeyEvent.VK_DOWN:
                y = y + 8;
                dir = 8;
                break;
            case KeyEvent.VK_UP:
                y = y - 8;
                dir = -8;
                break;
            case KeyEvent.VK_W:
                y = y - 8;
                dir = -8;
                break;
            case KeyEvent.VK_S:
                y = y + 8;
                dir = 8;
            case 0:
                dir = 0;
        }
    }

    public void reset() {
        x = ix;
        y = iy;
    }
}
