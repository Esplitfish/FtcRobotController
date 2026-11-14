package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

@Autonomous
public class AutoOp extends TeleOP{
    Eyes camera;
    Drivetrain auto_train;
    Ball_system autoballer;
    boolean timer_running;
    boolean timer_ran;
    Timer timer;
    TimerTask task;
    @Override
    public void init(){
        timer_running = true;
        timer_ran = false;
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
    public void loop(){
        if (!timer_ran){
            timer.schedule(task, 10000);
            timer_ran = true;
        }
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
