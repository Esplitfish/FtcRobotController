package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleOP extends OpMode{
    Drivetrain main_train;
    @Override
    public void init(){
        main_train = new Drivetrain(hardwareMap);
    }
    @Override
    public void loop(){
        main_train.accept_input_gamepad(gamepad1);
        main_train.apply_powers();
    }
}