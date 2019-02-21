package org.firstinspires.ftc.teamcode.RobotControllers.Robot4100StateTournamentCode;

import org.firstinspires.ftc.teamcode.Darlington2018SharedLib.FTC2018GameVuforiaNavigation;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Calculations.Robot2DPositionTracker;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.IntegratedFunctions.Robot2DPositionIndicator;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.MotorTypes.AndyMark2964;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.MotorTypes.AndyMark3103;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.MotorTypes.GoBlida5202Series30RPMMotor;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.MotorTypes.RevCoreHexMotor;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.MotorTypes.RevHDHex40Motor;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Sensors.RobotWheel;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Templates.RobotCamera;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Templates.RobotMotorTask;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Templates.RobotMotorType;

public class Robot4100Setting {
    public static String SettingFileName = "4100saved.json";

    public static final boolean TFOL_ShowPreviewScreen = true;
    public static final String TFOL_CAMERACONFIGURTIONNAME = "webCam";

    public static final FTC2018GameVuforiaNavigation.Vuforia3DRobotAxisIndicator VUFORIANAV_WEBCAMPOSITION = new FTC2018GameVuforiaNavigation.Vuforia3DRobotAxisIndicator(7.3,12.7,35,90,-20,90);
    public static final boolean VUFORIANAV_ShowPreviewScreen = true;

    public static final String GYRO_CONFIGURATIONNAME = "imu";

    public static final Robot2DPositionIndicator Field_MinPoint = new Robot2DPositionIndicator(-182.88,-182.88,0);
    public static final Robot2DPositionIndicator Field_MaxPoint = new Robot2DPositionIndicator(182.88,182.88,0);

    public static final double TELEOP_GAMEPADTRIGGERVALUE = 0.15;
    public static final double TELEOP_BIGGESTDRIVINGSPEED = 0.5;
    public static final double TELEOP_LINEARACTUATORSPEED = 1.0;
    public static final double TELEOP_DUMPERSLIDESPEED = 1.0;
    public static final double TELEOP_DRAWERSLIDESPEED = 1.0;
    public static final double AUTONOMOUS_BIGGESTDRIVINGSPEED = 0.4;
    public static final double AUTONOMOUS_LINEARACTUATORSPEED = 1.0;
    public static final double AUTONOMOUS_DUMPERSLIDESPEED = 0.5;
    public static final double AUTONOMOUS_DRAWERSLIDESPEED = 0.5;

    public static final double EXTREMEPOINTS_DISTANCEFROMCENTER = 22.86;
    public static final Robot2DPositionTracker.Robot2DPositionRobotAxisIndicator[] EXTREMEPOINTS = {
            new Robot2DPositionTracker.Robot2DPositionRobotAxisIndicator(-EXTREMEPOINTS_DISTANCEFROMCENTER,EXTREMEPOINTS_DISTANCEFROMCENTER,0),
            new Robot2DPositionTracker.Robot2DPositionRobotAxisIndicator(EXTREMEPOINTS_DISTANCEFROMCENTER,EXTREMEPOINTS_DISTANCEFROMCENTER,0),
            new Robot2DPositionTracker.Robot2DPositionRobotAxisIndicator(-EXTREMEPOINTS_DISTANCEFROMCENTER,-EXTREMEPOINTS_DISTANCEFROMCENTER,0),
            new Robot2DPositionTracker.Robot2DPositionRobotAxisIndicator(EXTREMEPOINTS_DISTANCEFROMCENTER,-EXTREMEPOINTS_DISTANCEFROMCENTER,0)
    };

    public static final String RIGHTDISTANCESENSOR_CONFIGURATIONNAME = "rightSideDistanceSensor";

    public static final boolean MOTIONSYSTEM_TIMECONTROLENABLED = false;
    public static final double MOTIONSYSTEM_TIMECONTROLFACTOR = 1.3;
    public static final double MOTIONSYSTEM_WHEELINSTALLEDDISTANCE = 14.8;
    public static final double MOTIONSYSTEM_WHEELRADIUS = 5;
    public static final double MOTIONSYSTEM_MVOEMENTFRICTION = 0.45;
    public static final double MOTIONSYSTEM_ROTATIONALFRICTION = 1.0;

    public static final String LEFTFRONTWHEEL_CONFIGURATIONNAME = "leftFrontMotor";
    public static final RobotMotorType LEFTFRONTWHEEL_MOTORTYPE = new RevHDHex40Motor();
    public static final RobotWheel LEFTFRONTWHEEL_MOTORWHEEL = new RobotWheel(new Robot2DPositionTracker.Robot2DPositionRobotAxisIndicator(-MOTIONSYSTEM_WHEELINSTALLEDDISTANCE,MOTIONSYSTEM_WHEELINSTALLEDDISTANCE,45),MOTIONSYSTEM_WHEELRADIUS);

    public static final String RIGHTFRONTWHEEL_CONFIGURATIONNAME = "rightFrontMotor";
    public static final RobotMotorType RIGHTFRONTWHEEL_MOTORTYPE = new RevHDHex40Motor();
    public static final RobotWheel RIGHTFRONTWHEEL_MOTORWHEEL = new RobotWheel(new Robot2DPositionTracker.Robot2DPositionRobotAxisIndicator(MOTIONSYSTEM_WHEELINSTALLEDDISTANCE,MOTIONSYSTEM_WHEELINSTALLEDDISTANCE,-45),MOTIONSYSTEM_WHEELRADIUS);

    public static final String LEFTBACKWHEEL_CONFIGURATIONNAME = "leftBackMotor";
    public static final RobotMotorType LEFTBACKWHEEL_MOTORTYPE = new RevHDHex40Motor();
    public static final RobotWheel LEFTBACKWHEEL_MOTORWHEEL = new RobotWheel(new Robot2DPositionTracker.Robot2DPositionRobotAxisIndicator(-MOTIONSYSTEM_WHEELINSTALLEDDISTANCE,-MOTIONSYSTEM_WHEELINSTALLEDDISTANCE,135),MOTIONSYSTEM_WHEELRADIUS);


    public static final String RIGHTBACKWHEEL_CONFIGURATIONNAME = "rightBackMotor";
    public static final RobotMotorType RIGHTBACKWHEEL_MOTORTYPE = new RevHDHex40Motor();
    public static final RobotWheel RIGHTBACKWHEEL_MOTORWHEEL = new RobotWheel(new Robot2DPositionTracker.Robot2DPositionRobotAxisIndicator(MOTIONSYSTEM_WHEELINSTALLEDDISTANCE,-MOTIONSYSTEM_WHEELINSTALLEDDISTANCE,-135),MOTIONSYSTEM_WHEELRADIUS);

    public static final String LINEARACTUATOR_CONFIGURATIONNAME = "linearActuatorMotor";
    public static final RobotMotorType LINEARACTUATOR_MOTORTYPE = new AndyMark2964();
    public static final double LINEARACTUATOR_MAX = 22.412, LINEARACTUATOR_MIN = 0;
    public static final boolean LINEARACTUATOR_TIMEOUTCONTROL = true;
    public static final double LINEARACTUATOR_TIMEOUTFACTOR = 1.2;
    public static final double LINEARACTUATOR_HOOKPCT = 83.772;

    public static final String DRAWERSLIDEAPPROACH_CONFIGURATIONNAME = "drawerSlideMotor";
    public static final RobotMotorType DRAWERSLIDEAPPROACH_MOTORTYPE = new AndyMark2964();
    public static final double DRAWERSLIDEAPPROACH_MAX = 4.375, DRAWERSLIDEAPPROACH_MIN = 0;
    public static final boolean DRAWERSLIDE_TIMEOUTCONTROL = true;
    public static final double DRAWERSLIDE_TIMEOUTFACTOR = 1.2;
    public static final String DRAWERSLIDE_MINTOUCHSENSOR_CONFIGURATIONNAME = "drawerSlideMinTouch", DRAWESLIDE_MAXTOUCHSENSOR_CONFIGURATIONNAME = "drawerSlideMaxTouch";
    public static final double DRAWESLIDE_SAFEPCT = 42.43;

    public static final String DUMPERSLIDE_CONFIGURATIONNAME = "dumperSlideMotor";
    public static final RobotMotorType DUMPERSLIDE_MOTORTYPE = new AndyMark3103();
    public static final double DUMPERSLIDE_MAX = 5.060, DUMPERSLIDE_MIN = 0;
    public static final boolean DUMPERSLIDE_TIMEOUTCONTROL = true;
    public static final double DUMPERSLIDE_TIMEOUTFACTOR = 1.2;
    public static final String DUMPERSLIDE_MAXTOUCHSENSOR_CONFIGURATIONNAME = "dumperSlideMaxTouch";
    public static final double DUMPERSLIDE_SAFEPCT = 50.85, DUMPERSLIDE_DUMPPCT = 92.16;

    public static final String COLLECTOR_CONFIGURATIONNAME = "collectorMotor";
    public static final RobotMotorType COLLECTOR_MOTORTYPE = new RevCoreHexMotor();

    public static final String DUMPERSERVO_CONFIGURATIONNAME = "dumperServo";
    public static final double DUMPERSERVO_OFFSET = 0.05;
    public static final double DUMPERSERVO_DUMPPOS = 0.0 + DUMPERSERVO_OFFSET, DUMPERSERVO_NORMALPOS = 0.40 + DUMPERSERVO_OFFSET;

    public static final String COLLECTOROUTSERVO_CONFIGURATIONNAME = "collectorSetOutServo";
    public static final double COLLECTOROUTSERVO_TODUMPPOS = 0.90, COLLECTOROUTSERVO_COLLECTPOS = 0.10, COLLECTOROUTSERVO_NORMALPOS=0.45;
}