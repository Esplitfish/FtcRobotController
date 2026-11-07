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
        powers[0] = gp.left_trigger; // Collector
        powers[1] = gp.right_trigger; // Launcher
    }
    public void apply_powers(){
        for (byte i = 0; i <= 2; i++){
            motors[i].setPower(powers[i]);
        }
    }
}
