package pac;

import pac.Paddle;

public class Ball {
    int x;
    int y;
    int ix;
    int iy;
    int dir;
    int dir1; // dir is vertical movement dir1 is lateral movement

    Ball(int screenW, int screenH) {
        x = screenW / 2;
        y = screenH / 2;
        ix = x;
        iy = y;
        dir = 5;
        dir1 = 0;
    }

    public void move() {
        x = x + dir;
        y = y + dir1;
    }

    public void bounce(Paddle pad) {
        dir = dir * -1;
        dir1 = dir1 + pad.dir;
    }

    public void bounce1() {
        dir1 = dir1 * -1;
    }

    public void reset() {
        dir = 5;
        dir1 = 0;
        x = ix;
        y = iy;
    }
}
