package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {
    DcMotorEx[] motors = new DcMotorEx[4];
    double[] powers = new double[4];
    Drivetrain(HardwareMap hm){
        motors[0] = hm.get(DcMotorEx.class, "Back Right Motor");
        motors[1] = hm.get(DcMotorEx.class, "Front Right Motor");
        motors[2] = hm.get(DcMotorEx.class, "Back Left Motor");
        motors[3] = hm.get(DcMotorEx.class, "Front Left Motor");
    }
    public void accept_input_gamepad(Gamepad gp){
        double x, y, r;
        x = gp.left_stick_x;
        y = gp.left_stick_y;
        r = gp.left_stick_x;
        powers[0] = y - x - r;
        powers[1] = y + x - r;
        powers[2] = y - x + r;
        powers[3] = y + x + r;
    }
    public void apply_powers(){
        for (byte i = 0; i <= 4; i++){
            motors[i].setPower(powers[i]);
        }
    }
}
