import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Gpanel panel = new Gpanel();
        panel.start();
        frame.add(panel);
        frame.setTitle("pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
