package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleOP extends OpMode {
    Drivetrain main_train;
    //Ball_system ball_ystem;
    @Override
    public void init(){
        main_train = new Drivetrain(hardwareMap);
        //ball_ystem = new Ball_system(hardwareMap);
    }
    @Override
    public void loop(){
        main_train.accept_input(gamepad1);
        main_train.apply_powers();
        //ball_ystem.accept_input_gamepad(gamepad1);
        //ball_ystem.apply_powers();

    }
}