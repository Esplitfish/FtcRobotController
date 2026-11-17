package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleOP extends OpMode {
    Drivetrain main_train;
    Ball_system ball_ystem;
    boolean headed = true;
    double xOffset=0;
    double yOffset=0;
    @Override
    public void init(){
        main_train = new Drivetrain(hardwareMap);
        ball_ystem = new Ball_system(hardwareMap);
        main_train.setOffsets(xOffset, yOffset);
        main_train.odometer.recalibrateIMU();
        main_train.odometer.resetPosAndIMU();
    }
    @Override
    public void loop(){
        if (gamepad1.aWasPressed())headed=!headed;
        main_train.accept_input(gamepad1, headed);
        main_train.apply_powers();
        ball_ystem.accept_input_gamepad(gamepad1);
        ball_ystem.apply_powers();
    }
}