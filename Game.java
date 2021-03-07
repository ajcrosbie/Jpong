package pac;

import pac.*;
import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Gpanel());
        frame.setTitle("pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
