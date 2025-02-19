package config.core;

import com.acmerobotics.dashboard.config.Config;

@Config
public class RobotConstants {

    // Outtake
    public static double outtakeGrabClose = 0.04;
    public static double outtakeGrabOpen = 0.2;
    public static double outtakeRotateTransfer = 0.265; //.775
    public static double outtakeRotateSpecimenGrab180 = 0.61;
    public static double outtakeRotateSpecimenGrab0 = 0.56;
    public static double outtakeRotateLeftScore = 0.8;
    public static double outtakeRotateRightScore = 0.32;
    public static double outtakeRotateLeftSpecimenScore180 = 0.7;
    public static double outtakeRotateRightSpecimenScore180 = 0.28;
    public static double outtakeRotateLeftSpecimenScore0 = 0.68;
    public static double outtakeRotateRightSpecimenScore0 = .2;
    public static double outtakePivotTransfer= 0.8; //0
    public static double outtakePivotScore = 0.53;
    public static double outtakePivotSpecimenGrab180 = .885;
    public static double outtakePivotSpecimenScore180 = 0.34;

    public static double outtakePivotSpecimenGrab0 = 0.97;
    public static double outtakePivotSpecimenScore0 = 0.41;

    // Intake
    public static double intakeGrabClose = 0.12;
    public static double intakeGrabOpen = 0.35;
    public static double intakeRotateTransfer = 0.32;
    public static double intakeRotateHoverVertical = 0.7;
    public static double intakeRotateGroundVertical = 0.71;
    public static double intakeRotateCloudVertical = 0.675;
    public static double intakeRotateSpecimen = 1;
    public static double intakePivotTransfer= 0.4;
    public static double intakePivotGround = 0.64;
    public static double intakePivotHover = 0.43;
    public static double intakePivotCloud = 0.6;
    public static double intakePivotSpecimen = 0;

    // Lift Positions
    public static int liftToZero = 0;
    public static int liftToHumanPlayer = 200;
    public static int liftToHighChamber = 200;
    public static int liftToHighBucket = 1750;
    public static int liftToTransfer = 200;
    public static int liftToPark = 0;

    // Extend Positions
    public static double extendZero = 0.525;
    public static double extendFull = .3;

}