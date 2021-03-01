import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gpanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 500;
    static final int PADDLE_HEIGHT = 100;
    static final int PADDLE_WIDTH = 20;
    static final int BALL_SIZE = 15;
    static final int UNIT_SIZE = 25;
    static final int DELAY = 40;
    static final int GAME_UNITS = (SCREEN_HEIGHT * SCREEN_WIDTH) / UNIT_SIZE;
    public static boolean running = true;
    int score = 0;
    int score1 = 0;
    Paddle paddle;
    Paddle paddle1;
    Ball ball;
    Timer timer;

    Gpanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
    }

    public void start() {
        paddle = new Paddle(10, SCREEN_HEIGHT / 2);
        paddle1 = new Paddle(SCREEN_WIDTH - PADDLE_WIDTH - 10, SCREEN_HEIGHT / 2);
        ball = new Ball(SCREEN_WIDTH, SCREEN_HEIGHT);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void score(String player) {
        if (player == "p1") {
            score1++;
        }
        if (player == "p2") {
            score++;
        }
    }

    public void reset() {
        ball.reset();
        paddle.reset();
        paddle1.reset();
    }

    public void collisions() {
        if (ball.x < 0) {
            score("p1");
            reset();
            // System.out.println(score);
            // System.out.println(score1);
        } else if (ball.x > SCREEN_WIDTH) {
            score("p2");
            // System.out.println(score);
            // System.out.println(score1);
            reset();
        } else if (ball.y < 0) {
            ball.bounce1();
        } else if (ball.y > SCREEN_HEIGHT) {
            ball.bounce1();
        }
        if (ball.y + BALL_SIZE > paddle.y & ball.y + BALL_SIZE < paddle.y + PADDLE_HEIGHT) {
            if (ball.x + BALL_SIZE > paddle.x & ball.x + BALL_SIZE < paddle.x + PADDLE_WIDTH) {
                ball.bounce(paddle);
            }
        }
        if (ball.y + BALL_SIZE > paddle1.y & ball.y + BALL_SIZE < paddle1.y + PADDLE_HEIGHT) {
            if (ball.x + BALL_SIZE > paddle1.x & ball.x + BALL_SIZE < paddle1.x + PADDLE_WIDTH) {
                ball.bounce(paddle1);
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawOval(ball.x, ball.y, BALL_SIZE, BALL_SIZE);
        g.fillOval(ball.x, ball.y, BALL_SIZE, BALL_SIZE);
        g.drawRect(paddle.x, paddle.y, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillRect(paddle.x, paddle.y, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.drawRect(paddle1.x, paddle1.y, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillRect(paddle1.x, paddle1.y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public void actionPerformed(ActionEvent e) {
        if (running) {
            // paddle.move(0);
            // paddle1.move(0);
            ball.move();
            collisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {
                paddle1.move(e.getKeyCode());
            } else {
                paddle.move(e.getKeyCode());
            }
        }

    }
}