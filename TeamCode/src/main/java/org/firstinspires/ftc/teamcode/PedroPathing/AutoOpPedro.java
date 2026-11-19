package org.firstinspires.ftc.teamcode.PedroPathing;

import static com.pedropathing.api.Paths.*;
import com.pedropathing.paths.Path;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;

import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.*;
import org.firstinspires.ftc.teamcode.TeleOP;

@Autonomous
public class AutoOpPedro extends TeleOP {
    Eyes camera;
    Drivetrain auto_train;
    Ball_system autoballer;
    Follower follower;
    final PoseFactory pose_factory = PoseFactory.degrees();
    final Pose start_pose = pose_factory.of(0, 0, 0);
    final Pose launch_pose = pose_factory.of(10,10,90);
    final Pose parking_spot = pose_factory.of(0, 50, 0);

    Path park(){
        return line(start_pose, parking_spot).linear(start_pose, parking_spot);
    }

    @Override
    public void init(){
        Scheduler.reset();

        follower = Constants.create(hardwareMap);
        follower.setPose(start_pose);
    }
    @Override
    public void start(){
        schedule(follow(follower, park()));
    }
    @Override
    public void loop(){
        follower.update();
        Scheduler.execute();
    }
    @Override
    public void stop(){
        OpModeStorage.auto_end_pose = follower.pose();
    }
}
