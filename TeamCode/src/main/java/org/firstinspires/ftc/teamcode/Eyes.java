package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

public class Eyes {
    public AprilTagProcessor april_tag_processor;
    Eyes(){ // Z vert, X horiz, Y outward from lens
        AprilTagProcessor.Builder april_tag_processor_builder = new AprilTagProcessor.Builder();
        april_tag_processor_builder.setTagLibrary(AprilTagGameDatabase.getCurrentGameTagLibrary());
        april_tag_processor = april_tag_processor_builder.build();
    }
}
