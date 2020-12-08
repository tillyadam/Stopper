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
    int hours;
    int minutes;
    int seconds;
    int miliseconds;
    String hoursToString=String.format("%02d",hours);
    String minutesToString=String.format("%02d",minutes);
    String secondsToString=String.format("%02d",seconds);
    String milisecondsToString=String.format("%02d",miliseconds);
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


            }
        });

        button_reszidoReset = new JButton("Részidő");
        button_reszidoReset.setBounds(20, 60, 125, 30);
        button_reszidoReset.setFont(new Font("Courier new", Font.PLAIN, 20));


        label_time = new JLabel(hoursToString+":"+minutesToString+":"+secondsToString+":"+milisecondsToString, SwingConstants.CENTER);
        label_time.setBounds(200, 30, 350, 60);
        label_time.setFont(new Font("Courier new", Font.ITALIC, 30));


        mainPanel.add(button_startStop);
        mainPanel.add(button_reszidoReset);
        mainPanel.add(label_time);

        this.setVisible(true);
    }

    private void start(){

    }

    private void stop(){

    }

    private void reset(){

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
