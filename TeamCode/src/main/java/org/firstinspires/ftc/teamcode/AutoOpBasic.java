package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import java.util.Timer;
import java.util.TimerTask;

@Autonomous
public class AutoOpBasic extends TeleOP{
    Eyes camera;
    Drivetrain auto_train;
    Ball_system autoballer;
    boolean timer_running;
    Timer timer;
    TimerTask task;
    @Override
    public void init(){
        timer_running = true;
        auto_train = new Drivetrain(hardwareMap);
        timer = new Timer();
        task = new TimerTask(){
            @Override
            public void run(){
                timer_running = false;
            }
        };
    }

    @Override
    public void start(){
        timer.schedule(task, 10000);
    }
    @Override
    public void loop(){
        if (timer_running) {
            auto_train.accept_input(
                    new double[]{
                            -0.3,
                            -0.3,
                            0.3,
                            0.3
                    }
            );
        } else {
            auto_train.accept_input(
                    new double[]{
                            0.0,
                            0.0,
                            0.0,
                            0.0
                    }
            );
        }
        auto_train.apply_powers();
    }
}
