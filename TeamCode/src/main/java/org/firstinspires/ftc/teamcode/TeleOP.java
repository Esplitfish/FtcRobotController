package org.firstinspires.ftc.teamcode;
import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.ManualDrive;

import org.firstinspires.ftc.teamcode.PedroPathing.Constants;

@TeleOp
public class TeleOP extends OpMode {
    Drivetrain main_train;
    Ball_system ball_ystem;
    boolean headed = true;
    boolean secretThirdOption=false;
    double xOffset=0;
    double yOffset=0;
    Follower follower;
    @Override
    public void init(){
        main_train = new Drivetrain(hardwareMap);
        ball_ystem = new Ball_system(hardwareMap);
        //main_train.setOffsets(xOffset, yOffset);
        //main_train.odometer.recalibrateIMU();
        //main_train.odometer.resetPosAndIMU();
        follower = Constants.create(hardwareMap);

    }
    @Override
    public void start(){
        follower.setPose(OpModeStorage.auto_end_pose);
        follower.update();
    }
    @Override
    public void loop(){
        if (gamepad1.aWasPressed())headed=!headed;
        if (headed) {
            main_train.accept_input(gamepad1, headed);
            main_train.apply_powers();
        }
        else if(secretThirdOption){
            double forward = -gamepad1.left_stick_y;
            double lateral = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;
            follower.manual(forward, lateral, turn);
        }
        else{
            DrivePowers powers = ManualDrive.fieldCentric(
                    -gamepad1.left_stick_y,
                    gamepad1.left_stick_x,
                    gamepad1.right_stick_x,
                    follower.pose().heading()
            );
            follower.manual(powers);
        }
        follower.update();
        ball_ystem.accept_input_gamepad(gamepad1);
        ball_ystem.apply_powers();
    }
}