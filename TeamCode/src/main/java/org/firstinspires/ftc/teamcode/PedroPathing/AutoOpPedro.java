package org.firstinspires.ftc.teamcode.PedroPathing;


import static com.pedropathing.api.Paths.*;
import com.pedropathing.paths.Path;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.*;
import org.firstinspires.ftc.teamcode.TeleOP;

@Autonomous
public class AutoOpPedro extends TeleOP {
    Eyes camera;
    Drivetrain auto_train;
    Ball_system autoballer;
    Follower follower;
    private final PoseFactory pose_factory = PoseFactory.degrees();
    private final Pose start_pose = pose_factory.of(0, 0, 0);
    private final Pose launch_pose = pose_factory.of(10,10,90);
    private final Pose parking_spot = pose_factory.of(0, 50, 0);

    private Path park(){
        return line(start_pose, parking_spot).linear(start_pose, parking_spot);
    }

    public void init(){
        follower = Constants.create(hardwareMap);
        follower.setPose(start_pose);
    }
    public void loop(){

    }
}
