/*
MIT License

Copyright (c) 2018 DarBots Collaborators

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

*/

package org.firstinspires.ftc.teamcode.DarlingtonSharedLib.RobotMotorTasks;

import android.support.annotation.NonNull;

import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Templates.RobotMotor;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Templates.RobotMotorTask;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Templates.RobotMotorTaskCallBack;

public class RobotFixedSpeedTask extends RobotMotorTask {
    double m_TimeInSeconds = 0;
    double m_Speed = 0;
    public RobotFixedSpeedTask(double timeInSeconds, double Speed, RobotMotorTaskCallBack TaskCallBack) {
        super(TaskCallBack);
        this.m_TimeInSeconds = timeInSeconds;
        this.m_Speed = Speed;
    }
    public RobotFixedSpeedTask(@NonNull RobotFixedSpeedTask SpeedTask){
        super(SpeedTask);
        this.m_TimeInSeconds = SpeedTask.m_TimeInSeconds;
        this.m_Speed = SpeedTask.m_Speed;
    }

    public double getSpeed(){
        return this.m_Speed;
    }

    public void setSpeed(double Speed){
        this.m_Speed = Speed;
        if(this.isBusy()){
            this.getMotorController().getMotor().setPower(this.m_Speed);
        }
    }

    public double getTimeInSeconds(){
        return this.m_TimeInSeconds;
    }

    public void setTimeInSeconds(double TimeInSeconds){
        this.m_TimeInSeconds = TimeInSeconds;
    }

    @Override
    protected void __startTask() {
        this.getMotorController().getMotor().setCurrentMovingType(RobotMotor.MovingType.withSpeed);
        this.getMotorController().getMotor().setPower(this.m_Speed);
    }

    @Override
    public void updateStatus() {
        if(this.getSecondsSinceStart() >= this.m_TimeInSeconds && this.m_TimeInSeconds > 0){
            this.endTask(true);
        }
    }
}
