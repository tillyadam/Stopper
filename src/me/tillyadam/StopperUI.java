package me.tillyadam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.Timer;

public class StopperUI extends JFrame implements ActionListener {
    JPanel mainPanel;
    JButton button_startStop, button_reszidoReset;
    JLabel label_time;
    Timer stopper;
    TimerTask task;
    int hours;
    int minutes;
    int seconds;
    String hoursToString = String.format("%02d", hours);
    String minutesToString = String.format("%02d", minutes);
    String secondsToString = String.format("%02d", seconds);
    LocalDateTime startTime = LocalDateTime.now();
    Duration elapsed;
    List<Time> reszidoLista;

    public StopperUI() {
        init();
    }

    private void init() {
        this.setTitle("Stopper");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainPanel = (JPanel) (this.getContentPane());
        this.setLayout(null);

        button_startStop = new JButton("Start");
        button_startStop.setBounds(20, 20, 125, 30);
        button_startStop.setFont(new Font("Courier new", Font.BOLD, 20));
        button_startStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopper = new Timer();

                if (button_startStop.getText().equals("Start")) {
                    button_startStop.setText("Stop");

                    task = new TimerTask() {
                        @Override
                        public void run() {
                            seconds++;
                            secondsToString = String.format("%02d", seconds % 60);
                            minutes = seconds / 60;
                            minutesToString = String.format("%02d", minutes % 60);
                            hours = seconds / 3600;
                            hoursToString = String.format("%02d", hours % 24);
                            label_time.setText(hoursToString + ":" + minutesToString + ":" + secondsToString);

                        }
                    };
                    stopper.schedule(task, 0, 1000);
                }

                else if (button_startStop.getText().equals("Stop")) {
                    button_startStop.setText("Start");

                    task.cancel();
                }


            }
        });

        button_reszidoReset = new JButton("Részidő");
        button_reszidoReset.setBounds(20, 60, 125, 30);
        button_reszidoReset.setFont(new Font("Courier new", Font.PLAIN, 20));


        label_time = new JLabel(hoursToString + ":" + minutesToString + ":" + secondsToString, SwingConstants.CENTER);
        label_time.setBounds(200, 30, 350, 60);
        label_time.setFont(new Font("Courier new", Font.ITALIC, 30));


        mainPanel.add(button_startStop);
        mainPanel.add(button_reszidoReset);
        mainPanel.add(label_time);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
