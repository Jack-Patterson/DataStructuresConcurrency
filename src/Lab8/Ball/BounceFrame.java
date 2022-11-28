package Lab8.Ball;//Ball without threads

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class BounceFrame extends JFrame {

    private JPanel canvas;
    private JButton startButton;
    private JButton stopButton;
    private JButton closeButton;
    private boolean startBtnClicked = false;
    private static List<Ball> balls = new ArrayList<>();

    private BounceFrame bf;
    
    public BounceFrame() {
        setSize(300, 200);
        setTitle("Bounce");
        canvas = new JPanel();
        add(canvas, "Center");

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        closeButton = new JButton("Close");
        stopButton = new JButton("Stop");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(closeButton);

        ButtonHandler handler = new ButtonHandler();

        startButton.addActionListener(handler);
        stopButton.addActionListener(handler);
        closeButton.addActionListener(handler);

        add(buttonPanel, "South");
    }

    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == startButton && !startBtnClicked)
            {
//                startBtnClicked = true;
                balls.add(new Ball(canvas));
                Thread thread = new Thread(balls.get(balls.size()-1));
                thread.start();
            } else if (event.getSource() == stopButton)
            {
                //balls.get(0).setStopThread(true);
                //balls.get(balls.size()-1).setStopThread(true);

                for (Ball b : balls) b.setStopThread(true);
            } else if (event.getSource() == closeButton)
            {
                System.exit(0);
            }
        }
    }
    
    public static void main(String[] args) {
        BounceFrame frame = new BounceFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static List<Ball> getBalls() {
        return balls;
    }

}
