package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {
    DcMotorEx[] motors = new DcMotorEx[4];
    double[] powers = new double[4];
    double DEADZONE;
    Drivetrain(HardwareMap hm, double d){
        motors[0] = hm.get(DcMotorEx.class, "Back Right Motor");
        motors[1] = hm.get(DcMotorEx.class, "Front Right Motor");
        motors[2] = hm.get(DcMotorEx.class, "Back Left Motor");
        motors[3] = hm.get(DcMotorEx.class, "Front Left Motor");
        DEADZONE = d;
    }
    public void accept_input(Gamepad gp){
        double x, y, r;
        // Is not headless
        x = gp.left_stick_x;
        y = -gp.right_stick_x;
        r = -gp.left_stick_y;

        powers[0] = y + x - r;
        powers[1] = y - x - r;
        powers[2] = y - x + r;
        powers[3] = y + x + r;

        /* BR
        if (y - x - r >= DEADZONE || y - x - r <= -DEADZONE) powers[0] = y + x - r;
        else powers[0] = 0;
        // FR
        if (y - x - r >= DEADZONE || y + x - r <= -DEADZONE) powers[1] = y - x - r;
        else powers[1] = 0;
        // BL
        if (y - x + r >= DEADZONE || y - x + r <= -DEADZONE) powers[2] = y - x + r;
        else powers[2] = 0;
        // FL
        if (y + x + r >= DEADZONE || y + x + r <= -DEADZONE) powers[3] = y + x + r;
        else powers[3] = 0;
        */
    }
    public void accept_input(double[] np){
        for (byte i = 0; i < 4; i++){
            powers[i] = np[i];
        }
    }
    public void apply_powers(){
        for (byte i = 0; i < 4; i++){
            motors[i].setPower(powers[i]);
        }
    }
}
