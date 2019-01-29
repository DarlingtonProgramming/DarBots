package org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Sensors;


import android.support.annotation.NonNull;

import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.IntegratedFunctions.MotionTaskCallBackToMotorTaskCallBack;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.RobotMotorTasks.RobotFixCountSpeedCtlTask;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.RobotMotorTasks.RobotFixCountTask;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Templates.RobotMotionTask;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Templates.RobotMotionTaskCallBack;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Templates.RobotMotorTaskCallBack;

public class RobotMotion {
    protected RobotMotorController m_MotorController;
    protected RobotWheel m_Wheel;
    public class FixedDistanceTask extends RobotFixCountTask implements RobotMotionTask {
        double m_Distance;
        public FixedDistanceTask(double Distance, double Speed, RobotMotionTaskCallBack TaskCallBack) {
            super(0, Speed, TaskCallBack == null ? null : new MotionTaskCallBackToMotorTaskCallBack(RobotMotion.this,TaskCallBack));
            this.setDistance(Distance);
        }
        public FixedDistanceTask(FixedDistanceTask Task){
            super(Task);
            this.m_Distance = Task.m_Distance;
        }
        public double getDistance(){
            return this.m_Distance;
        }
        public void setDistance(double Distance){
            this.m_Distance = Distance;
            double Revolution = Distance / RobotMotion.this.getRobotWheel().getCircumference();
            int Counts = (int) Math.round(Revolution * RobotMotion.this.getMotorController().getMotor().getMotorType().getCountsPerRev());
            super.setCounts(Counts);
        }

        @Override
        public RobotMotionTaskCallBack getMotionTaskCallBack(){
            if(super.getTaskCallBack() != null) {
                return ((MotionTaskCallBackToMotorTaskCallBack) super.getTaskCallBack()).getTaskCallBack();
            }else{
                return null;
            }
        }

        @Override
        public void setMotionTaskCallBack(RobotMotionTaskCallBack TaskCallBack) {
            if(TaskCallBack == null){
                super.setTaskCallBack(null);
            }else{
                if(super.getTaskCallBack() != null){
                    ((MotionTaskCallBackToMotorTaskCallBack) super.getTaskCallBack()).setTaskCallBack(TaskCallBack);
                }else{
                    super.setTaskCallBack(new MotionTaskCallBackToMotorTaskCallBack(RobotMotion.this,TaskCallBack));
                }
            }
        }
    }
    public class FixedDistanceSpeedCtlTask extends RobotFixCountSpeedCtlTask implements RobotMotionTask{
        double m_Distance;
        public FixedDistanceSpeedCtlTask(double Distance, double Speed, RobotMotionTaskCallBack TaskCallBack) {
            super(0, Speed, TaskCallBack == null ? null : new MotionTaskCallBackToMotorTaskCallBack(RobotMotion.this,TaskCallBack));
            this.setDistance(Distance);
        }
        public FixedDistanceSpeedCtlTask(FixedDistanceSpeedCtlTask Task){
            super(Task);
            this.m_Distance = Task.m_Distance;
        }
        public double getDistance(){
            return this.m_Distance;
        }
        public void setDistance(double Distance){
            this.m_Distance = Distance;
            double Revolution = Distance / RobotMotion.this.getRobotWheel().getCircumference();
            int Counts = (int) Math.round(Revolution * RobotMotion.this.getMotorController().getMotor().getMotorType().getCountsPerRev());
            super.setCounts(Counts);
        }

        @Override
        public RobotMotionTaskCallBack getMotionTaskCallBack(){
            if(super.getTaskCallBack() != null) {
                return ((MotionTaskCallBackToMotorTaskCallBack) super.getTaskCallBack()).getTaskCallBack();
            }else{
                return null;
            }
        }

        @Override
        public void setMotionTaskCallBack(RobotMotionTaskCallBack TaskCallBack) {
            if(TaskCallBack == null){
                super.setTaskCallBack(null);
            }else{
                if(super.getTaskCallBack() != null){
                    ((MotionTaskCallBackToMotorTaskCallBack) super.getTaskCallBack()).setTaskCallBack(TaskCallBack);
                }else{
                    super.setTaskCallBack(new MotionTaskCallBackToMotorTaskCallBack(RobotMotion.this,TaskCallBack));
                }
            }
        }
    }
    public RobotMotion(@NonNull RobotMotorController MotorController, @NonNull RobotWheel RobotWheel){
        this.m_MotorController = MotorController;
        this.m_Wheel = RobotWheel;
    }
    public RobotMotorController getMotorController(){
        return this.m_MotorController;
    }
    public void setMotorController(@NonNull RobotMotorController MotorController){
        this.m_MotorController = MotorController;
    }
    public RobotWheel getRobotWheel(){
        return this.m_Wheel;
    }
    public void setRobotWheel(RobotWheel Wheel){
        this.m_Wheel = Wheel;
    }

}
