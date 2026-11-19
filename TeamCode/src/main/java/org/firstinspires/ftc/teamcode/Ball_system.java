package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

public class Ball_system {
    Servo launch_loader;
    DcMotorEx[] motors = new DcMotorEx[2];
    double[] powers = new double[2];
    Ball_system(HardwareMap hm){
        motors[0] = hm.get(DcMotorEx.class, "Collector motor");
        motors[1] = hm.get(DcMotorEx.class, "Launcher motor");
        launch_loader = hm.get(Servo.class, "Loader server");
        motors[0].setDirection(DcMotorEx.Direction.REVERSE);
        //motors[1].setDirection(DcMotorEx.Direction.REVERSE);
    }
    public void accept_input_gamepad(Gamepad gp){
        powers[0] = gp.left_trigger; // Collector
        powers[1] = gp.right_trigger; // Launcher
        if (gp.right_bumper) powers[1] = -1.0;
    }
    public void apply_powers(){
        motors[0].setPower(powers[0]);
        motors[1].setPower(powers[1]);
    }
}
