package org.darbots.darbotsftclib.libcore.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.darbots.darbotsftclib.libcore.runtime.GlobalRegister;
import org.darbots.darbotsftclib.libcore.templates.RobotCore;

public abstract class BasicOpMode<CoreType extends RobotCore> extends LinearOpMode {
    public abstract CoreType getSpecificRobotCore();
    public abstract RobotCore getRobotCore();
    public abstract void hardwareInitialize();
    public abstract void hardwareDestroy();
    public abstract void RunThisOpMode();
    @Override
    public void runOpMode() throws InterruptedException {
        GlobalRegister.runningOpMode = this;
        this.hardwareInitialize();
        this.getRobotCore().getLogger().addLog("BasicOpMode","Status","OpMode initialized");
        this.waitForStart();
        if(this.opModeIsActive()){
            RunThisOpMode();
        }
        this.getRobotCore().getLogger().addLog("BasicOpMode","Status","OpMode finished");
        this.getRobotCore().getLogger().saveLogsToFile();
        this.getRobotCore().stop();
        this.hardwareDestroy();
        GlobalRegister.runningOpMode = null;
    }
}