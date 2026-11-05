package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class Ball_system {
    DcMotorEx[] motors = new DcMotorEx[2];
    double[] powers = new double[2];

    Ball_system(HardwareMap hm){
        motors[0] = hm.get(DcMotorEx.class, "Collector motor");
        motors[1] = hm.get(DcMotorEx.class, "Launcher motor");
    }
    public void accept_input_gamepad(Gamepad gp){
        double c, l; // C for collector L for launcher
        c = gp.left_trigger;
        l = gp.right_trigger;
        powers[0] = c;
        powers[1] = l;
    }
    public void apply_powers(){
        for (byte i = 0; i <= 2; i++){
            motors[i].setPower(powers[i]);
        }
    }
}

